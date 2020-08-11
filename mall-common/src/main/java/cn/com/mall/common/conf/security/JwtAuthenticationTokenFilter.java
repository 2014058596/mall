package cn.com.mall.common.conf.security;

import cn.com.mall.base.bean.HttpStatus;
import cn.com.mall.base.bean.JwtTokenUtils;
import cn.com.mall.base.bean.StandardResult;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: JwtAuthenticationTokenFilter
 * @Description: TODO
 * @author: 55555
 * @date: 2020年07月26日 3:46 下午
 */
@Component
@Order(1)
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        SecurityContextHolder.getContext().setAuthentication(null);
        String token = request.getHeader(JwtTokenUtils.TOKEN_HEADER);//获取token
        if (!StringUtils.isEmpty(token)) {//判断token是否为空
            String username = null;
            List<String> userRole = new ArrayList<>();
            try{
                username = JwtTokenUtils.getUsername(token);//取出token的用户信息
                userRole = JwtTokenUtils.getUserRole(token);
            }catch (Exception e){
                response.getOutputStream().write(JSONUtil.toJsonStr(StandardResult.fail("token 非法")).getBytes("UTF-8"));
                return;
            }
            if (username != null) {//判断Security的用户认证信息

                final MyUserDetail userDetails = new MyUserDetail(username, userRole);
                if (!JwtTokenUtils.isExpiration(token)) {//判断token是否过期
                    // 将用户信息存入 authentication，方便后续校验
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    // 将 authentication 存入 ThreadLocal，方便后续获取用户信息
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        chain.doFilter(request, response);
    }
}

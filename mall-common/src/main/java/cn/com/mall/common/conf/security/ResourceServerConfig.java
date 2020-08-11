package cn.com.mall.common.conf.security;

import cn.com.mall.base.bean.HttpStatus;
import cn.com.mall.base.bean.result.StandardResult;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 〈资源认证服务器〉
 *  配置资源服务器
 * @since 1.0.0
 */
@Configuration
@EnableResourceServer
@Order(3)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        //使用自己的权限拦截器
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http//系统相关
                .authorizeRequests()
                .antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
                //商户
                .antMatchers("/merchants/**").hasAnyAuthority("ROLE_MERCHANTS")
                //会员
                .antMatchers("/identity/**").hasAnyAuthority("ROLE_IDENTITY")
                //非授权
                .antMatchers("/**").permitAll().and()
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.getOutputStream().write(JSONUtil.toJsonStr(StandardResult.fail(HttpStatus.UNAUTHORIZED)).getBytes("UTF-8")))//身份
                .accessDeniedHandler((request, response, authException) -> response.getOutputStream().write(JSONUtil.toJsonStr(StandardResult.fail(HttpStatus.NOT_ACCEPTABLE)).getBytes("UTF-8")))//权限
                .and()
                .httpBasic();
    }
}


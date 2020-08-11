package cn.com.mall.user.security;

import cn.com.mall.base.bean.HttpStatus;
import cn.com.mall.base.bean.StandardResult;
import cn.com.mall.common.conf.security.JwtAuthenticationTokenFilter;
import cn.com.mall.user.security.handler.SecurityAuthenticationFailureHandler;
import cn.com.mall.user.security.handler.SecurityAuthenticationSuccessHandler;
import cn.com.mall.user.security.handler.SecurityLogoutSuccessHandler;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 〈security配置〉
 * 配置Spring Security
 * ResourceServerConfig 是比SecurityConfig 的优先级低的
 * @author wangmx
 * @since 1.0.0
 */
@Configuration
@EnableWebSecurity
@Order(2)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private SecurityAuthenticationFailureHandler failureHandler;

    @Autowired(required = false)
    private SecurityAuthenticationSuccessHandler successHandler;

    @Autowired
    private SecurityLogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new EncryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //使用自己的权限拦截器
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.authorizeRequests()
                //系统相关
                .antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
                //商户
                .antMatchers("/merchants/**").hasAnyAuthority("ROLE_MERCHANTS")
                //会员
                .antMatchers("/identity/**").hasAnyAuthority("ROLE_IDENTITY")
                //非授权
                .antMatchers("/**").permitAll().and()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.getOutputStream().write(JSONUtil.toJsonStr(StandardResult.fail(HttpStatus.UNAUTHORIZED)).getBytes("UTF-8")))//身份
                .accessDeniedHandler((request, response, authException) -> response.getOutputStream().write(JSONUtil.toJsonStr(StandardResult.fail(HttpStatus.NOT_ACCEPTABLE)).getBytes("UTF-8")))//权限
                .and()
                .formLogin()
                //成功和失败的配置
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .loginProcessingUrl("/form/token")
                .and().logout().logoutSuccessHandler(logoutSuccessHandler)
                .and().csrf().disable();   //csrf跨站点攻击关闭 否则必须要传递token！！
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }


    /**
     * 不定义没有password grant_type,密码模式需要AuthenticationManager支持
     *
     * @return
     * @throws Exception
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}


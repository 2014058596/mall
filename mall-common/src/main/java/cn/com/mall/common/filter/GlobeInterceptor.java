package cn.com.mall.common.filter;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
* @ClassName: GlobeInterceptor
* @Description: TODO
* @author: 55555
* @date: 2020年07月24日 5:24 下午
*/
@SpringBootConfiguration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobeInterceptor implements WebMvcConfigurer {
    private static Logger logger = LoggerFactory.getLogger(GlobeInterceptor.class);

    private static final String ACCESS_TOKEN_KEY = "accessToken";

    /**
     * 获取请求头中的 token 及用户并绑定到当前线程
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        HandlerInterceptor handlerInterceptor = new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
                try {

                    // 设置通用响应头
                    response.setContentType("application/json;charset=UTF-8");

                    // 从请求头或参数中获取 accessToken，临时兼容方案，后期强制只取请求头
                    String accessToken = request.getHeader(ACCESS_TOKEN_KEY);
                    if (StringUtils.isBlank(accessToken)) {
                        accessToken = request.getParameter(ACCESS_TOKEN_KEY);
                    }

                    return true;
                } catch (Exception e) {
                    logger.error("拦截器异常 => URL:{}" + "\r\n" + "Message:{}", request.getRequestURL(), e.getMessage());
                    logger.error("{}",e);
                    return false;
                }
            }
        };


        registry.addInterceptor(handlerInterceptor).addPathPatterns("/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:swagger-ui.html");
    }




}

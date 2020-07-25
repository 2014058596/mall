package cn.com.mall.user;

import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName: AdminStartApplication
 * @Description: TODO
 * @author: 55555
 * @date: 2020年04月04日 5:53 下午
 */
@SpringBootApplication
@ComponentScan("cn.com.mall")
@EnableDiscoveryClient
@MapperScan("cn.com.mall.user.mapper")
@EnableTransactionManagement
@EnableCircuitBreaker
@Log4j2
public class AdminStartApplication extends SpringBootServletInitializer {



    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AdminStartApplication.class);
    }



    public static void main(String[] args) {

        SpringApplication.run(AdminStartApplication.class, args);

    }

}

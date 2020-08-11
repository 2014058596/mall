package cn.com.mall.test;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @ClassName: AdminStartApplication
 * @Description: TODO
 * @author: 55555
 * @date: 2020年04月04日 5:53 下午
 */
@SpringBootApplication
@ComponentScan("cn.com.mall")
@EnableDiscoveryClient
@MapperScan("cn.com.mall.test.mapper")
@EnableTransactionManagement
@EnableCircuitBreaker
@Log4j2
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AdminStartApplication extends SpringBootServletInitializer {



    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AdminStartApplication.class);
    }



    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run(AdminStartApplication.class, args);

    }

}

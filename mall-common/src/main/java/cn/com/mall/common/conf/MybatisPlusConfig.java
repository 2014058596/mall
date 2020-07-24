package cn.com.mall.common.conf;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
* @ClassName: MybatisPlusConfig
* @Description: mybatis-plus配置
* @author: 55555
* @date: 2020年02月27日 12:27 下午
*/
@SpringBootConfiguration
@ConditionalOnClass(DataSourceConfig.class)
public class MybatisPlusConfig {

    /**
     * mybatis-plus分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}


package cn.com.mall.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestController
 * @Description: TODO
 * @author: 55555
 * @date: 2020年07月23日 11:09 下午
 */
@RestController
@Api(tags = "测试")
public class TestController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/test")
    @ApiOperation(value="获取分页列表  55555", notes="获取分页列表  55555")
    public String test(){
        kafkaTemplate.send("test"," 发送消息");
        return "ok";
    }
}

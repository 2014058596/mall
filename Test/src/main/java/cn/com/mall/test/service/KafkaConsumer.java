package cn.com.mall.test.service;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName: KafkaListener
 * @Description: TODO
 * @author: 55555
 * @date: 2020年07月23日 11:03 下午
 */
@Service
@Log4j2
public class KafkaConsumer {

    public KafkaConsumer(){
        log.debug("");
    }

    //@KafkaListener(topics = {"test"},groupId = "test")
    public void onMessage(ConsumerRecord<?, ?> records){
        log.info("value: {}", records.value());
        log.info("key: {}", records.key());
    }
    @KafkaListener(topics = {"test"},groupId = "test1")
    public void onMessage1(ConsumerRecord<?, ?> records){
        log.info("value: {}", records.value());
        log.info("key: {}", records.key());
    }
}

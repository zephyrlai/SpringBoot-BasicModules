package cn.zephyr.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @ClassName: MyProvider
 * @Author: laizonghao
 * @Description: 生产者
 * @Date: 2019/11/5 15:07
 */
@Service
@Slf4j
public class MyProvider {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message){
        log.info("sending message='{}' to topic='{}'", message, KafkaTopicEnum.DEMO_TOPIC.getKey());
        kafkaTemplate.send( KafkaTopicEnum.DEMO_TOPIC.getKey(), message);
    }
}

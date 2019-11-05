package cn.zephyr.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.messaging.MessageHeaders;
//import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * @ClassName: MyReceiver
 * @Author: laizonghao
 * @Description:
 * @Date: 2019/11/5 15:09
 */
@Service
@Slf4j
public class MyReceiver {

    @KafkaListener(topics = "DEMO_TOPIC")
    public void listen(@Payload String message) {
        log.info("received message='{}'", message);
    }
}

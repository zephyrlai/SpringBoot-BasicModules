package cn.zephyr.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Data
@Component
public class SysProperties extends Properties {
    @Value("${apache.rocketmq.consumer.customerGroup}")
    private String customerGroup;
    @Value("${apache.rocketmq.producer.producerGroup}")
    private String producerGroup;
    @Value("${apache.rocketmq.namesrvAddr}")
    private String nameServerAddr;
}

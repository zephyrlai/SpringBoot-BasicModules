package cn.zephyr.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName: KafkaTopicEnum
 * @Author: laizonghao
 * @Description:
 * @Date: 2019/11/5 15:13
 */
@AllArgsConstructor
@Getter
public enum KafkaTopicEnum {
    DEMO_TOPIC("DEMO_TOPIC","测试主题"),
    ;
    private String key;
    private String desc;
}

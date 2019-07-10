package cn.zephyr.redis.publisher;

import cn.zephyr.redis.enums.TopicEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author: laizonghao
 * @Description:
 * @Date: 2019-07-10 11:08
 */
@Service
public class PublisherService {
    private static Logger logger = LoggerFactory.getLogger(PublisherService.class);
    @Autowired
    private StringRedisTemplate redisTemplate;

    public String send01Message(String msg) {
        try {
            redisTemplate.convertAndSend(TopicEnum.TOPIC_01.getCode(), msg);
            logger.info("Topic01消息发送成功了,消息内容：{}",msg);
            return "消息发送成功了";

        } catch (Exception e) {
            e.printStackTrace();
            return "消息发送失败了";
        }
    }

    public String send02Message(String msg) {
        try {
            redisTemplate.convertAndSend(TopicEnum.TOPIC_02.getCode(), msg);
            logger.info("Topic02消息发送成功了,消息内容：{}",msg);
            return "消息发送成功了";

        } catch (Exception e) {
            e.printStackTrace();
            return "消息发送失败了";
        }
    }
}
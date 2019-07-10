package cn.zephyr.redis.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @Author: laizonghao
 * @Description:
 * @Date: 2019-07-10 11:06
 */
@Component
public class Topic02Listener implements MessageListener {
    private static Logger logger = LoggerFactory.getLogger(Topic02Listener.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        RedisSerializer<String> valueSerializer = redisTemplate.getStringSerializer();
        String deserialize = valueSerializer.deserialize(message.getBody());
        logger.info("这里是02监听器，收到的mq消息：{}" ,deserialize);
    }
}
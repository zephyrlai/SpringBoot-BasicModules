package cn.zephyr.redis.consumer;

import cn.zephyr.redis.enums.TopicEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @Author: laizonghao
 * @Description:
 * @Date: 2019-07-10 11:05
 */
@Configuration
//@AutoConfigureAfter({Topic01Listener.class})
public class SubscriberConfig {

    @Autowired
    private Topic01Listener topic01Listener;
    @Autowired
    private Topic02Listener topic02Listener;

    /**
     * 创建消息监听容器
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisMessageListenerContainer getRedisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory) {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        redisMessageListenerContainer.addMessageListener(new MessageListenerAdapter(topic01Listener), new PatternTopic(TopicEnum.TOPIC_01.getCode()));
        redisMessageListenerContainer.addMessageListener(new MessageListenerAdapter(topic02Listener), new PatternTopic(TopicEnum.TOPIC_02.getCode()));
        //……………………，多个监听器就继续依照上面的配置加入到监听容器
        return redisMessageListenerContainer;
    }
}

package helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Liuqi
 * Date: 2017/5/17.
 */
@SpringBootApplication
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory factory, MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        container.addMessageListener(listenerAdapter, new PatternTopic("chat"));
        return container;
    }

    @Bean
    public MessageListenerAdapter adapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    public Receiver receiver(CountDownLatch latch) {
        return new Receiver(latch);
    }

    @Bean
    public CountDownLatch countDownLatch() {
        return new CountDownLatch(1);
    }

    @Bean
    public StringRedisTemplate template(RedisConnectionFactory factory) {
        return new StringRedisTemplate(factory);
    }

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        StringRedisTemplate template = context.getBean(StringRedisTemplate.class);
        CountDownLatch countDownLatch = context.getBean(CountDownLatch.class);
        LOGGER.info("Sending message...");
        template.convertAndSend("chat", "Hello from Redis!");

        countDownLatch.await();

        System.exit(0);
    }
}

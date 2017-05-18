package rabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by Liuqi
 * Date: 2017/5/18.
 */
@Component
public class MyRunner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;
    private final ConfigurableApplicationContext applicationContext;

    public MyRunner(RabbitTemplate rabbitTemplate, Receiver receiver, ConfigurableApplicationContext applicationContext) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiver = receiver;
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("sending message---------");
        rabbitTemplate.convertAndSend(Application.queueName, "hello from rabbitMQ");
        receiver.getLatch().await(1000, TimeUnit.MILLISECONDS);
        applicationContext.close();

    }
}

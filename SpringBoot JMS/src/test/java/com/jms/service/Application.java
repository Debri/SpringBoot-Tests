package com.jms.service;

import com.jms.domain.Email;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;

/**
 * Created by Liuqi
 * Date: 2017/5/17.
 */
@SpringBootApplication
@EnableJms
public class Application {
    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        //提供了这个factory的所有引导默认值，包括消息转换器
        configurer.configure(factory, connectionFactory);
        return factory;
    }

    //将消息内容序列化到json
    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        JmsTemplate jmsTemplate = applicationContext.getBean(JmsTemplate.class);
        System.out.println("Sending an email message");
        jmsTemplate.convertAndSend("mailBox", new Email("debri_liu@163.com", "hello"));
    }
}

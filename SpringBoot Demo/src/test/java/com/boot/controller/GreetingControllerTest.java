package com.boot.controller;

import com.boot.service.StorageProperties;
import com.boot.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * Created by Liuqi
 * Date: 2017/5/16.
 */
@SpringBootApplication(scanBasePackages = {"com.boot.service","com.boot.controller"})//same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableConfigurationProperties(StorageProperties.class)
/*@ComponentScan(value = "com.boot.service.*")*/
public class GreetingControllerTest {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(GreetingControllerTest.class);
        application.run(args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
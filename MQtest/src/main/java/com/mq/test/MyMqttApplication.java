package com.mq.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MyMqttApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyMqttApplication.class, args);
    }
}
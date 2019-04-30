package com.mq.test.config;


import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/24
 */
@Configuration
public class MqttConfig {

    @Value("${mqtt.host}")
    String host;
    @Value("${mqtt.username}")
    String username;
    @Value("${mqtt.password}")
    String password;

    /**
     * publish--出站操作
     * @return
     */
    @Bean(name = "mqttOutbound")
    public ConcurrentHashMap<String, MyMqttPahoMessageHandler> mqttOutbound() {
        return new ConcurrentHashMap<>();
    }

    /**
     * 入站操作
     * @return
     */
    @Bean(name = "mqttInbound")
    public ConcurrentHashMap<String, MyMqttPahoMessageDrivenChannelAdapter> mqttInbound() {
        return new ConcurrentHashMap<>();
    }

    /**
     * 创建客户端工厂
     * @return
     */
    @Bean
    public DefaultMqttPahoClientFactory factory(){
        MqttConnectOptions options = new MqttConnectOptions();
        // 设定URI
        options.setServerURIs(new String[]{host});
        // 设置用户名和密码
        options.setUserName(username);
        char[] pwd = password.toCharArray();
        options.setPassword(pwd);
        // true表示每次连接到服务器都以新的身份连接，默认为true
        options.setCleanSession(true);
        // 设置超时时间，默认30秒 单位秒
        options.setConnectionTimeout(30);
        // 会话心跳时间 默认60秒 单位秒
        options.setKeepAliveInterval(60);

        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(options);

        //MemoryPersistence persistence = new MemoryPersistence();
        //factory.setPersistence(persistence);

        return factory;
    }
}

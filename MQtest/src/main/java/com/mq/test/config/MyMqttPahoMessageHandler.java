package com.mq.test.config;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;

/**
 * @author Wang Junbo
 * @description 出站消息的处理
 * @date 2019/4/24
 */
public class MyMqttPahoMessageHandler extends MqttPahoMessageHandler {

    public MyMqttPahoMessageHandler(String clientId, MqttPahoClientFactory clientFactory) {
        super(clientId, clientFactory);
    }

    /**
     * 发布消息
     */
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        publish(topic, message, null);
    }
}

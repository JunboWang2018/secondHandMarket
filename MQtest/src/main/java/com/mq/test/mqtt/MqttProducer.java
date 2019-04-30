package com.mq.test.mqtt;

import com.alibaba.fastjson.JSON;
import com.mq.test.config.MyMqttPahoMessageHandler;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by my on 2018/9/6.
 */
@Component
public class MqttProducer {
    private static final Logger logger = LoggerFactory.getLogger(MqttProducer.class);

    @Autowired
    private DefaultMqttPahoClientFactory factory;


    @Autowired
    @Qualifier("mqttOutbound")
    private ConcurrentHashMap<String, MyMqttPahoMessageHandler> mqttOutbound;

    @Bean
    public MessageChannel mqttOutputChannel() {
        return new DirectChannel();
    }

    /**
     * 获取交互用的Client终端
     * @param clientId： 客户端ID
     * @return
     */
    private MyMqttPahoMessageHandler getMqttOutBound(String clientId) {
        MyMqttPahoMessageHandler handler = mqttOutbound.get(clientId);
        if (handler == null) {
            handler = new MyMqttPahoMessageHandler(clientId, factory);
            handler.setAsync(true);
            handler.setConverter(new DefaultPahoMessageConverter());
            handler.setAsyncEvents(true);
            //handler.setBeanFactory(mock(BeanFactory.class));
            //EventPublisher publisher = new EventPublisher();
            //handler.setApplicationEventPublisher(publisher);
            handler.afterPropertiesSet();
            handler.start();
            mqttOutbound.put(clientId, handler);
        }

        return handler;
    }


    public void sendMessage(String clientId, String topic, String payload) throws Exception {
        sendMessage(clientId, topic, 0, payload);
    }

    public void sendMessage(String clientId, String topic, int qos, String payload) throws Exception{
        sendMessage(clientId, topic, qos, false , payload);
    }

    /**
     * 发送数据
     * @param clientId：全局唯一ID
     * @param topic：主题
     * @param qos：服务质量
     * @param retained：是否保留
     * @param payload：发送内容
     * @throws Exception
     */
    public void sendMessage(String clientId, String topic, int qos, boolean retained,String payload) throws Exception{
        MyMqttPahoMessageHandler outBound = getMqttOutBound(clientId);
        MqttMessage message = new MqttMessage();
        message.setRetained(retained);
        message.setQos(qos);
        message.setPayload(payload.getBytes());
        //message.setId(messageId);
        outBound.messageArrived(topic, message);
        logger.info("outBound="+JSON.toJSONString(message));
    }
}

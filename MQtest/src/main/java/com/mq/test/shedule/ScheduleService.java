package com.mq.test.shedule;

import com.alibaba.fastjson.JSON;
import com.mq.test.mqtt.MqttConsumer;
import com.mq.test.mqtt.MqttProducer;
import com.mq.test.util.UUIDUtil;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by my on 2018/9/6.
 */
@Component
public class ScheduleService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MqttProducer producer;

    @Autowired
    private MqttConsumer consumer;

    //@Scheduled(cron = "0/5 * * * * ?")
    public void sendMsg(){
        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setQos(1);
        mqttMessage.setRetained(true);
      //  mqttMessage.setId(1);
        String firstMsg = "the first message";
        mqttMessage.setPayload(firstMsg.getBytes());
        try {
            System.out.println("my-producer:" + JSON.toJSONString(mqttMessage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String producerId= null;
    @Scheduled(cron = "0/5 * * * * ?")
    public void sendMsg2(){
        String firstMsg = "the first message";
        try {
            if (producerId == null) {
                producerId = UUIDUtil.getUUID();
            }
            //producerId = "12345678";
            producer.sendMessage(producerId, "topic1", 1, false, firstMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String consumerId1 = null;
    @Scheduled(cron = "0/2 * * * * ?")
    public void rcvMsg(){
        try {
            int qos = 1;
            String topics = "topic1";
            if (consumerId1 == null) {
                consumerId1 = UUIDUtil.getUUID();
            }
            //consumerId1 = "123456789";
            consumer.subScribe(consumerId1, qos, topics);
            logger.info("订阅");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String consumerId2 = null;
    @Scheduled(cron = "0/2 * * * * ?")
    public void rcvMsg2(){
        try {
            int qos = 1;
            String topics = "topic1";
            if (consumerId2 == null) {
                consumerId2 = UUIDUtil.getUUID();
            }
            //consumerId2 = "1234567890";
            consumer.subScribe(consumerId2, qos, topics);
            logger.info("订阅");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
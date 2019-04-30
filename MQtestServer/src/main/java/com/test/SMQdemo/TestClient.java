package com.test.SMQdemo;

import cn.showclear.msg.queue.service.mqtt.IMqttReceiveEvent;
import cn.showclear.msg.queue.service.mqtt.IMsgListener;
import cn.showclear.msg.queue.service.mqtt.manage.MqttManagerImpl;
import cn.showclear.msg.queue.service.vo.ConfigBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/25
 */
public class TestClient {
    public static void main(String[] args) {
        ConfigBean configBean = new ConfigBean("admin","password","tcp://192.168.105.94:61613", 10);
        MqttManagerImpl mqttManger = new MqttManagerImpl(configBean);

        IMqttReceiveEvent mqttReceiveEvent = new Receive();
        mqttManger.setReceiveEvent(mqttReceiveEvent);

        mqttManger.subscribe("/call/status1");

        List<IMsgListener> msgListener = new ArrayList();
        msgListener.add(new SubEvent("subEvent1"));
        msgListener.add(new SubEvent("subEvent2"));
        msgListener.add(new SubEvent("subEvent3"));
        mqttManger.setMsgListeners(msgListener);
        mqttManger.connect();



        Timer timer = new Timer();
        SendMSG operateScreen = new SendMSG();
        operateScreen.setMqttManger(mqttManger);
        timer.schedule(operateScreen, 0L, 2000L);

/*
        MessageModel messageModel = new MessageModel(1, "add", "lalal", "我就是我");
        mqttManger.publish("/scooper-fax", messageModel);*/
    }
}

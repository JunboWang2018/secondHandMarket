package com.test.SMQdemo;

import cn.showclear.msg.queue.service.mqtt.manage.MqttManagerImpl;
import cn.showclear.msg.queue.service.vo.MessageModel;

import java.util.TimerTask;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/26
 */
public class SendMSG extends TimerTask {
    MqttManagerImpl mqttManger;
    static int i = 0;

    public void setMqttManger(MqttManagerImpl mqttManger) {
        this.mqttManger = mqttManger;
    }
    public void run() {
        MessageModel messageModel = new MessageModel(1, "add", "消息" + ++i, "我就是我");
        this.mqttManger.publish("/call/status1", messageModel);
        System.out.println(messageModel.toString());
    }
}

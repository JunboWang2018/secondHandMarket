package com.test.SMQdemo;

import cn.showclear.msg.queue.service.mqtt.IMqttReceiveEvent;
import cn.showclear.msg.queue.service.vo.MessageModel;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/26
 */
public class Receive implements IMqttReceiveEvent {
    public Receive() {
    }

    public Object doReceiveEvent(String topic, MessageModel message) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }

        System.out.println("回调方法获取" + topic + "   " + message.getData().toString());
        return 0;
    }
}

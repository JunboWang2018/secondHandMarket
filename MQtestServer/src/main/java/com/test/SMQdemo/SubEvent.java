package com.test.SMQdemo;

import cn.showclear.msg.queue.service.mqtt.IMsgListener;
import cn.showclear.msg.queue.service.mqtt.Subscribe;
import cn.showclear.msg.queue.service.vo.MessageModel;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/25
 */
public class SubEvent implements IMsgListener {

    private String name;

    public SubEvent(String name) {
        this.name = name;
    }

    @Subscribe("/call/status1")
    public void alarmEvent(String topic, MessageModel message) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }

        System.out.println(this.name + " 注解获取/call/status：主题【" + topic + "】:" + message.getData().toString() + ", type = " + message.getType());
    }

    @Subscribe("/alarm/meet/#")
    public void alarmAdd(String topic, MessageModel message) {
        System.out.println("注解获取/alarm/meet/#：主题【" + topic + "】:" + message.toString());
    }
}

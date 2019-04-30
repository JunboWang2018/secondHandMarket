package com.mq.test.config;

import com.alibaba.fastjson.JSON;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/24
 */
public class MyMqttPahoMessageDrivenChannelAdapter extends MqttPahoMessageDrivenChannelAdapter {
    private Logger logger = LoggerFactory.getLogger(getClass());
    public MyMqttPahoMessageDrivenChannelAdapter(String clientId, MqttPahoClientFactory clientFactory, String topic) {
        super(clientId, clientFactory, topic);
    }

    /**
     * 从服务器接收消息
     * MQTT客户端同步调用此方法。在此方法干净地返回之前，不会将确认发送回服务器
     * 如果此方法的实现抛出异常，则客户端将被关闭。下次重新连接客户端时，服务器将重新传送任何QoS 1或2消息。
     * 在此方法的实现运行时到达的任何其他消息将在内存中建立，然后将在网络上备份。
     * 如果应用程序需要持久保存数据，则应确保在从此方法返回之前保留数据，因为从此方法返回后，消息被视为已传递，并且将无法再现。
     * 可以在此回调的实现中发送新消息（例如，对此消息的响应），但实现不得断开客户端，因为无法发送对正在处理的消息的确认，以及会发生死锁。
     */
    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        //super.messageArrived(topic, mqttMessage);
        String clientId2 = this.getClientId();
        logger.info("接收的数据，clientId="+clientId2+",topic="+topic+", msg=" + JSON.toJSONString(mqttMessage));
    }

    /**
     * 断开服务器连接时触发
     */
    @Override
    public synchronized void connectionLost(Throwable cause) {
        // TODO Auto-generated method stub
        logger.info("connectionLost");
        super.connectionLost(cause);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // TODO Auto-generated method stub
        logger.info("deliveryComplete");
        super.deliveryComplete(token);
    }

}

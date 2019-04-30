package com.mq.test.demo;

import java.util.Arrays;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttPublish {


    public static void main(String[] args) {
        String topic = "MQTT Examples";
        String content = "Message from MqttPublish";
        int qos = 1;
        String broker = "tcp://192.168.105.87:61613";
        String clientId = "tcp1";
        MemoryPersistence persistence = new MemoryPersistence();

        try {

            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            connOpts.setUserName("admin");
            char[] pass = "password".toCharArray();
            connOpts.setPassword(pass);
            System.out.println("Connecting to broker: " + broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: " + content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");
            //sampleClient.disconnect();
            System.out.println("Disconnected");

            sampleClient.setCallback(new MqttCallback() {

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    System.out.println(topic + ": " + Arrays.toString(message.getPayload()));
                }

                // Called when a outgoing publish is complete
                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    System.out.println("deliveryComplete");
                }

                // Called when the client lost the connection to the broker
                @Override
                public void connectionLost(Throwable cause) {
                    System.out.println("lost the connection");
                }
            });

            //sampleClient.connect(connOpts);
            sampleClient.subscribe(topic, qos);
            //System.exit(0);
        } catch (Exception me) {
            //System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }
}

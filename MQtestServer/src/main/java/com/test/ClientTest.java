package com.test;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/25
 */
public class ClientTest {

    public static void main(String[] args) {
        ClientMQTT client1 = new ClientMQTT("client1");
        client1.start();
//        ClientMQTT client2 = new ClientMQTT("client2");
//        client2.start();
    }
}

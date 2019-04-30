package com.mq.test.mqtt;

import com.mq.test.config.MyMqttPahoMessageDrivenChannelAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 订阅消息处理
 * @author my
 *
 */
@Component
public class MqttConsumer {
    private static final Logger logger = LoggerFactory.getLogger(MqttConsumer.class);

    @Autowired
    private DefaultMqttPahoClientFactory factory;

    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

//	@Bean
//	@ServiceActivator(inputChannel = "mqttInputChannel")
//	public MessageHandler handler() {
//		return new MessageHandler() {
//			@Override
//			public void handleMessage(Message<?> message) throws MessagingException {
//				logger.info("MessageHandler="+ JSON.toJSONString(message));
//			}
//		};
//	}

    @Autowired
    @Qualifier("mqttInbound")
    private ConcurrentHashMap<String, MyMqttPahoMessageDrivenChannelAdapter> mqttInbound;

    /**
     * 获取消息驱动  入站管道适配器
     * @param clientId：全局唯一的ID
     * @param topics
     * @return
     */
    private MyMqttPahoMessageDrivenChannelAdapter getAdapter(String clientId, String topics) {
        MyMqttPahoMessageDrivenChannelAdapter adapter = mqttInbound.get(clientId);
        if (adapter == null) {
            adapter = new MyMqttPahoMessageDrivenChannelAdapter(clientId, factory, topics);
            adapter.setQos(1);
            adapter.setCompletionTimeout(5000);
            adapter.setConverter(new DefaultPahoMessageConverter());
            adapter.setOutputChannel(mqttInputChannel());
            ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
            taskScheduler.initialize();
            adapter.setTaskScheduler(taskScheduler);
            adapter.afterPropertiesSet();
            adapter.start();
            mqttInbound.put(clientId, adapter);
            logger.info("consumer, clientId="+clientId+", is OK.");
        }

        return adapter;
    }

    /**
     * 消费消息
     * @param clientId
     * @param qos
     * @param topics
     */
    public void subScribe(String clientId, int qos, String topics) {
        MyMqttPahoMessageDrivenChannelAdapter adapter = getAdapter(clientId, topics);
        adapter.setQos(qos);
    }
}

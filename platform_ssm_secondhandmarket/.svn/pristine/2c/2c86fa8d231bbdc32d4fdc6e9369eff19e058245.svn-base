/**
 *
 * Project Name: second-hand-market
 * File Name: InstantiationTracingBeanPostProcessor.java
 * Package Name: cn.showclear.www.config
 * Description: 
 * Copyright: Copyright (c) 2017
 * Company: 杭州叙简科技股份有限公司
 * @version 1.4.0
 * @author ZHENGKAI
 * @date 2017年1月12日下午5:25:53
 */
package cn.showclear.www.config;

import cn.showclear.utils.BiddOrderThread;
import cn.showclear.www.dao.base.product.ProductDao;
import cn.showclear.www.service.order.BiddRecordService;
import cn.showclear.www.service.order.OrderService;
import cn.showclear.www.service.product.ProductService;
import cn.showclear.www.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;

/**
 * spring容器初始化完成后业务操作
 * @Reason: TODO ADD REASON(可选). <br/>
 * @date: 2017年1月12日下午5:25:53 <br/>
 *
 * @author ZHENGKAI
 * @version 1.4.0
 */
public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger LOGGER = LoggerFactory.getLogger(InstantiationTracingBeanPostProcessor.class); 

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private BiddRecordService biddRecordService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	@Resource(name = "configProperties")
	private Properties configProperties;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("spring容器初始化完成");
		}
		
		if(event.getApplicationContext().getParent() == null) {
			//TODO 逻辑代码
			long interval = 60000; //默认一分钟
            if (configProperties != null) {
				interval = Long.valueOf(configProperties.getProperty("interval")).longValue();
			}
			//开启线程，注册竞价物品竞价期限检测服务
			LOGGER.debug("注册竞价物品定时检测任务，间隔时间为" + interval);
			BiddOrderThread timerTask = new BiddOrderThread(productService, productDao, biddRecordService, orderService, userService);
            Timer timer = new Timer();
            timer.schedule(timerTask, 0, interval);
        }
	}
}

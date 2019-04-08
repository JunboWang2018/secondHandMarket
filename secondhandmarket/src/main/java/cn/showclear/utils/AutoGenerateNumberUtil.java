package cn.showclear.utils;

import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Wang Junbo
 * @description 自动生成前缀+16位id工具类，prod表示二手物品，order表示订单，dmdi表示求购信息
 * @date 2019/4/8
 */
public class AutoGenerateNumberUtil {
    public static String getAutoGenerateId(String prefix) {
        Lock lock = new ReentrantLock(); //获得锁
        lock.lock();
        int hashCode = UUID.randomUUID().toString().hashCode();
        String generateId = prefix + hashCode;
        lock.unlock();
        return generateId;
    }
}

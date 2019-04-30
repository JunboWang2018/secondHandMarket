package com.mq.test.util;

import java.util.UUID;

/**
 * UUID工具类
 * @author my
 *
 */
public class UUIDUtil {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}

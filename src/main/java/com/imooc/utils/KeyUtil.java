package com.imooc.utils;

import java.util.Random;

/**
 * 商品id生成工具类
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     * 虽然重复的几率已经很低，但是为了防止多线程带来的隐患要加上synchronized
     * @return
     */
    public static synchronized  String genUniqueKey(){
        long millis = System.currentTimeMillis();

        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000; //六位随机数
        String str = String.valueOf(number);
        return millis + str;
    }
}

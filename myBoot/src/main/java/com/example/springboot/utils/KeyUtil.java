package com.example.springboot.utils;

import java.util.Random;

/**
 * @Auther: Administrator
 * @Date: 2018/10/14 14:30
 * @Description:
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     * synchronized 为了高并发时不重复
     * @return
     */
    public static synchronized String getUniqueKey(){
        Random random =new Random();
        Integer number =random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}

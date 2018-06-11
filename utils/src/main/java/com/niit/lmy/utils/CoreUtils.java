package com.niit.lmy.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 核心工具
 */
public class CoreUtils {
    //将时间日期转化为字符串
    public static String getDateTimeString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    //随机生成6位验证码
    public static String getRandomString(){
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6; i ++){
            int value = random.nextInt(10);
            stringBuffer.append(value);
        }
        return stringBuffer.toString();
    }
}

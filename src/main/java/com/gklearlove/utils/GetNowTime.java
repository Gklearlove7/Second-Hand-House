package com.gklearlove.utils;

import java.text.SimpleDateFormat;

/**
 * @Author: GK
 * @Date: 2020/5/7 13:47
 */
public class GetNowTime {
    public static String get_nowtime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now_date = df.format(System.currentTimeMillis());
        return now_date;
    }
}

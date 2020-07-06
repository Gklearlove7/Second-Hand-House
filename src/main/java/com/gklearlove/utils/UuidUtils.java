package com.gklearlove.utils;

import java.util.UUID;

/**
 * @Author: GK
 * @Date: 2020/4/25 21:01
 */
//工具类-生成UUID
public class UuidUtils {
    public static String generateUid(){
        return "U"+UUID.randomUUID().toString().replace("-","")+System.currentTimeMillis();
    }

}

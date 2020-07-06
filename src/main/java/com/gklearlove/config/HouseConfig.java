package com.gklearlove.config;

import org.springframework.context.annotation.Configuration;

/**
 * @Author: GK
 * @Date: 2020/5/11 21:30
 */
//房子信息的配置
@Configuration
public class HouseConfig {
    public String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }

//    private String baseurl="G:\\二手房网站\\房子目录\\pic\\";
//    private String baseurl="/app/second-house/user_pic/";
    //演示使用
        private String baseurl="G:\\second-house\\user_pic\\";
}

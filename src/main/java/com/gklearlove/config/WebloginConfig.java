package com.gklearlove.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: GK
 * @Date: 2020/5/13 17:20
 */
@Configuration
public class WebloginConfig extends WebMvcConfigurerAdapter {
    @Autowired
    LoginHandlerInterceptor loginHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //设置拦截的网址
        registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/house/add_house").addPathPatterns("/user/modify_password_page").addPathPatterns("/user/userinfo").addPathPatterns("/house/add_house").addPathPatterns("/user/become_seller_page").addPathPatterns("/user/go_allmyhouse").addPathPatterns("/house/get_allmyhouse").addPathPatterns("/house/put_pic").addPathPatterns("/house/add_house_info").addPathPatterns("/house/get_allmyhouse").addPathPatterns("/house/reserved").addPathPatterns("/house/submit_question").addPathPatterns("/house/submit_comment").addPathPatterns("/user/my_need").addPathPatterns("/user/submit_answer").addPathPatterns("/house/house_back")
        .addPathPatterns("/house/get_allmyneed").addPathPatterns("/house/not_need");
        super.addInterceptors(registry);
    }
}

package com.gklearlove.controller.adminstercontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: GK
 * @Date: 2020/4/18 0:53
 */
@Controller
public class MaiLControl {
    @Autowired
    JavaMailSender jms;

    @RequestMapping("/get_mail")
    String get_mail(){
        return "mail_demo";
    }
    @RequestMapping("/send")
    @ResponseBody
    public String send(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("782506171@qq.com");
        message.setTo("782506171@qq.com");
        message.setSubject("测试邮件");
        message.setText("这是一封测试邮件");
        System.out.println(message);
        jms.send(message);
        return "ok";
    }
}


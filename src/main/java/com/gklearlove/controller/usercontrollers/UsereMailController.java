package com.gklearlove.controller.usercontrollers;

import com.gklearlove.entity.user.User;
import com.gklearlove.service.userservice.IUserForgetServiceImpl;
import com.gklearlove.service.userservice.UserServiceImp;
import com.gklearlove.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @Author: GK
 * @Date: 2020/4/28 22:39
 */
@RequestMapping("/user")
@Controller
public class UsereMailController {
    @Autowired
    JavaMailSender jms;

    @Autowired
    UserServiceImp userServiceImp;

    @Autowired
    IUserForgetServiceImpl userForgetService;

    //修改用户的邮箱
    @RequestMapping("/modify_email_page")
    public String modify_email_page(){
        return "modify_email";
    }

//    //修改密码
    @RequestMapping("/forget_password_modify")
    @ResponseBody
    public HashMap<String,Object>  check_forget_password(@RequestParam("user_account") String user_account,@RequestParam("new_password") String user_password, @RequestParam("captcha") String captcha, HttpSession session){
        String code = (String) session.getAttribute("forget_code");
        HashMap<String, Object> data = new HashMap<>();
        if(captcha.equals(code)){
            //根据User_account查出信息
            User need_user = userForgetService.get_mail(user_account);
            need_user.setUser_password(user_password);
            int result = userServiceImp.modify_password(need_user);
            if(result != 0){
                data.put("code", 200);
                data.put("msg", "ok");
                return data;
            }else {
                data.put("code", 200);
                data.put("msg", "no");
                return data;
            }
        }else {
            data.put("code", 200);
            data.put("msg", "no");
            return data;
        }

    }

    //发送忘记密码的邮件
    @RequestMapping("/forget_send")
    @ResponseBody
    public String forget_send(@RequestParam("user_account") String user_account, HttpSession session) throws MessagingException {
        //根据user_account查出用户邮件
        User need_user = userForgetService.get_mail(user_account);
        if (need_user==null){
            return null;
        }else {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("782506171@qq.com");
            message.setTo(need_user.getUser_email());
            message.setSubject("重设新邮箱");
            String random = RandomUtil.getRandom();
//        String html = Htmltext.html(random);
            System.out.println(random);
            message.setText(random);
            session.setAttribute("forget_code",random);
            jms.send(message);
            return random;
        }

    }


    //发送邮件
    @RequestMapping("/send")
    @ResponseBody()
    public String send(@RequestParam("user_email") String email, HttpSession session) throws MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("782506171@qq.com");
        message.setTo(email);
        message.setSubject("重设新邮箱");
        String random = RandomUtil.getRandom();
//        String html = Htmltext.html(random);
        System.out.println(random);
        message.setText(random);
        session.setAttribute("code",random);
        jms.send(message);
        return random;
    }

    //审核验证码
    @RequestMapping("/check_mail")
    @ResponseBody
    public HashMap<String,Object>  check_mail(@RequestParam("user_email") String user_email, @RequestParam("captcha") String captcha, HttpSession session){
        String code = (String) session.getAttribute("code");
        User user = (User) session.getAttribute("user");
        HashMap<String, Object> data = new HashMap<>();
        if(captcha.equals(code)){
            user.setUser_email(user_email);
            int result = userServiceImp.modify_email(user);
            if(result != 0){
                session.setAttribute("user",user);
                data.put("code", 200);
                data.put("msg", "ok");
                return data;
            }else {
                data.put("code", 200);
                data.put("msg", "no");
                return data;
            }
        }else {
            data.put("code", 200);
            data.put("msg", "no");
            return data;
        }

    }


}

package com.gklearlove.controller.usercontrollers;

import com.gklearlove.entity.house.House;
import com.gklearlove.entity.seller.Seller;
import com.gklearlove.entity.user.Advise;
import com.gklearlove.entity.user.User;
import com.gklearlove.service.houseservice.HouseServiceImp;
import com.gklearlove.service.userservice.UserServiceImp;
import com.gklearlove.utils.GetNowTime;
import com.gklearlove.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: GK
 * @Date: 2020/4/24 23:59
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    UserServiceImp userServiceImp;
    @Autowired
    HouseServiceImp houseserviceImp;

    //前往登陆
    @RequestMapping("/gologin")
    public String gologin() {
        return "login";
    }

    //对用户登陆信息进行校验
    @RequestMapping("/login_judge")
    public String login_judge(User user, HttpSession session) {
        User result = userServiceImp.login(user);
        if (result != null) {
            if (result.getUser_status() == 0) {
                return "forbid";
            } else {
                session.setAttribute("user", result);
                List<House> newhouse = houseserviceImp.get_newhouse();
                List<House> mosthouse = houseserviceImp.get_mosthouse();
                session.setAttribute("newhouse", newhouse);
                session.setAttribute("mosthouse", mosthouse);
                //判断是否有这个卖家
                int is_seller = userServiceImp.is_seller(result.getUser_id());
                session.setAttribute("is_seller", is_seller);
                return "index";
            }
        } else {
            return "login";
        }
    }

    //找回密码
    @RequestMapping("/forget_password")
    public String forget_page(){
        return "forget_password";
    }



    //退出登陆
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    //用户注册处理
    @RequestMapping("/goregister")
    public String goregister() {
        return "register";
    }

    @RequestMapping("/register")
    public String register(User user) {
        int result = userServiceImp.register(user);
        if (result != 0) {
            return "login";
        } else {
            return "register";
        }
    }

    //查看个人信息
    @RequestMapping("/userinfo")
    public String userinfo(HttpServletRequest request, HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "userinfo";
        } else {
            return gologin();
        }
    }

    //修改用户信息
    @RequestMapping("/modify_userinfo")
    @ResponseBody
    public HashMap<String, Object> modify_userinfo(User user, HttpSession session) {
        //取出user_id
        User user1 = (User) session.getAttribute("user");
        String sex = user.getUser_sex();
        if (sex.equals("2")) {
            user.setUser_sex("女");
        } else {
            user.setUser_sex("男");
        }
        user.setUser_id(user1.getUser_id());
        int result = userServiceImp.modify_userinfo(user);
        if (result != 0) {
            //这里需要更新一下session的user
            session.setAttribute("user", userServiceImp.get_new_info(user.getUser_id()));
            HashMap<String, Object> data = new HashMap<>();
            data.put("code", 200);
            data.put("msg", "ok");
            return data;
        } else {
            return null;
        }

    }

    //修改账户密码页面
    @RequestMapping("/modify_password_page")
    public String modify_password_page() {
        return "modify_password";
    }

    //修改账户密码的操作
    @RequestMapping("/modify_password")
    @ResponseBody
    public HashMap<String, Object> modify_password(@RequestParam("new_password") String new_password, HttpSession session) {
        //取出user_id
        User user = (User) session.getAttribute("user");
        user.setUser_password(new_password);
        //修改密码
        int result = userServiceImp.modify_password(user);
        System.out.println(user);
        if (result != 0) {
            session.setAttribute("user", user);
            HashMap<String, Object> data = new HashMap<>();
            data.put("code", 200);
            data.put("msg", "ok");
            return data;
        } else {
            HashMap<String, Object> data = new HashMap<>();
            data.put("code", 200);
            data.put("msg", "no");
            return data;
        }
    }

    //跳转我的需要页面
    @RequestMapping("/my_need")
    public String my_need(){
        return "my_need";
    }

    //获取我的所有需求订单


    //成为自由经纪人
    @RequestMapping("/become_seller_page")
    public String become_seller_page(HttpSession session) {
        int is_seller = (int) session.getAttribute("is_seller");
        if (is_seller == 0) {
            return "become_seller";
        } else {
            return "is_seller";
        }
    }

    @RequestMapping("/become_seller")
    @ResponseBody
    public HashMap<String, Object> become_seller(Seller seller, HttpSession session) {
        //取出user_id，使之成为seller的seller_id
        User user = (User) session.getAttribute("user");
        String seller_id = user.getUser_id();
        String sex = seller.getSeller_sex();
        if (sex.equals("2")) {
            seller.setSeller_sex("女");
        } else {
            seller.setSeller_sex("男");
        }
        //注册一个seller
        seller.setSeller_id(seller_id);
        //设置可用初始化为0等待管理员的认证
        seller.setSeller_pass(0);
        int result = userServiceImp.become_seller(seller);
        if (result != 0) {
            session.setAttribute("seller", seller);
            HashMap<String, Object> data = new HashMap<>();
            data.put("code", 200);
            data.put("msg", "ok");
            session.setAttribute("is_seller",1);
            return data;
        } else {
            HashMap<String, Object> data = new HashMap<>();
            data.put("code", 200);
            data.put("msg", "no");
            return data;
        }
    }

    //跳转到我出售的房子
    @RequestMapping("/go_allmyhouse")
    public String go_allmyhouse(HttpSession session) {
        User user = (User) session.getAttribute("user");
        int seller_can = userServiceImp.seller_can(user.getUser_id());
        int is_seller = (int) session.getAttribute("is_seller");
        if (is_seller == 1) {
            if (seller_can == 0) {
                return "seller_forbid";
            } else {
                return "my_seller";
            }
        } else {
            return become_seller_page(session);
        }

    }

    //提交建议
    @RequestMapping(value = "/submit_advise")
    @ResponseBody
    public HashMap<String, Object> pass_seller(@RequestParam("advise_detail") String advise_detail){
        String advise_id = "ad"+UuidUtils.generateUid();
        String advise_time = GetNowTime.get_nowtime();
        Advise advise = new Advise();
        advise.setAdvise_id(advise_id);
        advise.setAdvise_accept(0);
        advise.setAdvise_detail(advise_detail);
        advise.setAdvise_time(advise_time);
        //添加这条建议
        int result = userServiceImp.submit_advise(advise);
        HashMap<String, Object> data = new HashMap<>();
        if(result!=0){
            data.put("code", 200);
            data.put("msg", "ok");
            return data;
        }else{
            //更新出错返回错误
            data.put("code", 200);
            data.put("msg", "no");
            return data;
        }

    }

    //回答问题
    //提交评论
    @RequestMapping("/submit_answer")
    @ResponseBody
    public HashMap<String,Object> submit_answer(@RequestParam("question_id") String question_id,
                                                 @RequestParam("answer_text") String answer_text,HttpSession session){


        int result = userServiceImp.answer_question(question_id, answer_text);
        HashMap<String, Object> data = new HashMap<>();
        if (result!=0){
            data.put("code", 0);
            data.put("msg", "yes");
            return data;
        }else {
            data.put("code", 0);
            data.put("msg", "no");
            return data;
        }

    }
}
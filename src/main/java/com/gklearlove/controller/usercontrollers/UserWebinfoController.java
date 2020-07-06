package com.gklearlove.controller.usercontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: GK
 * @Date: 2020/4/27 21:20
 */
@RequestMapping("/user")
@Controller
public class UserWebinfoController {
    //跳转关于我们页面
    @RequestMapping("/about")
    public String about(){
        return "about";
    }

    //跳转到联系我们页面
    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }
}

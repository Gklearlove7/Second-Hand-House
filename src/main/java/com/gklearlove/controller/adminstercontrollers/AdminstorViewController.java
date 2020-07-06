package com.gklearlove.controller.adminstercontrollers;

import com.github.pagehelper.PageInfo;
import com.gklearlove.entity.adminstor.Adminstor;
import com.gklearlove.entity.appoint.Appoint;
import com.gklearlove.entity.seller.Seller;
import com.gklearlove.entity.user.Advise;
import com.gklearlove.entity.user.Comment;
import com.gklearlove.entity.user.Evaluation;
import com.gklearlove.entity.user.User;
import com.gklearlove.service.adminstorservice.AdminstorServiceImp;
import com.gklearlove.service.userservice.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @Author: GK
 * @Date: 2020/4/9 9:12
 */
@Controller
@RequestMapping("/adminstor")
public class AdminstorViewController {
    @Autowired
    AdminstorServiceImp adminstorService;
    @Autowired
    UserServiceImp userServiceImp;
    //进入登陆页面,跳转到登陆的页面
    @RequestMapping("/gologin")
    public String gologin(){

        return "adminstorlogin";
    }

    //处理登陆页面提交的数据
    @RequestMapping("/login")
    public String login(Adminstor adminstor, HttpSession session, HttpServletRequest request){
        //这里拿到登陆数据封装在user这个对象里面，接下来用service层对其进行逻辑操作
        int login = adminstorService.login(adminstor);
        if (login!=0){
            return "adminstor_manage";
        }
        else {
            return "adminstorlogin";
        }
    }

    //获取所有用户信息
    @RequestMapping("/getAlluser")
    @ResponseBody
    public HashMap<String, Object> getAlluser(@RequestParam("page") int startPage, @RequestParam("limit") int maxPage, HttpServletRequest request) {
        PageInfo<User> pageInfo = adminstorService.get_user(startPage,maxPage);
        //利用HashMap方便转json
        HashMap<String, Object> resData = new HashMap<>();
        resData.put("code", 0);
        resData.put("msg", "");
        resData.put("count", pageInfo.getTotal());
        resData.put("data", pageInfo.getList());
        return resData;
    }
    //切换用户状态
    @RequestMapping("/switchstatusByuserid")
    @ResponseBody
    public HashMap<String,Object> switchstatusByuserid(@RequestParam("user_id") String user_id){
        //根据user_id查询用户信息
        User user = adminstorService.get_userinfo_byuser_id(user_id);
        int user_status = user.getUser_status();
        int new_user_status = (user_status+1)%2;
        //设置新的用户状态
        int result = adminstorService.set_new_status(user_id, new_user_status);
        HashMap<String, Object> data = new HashMap<>();

        if(result!=0){
            data.put("code", 200);
            data.put("msg", "ok");
            return data;
        }else {
            //遇到未知错误更新失败
            data.put("code", 200);
            data.put("msg", "no");
            return data;
        }
    }

    //评价信息区
    //获得所有评价数据数据
    @RequestMapping(value = "/getAllcomment")
    @ResponseBody
    public HashMap<String, Object> getAllcomment(@RequestParam("page") int startPage, @RequestParam("limit") int maxPage, HttpServletRequest request) {
        PageInfo<Comment> pageInfo = adminstorService.get_comment(startPage,maxPage);
        //利用HashMap方便转json
        HashMap<String, Object> resData = new HashMap<>();
        resData.put("code", 0);
        resData.put("msg", "");
        resData.put("count", pageInfo.getTotal());
        resData.put("data", pageInfo.getList());
        return resData;
    }
    //删除恶意评价信息
    @RequestMapping(value = "/remove_comment")
    @ResponseBody
    //@PathVariable的作用是将占位符中的内容取出
    public HashMap<String, Object> remove_comment(@RequestParam("comment_id") String comment_id){
        //获取指定comment_id的留言信息
        Comment comment = adminstorService.get_commentinfo_bycomment_id(comment_id);
        //这个时候要删除此条comment
        int result = adminstorService.remove_comment(comment_id);
        HashMap<String, Object> data = new HashMap<>();

        if(result!=0){
            data.put("code", 200);
            data.put("msg", "ok");
            return data;
        }else{
            //更新出错返回错误
            data.put("code", 200);
            data.put("msg", "ok");
            return data;
        }

    }

    //建议信息区
    //获得所有建议数据
    @RequestMapping(value = "/getAlladvise")
    @ResponseBody
    public HashMap<String, Object> getAlladvise(@RequestParam("page") int startPage, @RequestParam("limit") int maxPage) {
        //获取已经分页的数据

        PageInfo<Advise> pageInfo = adminstorService.get_advise(startPage,maxPage);
        //创建制定类型的字典
        HashMap<String, Object> resData = new HashMap<>();
        resData.put("code", 0);
        resData.put("msg", "");
        resData.put("count", pageInfo.getTotal());
        resData.put("data", pageInfo.getList());
        return resData;
    }

    //获取所有卖家信息
    @RequestMapping(value = "/getAllseller")
    @ResponseBody
    public HashMap<String,Object> getAllseller(@RequestParam("page") int startPage, @RequestParam("limit") int maxPage){
        PageInfo<Seller> pageInfo = adminstorService.get_seller(startPage,maxPage);
        HashMap<String, Object> resData = new HashMap<>();
        resData.put("code", 0);
        resData.put("msg", "");
        resData.put("count", pageInfo.getTotal());
        resData.put("data", pageInfo.getList());
        return resData;

    }

    //审核卖家
    @RequestMapping(value = "/pass_seller")
    @ResponseBody
    public HashMap<String, Object> pass_seller(@RequestParam("seller_id") String seller_id){
        //首先获取指定seller_id的状态
        int seller_pass = userServiceImp.seller_can(seller_id);
        int new_pass = (seller_pass+1)%2;
        //这个时候要删除此条comment
        int result = adminstorService.check_seller(seller_id,new_pass);
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

    //通过建议
    @RequestMapping(value = "/adopt_advise")
    @ResponseBody
    public HashMap<String, Object> adopt_advise(@RequestParam("advise_id") String advise_id){
        //获取当前accept
        int advise_accept = (adminstorService.get_accept(advise_id)+1)%2;
        //通过建议
        int result = adminstorService.adopt_advise(advise_id,advise_accept);
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

    //获取所有的指定购房信息
    @RequestMapping(value = "/getAllappoint")
    @ResponseBody
    public HashMap<String,Object> getAllappoint(@RequestParam("page") int startPage, @RequestParam("limit") int maxPage){
        PageInfo<Appoint> pageInfo = adminstorService.get_appoint(startPage,maxPage);
        HashMap<String, Object> resData = new HashMap<>();
        resData.put("code", 0);
        resData.put("msg", "");
        resData.put("count", pageInfo.getTotal());
        resData.put("data", pageInfo.getList());
        return resData;

    }

    //已获悉
    @RequestMapping(value = "/know_appoint")
    @ResponseBody
    public HashMap<String, Object> know_appoint(@RequestParam("appoint_id") String appoint_id){
        //删除这条指定购房需求，已获悉
        int result = adminstorService.know_appoint(appoint_id);
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



}

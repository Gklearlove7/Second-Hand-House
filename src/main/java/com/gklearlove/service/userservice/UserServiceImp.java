package com.gklearlove.service.userservice;

import com.gklearlove.dao.userdao.Sellerdao;
import com.gklearlove.dao.userdao.Userdao;
import com.gklearlove.entity.seller.Seller;
import com.gklearlove.entity.user.Advise;
import com.gklearlove.entity.user.User;
import com.gklearlove.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: GK
 * @Date: 2020/4/9 9:50
 */
@Service
public class UserServiceImp implements IUserService {
    //依赖注入一个dao
    @Autowired
    private Userdao userDao;
    @Autowired
    private Sellerdao sellerdao;
    @Override
    public int register(User user) {
        String user_id = UuidUtils.generateUid();
        user.setUser_id(user_id);
        int result = userDao.register(user);
        if(result!=0){
            return 1;
        }else {
            return 0;
        }

    }

    @Override
    public User login(User user) {
        System.out.println();
        //利用dao层去处理
        User login = userDao.login(user);
        if(login!=null){
            return login;
        }
        else {
            return null;
        }
    }

    //修改用户信息
    @Override
    public int modify_userinfo(User user) {
        int result = userDao.modify_userinfo(user);
        if(result!=0){
            return 1;
        }else {
            return 0;
        }

    }

    //重新获取用户信息放到session中
    @Override
    public User get_new_info(String user_id) {
        User user = userDao.get_new_info(user_id);
        if (user!=null){
            return user;
        }else {
            return null;
        }
    }

    @Override
    public int modify_password(User user) {
        int result = userDao.modify_password(user);
        if(result!=0){
            return 1;
        }else {
            return 0;
        }
    }

    //成为卖家
    @Override
    public int become_seller(Seller seller){
        int result = userDao.become_seller(seller);
        if (result!=0){
            return 1;
        }else {
            return 0;
        }
    }

    //设置新邮箱
    @Override
    public int modify_email(User user) {
        int result = userDao.modify_email(user);
        if(result!=0){
            return 1;
        }else {
            return 0;
        }
    }

    //判断是否是卖家
    @Override
    public int is_seller(String seller_id) {
        Seller seller = sellerdao.is_seller(seller_id);
        if (seller!=null){
            return 1;
        }else {
            return 0;
        }
    }

    //判断是否审核通过
    @Override
    public int seller_can(String seller_id) {
        Seller result = sellerdao.seller_can(seller_id);
        if (result!=null){
            if (result.getSeller_pass()!=0) {
                return 1;
            }else {
                return 0;
            }
        }else {
            return 0;
        }
    }

    //提交建议
    @Override
    public int submit_advise(Advise advise) {
        int result = userDao.submit_advise(advise);
        if (result!=0){
            return 1;
        }else {
            return 0;
        }
    }

    //回答问题
    @Override
    public int answer_question(String question_id, String answer_text) {
        int i = userDao.answer_question(question_id, answer_text);
        if (i!=0){
            return 1;
        }else {
            return 0;
        }

    }
}

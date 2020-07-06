package com.gklearlove.service.userservice;

import com.gklearlove.dao.userdao.Userdao;
import com.gklearlove.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: GK
 * @Date: 2020/6/6 15:25
 */
@Service
public class IUserForgetServiceImpl implements UserForgetService{
    @Autowired
    Userdao userdao;
    @Override
    public User get_mail(String user_account) {
        User userInfoByaccount = userdao.getUserInfoByaccount(user_account);
        return userInfoByaccount;
    }
}

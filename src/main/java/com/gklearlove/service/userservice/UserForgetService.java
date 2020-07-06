package com.gklearlove.service.userservice;

import com.gklearlove.entity.user.User;

/**
 * @Author: GK
 * @Date: 2020/6/6 15:24
 */
public interface UserForgetService {
    //根据用户account获取用户的邮箱
    User get_mail(String user_account);
}

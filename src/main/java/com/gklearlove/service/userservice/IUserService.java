package com.gklearlove.service.userservice;

import com.gklearlove.entity.seller.Seller;
import com.gklearlove.entity.user.Advise;
import com.gklearlove.entity.user.User;
import org.apache.ibatis.annotations.Insert;

/**
 * @Author: GK
 * @Date: 2020/4/9 9:42
 */
public interface IUserService {
    //注册功能
    public int register(User user);
    //登陆功能
    public User login(User user);
    //修改用户个人信息
    public int modify_userinfo(User user);
    //重新获取用户信息放到session中
    public User get_new_info(String user_id);
    //修改用户的密码
    public int modify_password(User user);
    //添加卖家
    public int become_seller(Seller seller);
    //设置新邮箱
    public int modify_email(User user);
    //判断是否是卖家
    public int is_seller(String seller_id);
    //判断是否审核通过
    public int seller_can(String seller_id);
    //添加建议
    public int submit_advise(Advise advise);

    //添加回答
    public int answer_question(String question_id,String answer_text);

}

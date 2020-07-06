package com.gklearlove.service.adminstorservice;

import com.github.pagehelper.PageInfo;
import com.gklearlove.entity.adminstor.Adminstor;
import com.gklearlove.entity.appoint.Appoint;
import com.gklearlove.entity.seller.Seller;
import com.gklearlove.entity.user.Advise;
import com.gklearlove.entity.user.Comment;
import com.gklearlove.entity.user.Evaluation;
import com.gklearlove.entity.user.User;


/**
 * @Author: GK
 * @Date: 2020/4/13 9:12
 */
public interface IAdminstorService {
    //登陆功能
    public int login(Adminstor adminstor);

    //获取所有用户信息
    PageInfo<User> get_user(int page,int limit);
    //根据user_id查询用户信息
    User get_userinfo_byuser_id(String user_id);
    //设置新的用户状态
    int set_new_status(String user_id,int user_status);

    //获取所有评价
    PageInfo<Comment> get_comment(int page, int limit);
    //根据评价id获取评价信息
    Comment get_commentinfo_bycomment_id(String comment_id);
    //删除此条评价
    int remove_comment(String comment_id);

    //获取所有建议
    public PageInfo<Advise> get_advise(int page, int limit);

    //获取所有卖家
    PageInfo<Seller> get_seller(int page, int limit);

    //将指定seller_id的状态切换
    int check_seller(String seller_id,int seller_pass);

    //采纳建议
    int adopt_advise(String advise_id,int advise_accept);

    //根据advise_id查询其accept
    int get_accept(String advise_id);

    //获取所有的appoint信息
    PageInfo<Appoint> get_appoint(int page, int limit);

    int know_appoint(String appoint_id);


}

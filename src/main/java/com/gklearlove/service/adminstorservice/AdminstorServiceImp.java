package com.gklearlove.service.adminstorservice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gklearlove.dao.adminstordao.Adminstordao;
import com.gklearlove.entity.adminstor.Adminstor;
import com.gklearlove.entity.appoint.Appoint;
import com.gklearlove.entity.seller.Seller;
import com.gklearlove.entity.user.Advise;
import com.gklearlove.entity.user.Comment;
import com.gklearlove.entity.user.Evaluation;
import com.gklearlove.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: GK
 * @Date: 2020/4/13 9:16
 */
@Service
public class AdminstorServiceImp implements IAdminstorService {
    @Autowired
    private Adminstordao adminstordao;

    //管理员登陆
    @Override
    public int login(Adminstor adminstor) {
        Adminstor result_admin = adminstordao.login(adminstor);
        if(result_admin !=null){
            return 1;
        }else {
            return 0;
        }
    }

    //获取所有用户信息
    @Override
    public PageInfo<User> get_user(int page, int limit) {
        PageHelper.startPage(page,limit);
        PageInfo<User> pageInfo = new PageInfo<>(adminstordao.get_user());
        return pageInfo;
    }
    //根据user_id获取用户信息
    @Override
    public User get_userinfo_byuser_id(String user_id) {
        User user = adminstordao.get_userinfo_byuser_id(user_id);
        return user;
    }
    //设置新的用户状态
    @Override
    public int set_new_status(String user_id,int user_status) {
        int result = adminstordao.set_new_status(user_id, user_status);
        if (result!=0){
            return 1;
        }else{
            return 0;
        }
    }


    //获取所有评价
    @Override
    public PageInfo<Comment> get_comment(int page, int limit) {
        PageHelper.startPage(page,limit);
        PageInfo<Comment> pageInfo = new PageInfo<>(adminstordao.get_comment());
        return pageInfo;


    }
    //根据评价id获取评价内容
    @Override
    public Comment get_commentinfo_bycomment_id(String comment_id) {
        Comment comment = adminstordao.get_commentinfo_bycomment_id(comment_id);
        return comment;
    }

    //删除恶意评价
    @Override
    public int remove_comment(String comment_id) {
        int result = adminstordao.remove_comment(comment_id);
        if (result!=0){
            return 1;
        }else {
            return 0;
        }

    }

    //获取所有建议
    @Override
    public PageInfo<Advise> get_advise(int page, int limit) {
        PageHelper.startPage(page,limit);
        PageInfo<Advise> pageInfo = new PageInfo<>(adminstordao.get_advise());
        return pageInfo;
    }


    //获取所有卖家
    @Override
    public PageInfo<Seller> get_seller(int page, int limit) {
        PageHelper.startPage(page,limit);
        PageInfo<Seller> pageInfo = new PageInfo<>(adminstordao.get_seller());
        return pageInfo;
    }

    //切换卖家状态
    @Override
    public int check_seller(String seller_id,int seller_pass) {
        int result = adminstordao.check_seller(seller_id, seller_pass);
        if (result!=0){
            return 1;
        }else {
            return 0;
        }
    }

    //采纳建议
    @Override
    public int adopt_advise(String advise_id, int advise_accept) {
        int result = adminstordao.adopt_advise(advise_id, advise_accept);
        if (result!=0){
            return 1;
        }else {
            return 0;
        }
    }

    //根据advise_id查询其accept
    @Override
    public int get_accept(String advise_id) {
        int accept = adminstordao.get_accept(advise_id);
        return accept;
    }

    @Override
    public PageInfo<Appoint> get_appoint(int page, int limit) {
        PageHelper.startPage(page,limit);
        PageInfo<Appoint> pageInfo = new PageInfo<>(adminstordao.get_appoint());
        return pageInfo;
    }

    @Override
    public int know_appoint(String appoint_id) {
        int i = adminstordao.know_appoint(appoint_id);
        if (i!=0){
            return 1;
        }else {
            return 0;
        }

    }


}

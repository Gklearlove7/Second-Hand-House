package com.gklearlove.dao.adminstordao;

import com.gklearlove.entity.adminstor.Adminstor;

import com.gklearlove.entity.appoint.Appoint;
import com.gklearlove.entity.seller.Seller;
import com.gklearlove.entity.user.Advise;
import com.gklearlove.entity.user.Comment;
import com.gklearlove.entity.user.Evaluation;
import com.gklearlove.entity.user.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author: GK
 * @Date: 2020/4/13 9:08
 */
@Mapper
public interface Adminstordao {
    @Select("select * from adminstor where adminstor_account=#{adminstor_account} and adminstor_password=#{adminstor_password}")
    Adminstor login(Adminstor adminstor);

    //获取所有用户信息
    @Select("select * from user")
    List<User> get_user();
    //根据user_id获取用户信息
    @Select("select * from user where user_id = #{user_id}")
    User get_userinfo_byuser_id(String user_id);
    //设置新的用户状态
    @Update("update user set user_status = #{user_status} where user_id = #{user_id}")
    int set_new_status(String user_id,int user_status);


    //查看所有评价
    @Select("select c.comment_id as comment_id, u.user_id as user_id,u.user_name as user_name,c.house_id as house_id,c.comment_detail as comment_detail,c.comment_time\n" +
            "from user u join comment c on c.user_id = u.user_id")
    List<Comment> get_comment();
    //获取指定评价id的评价信息
    @Select("select * from comment where comment_id = #{comment_id}")
    Comment get_commentinfo_bycomment_id(String comment_id);

    //删除恶意评价
    @Delete("delete from comment where comment_id=#{comment_id}")
    int remove_comment(String comment_id);

    //查询所有建议
    @Select("select * from advise")
    List<Advise> get_advise();


    //获取所有卖家
    @Select("select * from seller ")
    List<Seller> get_seller();

    //切换卖家状态
    @Update("update seller set seller_pass = #{seller_pass} where seller_id = #{seller_id}")
    int check_seller(String seller_id,int seller_pass);

    //采纳建议
    @Update("update advise set advise_accept = #{advise_accept} where advise_id = #{advise_id}")
    int adopt_advise(String advise_id,int advise_accept);

    //根据advise_id查询其accept
    @Select("select advise_accept from advise where advise_id = #{advise_id}")
    int get_accept(String advise_id);

    //获取所有指定购房信息
    @Select("select * from appoint ")
    List<Appoint> get_appoint();

    //已获悉
    @Delete("delete from appoint where appoint_id = #{appoint_id}")
    int know_appoint(String appoint_id);
}

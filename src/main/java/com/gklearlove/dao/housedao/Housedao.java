package com.gklearlove.dao.housedao;

import com.gklearlove.entity.appoint.Appoint;
import com.gklearlove.entity.house.House;
import com.gklearlove.entity.house.Question;
import com.gklearlove.entity.user.Comment;
import com.gklearlove.entity.user.Need;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: GK
 * @Date: 2020/4/29 16:35
 */
@Mapper
public interface Housedao {
    //查看最新发布的四个房子
    @Select("select * from house join seller on house.seller_id=seller.seller_id order by house_date desc limit 4")
    List<House> get_newhouse();

    //查看了解最多的四个房子
    @Select("select * from house join seller on house.seller_id=seller.seller_id order by house_viewnum desc limit 4")
    List<House> get_mosthouse();

    //根据house_id查询house的详细数据
    @Select("select * from house join seller on house.seller_id=seller.seller_id where house_id = #{house_id}")
    House get_house_detail(String house_id);

    //查询所有房子信息
    @Select("select * from house join seller on house.seller_id=seller.seller_id")
    List<House> get_all_house();

    //查询房子的照片路径
    @Select("select house_pic_dir from house where house_id=#{house_id}")
    String get_house_pic(String house_id);

    //将某个房子的查看次数加1
    @Update("update house set house_viewnum=house_viewnum+1 where house_id=#{house_id}")
    int add_viewnum(String house_id);

    //查询所有指定house_id的评论信息
    @Select("select c.user_id as user_id,u.user_name as user_name,c.house_id as house_id,c.comment_id as comment_id,c.comment_time as comment_time,c.comment_detail as comment_detail from comment c join user u on c.user_id = u.user_id where house_id = #{house_id}")
    List<Comment> get_all_comment(String house_id);

    //插入用户提交的评价
    @Insert("insert into comment(house_id,user_id,comment_id,comment_detail,comment_time) values(#{house_id},#{user_id},#{comment_id},#{comment_detail},#{comment_time})")
    int upload_comment(Comment comment);

    //获取指定house_id的所有问题
    @Select("select c.user_id as user_id,u.user_name as user_name,c.house_id as house_id,c.question_id as question_id,c.question_time as question_time,c.question_detail as question_detail,c.question_answer as question_answer from question c join user u on c.user_id = u.user_id where house_id = #{house_id}")
    List<Question> get_all_question(String house_id);

    //插入用户提交的问题
    @Insert("insert into question(house_id,user_id,question_id,question_detail,question_time,seller_id) values(#{house_id},#{user_id},#{question_id},#{question_detail},#{question_time},#{seller_id})")
    int upload_question(Question comment);

    //根据卖家id查询自己出售的所有房子信息
    @Select("select * from house where seller_id = #{seller_id}")
    List<House> get_allmyhouse(String seller_id);

    //获取用户心仪的所有房子
    @Select("select * from need a left join house b on a.house_id=b.house_id left join seller c on b.seller_id = c.seller_id where a.user_id=#{user_id}")
    List<Need> get_allmyneed(String user_id);
    //将房子设置为已预订或闲置
    @Update("update house set house_buy=#{house_buy} where house_id=#{house_id}")
    int reserved(String house_id,int house_buy);

    //将房子设置为已经有意向
    @Update("update house set house_need=#{user_name},house_need_time = #{need_time} where house_id=#{house_id} ")
    int need_buy(String house_id,String user_name,String need_time);

    //删除意向
    @Delete("delete from need where need_id=#{need_id}")
    int not_need1(String need_id);
    @Update("update house set house_need=null and house_need_time=null where house_id=#{house_id}")
    int not_need2(String house_id);

    //根据house_id删除订单
    @Delete("delete from need where house_id=#{house_id}")
    int house_back1(String house_id);
    @Update("update house set house_need=null and house_need_time=null where house_id=#{house_id}")
    int house_back2(String house_id);

    //加入订单
    @Insert("insert into need values(#{need_id},#{user_id},#{house_id},#{need_time},NULL)")
    int insert_need(String need_id,String user_id,String house_id,String need_time);
    //房子已出售
    @Delete("delete from house where house_id =#{house_id}")
    int sold(String house_id);

    //插入房子信息
    @Insert("insert into house set house_id=#{house_id},house_info=#{house_info},house_money=#{house_money},house_area=#{house_area},house_type=#{house_type},house_address=#{house_address},seller_id=#{seller_id},house_pic=#{house_pic},house_date=#{house_date},house_viewnum=#{house_viewnum},house_pic_dir=#{house_pic_dir},house_community=#{house_community},house_floor=#{house_floor},house_deposit=#{house_deposit},house_detail_info=#{house_detail_info},house_community_info=#{house_community_info},seller_name=#{seller_name},house_buy=#{house_buy}")
    int add_house_info(House house);

    //添加用户的需求
    @Insert("insert into appoint values(#{appoint_id},#{where_address},#{phone})")
    int appoint_house(Appoint appoint);

}

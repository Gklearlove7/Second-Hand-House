package com.gklearlove.service.houseservice;

import com.github.pagehelper.PageInfo;
import com.gklearlove.entity.appoint.Appoint;
import com.gklearlove.entity.house.House;
import com.gklearlove.entity.house.Question;
import com.gklearlove.entity.user.Comment;
import com.gklearlove.entity.user.Need;

import java.util.List;

/**
 * @Author: GK
 * @Date: 2020/4/29 16:37
 */
public interface IHouseService {
    //查看最新的四个房子
    public List<House> get_newhouse();

    //查找了解最多的四个房子
    public List<House> get_mosthouse();

    //根据house_id获取house的详细数据
    public House get_house_detail(String house_id);

    //获取所有房子信息
    public List<House> get_all_house();

    //查询房子的图片路径
    String get_house_pic(String house_id);

    //将房子的查看次数加1
    public int addviewnum(String house_id);

    //根据house_id查询所有的评论信息
    public PageInfo<Comment> get_all_comment(String house_id, int page, int limit);

    //插入用户的评论信息
    public int upload_comment(Comment comment);

    //获取所有的问题内容
    public PageInfo<Question> get_all_question(String house_id, int page, int limit);

    //插入用户的问题信息
    public int upload_question(Question question);

    //获取卖家出售的所有房子信息
    public PageInfo<House> get_allmyhouse(String seller_id,int page,int limit);

    //获取用户加入订单的所有房子信息
    public PageInfo<Need> get_allmyneed(String user_id, int page, int limit);

    //将房子设置为已预订或闲置
    public int reserved(String house_id,int house_buy);

    //将房子设置为已经有意向购买
    public int need_buy(String house_id,String user_name,String need_time);

    //不想要了
    public int not_need(String house_id,String need_id);

    //将房子恢复到正常
    public int go_back(String house_id);

    //插入订单信息
    public int insert_need(String need_id,String user_id,String house_id,String need_time);

    //将房子设置为已出售
    public int sold(String house_id);

    //添加新房子
    public int add_new_house(House house);

    //添加用户需求
    public int appoint_house(Appoint appoint);

}

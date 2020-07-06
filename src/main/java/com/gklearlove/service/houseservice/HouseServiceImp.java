package com.gklearlove.service.houseservice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gklearlove.dao.housedao.Housedao;
import com.gklearlove.entity.appoint.Appoint;
import com.gklearlove.entity.house.House;
import com.gklearlove.entity.house.Question;
import com.gklearlove.entity.user.Comment;
import com.gklearlove.entity.user.Need;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: GK
 * @Date: 2020/4/29 16:37
 */
@Service
public class HouseServiceImp implements IHouseService{
    @Autowired
    Housedao housedao;

    @Override
    public List<House> get_newhouse() {
        List<House> newhouse = housedao.get_newhouse();
        return newhouse;
    }

    @Override
    public List<House> get_mosthouse(){
        List<House> mosthouse = housedao.get_mosthouse();
        return mosthouse;
    }

    //根据house_id获取house的详细数据
    @Override
    public House get_house_detail(String house_id) {
        House house_detail = housedao.get_house_detail(house_id);
        return house_detail;
    }

    //获取所有房子信息
    @Override
    public List<House> get_all_house() {
        List<House> all_house = housedao.get_all_house();
        return all_house;
    }

    //获取图片的路径
    @Override
    public String get_house_pic(String house_id) {
        return housedao.get_house_pic(house_id);
    }

    //将房子的查看次数加1
    @Override
    public int addviewnum(String house_id) {
        int result = housedao.add_viewnum(house_id);
        return result;
    }

    //根据house_id获取所有评论信息
    @Override
    public PageInfo<Comment> get_all_comment(String house_id, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Comment> all_comment = housedao.get_all_comment(house_id);
        PageInfo<Comment> pageInfo = new PageInfo<>(all_comment);
        return pageInfo;
    }

    //插入评论信息
    @Override
    public int upload_comment(Comment comment) {
        int i = housedao.upload_comment(comment);
        if (i!=0){
            return 1;
        }else {
            return 0;
        }
    }

    //获取指定房子的所有问题内容
    @Override
    public PageInfo<Question> get_all_question(String house_id, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Question> all_question = housedao.get_all_question(house_id);
        PageInfo<Question> pageInfo = new PageInfo<>(all_question);
        return pageInfo;
    }

    //插入用户的问题信息
    @Override
    public int upload_question(Question question) {
        int i = housedao.upload_question(question);
        if (i!=0){
            return 1;
        }else {
            return 0;
        }
    }

    //获取卖家出售的所有房子
    @Override
    public PageInfo<House> get_allmyhouse(String seller_id,int page,int limit) {
        PageHelper.startPage(page,limit);
        List<House> all_myhouse = housedao.get_allmyhouse(seller_id);
        PageInfo<House> pageInfo = new PageInfo<>(all_myhouse);
        return pageInfo;
    }



    @Override
    public PageInfo<Need> get_allmyneed(String user_id, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Need> allmyneed = housedao.get_allmyneed(user_id);
        PageInfo<Need> pageInfo = new PageInfo<>(allmyneed);
        return pageInfo;
    }


    @Override
    public int reserved(String house_id, int house_buy) {
        int result = housedao.reserved(house_id, house_buy);
        if (result!=0){
            return 1;
        }else {
            return 0;
        }
    }

    //将房子置为已有意向
    @Override
    public int need_buy(String house_id, String user_name,String need_time) {
        int i = housedao.need_buy(house_id, user_name, need_time);
        if (i!=0){
            return 1;
        }else {
            return 0;
        }
//        return 0;
    }

    //不需要了
    @Override
    public int not_need(String house_id, String need_id) {
        int i = housedao.not_need1(need_id);
        int i1 = housedao.not_need2(house_id);
        if (i!=0 && i1!=0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int go_back(String house_id) {
        int i = housedao.house_back1(house_id);
        int i1 = housedao.house_back2(house_id);
        if (i!=0 && i1!=0){
            return 1;
        }else {
            return 0;
        }

    }

    //加入订单
    @Override
    public int insert_need(String need_id, String user_id, String house_id, String need_time) {
        int i = housedao.insert_need(need_id, user_id, house_id, need_time);
        if (i!=0){
            return 1;
        }else {
            return 0;
        }
    }

    //房子已出售
    @Override
    public int sold(String house_id) {
        int result = housedao.sold(house_id);
        if (result!=0){
            return 1;
        }else {
        return 0;
        }
    }

    //添加新房子
    @Override
    public int add_new_house(House house) {
        int result = housedao.add_house_info(house);
        if (result!=0){
            return 1;
        }else {
            return 0;
        }
    }

    //添加用户需求
    @Override
    public int appoint_house(Appoint appoint) {
        int result = housedao.appoint_house(appoint);
        if (result!=0){
            return 1;
        }else {
            return 0;
        }
    }
}

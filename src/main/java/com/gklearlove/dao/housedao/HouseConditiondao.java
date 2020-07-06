package com.gklearlove.dao.housedao;

import com.gklearlove.entity.house.House;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: GK
 * @Date: 2020/5/8 13:33
 */
@Mapper
public interface HouseConditiondao {
    //查询所有房子信息，根据地区
    @Select("select * from house join seller on house.seller_id=seller.seller_id where house.house_address =#{area}")
    List<House> get_all_house(String area);

    //查询所有房子，根据价格第一种
    @Select("select * from house join seller on house.seller_id=seller.seller_id where house.house_money >=#{money1}")
    List<House> get_all_houseBymoney1(int money1);

    //查询所有房子，根据价格第二种
    @Select("select * from house join seller on house.seller_id=seller.seller_id where house.house_money >=#{money1} and house.house_money<#{money2}")
    List<House> get_all_houseBymoney2(int money1,int money2);

    //查询所有房子，根据面积第一种
    @Select("select * from house join seller on house.seller_id=seller.seller_id where house.house_area >=#{area1}")
    List<House> get_all_houseByacrage1(int area1);

    //查询所有房子，根据面积第二种
    @Select("select * from house join seller on house.seller_id=seller.seller_id where house.house_area >=#{area1} and house.house_area<#{area2}")
    List<House> get_all_houseByacrage2(int area1,int area2);

    //查询所有房子，根据类型第一种
    @Select("select * from house join seller on house.seller_id=seller.seller_id where house.house_type !='一室一厅' and house.house_type !='二室一厅' and house.house_type !='三室一厅'")
    List<House> get_all_houseBytype1();

    //查询所有房子，根据类型第二种
    @Select("select * from house join seller on house.seller_id=seller.seller_id where house.house_type=#{type}")
    List<House> get_all_houseBytype2(String type);
}

package com.gklearlove.service.houseservice;

import com.gklearlove.entity.house.House;

import java.util.List;

/**
 * @Author: GK
 * @Date: 2020/5/8 13:35
 */
//针对的是按条件筛选的查房
public interface IHouseConditionService {
    //按地区筛选获取所有房子信息
    public List<House> get_all_house(String area);

    //根据价格筛选所有房子方法1
    public List<House> get_all_houseBymoney1(int money1);
    //根据价格筛选所有房子方法2
    public List<House> get_all_houseBymoney2(int money1,int money2);

    //根据面积筛选所有房子方法1
    public List<House> get_all_houseByacrage1(int area1);
    //根据面积筛选所有房子方法2
    public List<House> get_all_houseByacrage2(int area1,int area2);

    //根据房子类型筛选所有房子方法1
    public List<House> get_all_houseBytype();
    //根据房子类型筛选所有房子方法2
    public List<House> get_all_houseBytype2(String type);
}

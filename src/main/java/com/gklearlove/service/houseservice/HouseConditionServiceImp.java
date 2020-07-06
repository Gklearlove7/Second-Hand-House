package com.gklearlove.service.houseservice;

import com.gklearlove.dao.housedao.HouseConditiondao;
import com.gklearlove.entity.house.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: GK
 * @Date: 2020/5/8 13:37
 */
@Service
public class HouseConditionServiceImp implements IHouseConditionService{
    @Autowired
    HouseConditiondao houseConditiondao;
    //按照地区查找所有房子
    @Override
    public List<House> get_all_house(String area) {
        List<House> all_house = houseConditiondao.get_all_house(area);
        return all_house;
    }

    //根据房子价格查找房子信息
    @Override
    public List<House> get_all_houseBymoney1(int money1) {
        List<House> all_house = houseConditiondao.get_all_houseBymoney1(money1);
        return all_house;
    }

    @Override
    public List<House> get_all_houseBymoney2(int money1, int money2) {
        List<House> all_house = houseConditiondao.get_all_houseBymoney2(money1,money2);
        return all_house;
    }

    //根据房子面积查找房子信息
    @Override
    public List<House> get_all_houseByacrage1(int area1) {
        List<House> all_house = houseConditiondao.get_all_houseByacrage1(area1);
        return all_house;
    }


    @Override
    public List<House> get_all_houseByacrage2(int area1, int area2) {
        List<House> all_house = houseConditiondao.get_all_houseByacrage2(area1,area2);
        return all_house;
    }

    //根据房子类型查找房子信息
    @Override
    public List<House> get_all_houseBytype() {
        List<House> all_house = houseConditiondao.get_all_houseBytype1();
        return all_house;
    }

    @Override
    public List<House> get_all_houseBytype2(String type) {
        List<House> all_house = houseConditiondao.get_all_houseBytype2(type);
        return all_house;
    }
}

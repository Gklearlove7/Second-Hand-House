package com.gklearlove.entity.house;

import lombok.Data;

/**
 * @Author: GK
 * @Date: 2020/4/24 17:25
 */
@Data
public class House {
    private String house_id;
    private String house_info;
    private String house_address;
    private Double house_money;
    private Double house_area;
    private String house_type;
    private String seller_id;
    private String house_pic;
    private String house_date;
    private int house_viewnum;
    private String house_pic_dir;
    private String house_community;
    private int house_floor;
    private Double house_deposit;
    private String house_detail_info;
    private String house_community_info;
    private String seller_name;
    private int house_buy;
    private String seller_bank_card;//表里没有，是由联查的时候查出
    private String house_need;
    private String house_need_time;
}

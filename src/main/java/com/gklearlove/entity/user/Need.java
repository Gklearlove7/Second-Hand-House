package com.gklearlove.entity.user;

import lombok.Data;

/**
 * @Author: GK
 * @Date: 2020/6/7 9:33
 */
@Data
public class Need {
    private String need_id;
    private String user_id;
    private String house_id;
    private String need_time;
    private String is_buy;
    //下面是多表联查时的结果
    private String seller_bank_card;
    private String house_type;
    private String house_info;
    private String house_date;
    private String house_address;
    private String house_pic;
    private String house_money;
    private String house_deposit;


}

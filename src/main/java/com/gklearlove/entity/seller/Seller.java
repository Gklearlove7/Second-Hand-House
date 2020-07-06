package com.gklearlove.entity.seller;

import lombok.Data;

import java.lang.ref.PhantomReference;

/**
 * @Author: GK
 * @Date: 2020/4/24 17:29
 */
@Data
public class Seller {
    private String seller_id;
    private String house_id;//表中没有，要多表联查获得
    private String seller_address;
    private String seller_name;
    private int seller_years;
    private String seller_phone;
    private String seller_certificate;
    private String seller_describe;
    private String seller_street;
    private String seller_sex;
    private int seller_age;
    private String seller_card;
    private String seller_realname;
    private String seller_education;
    private String seller_email;
    private int seller_pass;
    private String seller_bank_card;

}

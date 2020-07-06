package com.gklearlove.entity.user;

import lombok.Data;

/**
 * @Author: GK
 * @Date: 2020/4/9 9:27
 */
@Data
public class User {
    private String user_id;
    private String user_name;
    private String user_sex;
    private String user_email;
    private String user_account;
    private String user_address;
    private String user_password;
    private String user_city;
    private String user_seat;
    private int user_status;
}

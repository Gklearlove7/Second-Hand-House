package com.gklearlove.entity.user;

import lombok.Data;

/**
 * @Author: GK
 * @Date: 2020/4/24 17:19
 */
@Data
public class Evaluation {
    private String evaluation_id;
    private String user_id;
    private String user_name;//表里没有是通过表的连接获得的
    private String house_id;
    private String evaluation_detail;
    private String evaluation_time;
}

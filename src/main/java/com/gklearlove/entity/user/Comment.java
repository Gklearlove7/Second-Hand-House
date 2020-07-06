package com.gklearlove.entity.user;

import lombok.Data;

/**
 * @Author: GK
 * @Date: 2020/4/24 15:50
 */
@Data
public class Comment {
    private String user_id;
    private String house_id;
    private String comment_id;
    private String comment_detail;
    private String comment_time;
    private String user_name;//表里没有这个字段，通过表的连接获得的

}

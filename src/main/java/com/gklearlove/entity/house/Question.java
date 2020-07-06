package com.gklearlove.entity.house;

import lombok.Data;

/**
 * @Author: GK
 * @Date: 2020/5/7 15:11
 */
@Data
public class Question {
    private String question_id;
    private String question_detail;
    private String house_id;
    private String user_id;
    private String seller_id;
    private String question_answer;
    private String question_time;
    private String user_name;//表里没有这个字段，通过表的连接获得的

}

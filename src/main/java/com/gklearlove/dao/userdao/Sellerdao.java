package com.gklearlove.dao.userdao;

import com.gklearlove.entity.seller.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: GK
 * @Date: 2020/5/14 19:47
 */
@Mapper
public interface Sellerdao {
    //查询是否存在该自由经纪人
    @Select("select * from seller where seller_id=#{seller_id}")
    Seller is_seller(String seller_id);

    //查询注册的自由经纪人是否审核通过
    @Select("select seller_pass from seller where seller_id = #{seller_id}")
    Seller seller_can(String seller_id);
}


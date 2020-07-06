package com.gklearlove.dao.paydao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @Author: GK
 * @Date: 2020/6/11 14:52
 */
@Mapper
public interface Paydao {
    //将二手房设置为已下定金
    @Update("update house set house_buy = 1 where house_id=#{house_id}")
    public int set_buy(String house_id);

    //设置将订单的is_buy设置为已下定金
    @Update("update need set is_buy=1 where need_id=#{need_id}")
    public int set_need_buy(String need_id);
}

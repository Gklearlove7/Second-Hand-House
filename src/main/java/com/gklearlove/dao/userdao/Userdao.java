package com.gklearlove.dao.userdao;

import com.gklearlove.entity.seller.Seller;
import com.gklearlove.entity.user.Advise;
import com.gklearlove.entity.user.User;
import org.apache.ibatis.annotations.*;

/**
 * @Author: GK
 * @Date: 2020/4/9 9:51
 */
@Mapper
public interface Userdao {

    //登陆操作
    @Select("select * from user where user_account=#{user_account} and user_password=#{user_password}")
    User login(User user);

    //注册操作
    @Insert("insert into user(user_id,user_account,user_password) values (#{user_id},#{user_account},#{user_password})")
    int register(User user);

    //修改密码
    @Update("update users set password = #{passwd} where userid = #{userid}")
    void modifypd(int userid,String passwd);

    //根据用户的账户获取其信息
    @Select("select * from user where user_account=#{user_account}")
    User getUserInfoByaccount(String user_account);

    //修改个人信息
    @Update("update user set user_name = #{user_name},user_sex = #{user_sex},user_seat = #{user_seat},user_address = #{user_address} where user_id = #{user_id}")
    int modify_userinfo(User user);

    //重新注入session里的user对象的操作
    @Select("select * from user where user_id = #{user_id}")
    User get_new_info(String user_id);

    //修改用户密码
    @Update("update user set user_password = #{user_password} where user_id = #{user_id}")
    int modify_password(User user);


    //成为自由经纪人
    @Insert("insert into seller values(#{seller_id},#{seller_address},#{seller_name},#{seller_years},#{seller_email},#{seller_pass},#{seller_phone},#{seller_certificate},#{seller_describe},#{seller_street},#{seller_sex},#{seller_age},#{seller_card},#{seller_realname},#{seller_education},#{seller_bank_card})")
    int become_seller(Seller seller);

    //更换邮箱
    @Update("update user set user_email = #{user_email} where user_id = #{user_id}")
    int modify_email(User user);

    //添加建议
    @Insert("insert into advise values(#{advise_id},#{advise_detail},#{advise_accept},#{advise_time})")
    int submit_advise(Advise advise);

    //回答问题
    @Update("update question set question_answer=#{question_answer} where question_id=#{question_id}")
    int answer_question(String question_id,String question_answer);

}

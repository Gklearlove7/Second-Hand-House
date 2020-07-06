package com.gklearlove.controller.housecontrollers;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gklearlove.entity.house.House;
import com.gklearlove.service.houseservice.HouseConditionServiceImp;
import com.gklearlove.service.houseservice.HouseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: GK
 * @Date: 2020/5/8 13:26
 */
//这里的Controller是针对的按条件筛选的房子
@Controller
@RequestMapping("/house")
public class HouseConditionController {
    @Autowired
    HouseServiceImp houseserviceImp;
    @Autowired
    HouseConditionServiceImp houseConditionServiceImp;

    //查看所有的指定地区的房子
    @RequestMapping("/house_searchByarea")
    public String house_searchByarea(@RequestParam("area") String area, HttpSession session, HttpServletRequest request){
        PageHelper.startPage(1, 5);
        //如果是不限就是最基本的查出所有，不然就是按条件查询
        if (area.equals("不限")){
            List<House> all_house = houseserviceImp.get_all_house();
            PageInfo<House> pageInfo = new PageInfo<>(all_house);
            request.setAttribute("all_house",all_house);
            request.setAttribute("pageInfo",pageInfo);
            return "house_search";
        }else {
            List<House> all_house = houseConditionServiceImp.get_all_house(area);
            PageInfo<House> pageInfo = new PageInfo<>(all_house);
            request.setAttribute("all_house", all_house);
            request.setAttribute("pageInfo", pageInfo);
            return "house_search";
        }
    }

    //查看所有的指定价格的房子
    @RequestMapping("/house_searchBymoney")
    public String house_searchBymoney(@RequestParam("money1") String money1, @RequestParam("money2") String money2,HttpSession session, HttpServletRequest request){
        PageHelper.startPage(1, 5);
        //如果是不限就是最基本的查出所有，不然就是按条件查询
        if (money1.equals("不限") && money2.equals("不限")){
            List<House> all_house = houseserviceImp.get_all_house();
            PageInfo<House> pageInfo = new PageInfo<>(all_house);
            request.setAttribute("all_house",all_house);
            request.setAttribute("pageInfo",pageInfo);
            return "house_search";
        }if (!money1.equals("不限") &&money2.equals("不限")){
            List<House> all_house = houseConditionServiceImp.get_all_houseBymoney1(Integer.parseInt(money1));
            PageInfo<House> pageInfo = new PageInfo<>(all_house);
            request.setAttribute("all_house", all_house);
            request.setAttribute("pageInfo", pageInfo);
            return "house_search";
        }else {
            List<House> all_house = houseConditionServiceImp.get_all_houseBymoney2(Integer.parseInt(money1),Integer.parseInt(money2));
            PageInfo<House> pageInfo = new PageInfo<>(all_house);
            request.setAttribute("all_house", all_house);
            request.setAttribute("pageInfo", pageInfo);
            return "house_search";
        }
    }

    //查看所有的指定面积的房子
    @RequestMapping("/house_searchByacrage")
    public String house_searchByacrage(@RequestParam("area1") String area1, @RequestParam("area2") String area2,HttpSession session, HttpServletRequest request){
        PageHelper.startPage(1, 5);
        //如果是不限就是最基本的查出所有，不然就是按条件查询
        if (area1.equals("不限") && area2.equals("不限")){
            List<House> all_house = houseserviceImp.get_all_house();
            PageInfo<House> pageInfo = new PageInfo<>(all_house);
            request.setAttribute("all_house",all_house);
            request.setAttribute("pageInfo",pageInfo);
            return "house_search";
        }if (!area1.equals("不限") &&area2.equals("不限")){
            List<House> all_house = houseConditionServiceImp.get_all_houseByacrage1(Integer.parseInt(area1));
            PageInfo<House> pageInfo = new PageInfo<>(all_house);
            request.setAttribute("all_house", all_house);
            request.setAttribute("pageInfo", pageInfo);
            return "house_search";
        }else {
            List<House> all_house = houseConditionServiceImp.get_all_houseByacrage2(Integer.parseInt(area1),Integer.parseInt(area2));
            PageInfo<House> pageInfo = new PageInfo<>(all_house);
            request.setAttribute("all_house", all_house);
            request.setAttribute("pageInfo", pageInfo);
            return "house_search";
        }
    }

    //根据房子类型进行筛选
    @RequestMapping("/house_searchBytype")
    public String house_searchBytype(@RequestParam("type") String type, HttpSession session, HttpServletRequest request){
        PageHelper.startPage(1, 5);
        //如果是不限就是最基本的查出所有，不然就是按条件查询
        if (type.equals("不限")){
            List<House> all_house = houseserviceImp.get_all_house();
            PageInfo<House> pageInfo = new PageInfo<>(all_house);
            request.setAttribute("all_house",all_house);
            request.setAttribute("pageInfo",pageInfo);
            return "house_search";
        }if (type.equals("除此之外")){
            List<House> all_house = houseConditionServiceImp.get_all_houseBytype();
            PageInfo<House> pageInfo = new PageInfo<>(all_house);
            request.setAttribute("all_house", all_house);
            request.setAttribute("pageInfo", pageInfo);
            return "house_search";
        }else {
            List<House> all_house = houseConditionServiceImp.get_all_houseBytype2(type);
            PageInfo<House> pageInfo = new PageInfo<>(all_house);
            request.setAttribute("all_house", all_house);
            request.setAttribute("pageInfo", pageInfo);
            return "house_search";
        }
    }
//    //上下分页查看所有房子
//    @RequestMapping("/getAllhouse")
//    public String getAllhouse(Integer pageNum, Integer maxPage, HttpServletRequest request, HttpSession session){
//        if (pageNum <= 1) {
//            pageNum = 1; // 如果页面小于1了就直接变成第一个
//        } else if (pageNum >= maxPage) {
//            pageNum = maxPage;// 如果页面大于最大了就变成最大的
//        }
//        PageHelper.startPage(pageNum, 5);
//        List<House> all_house = houseserviceImp.get_all_house();
//        PageInfo<House> pageInfo = new PageInfo<>(all_house);
//        request.setAttribute("pageInfo", pageInfo);
//        request.setAttribute("all_house", all_house);
//        return "house_search";
//    }

}

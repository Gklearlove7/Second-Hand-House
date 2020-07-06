package com.gklearlove.controller.housecontrollers;

import com.github.pagehelper.PageInfo;
import com.gklearlove.config.HouseConfig;
import com.gklearlove.controller.usercontrollers.UserInfoController;
import com.gklearlove.entity.house.House;
import com.gklearlove.entity.user.User;
import com.gklearlove.service.houseservice.HouseServiceImp;
import com.gklearlove.service.userservice.UserServiceImp;
import com.gklearlove.utils.GetNowTime;
import com.gklearlove.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: GK
 * @Date: 2020/5/11 21:23
 */
//添加房源信息的Controller
@Controller
@RequestMapping("/house")
public class HouseAddController {
    @Autowired
    HouseServiceImp houseServiceImp;

    @Autowired
    HouseConfig houseConfig;

    @Autowired
    UserServiceImp userServiceImp;

    //添加房源信息的页面
    @RequestMapping("/add_house")
    String add_house(HttpServletRequest request,HttpSession session){
        User user = (User) session.getAttribute("user");
        int seller_can = userServiceImp.seller_can(user.getUser_id());
        int is_seller = (int) session.getAttribute("is_seller");

        if (is_seller == 1) {
            if (seller_can == 0) {
                return "seller_forbid";
            } else {
                //在这里设置房子的ID
                String house_id = "h"+UuidUtils.generateUid();
                request.setAttribute("new_house_id",house_id);
                return "addsellerhouse";
            }
        } else {
            UserInfoController userInfoController= new UserInfoController();
            return userInfoController.become_seller_page(session);
        }

    }

    //添加房子照片
    @RequestMapping("/put_pic")
    @ResponseBody
    public HashMap<String,Object> put_pic(HttpServletRequest req, HttpSession session, @RequestParam("file") MultipartFile mfile,@RequestParam("house_id") String house_id) throws IllegalStateException, IOException {
        //
        //判断用户的目录是否存在
        String house_path = houseConfig.getBaseurl()+house_id;
        File file = new File(house_path);
        HashMap<String, Object> resData = new HashMap<>();
        String pic_path=null;
        String fileName = mfile.getOriginalFilename();
        if (file.exists()){
            //获取全路径
            pic_path = house_path+File.separator+fileName;
            mfile.transferTo(new File(pic_path));
            resData.put("code", 0);
            resData.put("msg", "ok");
        }else {
            file.mkdirs();
            //获取全路径
            pic_path = house_path+File.separator+fileName;
            mfile.transferTo(new File(pic_path));
            resData.put("code", 0);
            resData.put("msg", "ok");
        }
        return resData;
    }
    @RequestMapping("/add_house_info")
    @ResponseBody
//    public HashMap<String,Object> add_house_info(@RequestParam("house_id") String house_id,@RequestParam("house_community") String house_community, @RequestParam("house_type") String house_type,@RequestParam("house_address") String house_address,@RequestParam("house_money") Double house_money,@RequestParam("house_deposit") Double house_deposit,@RequestParam("house_area") Double house_area,@RequestParam("house_floor") int house_floor,@RequestParam("house_info") String house_info,@RequestParam("house_community_info") String house_community_info,@RequestParam("house_detail_info") String house_detail_info,@RequestParam("seller_id") String  seller_id,@RequestParam("seller_name") String  seller_name,HttpServletRequest request,HttpSession session){
      public HashMap<String,Object> add_house_info(House house,HttpServletRequest request,HttpSession session){
        //首先获得当前的时间
        String nowtime = GetNowTime.get_nowtime();
        house.setHouse_date(nowtime);
        //设置一些图片路径、查看次数等
        house.setHouse_buy(0);
        house.setHouse_viewnum(0);
        house.setHouse_pic_dir(houseConfig.getBaseurl()+house.getHouse_id());
        System.out.println(house);
        //这里设置一下房子的代表图，默认是第一张
        String pic_path =houseConfig.getBaseurl()+house.getHouse_id();
        //获取house_id路径下的图片的路径
        File file = new File(pic_path);
        File[] tempList = file.listFiles();
        String house_pic=tempList[0].getName();
        house.setHouse_pic(house_pic);

        //执行插入操作
        int result = houseServiceImp.add_new_house(house);
        HashMap<String, Object> data = new HashMap<>();
        if (result!=0){
            data.put("code", 200);
            data.put("msg", "ok");
            return data;
        }else {
            data.put("code", 200);
            data.put("msg", "no");
            return data;
        }
    }
}

package com.gklearlove.controller.housecontrollers;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gklearlove.config.HouseConfig;
import com.gklearlove.entity.appoint.Appoint;
import com.gklearlove.entity.house.House;
import com.gklearlove.entity.house.Question;
import com.gklearlove.entity.user.Comment;
import com.gklearlove.entity.user.Need;
import com.gklearlove.entity.user.User;
import com.gklearlove.service.houseservice.HouseServiceImp;
import com.gklearlove.utils.GetNowTime;
import com.gklearlove.utils.RandomUtil;
import com.gklearlove.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: GK
 * @Date: 2020/4/29 15:04
 */
@RequestMapping("/house")
@Controller
public class HouseController {

    @Autowired
    HouseServiceImp houseserviceImp;

    @Autowired
    HouseConfig houseConfig;
    //返回到主页
    @RequestMapping("/index")
    public String index(HttpSession session){
        //查询相应的最新的4个房子和最热门的4个房子
        List<House> newhouse = houseserviceImp.get_newhouse();
        List<House> mosthouse = houseserviceImp.get_mosthouse();
        session.setAttribute("newhouse",newhouse);
        session.setAttribute("mosthouse",mosthouse);
        return "index";
    }

    //根据前段的点击获取house的详细数据返回
    @RequestMapping("/house_detail")
    public String house_detail(@RequestParam("house_id") String house_id, HttpServletRequest request){
        House house_detail = houseserviceImp.get_house_detail(house_id);
        //根据house_id查出所有照片
        String pic_path =houseserviceImp.get_house_pic(house_id);
        //获取house_id路径下的所有图片的路径
        List<String> listFileName = new ArrayList<>();
        File file = new File(pic_path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            listFileName.add(tempList[i].getName());
        }

        //查看次数加1
        houseserviceImp.addviewnum(house_id);
        request.setAttribute("house_detail",house_detail);
        request.setAttribute("listFileName",listFileName);
        return "house_detail";
    }

    //查看所有的房子
    @RequestMapping("/house_search")
    public String house_search(HttpSession session,HttpServletRequest request){
        PageHelper.startPage(1, 5);
        List<House> all_house = houseserviceImp.get_all_house();
        PageInfo<House> pageInfo = new PageInfo<>(all_house);
        request.setAttribute("all_house",all_house);
        request.setAttribute("pageInfo",pageInfo);
        return "house_search";
    }
    //上下分页查看所有房子
    @RequestMapping("/getAllhouse")
    public String getAllhouse(Integer pageNum, Integer maxPage, HttpServletRequest request, HttpSession session){
        if (pageNum <= 1) {
            pageNum = 1; // 如果页面小于1了就直接变成第一个
        } else if (pageNum >= maxPage) {
            pageNum = maxPage;// 如果页面大于最大了就变成最大的
        }
        PageHelper.startPage(pageNum, 5);
        List<House> all_house = houseserviceImp.get_all_house();
        PageInfo<House> pageInfo = new PageInfo<>(all_house);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("all_house", all_house);
        return "house_search";
    }

    //查询指定house_id的所有留言信息
    @RequestMapping(value = "/house_comment/{house_id}")
    @ResponseBody
    public HashMap<String, Object> house_comment(@PathVariable String house_id, @RequestParam("page") int startPage, @RequestParam("limit") int maxPage) {
        //获取已经分页的数据
        PageInfo<Comment> pageInfo = houseserviceImp.get_all_comment(house_id,startPage,maxPage);
        //创建制定类型的字典
        HashMap<String, Object> resData = new HashMap<>();
        resData.put("code", 0);
        resData.put("msg", "");
        resData.put("count", pageInfo.getTotal());
        resData.put("data", pageInfo.getList());
        return resData;
    }

    //用户提交自己的留言给指定的房子
    @RequestMapping("/submit_comment")
    @ResponseBody
    public HashMap<String, Object> submit_comment(HttpSession session,@RequestParam("user_comment") String user_comment,@RequestParam("house_id") String house_id){
        //生成随机comment_id然后获得当前时间然后插入数据库
        String comment_id = "c"+UuidUtils.generateUid();
        User user = (User) session.getAttribute("user");
        String user_id = user.getUser_id();
        String comment_time = GetNowTime.get_nowtime();
        Comment comment = new Comment();
        comment.setComment_id(comment_id);
        comment.setUser_id(user_id);
        comment.setHouse_id(house_id);
        comment.setComment_detail(user_comment);
        comment.setComment_time(comment_time);
        int i = houseserviceImp.upload_comment(comment);
        HashMap<String, Object> resData = new HashMap<>();
        if (i!=0){
            resData.put("code", 0);
            resData.put("msg", "ok");
        }else {
            resData.put("code", 0);
            resData.put("msg", "no");
        }

        return resData;
    }

    //查询指定house_id的所有问题信息
    @RequestMapping(value = "/house_question/{house_id}")
    @ResponseBody
    public HashMap<String, Object> house_question(@PathVariable String house_id, @RequestParam("page") int startPage, @RequestParam("limit") int maxPage) {
        //获取已经分页的数据
        PageInfo<Question> pageInfo = houseserviceImp.get_all_question(house_id,startPage,maxPage);
        //创建制定类型的字典
        HashMap<String, Object> resData = new HashMap<>();
        resData.put("code", 0);
        resData.put("msg", "");
        resData.put("count", pageInfo.getTotal());
        resData.put("data", pageInfo.getList());
        return resData;
    }

    //用户提交对指定房子的问题
    @RequestMapping("/submit_question")
    @ResponseBody
    public HashMap<String, Object> submit_question(HttpSession session,@RequestParam("user_question") String user_question,@RequestParam("house_id") String house_id,@RequestParam("seller_id") String seller_id){
        //生成随机question_id然后获得当前时间然后插入数据库
        String question_id = "q"+UuidUtils.generateUid();
        User user = (User) session.getAttribute("user");
        String user_id = user.getUser_id();
        String question_time = GetNowTime.get_nowtime();
        Question question = new Question();
        question.setHouse_id(house_id);
        question.setQuestion_id(question_id);
        question.setQuestion_detail(user_question);
        question.setUser_id(user_id);
        question.setQuestion_time(question_time);
        question.setSeller_id(seller_id);
        int i = houseserviceImp.upload_question(question);
        HashMap<String, Object> resData = new HashMap<>();
        if (i!=0){
            resData.put("code", 0);
            resData.put("msg", "ok");
        }else {
            resData.put("code", 0);
            resData.put("msg", "no");
        }

        return resData;
    }

    //获取卖家自己出售的房子
    @RequestMapping("/get_allmyhouse")
    @ResponseBody
    public HashMap<String,Object> get_allmyhouse(int page,int limit,HttpSession session){
        User user = (User) session.getAttribute("user");
        String user_id = user.getUser_id();
        PageInfo<House> pageInfo = houseserviceImp.get_allmyhouse(user_id, page, limit);
        HashMap<String, Object> data = new HashMap<>();
        data.put("code", 200);
        data.put("msg", "yes");
        data.put("count", pageInfo.getTotal());
        data.put("data", pageInfo.getList());
        return data;
    }

    //获取用户加入订单的房子
    @RequestMapping("/get_allmyneed")
    @ResponseBody
    public HashMap<String,Object> get_allmyneed(int page,int limit,HttpSession session){
        User user = (User) session.getAttribute("user");
        String user_id = user.getUser_id();
        PageInfo<Need> pageInfo = houseserviceImp.get_allmyneed(user_id, page, limit);
        HashMap<String, Object> data = new HashMap<>();
        data.put("code", 200);
        data.put("msg", "yes");
        data.put("count", pageInfo.getTotal());
        data.put("data", pageInfo.getList());
        return data;
    }


    //将房子标记为已有人有意向
    @RequestMapping("/need_house")
    @ResponseBody
    public HashMap<String,Object> need(String house_id,String user_id,HttpSession session){
        User user = (User) session.getAttribute("user");
        String nowtime = GetNowTime.get_nowtime();
        HashMap<String, Object> data = new HashMap<>();

        int i = houseserviceImp.need_buy(house_id, user.getUser_name(), nowtime);
        String need_id = "n"+RandomUtil.getRandom();
        int i1 = houseserviceImp.insert_need(need_id, user_id, house_id, nowtime);
        if (i!=0&&i1!=0){
            data.put("code", 200);
            data.put("msg", "yes");
            return data;
        }else {
            data.put("code", 200);
            data.put("msg", "no");
            return data;
        }
    }
    //将房子标记为已预定
    @RequestMapping("/reserved")
    @ResponseBody
    public HashMap<String,Object> reserved(String house_id,String house_buy,HttpSession session){
        int house_buy_new = (Integer.parseInt(house_buy)+1)%2;
        int result = houseserviceImp.reserved(house_id, house_buy_new);
        HashMap<String, Object> data = new HashMap<>();
        data.put("code", 200);
        data.put("msg", "yes");
        return data;
    }

    //意愿被去除
    @RequestMapping("/not_need")
    @ResponseBody
    public HashMap<String,Object> not_need(String house_id,String need_id,HttpSession session){

        int result = houseserviceImp.not_need(house_id, need_id);
        HashMap<String, Object> data = new HashMap<>();
        data.put("code", 200);
        data.put("msg", "yes");
        return data;
    }

    //将房子恢复回正常
    @RequestMapping("/house_back")
    @ResponseBody
    public HashMap<String,Object> house_back(String house_id,HttpSession session){

        int result = houseserviceImp.go_back(house_id);
        HashMap<String, Object> data = new HashMap<>();
        if (result!=0){
            data.put("code", 200);
            data.put("msg", "yes");
        }else {
            data.put("code", 200);
            data.put("msg", "no");
        }
        return data;
    }

    //房子已出售
    @RequestMapping("/sold")
    @ResponseBody
    public HashMap<String,Object> sold(String house_id,HttpSession session){
        int result = houseserviceImp.sold(house_id);
        HashMap<String, Object> data = new HashMap<>();
        if (result!=0){
            data.put("code", 200);
            data.put("msg", "yes");
            return data;
        }else {
            data.put("code", 200);
            data.put("msg", "no");
            return data;
        }
    }

    //显示图片
    @RequestMapping("/get_pic_image")
    public void get_image_file(String file_name,String house_id, HttpServletResponse response, HttpSession session){
        if (file_name==null){
            return;
        }
        User user = (User) session.getAttribute("user");
        File file = new File(houseConfig.getBaseurl()+File.separator+house_id+File.separator+file_name);
        response.setContentType("image/jpeg");//设置输出流内容格式为图片格式
        response.setCharacterEncoding("utf-8");//response的响应的编码方式为utf-8
        try {
            OutputStream outputStream = response.getOutputStream();//输出流
            InputStream in = new FileInputStream(file);//字节输入流
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = in.read(buf, 0, 1024)) != -1) {
                outputStream.write(buf, 0, len);
            }
            in.close();
            outputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @RequestMapping("/submit_appoint_house")
    @ResponseBody
    public HashMap<String,Object> appoint_house(String where_address,String phone,HttpSession session){
        Appoint appoint = new Appoint();
        String appoint_id = "a"+UuidUtils.generateUid();
        appoint.setAppoint_id(appoint_id);
        appoint.setWhere_address(where_address);
        appoint.setPhone(phone);
        int result = houseserviceImp.appoint_house(appoint);
        HashMap<String, Object> data = new HashMap<>();
        if (result!=0){
            data.put("code", 200);
            data.put("msg", "yes");
            return data;
        }else {
            data.put("code", 200);
            data.put("msg", "no");
            return data;
        }
    }

}

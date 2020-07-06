<%--
  Created by IntelliJ IDEA.
  User: 78250
  Date: 2020/4/13
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>管理员中心</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css">
    <script src="/layui/layui.all.js"></script>
    <script src="/jq/jquery-1.8.3.js" type="text/javascript"></script>
    <script src="/js/adminstor.js"></script>
    <%-- 利用jquery的方法，表格变色 --%>
    <script type="text/javascript">
        $(function(){
            //表格隔行变色
            $("table>tbody>tr:even").css("background","gray");
            $("table>tbody>tr:odd").css("background","pink");
        });
    </script>
</head>
<body>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/layui/css/layui.css">
    <script src="/layui/layui.all.js"></script>
    <title>个人信息</title>
    <style type="text/css">
        body{
            height:700px;
            margin-left: 0px;
            margin-top: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
            background:#FDFAFA;
        }
        #first{

            width: 100%;
            height: 10%;
            position:relative;
            top: 0%;
            text-align: center;
            border-bottom: 0.5px solid #F6F6F6;
            background:#6AEED3;

        }
        #first_one{
            width:10%;
            height: 100%;
            position: relative;
            left: 0%;
            float: left;
            text-align: center;
            line-height: 100px;


        }
        #first_h1{
            width: 70%;

        }
        #first_two{
            width: 90%;
            height: 100%;
            position: relative;
            left: 10%;

        }
        #second{
            width: 100%;
            height: 88%;
            position: relative;
            top: 2%;
        }
        #second_one{
            width: 12%;
            height: 100%;
            float: left;
            background:#FFFFFF;
            border-right: 1px solid #F6F6F6;



        }
        #second_two{
            width: 84%;
            height: 100%;
            float: left;
            position: relative;
            left: 2%;
            border-radius: 5px;
            border: 1px solid #F6F6F6;
            background:#FFFFFF;


        }
        #show_info{
            width: 60%;
            height: 100%;
            position: relative;
            left: 10%;
        }
        .ttr{
            height: 70px;
        }

    </style>
</head>

<body>
<div id="first">
    <div id="first_one"><a href="">返回</a></div>
    <div id="first_two">
        <div id="first_h1">
            <h1>二手房交易网站|管理员中心</h1>
        </div>

    </div>
</div>
<div id="second">
    <div id="second_one">
    </div>
    <div id="second_two">
        <div class="layui-tab" lay-filter="test1">
            <ul class="layui-tab-title" >
                <li class="layui-this" lay-id="111" >用户信息</li>
                <li lay-id="333">建议筛选</li>
                <li lay-id="444">评价整理</li>
                <li lay-id="555">卖家注册审核</li>
                <li lay-id="666">指定购房</li>

            </ul>
            <div class="layui-tab-content">

                <%-- 用户信息 --%>
                <div class="layui-tab-item ">
                <%-- 用户信息管理区 --%>
                    <table id="user" lay-filter="test"></table>
                    <%-- 处理用户信息 --%>
                    <script type="text/html" id="switch">
                        <button id="forbid_user" onclick="forbid_user('{{d.user_id}}')">禁/启用</button>
<%--                        <a href="/adminstor/switchstatusByuserid/{{d.user_id}}" class="layui-table-link">禁/启用</a>--%>
                    </script>
                    <script>
                        layui.use('table', function(){
                            var table_user = layui.table;

                            table_user.render({
                                elem: '#user'
                                ,height: 450
                                ,url: '/adminstor/getAlluser' //数据接口
                                ,page: true //开启分页
                                ,cols: [[ //表头
                                    {field: 'user_id', title: '用户id', width:200, sort: true, fixed: 'left'}
                                    ,{field: 'user_name', title: '用户名', width:90}
                                    ,{field: 'user_sex', title: '性别', width: 80}
                                    ,{field: 'user_email', title: '用户邮箱', width: 200}
                                    ,{field: 'user_address', title: '用户位置', width: 300}
                                    ,{field: 'user_status', title: '用户状态', width: 90}
                                    , {field: 'user_id', title: '操作', width: 80, templet: '#switch'}
                                ]]
                            });

                        });
                    </script>
                </div>

                <%--建议--%>
                <div class="layui-tab-item">
                    <%--建议管理区--%>

                    <table id="advise" lay-filter="test"></table>
                    <%-- 采纳建议--%>
                    <script type="text/html" id="check">
                        <button id="adopt" onclick="adopt('{{d.advise_id}}')">采纳</button>
                    </script>
                    <script>
                        layui.use('table', function(){
                            var table_advise = layui.table;

                            table_advise.render({
                                elem: '#advise'
                                ,height: 450
                                ,url: '/adminstor/getAlladvise' //数据接口
                                ,page: true //开启分页
                                ,cols: [[ //表头
                                    ,{field: 'advise_detail', title: '建议内容', width: 200}
                                    ,{field: 'advise_time', title: '建议时间', width: 200}
                                    ,{field: 'advise_accept', title: '是否接纳', width: 200}
                                    , {field: 'advise_id', title: '采纳', width: 80, templet: '#check'}
                                ]]
                            });

                        });
                    </script>
                </div>
                <%-- 评价 --%>
                <div class="layui-tab-item">
                    <%-- 评价管理区 --%>
                        <table id="evaluation" lay-filter="test"></table>
                        <%-- 评价分析--%>
                        <script type="text/html" id="analysis">
                            <button id="comment_analysis" onclick="comment_analysis('{{d.comment_id}}')">恶意评价-删除</button>
<%--                            <a href="/adminstor/checkadviseByadviseid/{{d.adviseid}}" class="layui-table-link">评价整理</a>--%>
                        </script>
                        <script>
                            layui.use('table', function(){
                                var table_evaluation = layui.table;

                                table_evaluation.render({
                                    elem: '#evaluation'
                                    ,height: 450
                                    ,url: '/adminstor/getAllcomment' //数据接口
                                    ,page: true //开启分页
                                    ,cols: [[ //表头
                                        {field: 'user_id', title: '用户id', width:200, sort: true}
                                        ,{field: 'user_name', title: '用户名', width:90}
                                        ,{field: 'house_id', title: '房屋id', width:200}
                                        ,{field: 'comment_detail', title: '评价内容', width: 200}
                                        ,{field: 'comment_time', title: '评价时间', width: 200}
                                        ,{field: 'comment_id', title: '评价分析', width: 200, templet: '#analysis'}
                                    ]]
                                });

                            });
                        </script>
                </div>

                <%-- 卖家注册审核 --%>
                <div class="layui-tab-item">
                    <table id="seller_check" lay-filter="test"></table>
                    <%-- 注册审核--%>
                    <script type="text/html" id="pass">
                        <button id="pass_check" onclick="pass_check('{{d.seller_id}}')">通过/禁止</button>
                    </script>
                    <script>
                        layui.use('table', function(){
                            var table_seller_check = layui.table;

                            table_seller_check.render({
                                elem: '#seller_check'
                                ,height: 450
                                ,url: '/adminstor/getAllseller' //数据接口
                                ,page: true //开启分页
                                ,cols: [[ //表头
                                    {field: 'seller_id', title: '经纪人id', width:200, sort: true, fixed: 'left'}
                                    ,{field: 'seller_name', title: '经纪人昵称', width:150}
                                    ,{field: 'seller_address', title: '经纪人地址', width: 170}
                                    ,{field: 'seller_email', title: '经纪人邮箱', width: 170}
                                    ,{field: 'seller_phone', title: '经纪人手机', width: 170}
                                    ,{field: 'seller_certificate', title: '资格认证', width: 170}
                                    ,{field: 'seller_describe', title: '个人描述', width: 220}
                                    ,{field: 'seller_street', title: '区县', width: 70}
                                    ,{field: 'seller_sex', title: '性别', width: 70}
                                    ,{field: 'seller_age', title: '年龄', width: 70}
                                    ,{field: 'seller_realname', title: '真实姓名', width: 100}
                                    ,{field: 'seller_education', title: '学历', width: 70}
                                    ,{field: 'seller_card', title: '身份证', width: 180}
                                    ,{field: 'seller_pass', title: '是否通过', width: 140}
                                    ,{field: 'seller_id', title: '通过/禁止', width: 100, templet: '#pass'}
                                ]]
                            });

                        });
                    </script>


                </div>
                    <%-- 指定购房 --%>
                    <div class="layui-tab-item">
                        <table id="appoint_house" lay-filter="test"></table>
                        <%-- 指定购房--%>
                        <script type="text/html" id="know">
                            <button id="appoint_know" onclick="appoint_know('{{d.appoint_id}}')">已获悉</button>
                        </script>
                        <script>
                            layui.use('table', function(){
                                var table_appoint = layui.table;

                                table_appoint.render({
                                    elem: '#appoint_house'
                                    ,height: 450
                                    ,url: '/adminstor/getAllappoint' //数据接口
                                    ,page: true //开启分页
                                    ,cols: [[ //表头
                                        {field: 'appoint_id', title: '指定购房id', width:200, sort: true, fixed: 'left'}
                                        ,{field: 'where_address', title: '指定购房区域', width:150}
                                        ,{field: 'phone', title: '指定人电话', width: 170}
                                        ,{field: 'appoint_id', title: '已获悉', width: 100, templet: '#know'}
                                    ]]
                                });

                            });
                        </script>


                    </div>

                    </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>

</body>
</html>

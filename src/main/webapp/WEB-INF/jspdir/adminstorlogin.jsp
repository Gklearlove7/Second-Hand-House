<%--
  Created by IntelliJ IDEA.
  User: 78250
  Date: 2020/4/8
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css">
    <script src="/layui/layui.all.js"></script>
    <title>Login页面</title>
    <style type="text/css">

        body{
            /*这里修改body的高度、外边距*/
            height:700px;
            margin-left: 0px;
            margin-top: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
        }
        #first{
            /*修改宽和高度以及字体位置*/
            width: 100%;
            height: 13%;
            text-align: center;

        }
        #second{
            /*设置宽高以及背景并且自适应*/
            width:100%;
            height: 87%;
            background:url("/image/Register_Login/login_registerbg.jpg")no-repeat;
            background-size: cover;

        }
        #second_part{
            /*设置宽高以及相对定位的位置*/
            width:40%;
            height:60%;

            position:relative;
            left: 30%;
            top: 15%;
            background:white;
            /*设置边框成圆角以及样式*/
            border-radius: 4px;
            border: 0.5px solid#000;
        }
        #part_center{
            width: 87%;
            height: 60%;
            position: relative;
            left: 12%;
            top: 25%;
        }
        #part_bottom{
            width: 100%;
            height: 20%;
            position: relative;
            top: 7%;
            align-content: center;
            left: -6%;
        }

    </style>
</head>

<body>
<div id="first">
    <h1>二手房交易网站</h1>

    <h3>管理员登录页面</h3>
</div>
<div id="second">
    <div id="second_part">
        <div id="part_center">
            <form class="layui-form" action="/adminstor/login" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">账号:</label>
                    <div class="layui-input-inline">
                        <input type="text" name="adminstor_account" required lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码:</label>
                    <div class="layui-input-inline">
                        <input type="password" name="adminstor_password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>


</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 78250
  Date: 2020/4/25
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>二手房交易网站</title>
    <link rel="shortcut icon" href="/images/favicon.ico" />
    <link type="text/css" href="/css/css.css" rel="stylesheet" />
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/appoint.js"></script>
    <script type="text/javascript" src="/js/js.js"></script>
    <script type="text/javascript" src="/js/myjs.js"></script>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <script src="/layui/layui.all.js"></script>
    <script type="text/javascript">
        $(function(){
            //导航定位
            $(".nav li:eq(6)").addClass("navCur");
        })
    </script>
</head>

<body>
<div class="header">
    <div class="width1190">
        <div class="fl">您好，欢迎来到二手房交易网站！</div>
        <div class="fr">
            <a href="/user/userinfo">${user.user_name}</a> |
            <a href="/user/logout">退出</a> |
            <a href="javascript:;" onclick="AddFavorite(window.location,document.title)">加入收藏</a> |
            <a href="javascript:;" onclick="SetHome(this,window.location)">设为首页</a>
        </div>
        <div class="clears"></div>
    </div><!--width1190/-->
</div><!--header/-->
<div class="logo-phone">
    <div class="width1190">
        <h1 class="logo"><a href="index.html"><img src="/images/logo.png" width="163" height="59" /></a></h1>
        <div class="phones"><strong>15202972907</strong></div>
        <div class="clears"></div>
    </div><!--width1190/-->
</div><!--logo-phone/-->
<div class="list-nav">
    <div class="width1190">
        <div class="list">
            <h3>房源分类</h3>
            <div class="list-list">
                <dl>
                    <dt><a href="javascript:;">房源区域</a></dt>
                    <dd>
                        <a href="/house/house_search">未央区</a>
                        <a href="/house/house_search">雁塔区</a>
                        <a href="/house/house_search">莲湖区</a>
                        <a href="/house/house_search">长安区</a>
                        <a href="/house/house_search">灞桥区</a>
                        <a href="/house/house_search">碑林区</a>
                        <a href="/house/house_search">阎良区</a>
                        <a href="/house/house_search">高陵区</a>
                        <a href="/house/house_search">临潼区</a>
                        <a href="/house/house_search">新城区</a>
                    </dd>
                </dl>
                <dl>
                    <dt><a href="/house/house_search">二手房</a></dt>
                    <dd>
                        <a href="/house/house_search">价格</a>
                        <a href="/house/house_search">面积</a>
                        <a href="/house/house_search">房型</a>
                    </dd>
                </dl>
            </div>
        </div><!--list/-->
        <ul class="nav">
            <li><a href="/house/index">首页</a></li>
            <li><a href="/house/house_search">二手房</a></li>
            <li class="zhiding"><a href="javascript:;">指定购房</a></li>
            <li><a href="/user/become_seller_page">申请自由经纪人</a></li>
            <li><a href="/user/about">关于我们</a></li>
            <div class="clears"></div>
        </ul><!--nav/-->
        <div class="clears"></div>
    </div><!--width1190/-->
</div><!--list-nav/-->
<div class="banner">

    <div class="layui-carousel" id="test1">
        <div carousel-item>
            <div><img src="/lunbo/xian1.jpg" alt="" style="width:1300px;height: 373px "></div>
            <div><img src="/lunbo/xian2.jpg" alt="" style="width:1300px;height: 373px "></div>
            <div><img src="/lunbo/xian3.jpg" alt="" style="width:1300px;height: 373px "></div>
        </div>
    </div>
    <!-- 条目中可以是任意内容，如：<img src=""> -->
    <script>
        layui.use('carousel', function(){
            var carousel = layui.carousel;
            //建造实例
            carousel.render({
                elem: '#test1'
                ,width: '100%' //设置容器宽度
                ,arrow: 'always' //始终显示箭头
                ,autoplay: 'true'
                ,interval:2000
                //,anim: 'updown' //切换动画方式
            });
        });
    </script>

</div>

<div class="content">
    <div class="width1190">
        <div class="vip-left">
            <div class="vipNav">
                <h3 class="vipTitle">用户中心</h3>
                <dl>
                    <dt class="vipIcon3">账户设置</dt>
                    <dd>
                        <a href="/user/userinfo" class="vipNavCur">我的资料</a>
                        <a href="/user/modify_password_page">账户密码设置</a>
                        <a href="/user/my_need">我的需要</a>
                    </dd>
                    <dt class="vipIcon1">作为自由经纪人</dt>
                    <dd>
                        <a href="/house/add_house">添加出售</a>
                        <a href="/user/become_seller_page">申请自由经纪人</a>
                        <a href="/user/go_allmyhouse">我的出售</a>
                    </dd>
                </dl>
            </div><!--vipNav/-->
        </div><!--vip-left/-->
        <div class="vip-right">
            <h3 class="vipright-title">查看并修改资料</h3>
            <table class="grinfo">
                <tbody>
                <tr>
                    <th>邮箱：</th>
                    <td> <strong>${user.user_email}</strong>
                        &nbsp;&nbsp;&nbsp;&nbsp;<a href="/user/modify_email_page"><span style="color:#888;cursor:pointer">(修改邮箱)</span></a>
                    </td>
                </tr>
                <tr>
                    <th><span class="red">*</span> 名称：</th>
                    <td>
                        <input class="inp inw" type="text" id="user_name" value="${user.user_name}" maxlength="20">
                    </td>
                </tr>
                <tr>
                    <th><span class="red">*</span> 性 &nbsp; &nbsp;别：</th>
                    <td>
                        <input type="radio" value="2" id="rbSex1" name="user_sex" >
                        <label for="rbSex1">女</label>
                        <input type="radio" value="1" id="rbSex2" name="user_sex">
                        <label for="rbSex2">男</label>
                        <span id="Sex_Tip"></span>
                    </td>
                </tr>
                <tr>
                    <th><span class="red"></span> 区 &nbsp; &nbsp;县：</th>
                    <td>
                        <input class="inp inw" type="text" id="user_seat" value="${user.user_seat}">
                    </td>
                </tr>

                <tr>
                    <th valign="top">详细地址：</th>
                    <td>
                        <textarea id="user_address" class="grtextarea" >${user.user_address}</textarea>
                        <br>
                        <span class="fgrey">(50字符以内)</span>
                    </td>
                </tr>
                <tr>
                    <th>&nbsp;</th>
                    <td colspan="2">
                        <label class="butt" id="butt">
                            <button class="member_mod_buttom" onclick="submit_change()" >提交修改</button>
                        </label>
                    </td>
                </tr>
                </tbody>
            </table>
        </div><!--vip-right/-->
        <div class="clearfix"></div>
    </div><!--width1190/-->
</div><!--content/-->

<div class="footer">
    <div class="width1190">
        <div class="fl"><a href="about.html">Gklearlove</a><a href="/user/about">关于我们</a><a href="/user/contact">联系我们</a></div>
        <div class="fr">
            <dl>
                <dt><img src="/images/erweima%20.png" width="76" height="76" /></dt>
                <dd>微信扫一扫<br />房价点评，精彩发布</dd>
            </dl>
            <dl>
                <dt><img src="/images/erweima%20.png" width="76" height="76" /></dt>
                <dd>微信扫一扫<br />房价点评，精彩发布</dd>
            </dl>
            <div class="clears"></div>
        </div>
        <div class="clears"></div>
    </div><!--width1190/-->
</div><!--footer/-->
<div class="copy">Gklearlove-郭凯</div>
<div class="bg100"></div>
<div class="zhidinggoufang">
    <h2>指定购房 <span class="close">X</span></h2>
    <form action="#" method="get">
        <div class="zhiding-list">
            <label>选择区域：</label>
            <select id="where_address">
                <option>新城区</option>
                <option>碑林区</option>
                <option>莲湖区</option>
                <option>灞桥区</option>
                <option>未央区</option>
                <option>雁塔区</option>
                <option>阎良区</option>
                <option>临潼区</option>
                <option>长安区</option>
                <option>高陵区</option>
            </select>
        </div>
        <div class="zhiding-list">
            <label>联系方式：</label>
            <input type="text" id="phone" />
        </div>
        <div class="zhidingsub"><button id="zhidingsubmit" type="button" onclick="appoint_house()"> 确定</button></div>
    </form>
    <div class="zhidingtext">
        <h3>指定购房注意事宜：</h3>
        <p>1、请详细输入您所需要购买的房源信息</p>
        <p>2、制定购房申请提交后，客服中心会在24小时之内与您取得联系</p>
        <p>3、如有任何疑问，请随时拨打我们的电话：15202972907</p>
    </div><!--zhidingtext/-->
</div><!--zhidinggoufang/-->
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 78250
  Date: 2020/4/27
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<%--  自适应  <meta name="viewport" content="width=device-width, initial-scale=1" />--%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>二手房交易网站</title>
    <link rel="shortcut icon" href="/images/favicon.ico" />
    <link type="text/css" href="/css/css.css" rel="stylesheet" />
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/appoint.js"></script>
    <script type="text/javascript" src="/js/js.js"></script>
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
            <c:if test="${empty sessionScope.user}">
                <a href="/user/gologin">登录</a> |
                <a href="/user/goregister">注册</a> |
            </c:if>
            <c:if test="${!empty sessionScope.user}">
                <a href="/user/userinfo">${sessionScope.user.user_name}</a> |
                <a href="/user/logout">退出</a>|
            </c:if>
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
<%--轮播--%>
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
        <div class="contleft">
            <ul class="leftNav">
                <li class="leftNavCur"><a href="/user/about">关于我们</a></li>
                <li><a href="/user/contact">联系我们</a></li>
            </ul><!--leftNav/-->
        </div><!--contleft/-->
        <div class="contright">
            <h2 class="rightat">二手房交易网站简介</h2>
            <div class="about">
                <img src="/images/about.jpg" /><br />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;二手房是已经在房地产交易中心备过案、完成初始登记和总登记的、再次上市进行交易的房产。它是相对开发商手里的商品房而言，是房地产产权交易三级市场的俗称。包括商品房、允许上市交易的二手公房（房改房）、解困房、拆迁房、自建房、经济适用房、限价房。
                <br /><br />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;目前，市场需要一个专门为二手房服务的网站，用户可以通过该网站查找符合自己期望的二手房，然后与自由经纪人进行沟通、付定金等。当然，想要出售二手房的用户，也可以通过成为自由经纪人的方式，展示并出售自己的二手房。这既方便和用户的购买也方便了经纪人的出售。
                <br /><br />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在我们的二手房交易网站中，无论是注册成为普通用户还是要注册成为自由经纪人，都要阅读并同意相应的法律条文，在合情、合法的基础上，进行沟通交易。并且在付定金的过程中，也是要阅读并同意相关法律条文。如果在这个过程中，存在某些不正当的交易，那么我方将协助卖家或买家捍卫个人利益。
                <br /><br />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;希望，通过我们的网站，可以提供您一份便利，让您更安全、更便捷的进行二手房交易。
            </div>
        </div><!--contright/-->
        <div class="clears"></div>
    </div><!--width1190/-->
</div><!--content/-->

<div class="footer">
    <div class="width1190">
        <div class="fl"><a href="index.html"><strong>Gklearlove</strong></a><a href="/user/about">关于我们</a><a href="/user/contact">联系我们</a><a href="/user/userinfo">个人中心</a></div>
        <div class="fr">
            <dl>
                <dt><img src="/images/erweima%20.png" width="76" height="76" /></dt>
                <dd>微信扫一扫<br />加开发者好友</dd>
            </dl>
            <dl>
                <dt><img src="/images/erweima%20.png" width="76" height="76" /></dt>
                <dd>微信扫一扫<br />加开发者好友</dd>
            </dl>
            <div class="clears"></div>
        </div>
        <div class="clears"></div>
    </div><!--width1190/-->
</div><!--footer/-->
<div class="copy">Gklearlove-郭凯</div><div class="bg100"></div>
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

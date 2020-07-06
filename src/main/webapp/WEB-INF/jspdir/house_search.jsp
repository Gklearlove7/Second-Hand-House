<%--
  Created by IntelliJ IDEA.
  User: 78250
  Date: 2020/4/30
  Time: 12:20
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
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link type="text/css" href="/css/css.css" rel="stylesheet" />
    <script type="text/javascript" src="/js/appoint.js"></script>
    <script type="text/javascript" src="/js/jquery.js"></script>
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


<div class="content" >
    <div class="width1190">
        <form action="#" method="get" class="pro-search">
            <table>
                <tr>
                    <th>房源区域：</th>
                    <td>
                        <a href="/house/house_searchByarea?area=不限" class="pro-cur">不限</a>
                        <a href="/house/house_searchByarea?area=未央区">未央区</a>
                        <a href="/house/house_searchByarea?area=雁塔区">雁塔区</a>
                        <a href="/house/house_searchByarea?area=莲湖区">莲湖区</a>
                        <a href="/house/house_searchByarea?area=长安区">长安区</a>
                        <a href="/house/house_searchByarea?area=灞桥区">灞桥区</a>
                        <a href="/house/house_searchByarea?area=碑林区">碑林区</a>
                        <a href="/house/house_searchByarea?area=阎良区">阎良区</a>
                        <a href="/house/house_searchByarea?area=高陵区">高陵区</a>
                        <a href="/house/house_searchByarea?area=临潼区">临潼区</a>
                        <a href="/house/house_searchByarea?area=新城区">新城区</a>
                    </td>
                </tr>
                <tr>
                    <th>价格：</th>
                    <td>
                        <a href="/house/house_searchBymoney?money1=不限&money2=不限" class="pro-cur">不限</a>
                        <a href="/house/house_searchBymoney?money1=0&money2=300000">0万-30万</a>
                        <a href="/house/house_searchBymoney?money1=300000&money2=500000">30万-50万</a>
                        <a href="/house/house_searchBymoney?money1=500000&money2=1000000">50万-100万</a>
                        <a href="/house/house_searchBymoney?money1=1000000&money2=不限">100万以上</a>
                    </td>
                </tr>
                <tr>
                    <th>面积：</th>
                    <td>
                        <a href="/house/house_searchByacrage?area1=不限&area2=不限" class="pro-cur">不限</a>
                        <a href="/house/house_searchByacrage?area1=0&area2=20">0-20平方</a>
                        <a href="/house/house_searchByacrage?area1=20&area2=40">20-40平方</a>
                        <a href="/house/house_searchByacrage?area1=40&area2=60">40-60平方</a>
                        <a href="/house/house_searchByacrage?area1=60&area2=80">60-80平方</a>
                        <a href="/house/house_searchByacrage?area1=80&area2=100">80-100平方</a>
                        <a href="/house/house_searchByacrage?area1=100&area2=不限">100平方以上</a>
                    </td>
                </tr>
                <tr>
                    <th>房型：</th>
                    <td>
                        <a href="/house/house_searchBytype?type=不限" class="pro-cur">不限</a>
                        <a href="/house/house_searchBytype?type=一室一厅">一室一厅</a>
                        <a href="/house/house_searchBytype?type=两室一厅">两室一厅</a>
                        <a href="/house/house_searchBytype?type=三室一厅">三室一厅</a>
                        <a href="/house/house_searchBytype?type=除此之外">除此之外</a>
                    </td>
                </tr>
            </table>
        </form><!--pro-search/-->
    </div><!--width1190/-->
    <div class="width1190">
        <div class="pro-left">
            <c:forEach items="${requestScope.all_house}" var="house">
            <dl>
                <dt><a href="/house/house_detail?house_id=${house.house_id}"><img src="/house/get_pic_image?file_name=${house.house_pic}&house_id=${house.house_id}" width="286" height="188" /></a></dt>
                <dd>
                    <h3><a href="/house/house_detail?house_id=${house.house_id}">${house.house_info} ${house.house_type}</a></h3>
                    <div class="pro-wei">
                        <img src="/images/weizhi.png" width="12" height="16" /> <strong class="red">${house.house_address}</strong><br>
                        <img src="/images/weizhi.png" width="12" height="16" /> <font class="red">${house.house_community}</font>
                    </div>
                    <div class="pro-fang">${house.house_type} ${house.house_area}平 ${house.house_floor}层</div>
                    <div class="pra-fa">发布人：${house.seller_name}  发布时间：${house.house_date}</div>
                </dd>
                <div class="price">¥ <strong>${house.house_money}</strong><span class="font12">元</span></div>
                <div class="clears"></div>
            </dl>
            </c:forEach>
        </div><!--pro-left/-->

        <div class="clears"></div>
    </div><!--width1190/-->
</div><!--content/-->

<div class="row">
    <div class="col-sm-4">

        <div class="dataTables_info" id="datatable-editable_info" role="status"
             aria-live="polite">
        </div>
    </div>
    <div class="col-sm-6">
        <div class="dataTables_paginate paging_simple_numbers" id="datatable-editable_paginate">
            <ul class="pagination">
                <li class="paginate_button previous" aria-controls="datatable-editable"
                    tabindex="0" id="datatable-editable_previous">
                    <a href="/house/getAllhouse?pageNum=${pageInfo.pageNum-1}&maxPage=${pageInfo.pages}">上一页</a>
                </li>
                <li class="paginate_button active" aria-controls="datatable-editable"
                    tabindex="0"><a href="javascript:return false;">当前第${pageInfo.pageNum}页/总共${pageInfo.pages}页 </a>
                </li>

                <li class="paginate_button next" aria-controls="datatable-editable"
                    tabindex="0" id="datatable-editable_next">
                    <a href="/house/getAllhouse?pageNum=${pageInfo.pageNum+1}&maxPage=${pageInfo.pages}">下一页</a>
                </li>
            </ul>

        </div>

    </div>
</div>


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
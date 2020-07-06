<%--
  Created by IntelliJ IDEA.
  User: 78250
  Date: 2020/4/29
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<!doctype html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>二手房交易网站</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <script src="/layui/layui.js"></script>
    <link rel="shortcut icon" href="/images/favicon.ico" />
    <link type="text/css" href="/css/css.css" rel="stylesheet" />
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/appoint.js"></script>
    <script type="text/javascript" src="/js/js.js"></script>
    <script type="text/javascript" src="/js/myjs.js"></script>
    <script type="text/javascript" src="/js/question.js"></script>
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
</div>	
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
    <div class="width1190" style="width:1000px;">
        <div class="proImg fl">
            <img src="/house/get_pic_image?file_name=${requestScope.house_detail.house_pic}&house_id=${requestScope.house_detail.house_id}" />
        </div><!--proImg/-->
   <div class="proText fr">
    <h3 class="proTitle">${requestScope.house_detail.house_community}  ${requestScope.house_detail.house_type} </h3>
    <div class="proText1">
     编号：${requestScope.house_detail.house_id}<br />
     售价：${requestScope.house_detail.house_money}元<br />
     户型：${requestScope.house_detail.house_type}<br />
     面积：${requestScope.house_detail.house_area}㎡<br />
     简介：${requestScope.house_detail.house_info}<br />
     楼层：${requestScope.house_detail.house_floor}<br />
     小区：${requestScope.house_detail.house_community}<br />
     所在区县:${requestScope.house_detail.house_address}
     发布时间:${requestScope.house_detail.house_date}<br />
     发布人:${requestScope.house_detail.seller_name}
    </div>
    <div class="xun-car">
        <c:choose>
            <c:when test="${requestScope.house_detail.house_buy==0}" >
                <c:choose>
                    <c:when test="${empty requestScope.house_detail.house_need }">
                        <a href="javascript:;" class="xwjg" onclick="need_house('${requestScope.house_detail.house_id}','${sessionScope.user.user_id}')">¥<strong>${requestScope.house_detail.house_deposit}</strong>元定金</a>
                        <%--                <a href="javascript:;" class="xwjg" onclick="buy_house('${requestScope.house_detail.seller_bank_card}')">¥<strong>${requestScope.house_detail.house_deposit}</strong>元定金</a>--%>
                    </c:when>
                    <c:otherwise>
                        <a href="javascript:;" class="xwjg">已有意愿</a>
                    </c:otherwise>
                </c:choose>

<%--                <a href="javascript:;" class="xwjg" onclick="buy_house('${requestScope.house_detail.seller_bank_card}')">¥<strong>${requestScope.house_detail.house_deposit}</strong>元定金</a>--%>
            </c:when>

            <c:otherwise>
                <a href="javascript:;" class="xwjg">已预订</a>
            </c:otherwise>
        </c:choose>
    </div><!--xun-car/-->
   </div><!--proText/-->
        <div class="clears"></div>
    </div><!--width1190/-->
    <div class="proBox" style="width:1000px;margin:10px auto;">
        <div class="proEq">
            <ul class="fl">
                <li class="proEqCur">房源详情</li>
                <li>房源图片</li>
                <li>小区介绍</li>
                <li>评价信息</li>
				<li>提问信息</li>
            </ul>
            <div class="clears"></div>
        </div><!--proEq/-->
        <div class="proList">
        <%-- 房源信息 --%>
            <strong>${requestScope.house_detail.house_detail_info}</strong>
            <br />

        </div><!--proList/-->
        <div class="proList">
            <%-- 房子照片 --%>
            <c:forEach var="pic_path" items="${requestScope.listFileName}">
                <img src="/house/get_pic_image?file_name=${pic_path}&house_id=${requestScope.house_detail.house_id} " style="width: 200px;height: 200px" />
            </c:forEach>
        </div><!--proList/-->
        <div class="proList">
            <%-- 小区信息 --%>
            ${requestScope.house_detail.house_community_info}
        </div><!--proList/-->
        <div class="proList">
            <%-- 评价信息 --%>
                <table class="layui-hide" id="comment"></table>
                <script>
                    layui.use('table', function(){
                        var table = layui.table;

                        table.render({
                            elem: '#comment'
                            ,url:'/house/house_comment/${requestScope.house_detail.house_id}'
                            ,limit:5
                            ,cols: [[
                                {field:'user_name', width:150, title: '用户名称'}
                                ,{field:'comment_detail', width:600, title: '评价内容'}
                                ,{field:'comment_time', width:208, title: '评价时间'}
                            ]]
                            ,page: true
                        });
                    });
                </script>
                <div class="layui-form-item layui-form-text sty">
                    <label class="layui-form-label">我的评论</label>
                    <div class="layui-input-block">
                        <textarea name="desc" placeholder="请输入你的评论，并且保证你的评论真实" class="layui-textarea" id="submit_comment"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo" onclick="submit_comment('${requestScope.house_detail.house_id}')" )>立即提交</button>
                    </div>
                </div>
        </div><!--proList/-->

        <div class="proList">
            <%-- 提问说信息 --%>

            <table class="layui-hide" id="question"></table>

                <script type="text/html" id="answer">
                    <button id="answer_button" onclick="answer('{{d.question_id}}','${requestScope.house_detail.seller_id}','${sessionScope.user.user_id}')">回答</button>
                </script>
            <script>
                layui.use('table', function(){
                    var question_table = layui.table;

                    question_table.render({
                        elem: '#question'
                        ,url:'/house/house_question/${requestScope.house_detail.house_id}'
                        ,limit:5
                        ,cols: [[
                            {field:'user_name', width:100, title: '用户名称'}
                            ,{field:'question_detail', width:400, title: '问题内容'}
                            ,{field:'question_time', width:170, title: '问题时间'}
                            ,{field:'question_answer', width:190, title: '问题回答'}
                            ,{field:'question_id', width:95, templet: '#answer'}
                        ]]
                        ,page: true
                    });
                });
            </script>
            <div class="layui-form-item layui-form-text sty">
                <label class="layui-form-label">我的问题</label>
                <div class="layui-input-block">
                    <textarea name="desc" placeholder="请输入你的问题" class="layui-textarea" id="submit_question"></textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo" onclick="submit_question('${requestScope.house_detail.house_id}','${requestScope.house_detail.seller_id}')" )>立即提交</button>
                </div>
            </div>
        </div><!--proList/-->
    </div><!--proBox/-->

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
<div class="copy">Gklearlove-郭凯</div>
<div class="bg100"></div>
<div class="zhidinggoufang">
    <h2>指定购房 <span class="close">X</span></h2>
    <form action="#">
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

<%--
  Created by IntelliJ IDEA.
  User: 78250
  Date: 2020/4/8
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>主页</title>
    <script src="/jq/jquery-1.8.3.js" type="text/javascript"></script>
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
<h1>${sessionScope.user.user_name}管理员您好</h1>
<a href="/usr/logout">退出登陆</a>
<%--这里用JSTL来遍历所有的信息--%>
<table>
    <thead>
        <tr>
            <th>用户id</th>
            <th>用户姓名</th>
            <th>用户密码</th>
            <th>用户性别</th>
            <th>用户年龄</th>
            <th>操作</th>
        </tr>

    </thead>
    <tbody>
<%-- jstl来遍历 --%>
    <c:forEach var="user" items="${alluser}">
        <tr>
            <th>${user.user_id}</th>
            <th>${user.user_name}</th>
            <th>${user.user_password}</th>
            <th>${user.user_sex}</th>
            <th>${user.user_age}</th>
            <th>
                <button onclick="javaScript:location.href='/usr/removeUserByUserid/${user.userid}?pageNum=${pageInfo.pageNum}&maxPage=${pageInfo.pages}'">删除</button>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <button onclick="modifypd_buid(${user.userid})">修改</button>
                <script>
                    function modifypd_buid(userid){
                        var newPass=prompt("请输入新密码","请填写");
                        location.href="/usr/modifypd_buid?userid="+userid+"&newPass="+newPass+"&pageNum=${pageInfo.pageNum}&maxPage=${pageInfo.pages}";
                    }
                </script>
            </th>
        </tr>

    </c:forEach>

    </tbody>

</table>
<center>
    当前第${pageInfo.pageNum}页/总共${pageInfo.pages}页  ，
    <a href="/usr/getAllUsers?pageNum=${pageInfo.pageNum-1}&maxPage=${pageInfo.pages}">上一页</a>
    <a href="/usr/getAllUsers?pageNum=${pageInfo.pageNum+1}&maxPage=${pageInfo.pages}">下一页</a>
</center>
</body>
</html>

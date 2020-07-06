<%--
  Created by IntelliJ IDEA.
  User: 78250
  Date: 2020/6/6
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<form action="/pay" method="post">
    订单号：<input type="text" readonly="readonly" value="${requestScope.WIDout_trade_no}" name="WIDout_trade_no"><br/>
    订单名称：<input type="text" readonly="readonly" value="${requestScope.WIDsubject}" name="WIDsubject"><br/>
    付款金额：<input type="text" readonly="readonly" value="${requestScope.WIDtotal_amount}" name="WIDtotal_amount"><br/>
    WIDbody：<input type="text" readonly="readonly" value="${requestScope.WIDbody}" name="WIDbody"><br/>
    二手房id：<input type="text" readonly="readonly" value="${requestScope.house_id}" name="WIDbody"><br/>
    <input type="submit" value="确认下单">
</form>


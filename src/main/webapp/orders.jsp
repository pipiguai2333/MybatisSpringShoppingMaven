<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-05-02
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<a href="getAllGoods">继续购物</a>
    <c:forEach var="order" items="${requestScope.orders}">
    <table border=1>
        <tr>
            <td>订单编号</td>
            <td>${order.orderId}</td>
            <td>创建时间</td>
            <td><fmt:formatDate value='${order.createdTime}' pattern='yyyy-MM-dd HH:mm:ss'/></td>
            <td>
                <form action="deleteOrder" method="post">
                    <input type="hidden" name="orderId" value="${order.orderId}" />
                    <input type="submit" value="删除">
                </form>
            </td>
        </tr>
    </table>
        <table border=1>
            <tr>
                <td>物品编号</td>
                <td>物品名称</td>
                <td>物品价格</td>
                <td>物品数量</td>
            </tr>
            <c:forEach var="item" items="${order.items}">
                <tr>
                    <td>${item.goods.goodsId}</td>
                    <td>${item.goods.goodsName}</td>
                    <td>${item.goods.price}</td>
                    <td>${item.quantity}</td>
                </tr>
            </c:forEach>
        </table>
        <hr/>
    </c:forEach>
</body>
</html>

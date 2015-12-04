<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="col" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello World</title>
</head>
 <script>
     function queryItems() {
         document.itemsForm.action="${pageContext.request.contextPath}/items/queryItems";
         document.itemsForm.submit();
     }
     function deleteItems() {
         document.itemsForm.method = "post";
         document.itemsForm.action="${pageContext.request.contextPath}/items/deleteItems";
         document.itemsForm.submit();
     }
 </script>
<body>
用户名: ${username} <a href="${pageContext.request.contextPath}/user/logout">退出</a>
<form name="itemsForm" method="post">
<table border="1" cellpadding="1" cellspacing="1">
<tr>
    <td>商品名称：<input name="itemsCustom.name"/></td>
    <td><input type="button" value="查询" onclick="queryItems()"/>
        <input type="button" value="批量删除" onclick="deleteItems()"/></td>
</tr>
</table>
<table border="1" cellpadding="1" cellspacing="1" >
    <tr>
        <td>选择</td>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>商品描述</td>
        <td>生成日期</td>
        <td>操作</td>
    </tr>
    <col:forEach items="${itemsList}" var="item">
        <tr>
            <td><input type="checkbox" name="items_id" value="${item.id}"/></td>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.description}</td>
            <td><fmt:formatDate value='${item.createTime }' pattern='yyyy-MM-dd HH:mm:dd'/></td>
            <td><a href="${pageContext.request.contextPath}/items/editItems?id=${item.id}">编辑</a></td>
        </tr>
    </col:forEach>
    <tr></tr>
</table>
</form>
</body>
</html>
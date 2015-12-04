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
     function editItemsList() {
         document.itemsForm.action="${pageContext.request.contextPath}/items/editItemsList";
         document.itemsForm.submit();
     }
 </script>
<body>
<form name="itemsForm" method="post">
<table border="1" cellpadding="1" cellspacing="1">
<tr>
    <td><input type="button" value="批量删除" onclick="editItemsList()"/></td>
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
    <col:forEach items="${itemsList}" var="item" varStatus="status">
        <tr>
            <td><input name="${item[status.index].name}" value="${item.name}"/></td>
            <td><input name="${item[status.index].price}" value="${item.price}"/></td>
            <td><input name="${item[status.index].description}" value="${item.description}"/></td>
            <td><input name="${item[status.index].createTime}" value="<fmt:formatDate value='${item.createTime }' pattern='yyyy-MM-dd HH:mm:dd'/>"/></td>
        </tr>
    </col:forEach>
    <tr>
   <td>
        </td>
    </tr>
</table>
</form>
</body>
</html>
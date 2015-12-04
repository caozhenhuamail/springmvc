<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello World</title>
</head>
<body>

<c:if test="${allErrors!=null}">
    <c:forEach items="${allErrors}" var="error">
        ${error.defaultMessage} <br/>
    </c:forEach>
</c:if>

<form id="itemForm" method="post" action="${pageContext.request.contextPath}/items/editItemsSubmit">
    <input type="hidden" name="id" value="${itemsCustom.id}"/>
    <table border="1" cellpadding="1" cellspacing="1">
        <tr>
            <td>商品名称：</td>
            <td><input type="text" name="name" value="${itemsCustom.name}"/></td>
        </tr>
        <tr>
            <td>商品价格：</td>
            <td><input type="text" name="price" value="${itemsCustom.price}"/></td>
        </tr>
        <tr>
            <td>商品名称：</td>
            <td><textarea rows="3" cols="30" name="description" >${itemsCustom.description}</textarea></td>
        </tr>
        <tr>
            <td>创建日期：</td>
            <td>
                <input type="text" name="createTime" value="<fmt:formatDate value='${itemsCustom.createTime }'
                pattern='yyyy-MM-dd HH:mm:dd'/>"/>
            </td>
        </tr>
        <tr>
            <td>提交：</td>
            <td><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>

</body>
</html>
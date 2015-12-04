<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登陆</title>
</head>
<body>

<form id="itemForm" method="get" action="${pageContext.request.contextPath}/user/login">
    <table border="1" cellpadding="1" cellspacing="1">
        <tr>
            <td>登陆名称：</td>
            <td><input type="text" name="username" value=""/></td>
        </tr>
        <tr>
            <td>登陆密码：</td>
            <td><input type="text" name="password" value=""/></td>
        </tr>
        <tr>
            <td>提交：</td>
            <td><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>

</body>
</html>
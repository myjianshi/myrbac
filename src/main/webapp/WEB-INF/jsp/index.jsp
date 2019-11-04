<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h1>Welcome to Simple RBAC System</h1>
<form action="login" method="post">
    用户名 :<input type="text" name="username"><br>
    密 码:<input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>

</body>
</html>

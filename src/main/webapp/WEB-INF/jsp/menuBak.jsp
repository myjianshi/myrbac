<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>首页</title>
</head>
<body>

<a href="tologin">登录</a>
<a href="exit">注销</a>

<hr>
<c:if test="${not empty user}">
    当前用户：${user.username}<br>
     <c:if test="${not empty permissions}">
         <ul>
             <c:forEach items="${permissions}" var="p">
                 <li><a href="api/${p}">${p}</a></li>
             </c:forEach>
         </ul>

     </c:if>
    <c:if test="${ empty permissions}">
        <h1>无权限，请联系管理员！</h1>

    </c:if>
    <hr>
</c:if>



</body>
</html>

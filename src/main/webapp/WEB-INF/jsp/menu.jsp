<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="utf-8" />
    <title>大汉银行</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <a href="">
            <div class="layui-logo">简易后台管理系统</div>
        </a>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item">
                <a href="/">返回前台</a>
            </li>

            <li class="layui-nav-item">
                <a href="">用户</a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd>
                        <a href="">邮件管理</a>
                    </dd>
                    <dd>
                        <a href="">消息管理</a>
                    </dd>
                    <dd>
                        <a href="">授权管理</a>
                    </dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="img/j10.png" class="layui-nav-img"> ${user.username} </a>
                <dl class="layui-nav-child">
                    <dd>
                        <a href="javascript:;" onclick="addTab(this);" tab_url="">基本资料</a>
                    </dd>
                    <dd>
                        <a href="">安全设置</a>
                    </dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="/myrbac/exit">退了</a>
            </li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree">

                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">常规功能</a>
                    <dl class="layui-nav-child">


                        <c:if test="${not empty permissions}">

                            <c:forEach items="${permissions}" var="p">
                                <dd><a href="javascript:void(0);" class="layTabPlus" tab_url="api/${p}">${p}</a></dd>

                            </c:forEach>
                        </c:if>

                    </dl>
                </li>


            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="layui-tab" lay-filter="demoTab" lay-allowClose="true">
            <ul class="layui-tab-title">
                <li class="layui-this " lay-id='base_info'>welcome</li>
            </ul>
            <div class="layui-tab-content" style="padding:0px;">
                <div class="layui-tab-item layui-show">
                    <div class="sysNotice col">
                        <h1>大汉银行欢迎你！</h1>
                        <h1>向歼二零致敬！</h1>
                        <img src="img/j20.png">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-footer">
        © 2018layTabPlus
    </div>
</div>
<script src="layui/layui.all.js"></script>
<script>
    var $ = layui.jquery;
    var layer = layui.layer;
    var element = layui.element;
    var util = layui.util;
    var table = layui.table;
</script>
<script src="js/layTabPlus.js"></script>
<script>
    layTabPlus.init({
        lay_filter: 'demoTab',
        tab_jump:true
    });
</script>
</body>

</html>

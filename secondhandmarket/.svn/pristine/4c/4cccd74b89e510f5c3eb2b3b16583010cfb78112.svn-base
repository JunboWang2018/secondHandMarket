<%@ page language="java" contentType="text/html;charset=UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <script type="text/javascript" src="/secondhandmarket/js/jquery-3.3.1.min.js" ></script>
    <link rel="stylesheet" href="/secondhandmarket/css/bootstrap.min.css" />
    <script type="text/javascript" src="/secondhandmarket/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="/secondhandmarket/js/common.js" ></script>
</head>
<body>
    <div class="container-fluid">
        <div class="col-md-9">
            <a href="/secondhandmarket/"><h2><span class="label label-primary">二手集市</span></h2></a>
        </div>
        <div class="col-md-3" style="padding-top:20px;" align="right">
            <ol class="list-inline" >
                <c:if test="${empty sessionScope.user}">
                    <li><a href="/secondhandmarket/view/user/toLogin">你好，请登录</a></li>
                    <li><a href="/secondhandmarket/view/user/toRegister">注册</a></li>
                </c:if>
                <c:if test="${!empty sessionScope.user}">
                    <li>你好，${sessionScope.user}</li>
                    <li><a href="/secondhandmarket/data/user/logout">退出</a></li>
                    <li><a href="/secondhandmarket/view/order/toMyOrder">我的订单</a></li>
                </c:if>

                <li><a href="/secondhandmarket/view/release/toReleaseProduct">发布物品</a></li>
                <li><a href="/secondhandmarket/view/release/toReleaseDemandInfo">发布求购</a></li>
            </ol>
        </div>
    </div>
    <div class="container-fluid" style="height: 60px">
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div>
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">主页</a></li>
                        <li><a href="/secondhandmarket/?typeCode=FURN">家具</a></li>
                        <li><a href="/secondhandmarket/data/index/search?typeCode=ELAP">电器</a></li>
                        <li><a href="/secondhandmarket/data/index/search?typeCode=DGTL">数码</a></li>
                        <li><a href="/secondhandmarket/data/index/search?typeCode=TSPT">交通工具</a></li>
                        <li><a href="/secondhandmarket/data/index/search?typeCode=HDWR">五金器具</a></li>
                        <li><a href="/secondhandmarket/data/index/search?typeCode=DCRT">装饰摆件</a></li>
                        <li><a href="/secondhandmarket/data/index/search?typeCode=CLTB">服饰包具</a></li>
                        <li><a href="/secondhandmarket/data/index/search?typeCode=TCKT">点券</a></li>
                        <li><a href="/secondhandmarket/data/index/search?typeCode=DGTP">数字商品</a></li>
                    </ul>
                </div>
                <form class="navbar-form navbar-right" role="search" >
                    <div class="form-group">
                        <input id="search_key" type="text" class="form-control">
                    </div>
                    <button type="button" class="btn btn-default" onclick="toProdKeySearch()">搜索物品</button>
                    <button type="button" class="btn btn-default" onclick="toDemdInfoKeySearch()">搜索求购</button>
                </form>
            </div>
        </nav>
    </div>
</body>
</html>


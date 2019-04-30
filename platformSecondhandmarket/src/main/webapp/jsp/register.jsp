<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <script type="text/javascript" src="/second_hand_market/js/jquery-3.3.1.min.js" ></script>
    <link rel="stylesheet" href="/second_hand_market/css/bootstrap.min.css" />
    <script type="text/javascript" src="/second_hand_market/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="/second_hand_market/js/register.js" ></script>
    <script type="text/javascript" src="/second_hand_market/js/common.js"></script>
    <style type="text/css">
        .center-in-center{
            position: absolute;
            top: 50%;
            left: 50%;
            -webkit-transform: translate(-50%, -50%);
            -moz-transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            -o-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }
        .input-group{
            width: 378px;
            margin-right: 30px;
        }
        .input-group-addon{
            width: 67px;
        }
    </style>
</head>
<body>

<div class="center-in-center">
    <div class="col-md-5">
        <div
                style="width: 440px; border: 1px solid #E7E7E7; padding: 20px 0 20px 30px; border-radius: 5px; margin-top:; background: #fff;">
            <font style="margin-left: 170px;" size="4">注册</font>
            <div>&nbsp;</div>
            <div class="input-group">

                <span class="input-group-addon">用户名</span>
                <input id="username" type="text" class="form-control" placeholder="请输入用户名">
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">密码</span>
                <input id="password" type="password" class="form-control" placeholder="请输入密码">
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">联系方式</span>
                <input id="tel" type="text" class="form-control" placeholder="请输入联系方式">
            </div>
            <br>
            <div style="margin-left: 160px;">
                <button id="register" type="button" class="btn btn-primary" >注册</button>
            </div>
        </div>
    </div>

</body>
</html>


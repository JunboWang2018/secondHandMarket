<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>

    <script type="text/javascript" src="/secondhandmarket/js/jquery-3.3.1.min.js" ></script>
    <link rel="stylesheet" href="/secondhandmarket/css/bootstrap.min.css" />
    <script type="text/javascript" src="/secondhandmarket/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="/secondhandmarket/js/loadHeader.js"></script>
    <script type="text/javascript" src="/secondhandmarket/js/common.js"></script>
    <style type="text/css">
        td{
            text-align: center
        }

    </style>

    <script>
        window.onload = loadMyOrder();
        /*$(document).ready(function(){
            $("#check_record").click(function(){
                $("#myModalLabel").text("记录");
                $('#myModal').modal();
            });
        });*/

    </script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-fluid" >
    <table class="table table-striped table-hover">
        <h3><span class="label label-info">购买记录</span></h3>
        <thead>
            <tr>
                <th width="20%" style="text-align: center;">订单编号</th>
                <th width="30%" style="text-align: center;">物品名称</th>
                <th width="10%" style="text-align: center;">卖家</th>
                <th width="10%" style="text-align: center;">单价</th>
                <th width="10%" style="text-align: center;">数量</th>
                <th width="10%" style="text-align: center;">订单总价</th>
                <th width="10%" style="text-align: center;">交易类型</th>
            </tr>
        </thead>
        <tbody id="buy_order_list">
        </tbody>
    </table>
    <table class="table table-striped table-hover">
        <h3><span class="label label-info">出售记录</span></h3>
        <thead>
            <tr>
                <th width="20%" style="text-align: center;">订单编号</th>
                <th width="30%" style="text-align: center;">物品名称</th>
                <th width="10%" style="text-align: center;">买家</th>
                <th width="10%" style="text-align: center;">单价</th>
                <th width="10%" style="text-align: center;">数量</th>
                <th width="10%" style="text-align: center;">订单总价</th>
                <th width="10%" style="text-align: center;">交易类型</th>
            </tr>
        </thead>
        <tbody id="sale_order_list">
        </tbody>
    </table>
</div>
<<!--
    作者：offline
    时间：2019-04-05
    描述：隐藏的记录框
--->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">新增</h4>
            </div>
            <div class="modal-body">
                <table class="table table-striped table-hover">
                    <h4><span id="order_page_price_record_name" class="label label-info"></span></h4>
                    <thead id="order_page_price_record_head">
                    </thead>
                    <tbody id="order_page_price_record_body">
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal"  onclick="removeOrderPagePriceRecordHTML()"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>


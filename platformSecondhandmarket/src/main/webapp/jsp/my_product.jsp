<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的物品</title>

    <script type="text/javascript" src="/second_hand_market/js/jquery-3.3.1.min.js" ></script>
    <link rel="stylesheet" href="/second_hand_market/css/bootstrap.min.css" />
    <script type="text/javascript" src="/second_hand_market/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="/second_hand_market/js/loadHeader.js"></script>
    <script type="text/javascript" src="/second_hand_market/js/common.js"></script>
    <style type="text/css">
        td{
            text-align: center
        }

    </style>

    <script>
        window.onload = loadMyProducts();

    </script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-fluid" >
    <table class="table table-striped table-hover">
        <h3><span class="label label-info">我的物品</span></h3>
        <thead>
            <tr>
                <th width="20%" style="text-align: center;">物品编号</th>
                <th width="30%" style="text-align: center;">物品名称</th>
                <th width="5%" style="text-align: center;">单价</th>
                <th width="5%" style="text-align: center;">数量</th>
                <th width="5%" style="text-align: center;">折旧率</th>
                <th width="15%" style="text-align: center;">交易类型</th>
                <th width="10%" style="text-align: center;">交易状态</th>
                <th width="10%" style="text-align: center;">上/下架</th>
            </tr>
        </thead>
        <tbody id="my_products">
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
                    <h4><span id="price_page_price_record_name" class="label label-info"></span></h4>
                    <thead id="prod_page_price_record_head">
                    </thead>
                    <tbody id="prod_page_price_record_body">
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal"  onclick="removeProdPagePriceRecordHTML()"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>


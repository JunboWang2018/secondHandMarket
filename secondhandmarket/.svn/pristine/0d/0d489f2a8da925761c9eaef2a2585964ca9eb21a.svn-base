<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品信息</title>

    <script type="text/javascript" src="/secondhandmarket/js/jquery-3.3.1.min.js" ></script>
    <link rel="stylesheet" href="/secondhandmarket/css/bootstrap.min.css" />
    <script type="text/javascript" src="/secondhandmarket/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="/secondhandmarket/js/loadHeader.js"></script>
    <script type="text/javascript" src="/secondhandmarket/js/common.js"></script>
    <script>
        window.onload = function () {
            var productNumber = "${productNumber}";
            prodNumberSearch(productNumber);
        }
    </script>
</head>
<body>
<jsp:include page="header.jsp"/>
    <div class="container">
        <div class="row">
            <div
                    style="border: 1px solid #e4e4e4; width: 930px; margin-bottom: 10px; margin: 0 auto; padding: 10px; margin-bottom: 10px;">
                <span id="navTypeName">分类名</span>&nbsp;&nbsp;&gt;&nbsp<span id="navProdName"></span>;
            </div>

            <div style="margin: 0 auto; width: 950px;">
                <div class="col-md-6">
                    <img id="prodImg" style="opacity: 1; width: 400px; height: 350px;" title=""
                         class="medium"
                         src="">
                </div>

                <div class="col-md-6" style="margin-top: 10px;">
                    <div>
                        <strong>物品编号 : </strong>
                        <span id="prodNumber"></span>
                    </div>
                    <br>
                    <div>
                        <strong>物品名 : </strong>
                        <span id="prodName"></span>
                    </div>
                    <br>
                    <div id="saleInfo">

                    </div>
                </div>
            </div>
        </div>
        <div class="row" style="margin-top: 40px">
            <h4><strong>物品描述</strong></h4>
            <br>
            <span id="prodDesc"></span>
        </div>
    </div>
</body>
</html>


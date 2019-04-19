<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>求购信息</title>

    <script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <script type="text/javascript" src="js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="js/loadHeader.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <style type="text/css">
        td{
            text-align: center;
            width: 400px;
            height: 100px;
        }

    </style>
    <script>
        window.onload = function () {
            var demdInfoNumber = "${demdInfoNumber}";
            demdInfoNumberSearch(demdInfoNumber);
        }
    </script>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div class="container-fluid">
        <table border="1" align="center">
            <caption style="text-align: center;"><h2><span class="label label-info">求购信息</span></h2></caption>
            <tr>
                <td>求购信息编号：</td>
                <td id="demand_info_number"></td>
            </tr>
            <tr>
                <td>名称：</td>
                <td id="demand_info_name"></td>
            </tr>
            <tr>
                <td>求购物品类型：</td>
                <td id="demand_info_typeName"></td>
            </tr>
            <tr>
                <td>折旧率要求：</td>
                <td id="demand_info_rate"></td>
            </tr>
            <tr>
                <td>数量要求：</td>
                <td id="demand_info_quantity"></td>
            </tr>
            <tr>
                <td>求购价：</td>
                <td id="demand_info_price"></td>
            </tr>
            <tr>
                <td>其它要求：</td>
                <td id="demand_info_other"></td>
            </tr>
            <tr>
                <td>用户名：</td>
                <td id="demand_info_username"></td>
            </tr>
            <tr>
                <td>联系方式：</td>
                <td id="demand_info_tel"></td>
            </tr>
            <tr>
                <td>创建时间：</td>
                <td id="demand_info_createDate"></td>
            </tr>
        </table>
    </div>

</body>
</html>


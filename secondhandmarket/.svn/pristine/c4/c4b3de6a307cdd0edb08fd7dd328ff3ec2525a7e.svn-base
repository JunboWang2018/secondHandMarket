<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>求购列表</title>

    <script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <script type="text/javascript" src="js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="js/loadHeader.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script>
        window.onload = function () {
            document.getElementById("requirement_list_page").innerHTML = localStorage.getItem("demdIResultListString");
        }
    </script>
    <style type="text/css">
        td{
            text-align: center
        }

    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-fluid" >
    <table class="table table-hover">
        <h3><span class="label label-info">求购信息</span></h3>
        <thead>
        <tr>
            <th style="text-align: center; width: 17%">需求编号</th>
            <th style="text-align: center; width: 27%">需求名称</th>
            <th style="text-align: center; width: 12%">折旧率要求</th>
            <th style="text-align: center; width: 12%">数量要求</th>
            <th style="text-align: center; width: 12%">价格要求</th>
        </tr>
        </thead>
        <tbody id="requirement_list_page">

        </tbody>
    </table>
</div>

</body>
</html>

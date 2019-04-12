<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>搜索结果</title>

    <script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <script type="text/javascript" src="js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="js/loadHeader.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script>
        window.onload = function () {
            document.getElementById("product_list_page").innerHTML = localStorage.getItem("prodResultListString");
        }
    </script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="product_list_page" class="container-fluid">
    <div class='col-md-2' style='height:250px'>
        <a href='item.html'>
            <img src='#' width='170' height='170' style='display: inline-block;'>
        </a>
        <p>
            <a href='item.html' style='color: green'>物品标题</a>
        </p>
        <p>
            <font color='#FF0000'>售价：&yen</font>
        </p>
    </div>
</div>
</body>
</html>


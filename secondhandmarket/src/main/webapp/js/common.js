function getRootPath() {
    //获取当前url
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录
    var pathName = window.document.location.pathname;
    var position = curWwwPath.indexOf(pathName);
    //截取主机地址
    var localhostPath = curWwwPath.substring(0, position);
    //截取项目名
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return localhostPath + projectName;
}

function prodKeySearch() {
    var key = $("#search_key").val();
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/search/searchProdList",
        dataType : 'json',
        data : {
            name : key
        },
        /*success : function (result) {
            if (result.code == 0) {
                var productList = result.data.list;
                if (productList != null) {
                    var productListString = "";
                    for (var i = 0; i < productList.length; i++) {
                        productListString += "<div class='col-md-2' style='height:250px; width: 250px; text-align: center'>\n" +
                            "            <a href=/secondhandmarket/data/search/searchProduct?productNumber=" + productList[i].productNumber + ">\n" +
                            "                <img src=/secondhandmarket/image/" + productList[i].image + " width='170px' height='170px' align='center' style='display: inline-block;'>\n" +
                            "            </a>\n" +
                            "            <p>\n" +
                            "                <a href=/secondhandmarket/data/search/searchProduct?productNumber=" + productList[i].productNumber + " style=''>" + productList[i].name + "</a>\n" +
                            "            </p>\n" +
                            "            <p align='center'><h4><span style='color: red'>售价：￥&nbsp;" + productList[i].price + "</span></h4></p>" +
                            "        </div>"
                    }
                    if (localStorage.getItem("prodResultListString" != null)) {
                        localStorage.removeItem("prodResultListString");
                    }
                    localStorage.setItem("prodResultListString", productListString);
                    window.location.href = getRootPath() + "/view/search/prodListResult";
                }
            } else {
                alert(result.message);
            }
        },*/
        error : function () {
            alert("请求失败")
        }
    });
}

function demdInfoKeySearch() {
    var key = $("#search_key").val();
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/search/searchDemandInfoList",
        dataType : 'json',
        data : {
            name : key
        },
        success : function (result) {
            if (result.code == 0) {
                var demandInfoList = result.data.list;
                if (demandInfoList != null) {
                    var demandInfoString = "";
                    for (var i = 0; i < demandInfoList.length; i++) {
                        demandInfoString += "<td style='text-align: center'>"+ demandInfoList[i].demandInfoNumber +"</td>" +
                            "<td style='text-align: center'>" + demandInfoList[i].name + "</td>" +
                            "<td style='text-align: center'>" + demandInfoList[i].depreciationRate + "</td>" +
                            "<td style='text-align: center'>" + demandInfoList[i].quantity + "</td>" +
                            "<td style='text-align: center'>" + demandInfoList[i].price + "</td>"
                    }
                    if (localStorage.getItem("demdIResultListString" != null)) {
                        localStorage.removeItem("demdIResultListString");
                    }
                    localStorage.setItem("demdIResultListString", demandInfoString);
                    window.location.href = getRootPath() + "/view/search/demdInfoListResult";
                }
            } else {
                alert(result.message);
            }
        },
        error : function () {
            alert("请求失败")
        }
    });
}


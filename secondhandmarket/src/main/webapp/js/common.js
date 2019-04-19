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

function toProdKeySearch() {
    var searchKey = $("#search_key").val();
    window.open(getRootPath() + "/view/search/searchProdList?searchKey=" + searchKey);
}

function prodKeySearch(searchKey) {
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/search/searchProdList",
        dataType : 'json',
        data : {
            name : searchKey
        },
        success : function (result) {
            if (result.code == 0) {
                var productList = result.data.list;
                if (productList != null) {
                    var productListString = initProdHTML(productList);
                    document.getElementById("product_list_page").innerHTML = productListString;
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

function initProdHTML(productList) {
    var productListString = "";
    for (var i = 0; i < productList.length; i++) {
        var priceType = "";
        var saleWayType = "";
        if (productList[i].saleWayCode == "BOUT") {
            priceType = "一口价";
            saleWayType = "一口价";
        }
        if (productList[i].saleWayCode == "BIDD") {
            priceType = "起拍价";
            saleWayType = "竞价";
        }
        if (productList[i].saleWayCode == "BARG") {
            priceType = "参考售价";
            saleWayType = "议价";
        }
        productListString += "<div class='col-md-2' style='height:280px; width: 250px; text-align: center'>\n" +
            "            <a href=/secondhandmarket/view/search/searchProduct?productNumber=" + productList[i].productNumber + ">\n" +
            "                <img src=/secondhandmarket/image/" + productList[i].image + " width='170px' height='170px' align='center' style='display: inline-block;'>\n" +
            "            </a>\n" +
            "            <p>\n" +
            "                <a href=/secondhandmarket/view/search/searchProduct?productNumber=" + productList[i].productNumber + " style=''>" + productList[i].name + "</a>\n" +
            "            </p>\n" +
            "            <p align='center'><h4><span style='color: red'>" + priceType + "：￥&nbsp;" + productList[i].price + "</span></h4>&nbsp;交易类型：" + saleWayType + "</p>" +
            "        </div>"

    }
    return productListString;
}

function prodNumberSearch(productNumber) {
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/search/searchProductInfo",
        dataType : "json",
        data : {
            productNumber : productNumber
        },
        success : function (result) {
            if (result.code == 0) {
                productInfo = result.data;
                document.getElementById("navTypeName").innerHTML = productInfo.typeName;
                document.getElementById("navProdName").innerHTML = productInfo.productDo.name;
                document.getElementById("prodName").innerHTML = productInfo.productDo.name;
                document.getElementById("prodNumber").innerHTML = productInfo.productDo.productNumber;
                document.getElementById("prodImg").src = "/secondhandmarket/image/" + productInfo.productDo.image;
                var addPrice = productInfo.biddMaxPrice + productInfo.productDo.addPriceLimit
                if (productInfo.productDo.saleWayCode == "BIDD") {
                    document.getElementById("saleInfo").innerHTML = "<div style='margin: 10px 0 10px 0;'>"
                        + "当前最高价: <strong style='color: #ef0101;'>￥：" + productInfo.biddMaxPrice + "元</strong>&nbsp; 起拍价：<span>￥" + productInfo.productDo.price + "元</span>&nbsp; 最低加价幅度： <span>" + productInfo.productDo.addPriceLimit +"元</span></div>"
                        + "<div style='margin: 10px 0 10px 0;'>交易方式: <span>" + productInfo.saleWayName + "</span></div>"
                        + "<div style='margin: 10px 0 10px 0;'>倒计时:&nbsp; <span id='countDown' style='color: red'></span></div>"
                        + "<div style='padding: 10px; border: 1px solid #e7dbb1; width: 330px; margin: 15px 0 10px 0;; background-color: #FFFFFF;'>"
                        + "<div style='border-bottom: 1px solid #faeac7; margin-top: 20px; padding-left: 10px;'>"
                        + "出价: <input id='BIDD_price' value='" + addPrice + "' type='text'></div>"
                        + "<div style='margin: 20px 0 10px 0;; text-align: center;'>"
                        + "<button id='BIDD_buy' type='button' class='btn btn-primary' style='width: 100px' onclick='buyBIDDProd()'>出价</button></div></div>"
                } else if(productInfo.productDo.saleWayCode == "BARG") {
                    document.getElementById("saleInfo").innerHTML = "<div style='margin: 10px 0 10px 0;'>"
                        + "参考售价：<span>￥" + productInfo.productDo.price + "元</span></div>"
                        + "<div style='margin: 10px 0 10px 0;'>交易方式: <span>" + productInfo.saleWayName + "</span></div>"
                        + "<div style='padding: 10px; border: 1px solid #e7dbb1; width: 330px; margin: 15px 0 10px 0;; background-color: #FFFFFF;'>"
                        + "<div style='border-bottom: 1px solid #faeac7; margin-top: 20px; padding-left: 10px;'>"
                        + "出价: <input id='BARG_price' type='text' placeholder='请输入期望价格'></div>"
                        + "<div style='margin: 20px 0 10px 0;; text-align: center;'>"
                        + "<button id='BARG_buy' type='button' class='btn btn-primary' style='width: 100px' onclick='buyBARGProd()'>出价</button></div></div>"
                } else {
                    document.getElementById("saleInfo").innerHTML = "<div style='margin: 10px 0 10px 0;'>"
                        + "一口价: <strong style='color: #ef0101;'>￥" + productInfo.productDo.price + "元</strong></div>"
                        + "<div style='padding: 10px; border: 1px solid #e7dbb1; width: 330px; margin: 15px 0 10px 0;; background-color: #FFFFFF;'>"
                        + "<div style='border-bottom: 1px solid #faeac7; margin-top: 20px; padding-left: 10px;'>"
                        // + "购买: <input id='BOUT_quantity' value='1' type='text'></div>"
                        + "<div style='margin: 20px 0 10px 0;; text-align: center;'>"
                        + "<button id='BOUT_buy' type='button' class='btn btn-primary' style='width: 100px' onclick='buyBOUTProd()'>购买</button></div></div>"
                }
                document.getElementById("prodDesc").innerHTML = productInfo.productDo.description;
                //计算倒计时秒数
                var prodCreateDate = new Date(productInfo.productDo.createDate).getTime();
                var currentMillis = new Date().getTime();
                var times = Math.floor((prodCreateDate + productInfo.productDo.timeLimit * 1000 - currentMillis) / 1000);
                console.log(times);
                timeDown(times);
            } else if (result.code == 10) {
                alert(result.message);
            }
        },
        error : function () {
            alert("请求失败");
        }
    });
}

function timeDown(times) {
    var timer = null;
    timer = setInterval(function () {
        var day = 0;
        var hour = 0;
        var minute = 0;
        var second = 0;
        if (times > 0) {
            day = Math.floor(times / (60 * 60 * 24));
            hour = Math.floor(times / (60 * 60)) - (day * 24);
            minute = Math.floor(times / 60) - hour * 60 - day * 24 * 60;
            second = times - minute * 60 - hour * 60 * 60 - day * 60 * 60 * 24;
        }
        if (day <= 9) {
            day = '0' + day;
        }
        if (hour <= 9) {
            hour = '0' + hour;
        }
        if (minute <= 9) {
            minute = '0' + minute;
        }
        if (second <= 9) {
            second = '0' + second;
        }
        times--;
        $("#countDown").html(day + "天 ：" + hour + "小时 ：" + minute + "分钟 ：" + second + "秒" );
    }, 1000);
    if (times <= 0) {
        clearInterval(timer);
    }
}

function prodListConditionSearch() {
    var typeCode = $("#product_type option:selected").val();
    var depRateSymbol = $("#product_dr_condition option:selected").val();
    var depreciationRate = $("#product_depreciationRate").val();
    var minPrice = $("#prod_min_price").val();
    var maxPrice = $("#prod_max_price").val();
    var saleWayCode = $("#product_saleWay option:selected").val();
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/search/searchProdListByQo",
        dataType : 'json',
        data : {
            typeCode : typeCode,
            depRateSymbol : depRateSymbol,
            depreciationRate : depreciationRate,
            maxPrice : maxPrice,
            minPrice : minPrice,
            saleWayCode : saleWayCode
        },
        success : function (result) {
            if (result.code == 0) {
                var productList = result.data.list;
                if (productList != null) {
                    var indexProdList = new Array();
                    //取前7个商品
                    for (var i = 0; i < productList.length && i < 7; i++) {
                        indexProdList[i] = productList[i];
                    }
                    var productListString = initProdHTML(indexProdList);
                    document.getElementById("product_list").innerHTML = productListString;
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

function toDemdInfoKeySearch() {
    var searchKey = $("#search_key").val();
    window.location.href = getRootPath() + "/view/search/searchDemandInfoList?searchKey=" + searchKey;
}

function demandInfoKeySearch(searchKey) {
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/search/searchDemandInfoList",
        dataType : 'json',
        data : {
            name : searchKey
        },
        success : function (result) {
            if (result.code == 0) {
                var demandInfoList = result.data.list;
                if (demandInfoList != null) {
                    var demandInfoString = initDemandInfoHTML(demandInfoList);
                    document.getElementById("requirement_list_page").innerHTML = demandInfoString;
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

function initDemandInfoHTML(demandInfoList) {
    var demandInfoString = "";
    for (var i = 0; i < demandInfoList.length; i++) {
        demandInfoString += "<tr><td style='text-align: center'>"+ demandInfoList[i].demandInfoNumber +"</td>" +
            "<td style='text-align: center'><a href='/secondhandmarket/view/search/searchDemandInfo?demdInfoNumber=" + demandInfoList[i].demandInfoNumber +"'>" + demandInfoList[i].name + "</a></td>" +
            "<td style='text-align: center'>" + demandInfoList[i].depreciationRate + "</td>" +
            "<td style='text-align: center'>" + demandInfoList[i].quantity + "</td>" +
            "<td style='text-align: center'>" + demandInfoList[i].price + "</td></tr>"
    }
    return demandInfoString;
}


function DemdInfoListCondSearch() {
    var typeCode = $("#demandInfo_type").val();
    var depRateSymbol = $("#demandInfo_dr_condition").val();
    var depreciationRate = $("#demandInfo_depreciationRate").val();
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/search/searchDemdInfoListByQo",
        dataType : 'json',
        data : {
            typeCode : typeCode,
            depRateSymbol : depRateSymbol,
            depreciationRate : depreciationRate
        },
        success : function (result) {
            if (result.code == 0) {
                var demdInfoList = result.data.list;
                if (demdInfoList != null) {
                    var DemdInfoListString = initDemandInfoHTML(demdInfoList);
                    document.getElementById("requirementList").innerHTML = DemdInfoListString;
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

function demdInfoNumberSearch(demdInfoNumber) {
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/search/searchDemandInfo",
        dataType : "json",
        data : {
            demdInfoNumber : demdInfoNumber
        },
        success : function (result) {
            if (result.code == 0) {
                demandInfo = result.data;
                $("#demand_info_number").text(demandInfo.demandInfoDo.demandInfoNumber);
                $("#demand_info_name").text(demandInfo.demandInfoDo.name);
                $("#demand_info_typeName").text(demandInfo.typeName);
                $("#demand_info_rate").text(demandInfo.demandInfoDo.depreciationRate);
                $("#demand_info_quantity").text(demandInfo.demandInfoDo.quantity);
                $("#demand_info_price").text(demandInfo.demandInfoDo.price);
                $("#demand_info_other").text(demandInfo.demandInfoDo.other);
                $("#demand_info_username").text(demandInfo.userName);
                $("#demand_info_tel").text(demandInfo.userTel);
                $("#demand_info_createDate").text(demandInfo.demandInfoDo.createDate);
            } else if (result.code == 10) {
                alert(result.message);
            }
        },
        error : function () {
            alert("请求失败");
        }
    });
}

function buyBOUTProd() {
    var productNumber = document.getElementById("prodNumber").innerHTML;
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/order/generateOrder",
        dataType : "json",
        data : {
            productNumber : productNumber,
        },
        success : function (result) {
            if (result.code == 105) {
                alert(result.message);
                window.location.href = "/secondhandmarket/";
            } else {
                alert(result.message);
            }
        },
        error : function () {
            alert("请求失败");
        }
    });
}

function buyBIDDProd() {
    var productNumber = document.getElementById("prodNumber").innerHTML;
    var biddPrice = $("#BIDD_price").val();
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/price/BIDD",
        dataType : "json",
        data : {
            productNumber : productNumber,
            biddingPrice : biddPrice
        },
        success : function (result) {
            if (result.code == 105) {
                alert(result.message);
                window.location.reload();
            } else {
                alert(result.message);
            }
        },
        error : function () {
            alert("请求失败");
        }
    });
}


function buyBARGProd() {
    var productNumber = document.getElementById("prodNumber").innerHTML;
    var bargPrice = $("#BARG_price").val();
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/price/BARG",
        dataType : "json",
        data : {
            productNumber : productNumber,
            bargainingPrice : bargPrice
        },
        success : function (result) {
            if (result.code == 105) {
                alert(result.message);
            } else {
                alert(result.message);
            }
        },
        error : function () {
            alert("请求失败");
        }
    });
}

/**
 * 以下是加载我的订单页面数据函数
 */

function loadMyOrder() {
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/order/myOrderList",
        dataType : "json",
        success : function (result) {
            if (result.code == 0) {
                initOrderPage(result);
            } else {
                alert(result.message);
            }
        },
        error : function () {
            alert("获取订单失败");
        }
    });
}

function initOrderPage(result) {
    var buyOrderHTML = "";
    var saleOrderHTML = "";
    buyOrderList = result.data.buyOrderList;
    saleOrderList = result.data.saleOrderList;
    if (buyOrderList != null) {
        for (var i = 0; i < buyOrderList.length; i++) {
            var itemPrice = buyOrderList[i].prodQuantity * buyOrderList[i].prodPrice;
            buyOrderHTML += "<tr><td>" + buyOrderList[i].orderDo.orderNumber + "</td>" + "<td>" + buyOrderList[i].prodName + "</td>"
                + "<td>" + buyOrderList[i].saleUserName + "</td>" + "<td>" + buyOrderList[i].prodPrice + "</td>"
                + "<td>" + buyOrderList[i].prodQuantity + "</td>" + "<td>" + itemPrice + "</td>"
            if (buyOrderList[i].saleWayCode == "BIDD" || buyOrderList[i].saleWayCode == "BARG") {
                buyOrderHTML += "<td>" + buyOrderList[i].saleWayName + "&nbsp;<button id='check_record_" + buyOrderList[i].orderDo.productId + "' onclick='checkBuyPriceRecord("+ buyOrderList[i].orderDo.productId + ")'>查看记录</button></td></tr>"
            } else {
                buyOrderHTML += "<td>" + buyOrderList[i].saleWayName + "</td></tr>";
            }
        }
    }
    if (saleOrderList != null) {
        for (var i = 0; i < saleOrderList.length; i++) {
            var itemPrice = saleOrderList[i].prodQuantity * saleOrderList[i].prodPrice;
            saleOrderHTML += "<tr><td>" + saleOrderList[i].orderDo.orderNumber + "</td>" + "<td>" + saleOrderList[i].prodName + "</td>"
                + "<td>" + saleOrderList[i].buyUserName + "</td>" + "<td>" + saleOrderList[i].prodPrice + "</td>"
                + "<td>" + saleOrderList[i].prodQuantity + "</td>" + "<td>" + itemPrice + "</td>";
            if (saleOrderList[i].saleWayCode == "BIDD" || saleOrderList[i].saleWayCode == "BARG") {
                saleOrderHTML += "<td>" + saleOrderList[i].saleWayName + "&nbsp;<button id='check_record_" + saleOrderList[i].orderDo.productId + "' onclick='checkSalePriceRecord("+ saleOrderList[i].orderDo.productId + ")'>查看记录</button></td></tr>"
            } else {
                saleOrderHTML += "<td>" + saleOrderList[i].saleWayName + "</td></tr>";
            }
        }

    }
    document.getElementById("buy_order_list").innerHTML = buyOrderHTML;
    document.getElementById("sale_order_list").innerHTML = saleOrderHTML;
}

/**
 * 购买记录的竞价/议价记录，只包含自己的记录
 * @param prodId
 */
function checkBuyPriceRecord(prodId) {
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/order/searchBuyPriceRecord",
        dataType : "json",
        data : {
            productId : prodId
        },
        success : function (result) {
            if (result.code == 0) {
                document.getElementById("record_name").innerText = result.data.saleWayName + "记录";
                initPriceRecord(result.data.list, "BUY");
            } else {
                alert(result.message);
            }
        },
        error : function () {
            alert("获取订单列表失败");
        }
    });
    $("#myModalLabel").text("记录");
    $('#myModal').modal();
}

/**
 * 出售记录的竞价/议价记录，包含该物品的所有记录
 * @param prodId
 */
function checkSalePriceRecord(prodId) {
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/order/searchSalePriceRecord",
        dataType : "json",
        data : {
            productId : prodId
        },
        success : function (result) {
            if (result.code == 0) {
                document.getElementById("order_page_price_record_name").innerText = result.data.saleWayName + "记录";
                initPriceRecord(result.data.list, "SALE");
            } else {
                alert(result.message);
            }
        },
        error : function () {
            alert("获取记录失败");
        }
    });
    $("#myModalLabel").text("记录");
    $('#myModal').modal();
}

/**
 * 数据渲染到竞价/议价记录弹框中
 * @param data
 * @param sale
 */
function initPriceRecord(data, sale) {
    if (sale == "BUY") {
        document.getElementById("order_page_price_record_head").innerHTML = "<tr><th width='30%' style='text-align: center;'>序号</th>" +
            "<th width='30%' style='text-align: center;'>价格</th><th width='40%' style='text-align: center;'>出价时间</th></tr>"
        var recordListHTML = "";
        for (var i = 0; i < data.length; i++) {
            recordListHTML += "<tr><td>" + data[i].recordId + "</td><td>" + data[i].price + "</td><td>" + data[i].time + "</td></tr>"
        }
        document.getElementById("order_page_price_record_body").innerHTML = recordListHTML;
    }

    if (sale == "SALE") {
        document.getElementById("order_page_price_record_head").innerHTML = "<tr><th width='20%' style='text-align: center;'>序号</th>" +
            "<th width='20%' style='text-align: center;'>价格</th><th width='20%' style='text-align: center;'>出价人</th><th width='40%' style='text-align: center;'>出价时间</th></tr>"
        var recordListHTML = "";
        for (var i = 0; i < data.length; i++) {
            recordListHTML += "<tr><td>" + data[i].recordId + "</td><td>" + data[i].price + "</td><td>" + data[i].username + "</td><td>" + data[i].time + "</td></tr>"
        }
        document.getElementById("order_page_price_record_body").innerHTML = recordListHTML;
    }
}

/**
 * 以下是加载我的物品页面数据的方法
 */

function loadMyProducts() {
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/search/searchMyProduct",
        dataType : "json",
        success : function (result) {
            if (result.code == 0) {
                initMyProdsPage(result);
            } else {
                alert(result.message);
            }
        },
        error : function () {
            alert("获取物品列表失败");
        }
    });
}

function initMyProdsPage(result) {
    var myProdsHTML = "";
    myProdsList = result.data.list;
    if (myProdsList != null) {
        for (var i = 0; i < myProdsList.length; i++) {
            myProdsHTML += "<tr><td>" + myProdsList[i].productDo.productNumber + "</td>" + "<td>" + myProdsList[i].productDo.name + "</td>"
                + "<td>" + myProdsList[i].productDo.price + "</td>" + "<td>" + myProdsList[i].productDo.quantity + "</td>"
                + "<td>" + myProdsList[i].productDo.depreciationRate + "</td>";
            if (myProdsList[i].productDo.saleWayCode == "BIDD" || myProdsList[i].productDo.saleWayCode == "BARG") {
                myProdsHTML += "<td>" + myProdsList[i].saleWayName + "&nbsp;<button onclick=checkProdPagePriceRecord('"+ myProdsList[i].productDo.productNumber + "'," + myProdsList[i].productDo.isSelling + "," + myProdsList[i].productDo.productId + "," + myProdsList[i].productDo.isSold +")>查看记录</button></td>"

            } else {
                myProdsHTML += "<td>" + myProdsList[i].saleWayName + "</td>";
            }
            myProdsHTML += "<td>" + myProdsList[i].sellStatus + "</td>";
            if (myProdsList[i].productDo.isSelling == "1" && myProdsList[i].productDo.isSold == "0") {
                myProdsHTML += "<td><button onclick='prodTakeDown(" + myProdsList[i].productDo.productId + ")'>下架</button></td></tr>";
            } else if (myProdsList[i].productDo.isSelling == "0" && myProdsList[i].productDo.isSold == "0") {
                myProdsHTML += "<td><button onclick='prodTakeUp("+ myProdsList[i].productDo.productId + ")'>上架</button></td></tr>";
            } else {
                myProdsHTML += "<td></td></tr>";
            }
        }
    }
    $("#my_products").html(myProdsHTML);
}

function checkProdPagePriceRecord(productNumber, isSelling, prodId, isSold) {
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/order/searchSalePriceRecord",
        dataType : "json",
        data : {
            productId : prodId
        },
        success : function (result) {
            if (result.code == 0) {
                document.getElementById("price_page_price_record_name").innerText = result.data.saleWayName + "记录";
                initProdPagePriceRecord(result.data, productNumber, isSelling, isSold);
            } else {
                alert(result.message);
            }
        },
        error : function () {
            alert("获取记录失败");
        }
    });
    $("#myModalLabel").text("记录");
    $('#myModal').modal();
}

function initProdPagePriceRecord(data, productNumber, isSelling, isSold) {
    if (data.saleWayName == "竞价") {
        document.getElementById("prod_page_price_record_head").innerHTML = "<tr><th width='20%' style='text-align: center;'>序号</th>" +
            "<th width='20%' style='text-align: center;'>价格</th><th width='20%' style='text-align: center;'>出价人</th><th width='40%' style='text-align: center;'>出价时间</th></tr>";
        var recordListHTML = "";
        for (var i = 0; i < data.list.length; i++) {
            recordListHTML += "<tr><td>" + data.list[i].recordId + "</td><td>" + data.list[i].price + "</td><td>" + data.list[i].username + "</td><td>" + data.list[i].time + "</td></tr>"
        }
        document.getElementById("prod_page_price_record_body").innerHTML = recordListHTML;
    }
    if (data.saleWayName == "议价") {
        if (isSelling == "1" && isSold == "0") {
            document.getElementById("prod_page_price_record_head").innerHTML = "<tr><th width='15%' style='text-align: center;'>序号</th>" +
                "<th width='15%' style='text-align: center;'>价格</th><th width='15%' style='text-align: center;'>出价人</th><th width='40%' style='text-align: center;'>出价时间</th><th width='15%' style='text-align: center;'>交易</th></tr>";
        } else {
            document.getElementById("prod_page_price_record_head").innerHTML = "<tr><th width='15%' style='text-align: center;'>序号</th>" +
                "<th width='15%' style='text-align: center;'>价格</th><th width='15%' style='text-align: center;'>出价人</th><th width='40%' style='text-align: center;'>出价时间</th></tr>";
        }

        var recordListHTML = "";
        for (var i = 0; i < data.list.length; i++) {
            recordListHTML += "<tr><td>" + data.list[i].recordId + "</td><td>" + data.list[i].price + "</td><td>" + data.list[i].username + "</td><td>" + data.list[i].time + "</td>"
            if (isSelling == "1" && isSold == "0") {
                recordListHTML += "<td><button onclick=generateBARGOrder('"+ productNumber + "','" + data.list[i].username + "'," + data.list[i].price + ")>成交</button></td></tr>"
            } else {
                recordListHTML += "</tr>";
            }
        }
        document.getElementById("prod_page_price_record_body").innerHTML = recordListHTML;
    }
}

/**
 * 物品上架
 * @param productId
 */
function prodTakeUp(productId) {
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/search/takeUpOrDownProd",
        dataType : "json",
        data : {
            productId : productId,
            isSelling : "1"
        },
        success : function (result) {
            if (result.code == 106) {
                alert(result.message);
                window.location.reload();
            } else {
                alert(result.message);
            }
        },
        error : function () {
            alert("请求失败");
        }
    });
}

/**
 * 物品下架
 * @param productId
 */
function prodTakeDown(productId, saleWayCode) {
    var is_takeDown = confirm("若是议价物品下架，则会删除所有议价记录，是否下架？");
    if (!is_takeDown) {
        return;
    }
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/search/takeUpOrDownProd",
        dataType : "json",
        data : {
            productId : productId,
            isSelling : "0"
        },
        success : function (result) {
            if (result.code == 107) {
                alert(result.message);
                window.location.reload();
            } else {
                alert(result.message);
            }
        },
        error : function () {
            alert("请求失败");
        }
    });
}

function generateBARGOrder(productNumber, username, price) {
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/order/generateOrder",
        dataType : "json",
        data : {
            productNumber : productNumber,
            username : username,
            price : price
        },
        success : function (result) {
            if (result.code == 105) {
                alert(result.message);
                window.location.reload();
            } else {
                alert(result.message);
            }
        },
        error : function () {
            alert("请求失败");
        }
    });
}

function removeOrderPagePriceRecordHTML() {
    $("#order_page_price_record_head").html("");
    $("#order_page_price_record_body").html("");
}

function removeProdPagePriceRecordHTML() {
    $("#prod_page_price_record_head").html("");
    $("#prod_page_price_record_body").html("");
}
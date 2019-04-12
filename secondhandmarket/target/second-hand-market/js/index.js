function loadIndexData() {
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/index/search",
        async : true,
        dataType : 'json',
        success: function(result) {
            if (result.code == 0) {
                var productList = result.data.productList;
                var demandInfoList = result.data.demandInfoList;
                if (productList != null) {
                    var productListString = "";
                    for (var i = 0; i < productList.length && i < 7; i++) {
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
                    document.getElementById("product_list").innerHTML = productListString;
                }
                if (demandInfoList != null) {
                    var demandInfoString = "";
                    for (var i = 0; i < demandInfoList.length && i < 10; i++) {
                        demandInfoString += "<td style='text-align: center'>"+ demandInfoList[i].demandInfoNumber +"</td>" +
                            "<td style='text-align: center'>" + demandInfoList[i].name + "</td>" +
                            "<td style='text-align: center'>" + demandInfoList[i].depreciationRate + "</td>" +
                            "<td style='text-align: center'>" + demandInfoList[i].quantity + "</td>" +
                            "<td style='text-align: center'>" + demandInfoList[i].price + "</td>"
                    }
                    document.getElementById("requirementList").innerHTML = demandInfoString;
                }

            } else {
                alert(result.message);
            }
        },
        error: function () {
            alert("请求失败");
        }
    });
}



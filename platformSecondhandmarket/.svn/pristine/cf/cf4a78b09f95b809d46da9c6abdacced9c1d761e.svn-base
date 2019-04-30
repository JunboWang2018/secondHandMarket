function loadIndexData(typeCode) {
    $.ajax({
        type : "get",
        url : "/secondhandmarket/data/index/search",
        async : true,
        dataType : 'json',
        data : {
            typeCode : typeCode
        },
        success: function(result) {
            if (result.code == 0) {
                var productListString = "";
                var demandInfoString = "";
                var indexProdList = new Array();
                var indexDemdInfoList = new Array();
                var productList = result.data.productList;
                var demandInfoList = result.data.demandInfoList;
                //取前7个商品，前15个求购信息
                for (var i = 0; i < productList.length && i < 7; i++) {
                    indexProdList[i] = productList[i];
                }
                for (var i = 0; i < demandInfoList.length && i < 15; i++) {
                    indexDemdInfoList[i] = demandInfoList[i];
                }
                productListString = initProdHTML(indexProdList);
                demandInfoString = initDemandInfoHTML(indexDemdInfoList);
                document.getElementById("product_list").innerHTML = productListString;
                document.getElementById("requirementList").innerHTML = demandInfoString;
            } else {
                alert(result.message);
            }
            if (typeCode == null || typeCode == "") {
                $("#INDEX").addClass('active');
            } else {
                document.getElementById(typeCode).className = 'active';
            }
        },
        error: function () {
            alert("请求失败");
        }
    });
}



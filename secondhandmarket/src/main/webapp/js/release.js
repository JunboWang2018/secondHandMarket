$(document).ready(function(){
    $("#release_product").click(function(){
        var name = $("#product_name").val();
        var typeCode = $("#product_type").val();
        var imageFile = $("#product_image")[0].files[0];
        var depreciationRate = $("#product_depreciation_rate").val();
        var quantity = $("#product_quantity").val();
        var price = $("#product_price").val();
        var saleWayCode = $("#product_sale_way").val();
        var timeLimit = $("#time_limit").val();
        var addPriceLimit = $("#add_price_limit").val();

        var isPass = validateArgument(name, typeCode, imageFile, depreciationRate, quantity, price, saleWayCode, timeLimit, addPriceLimit);
        if (!isPass) {
            return
        }
        var formData = new FormData();
        formData.append("name", $("#product_name").val());
        formData.append("typeCode", $("#product_type").val());
        formData.append("imageFile", $("#product_image")[0].files[0]);
        formData.append("description", $("#prodcut_desc").val());
        formData.append("depreciationRate", $("#product_depreciation_rate").val());
        formData.append("quantity", $("#product_quantity").val());
        formData.append("price", $("#product_price").val());
        formData.append("saleWayCode", $("#product_sale_way").val());
        formData.append("timeLimit", $("#time_limit").val());
        formData.append("addPriceLimit", $("#add_price_limit").val());
        $.ajax({
            type : "post",
            url : "/secondhandmarket/data/release/product",
            catch: false,
            processData: false,
            contentType: false,
            dataType: "json",
            data : formData,
            success: function(data) {
                if (data.code == 104) {
                    alert(data.message);
                    window.location.href = getRootPath() + "/";
                } else {
                    alert("发布失败");
                }
            },
            error: function () {
                alert("请求失败");
            }
        });
    });

    function validateArgument(name, typeCode, imageFile, depreciationRate, quantity, price, saleWayCode, timeLimit, addPriceLimit) {
        if (name == null || name == "") {
            alert("请输入物品名称");
            return false;
        }
        if (typeCode == null || typeCode == "") {
            alert("请选择物品类型");
            return false;
        }
        if (imageFile == null || imageFile == "") {
            alert("请上传物品图片");
            return false;
        }
        if (depreciationRate == null || depreciationRate == "") {
            alert("请输入折旧率");
            return false;
        }
        if (quantity == null || quantity == "") {
            alert("请输入物品数量");
            return false;
        }
        if (price == null || price == "") {
            alert("请输入单价");
            return false;
        }
        if (saleWayCode == null || saleWayCode == "") {
            alert("请选择出售方式");
            return false;
        } else if (saleWayCode == "BIDD") {
            if (timeLimit == null || timeLimit == "") {
                alert("请输入竞价期限");
                return false;
            }
            if (addPriceLimit == null || addPriceLimit == "") {
                alert("请输入最低加价金额");
                return false;
            }
        }

    }

    $("#release_requirement").click(function() {
        var name = $("#requirement_name").val();
        var typeCode = $("#requirement_type").val();
        var depreciationRate = $("#requirement_depreciation_rate").val();
        var quantity = $("#requirement_quantity").val();
        var price = $("#requirement_price").val();

        var isPass = validateRequirementArgu(name, typeCode, depreciationRate, quantity, price);
        if (!isPass) {
            return;
        }

        var formData = new FormData();
        formData.append("name", $("#requirement_name").val());
        formData.append("typeCode", $("#requirement_type").val());
        formData.append("depreciationRate", $("#requirement_depreciation_rate").val());
        formData.append("quantity", $("#requirement_quantity").val());
        formData.append("price", $("#requirement_price").val());
        formData.append("other", $("#requirement_other").val());
        $.ajax({
            url : "/secondhandmarket/data/release/demandInfo",
            data : formData,
            catch: false,
            processData: false,
            contentType: false,
            type : "POST",
            dataType : "json",
            success : function(data) {
                if (data.code == 104) {
                    alert(data.message);
                    window.location.href = getRootPath() + "/";
                } else {
                    alert("发布失败");
                }
            },
            error : function() {
                alert("请求失败");
            }
        });
    });
});

function validateRequirementArgu(name, typeCode, depreciationRate, quantity, price) {
    if (name == null || name == "") {
        alert("请输入求购物品名称");
        return false;
    }
    if (typeCode == null || typeCode == "") {
        alert("请选择求购物品类型");
        return false;
    }
    if (depreciationRate == null || depreciationRate == "") {
        alert("请输入求购物品折旧率要求");
        return false;
    }
    if (quantity == null || quantity == "") {
        alert("请输入求购物品数量要求  ");
        return false;
    }
    if (price == null || price == "") {
        alert("请输入求购物品价格要求");
        return false;
    }
}

//竞价期限
function timeLimitDisplay(timeLimit) {
    if($("#product_sale_way").val() == "BIDD") {
        document.getElementById('div_time_limit').style.display = "block";
    } else {
        document.getElementById('div_time_limit').style.display = "none";
    }

}

//图片预览
function previewImage(inputObject, divPreviewId){
    var reader = new FileReader();
    reader.readAsDataURL(inputObject.files[0]);
    reader.onload = function() {
        document.getElementById('image').src = reader.result;
    }
}
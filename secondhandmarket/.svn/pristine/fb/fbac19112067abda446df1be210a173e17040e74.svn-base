$(document).ready(function(){
    $("#release_product").click(function(){
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

    $("#release_requirement").click(function() {
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
$(document).ready(function () {
    $("#register").click(function(){
        $.ajax({
            type : "get",
            url : "/secondhandmarket/data/user/register",
            async : true,
            dataType : 'json',
            data : {
                userName : $("#username").val(),
                password : $("#password").val(),
                tel : $("#tel").val()
            },
            success: function(data) {
                if (data.code == 103) {
                    alert(data.message);
                    window.location.href = getRootPath() + "/";
                } else {
                    alert(data.message);
                }
            },
            error: function () {
                alert("请求失败");
            }
        });
    });
});
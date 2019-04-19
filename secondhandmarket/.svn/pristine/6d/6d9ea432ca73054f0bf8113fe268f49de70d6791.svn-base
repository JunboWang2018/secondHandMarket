$(document).ready(function(){
    $("#login").click(function() {
        var username = $("#username").val();
        var password = $("#password").val();
        if (username == null || username == "") {
            alert("请输入用户名")
            return;
        }
        $.ajax({
            type : "get",
            url : "/secondhandmarket/data/user/login",
            async : true,
            dataType : 'json',
            data : {
                userName : username,
                password : password
            },
            success: function(data) {
                if (data.code == 102) {
                    alert(data.message);
                    window.sessionStorage.setItem("is_login", "true");
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
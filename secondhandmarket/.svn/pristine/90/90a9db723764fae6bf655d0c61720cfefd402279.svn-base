$(document).ready(function () {
    $("#register").click(function(){
        $.ajax({
            type : "post",
            url : "register",
            async : true,
            dataType : 'json',
            data : {
                username : $("#username").val(),
                password : $("#password").val()
            },
            success: function(data) {
                if (data.code == 1) {
                    alert(data.message);

                } else if (data.code == 0) {
                    alert(data.message);
                } else {
                    alert("注册失败");
                }
            },
            error: function (data) {
                alert("请求失败");
            }
        });
    });
});
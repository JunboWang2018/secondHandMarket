$(document).ready(function(){
    $("#login").click(function() {
        $.ajax({
            type : "post",
            url : "login",
            async : true,
            dataType : 'json',
            data : {
                username:$("#username").val(),
                password: $("#password").val()
            },
            success: function(data) {
                if (data.code == 1) {
                    alert(data.message);
                    jumpToIndex();
                } else if (data.code == 0) {
                    alert(data.message);
                } else {
                    alert("登陆失败");
                }
            },
            error: function (data) {
                alert("请求失败");
            }
        });
    });
});
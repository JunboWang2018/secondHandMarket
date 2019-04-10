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

function jumpToIndex() {
    $.ajax({
        type : "post",
        url : "index",
        async : true
    });
}


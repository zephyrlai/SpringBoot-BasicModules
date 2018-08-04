//layui模块的定义
layui.define(['jquery'],function(exports){
    var sysFunction = {
        tabFunc : function (element,funcName) {
                var $ = layui.jquery;
                layer.msg(funcName);
                console.log(funcName);
                var switchFlag = false;
                $("#tab-title li").each(function () {
                    $("this").remove();
                    var tabName = $(this).attr("lay-id");
                    if(tabName != undefined){
                        if(tabName == funcName){
                            switchFlag = true;
                            element.tabChange('nav-filter', $(this).attr("lay-id"));
                        }
                    }
                })
                if(!switchFlag){
                    element.tabAdd('nav-filter', {
                        title: funcName
                        ,content: '<h1>'+funcName+'</h1>' //支持传入html
                        ,id: funcName
                    });
                    element.tabChange('nav-filter', funcName);
                }
        }
    }

    exports('sysFunction', sysFunction);
});

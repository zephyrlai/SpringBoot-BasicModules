//layui模块的定义
layui.define(['jquery'],function(exports){
    var sysFunction = {
        tabFunc : function (element,funcName,tabContent) {
                var $ = layui.jquery;
                // layer.msg
                console.log(funcName);
                var switchFlag = false;
                $("#tab-title li").each(function () {
                    // $("this").remove();
                    var tabName = $(this).attr("lay-id");
                    if(tabName != undefined){
                        if(tabName == funcName){
                            switchFlag = true;
                            element.tabChange('nav-filter', $(this).attr("lay-id"));
                        }
                    }
                })
                if(!switchFlag){
                    var content = $.ajax({url:tabContent,async:false}).responseText;
                    element.tabAdd('nav-filter', {
                        title: funcName
                        ,content: content //支持传入html
                        ,id: funcName
                    });
                    element.tabChange('nav-filter', funcName);
                }
        },

        // 获取后端controller接口返回的html文件的代码，通常用法：$("xxx").append(getHtmlCode("/xxx/xxxx"));
        getHtmlCode : function (url) {
            var $ = layui.jquery;
            return $.ajax({url:url,async:false}).responseText;
        }
    }

    exports('sysFunction', sysFunction);
});

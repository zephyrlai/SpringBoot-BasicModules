layui.config({
    base: '/layui/my/modules/' //存放拓展模块的根目录
}).extend({ //设定模块别名
    sysFunction: 'functions' //如果 tabTab.js 是在根目录，也可以不用设定别名
});
//JavaScript代码区域
layui.use(['element','jquery','layer','sysFunction'], function(){
    var element = layui.element,
        $ =layui.jquery,
        sysFunction = layui.sysFunction;

    /*页面初始化时执行的操作*/
    //动态计算tab栏的宽度
    $("#tab-title").css("width",(parseInt($("#tab-title").css("width"))-230)+"px");
    //动态计算tab内容页的位置
    $("#tab-content").css("top",parseInt($("#tab-title").css("height")+parseInt($(".layui-header").css("height")))-10+"px");


    /*点击左侧导航栏，右侧tab页新增或者切换的操作*/
    $(".opt-newTab").click(function(){
        if($(this).attr('url') == undefined)
            layer.msg($(this).text()+"仍在开发中")
        else
        sysFunction.tabFunc(element,$(this).text(),$(this).attr('url'));
    });
});

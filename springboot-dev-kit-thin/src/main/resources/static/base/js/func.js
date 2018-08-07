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
    $(".opt-newTab").click(function(){
        sysFunction.tabFunc(element,$(this).text(),'/student/toInfo');
    });
});

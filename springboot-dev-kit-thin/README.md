## 基本功能
#### 技术选型
1. 核心：SpringBoot
1. DAO：Mybatis、Mybatis-Plus、Spring-Jpa，三者任选其一
1. Entity与DAO代码的自动生成：基于MyBatis-generator改造
1. 鉴权：基于切面，也提供基于拦截器的方式与基于Apache Shiro的方式，三种方式任选其一；
1. 定时任务：Spring Schedule(Quartz)
1. 模板引擎：Thymeleaf
1. 日志：默认Logback，同时提供基于Log4J的日志处理，两种方式任选其一
1. 参数校验：Hibernate Validation或者
1. Api说明：Swagger2
1. 缓存：考虑基于注解维护，默认Redis，同时提供基于Ehcache的缓存处理方式，两种方式任选其一
1. 图表：Echart
1. 富文本编辑器：ckEditor
#### 功能列表
1. dao层采用Mybatis、Mybatis-Plus、Spring-Jpa，三者任选其一
1. 前端页面（标签页）代码块的自动生成（分页表格 + 增删改查按钮）
1. 基于数据库的可维护菜单以及按钮
1. 基于切面的鉴权（登录、退出、未登录自动跳转登录页等），

> 技术选型与功能参考  
    [layuiAdmin](http://www.layui.com/admin/pro/)  
    [jeesite4](https://gitee.com/thinkgem/jeesite4)  
    [zheng](https://gitee.com/shuzheng/zheng)
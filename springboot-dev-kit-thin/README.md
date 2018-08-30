## 基本功能
### 技术选型
1. 核心：SpringBoot
1. DAO：Mybatis、Mybatis-Plus、Spring-Jpa，三者任选其一
1. Entity与DAO代码的自动生成：基于MyBatis-generator改造
1. 鉴权：基于切面，也提供基于拦截器的方式与基于Apache Shiro的方式，三种方式任选其一；
1. 定时任务：Spring Schedule(Quartz)
1. 模板引擎：Thymeleaf
1. 日志：默认Logback，同时提供基于Log4J的日志处理，两种方式任选其一
1. 参数校验：Hibernate Validation或者
1. Api说明：Swagger2（或单独部署RAP）
1. 缓存：考虑基于注解维护，默认Redis，同时提供基于Ehcache的缓存处理方式，两种方式任选其一
1. 图表：Echart
1. 富文本编辑器：ckEditor
### 功能列表
1. dao层采用Mybatis、Mybatis-Plus、Spring-Jpa，三者任选其一
1. 前端页面（标签页）代码块的自动生成（分页表格 + 增删改查按钮）
1. 后端dao、entity层的代码生成
1. 基于数据库的可维护菜单以及按钮
1. 基于切面的鉴权（登录、退出、未登录自动跳转登录页等）
1. 组织机构
1. 角色用户
1. 菜单及按钮授权
1. 数据权限
1. 系统参数
1. 内容管理
1. 工作流

### 菜单层级
学生管理
    |-信息管理
    |-奖惩管理
教师管理
档案管理
系统管理
开发工具
    |-前端组件
    |-后端代码生成
    |-后端日志查询


### 代码生成需求记录
#### 1.菜单层级：  
* 代码生成管理：  
    * 库表配置  
    * 代码生成
#### 2.库表配置：
1. 数据源选择：默认使用第一数据源，在多数据源场景下体现优势  
1. 库表选择：选择需要生成前端代码、后端代码的表  
1. 库表配置：针对选择的库表配置每个字段的基本数据（名称、数据类型、表单类型等）
    1. 库表配置的表头  

    SQL字段 | SQL注释 | SQL类型 | Java类型 | Java属性名 | 主键 | 必填 | select | insert | update | 表格显示 | 查询匹配方式 | 表单类型 | 字典类型 | 排序
    :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---:
    id | 编号 | int | Integer | id | √ | √ | √ | --- | --- | --- | "=" | "隐藏域" | --- | 10 
    name | 姓名 | varchar(50) | String | name | --- | --- | √ | √ | √ | √ | "like" | "单行文本框" | --- | 20
    del_flag | 删除标记 | char(1) | String | delFlag | --- | √ | √ | √ | √ | --- | "=" | "单选框" | --- | 30
    --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | ---


### 项目衍生：
由于当前项目中用到了一些独立的技术&框架，于是衍生出了如下的独立演示模块
1. java-reflection
1. springboot-pagehelper
1. springboot-freemarker
1. springboot-jpa

> 技术选型与功能参考  
    [layuiAdmin](http://www.layui.com/admin/pro/)  
    [jeesite4](https://gitee.com/thinkgem/jeesite4)  
    [zheng](https://gitee.com/shuzheng/zheng)
## Freemarker与SpringBoot集成
### 一、Freemarker概述
1. FreeMarker是一个用Java语言编写的模板引擎，它基于模板来生成文本输出。FreeMarker与Web容器无关，即在Web运行时，它并不知道Servlet或HTTP。它不仅可以用作表现层的实现技术，而且还可以用于生成XML，JSP或Java 等。  
1. freemarker的功能：
    1. 根据模板问题动态渲染html文件（动态塞入后端提供的数据）
    1. 根据模板生成各种格式的文件（生成实体文件）

### 二、使用Freemarker动态渲染html文件
1. 搭建演示环境  
    1. 新建springboot项目，添加pom依赖（web + thymeleaf + freemarker）
        pom.xml
        ``` xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-freemarker</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        ```
    1. 配置文件   
        application.propertes:
        ``` propertes
        # THYMELEAF (ThymeleafAutoConfiguration)
        spring.thymeleaf.cache=false
        spring.thymeleaf.enabled=true
        spring.thymeleaf.encoding=UTF-8
        spring.thymeleaf.prefix=classpath:/templates/
        spring.thymeleaf.suffix=.html
        spring.thymeleaf.content-type=text/html
        spring.thymeleaf.mode=LEGACYHTML5
        spring.thymeleaf.check-template-location=true

        ##freemarker
        spring.freemarker.cache=false
        spring.freemarker.charset=UTF-8
        spring.freemarker.check-template-location=true
        spring.freemarker.content-type=text/html
        spring.freemarker.enabled=true
        spring.freemarker.suffix=.ftl
        spring.freemarker.template-loader-path=classpath:/templates/freemarker
        ```
    1. 模板文件demo.ftl
        ``` html
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Title</title>
        </head>
        <body>
            Hello World! --Name:${name}
        </body>
        </html>
        ```
1. 使用Freemarker动态渲染演示  
    主要有如下几种类型的使用：String、Object、Map、List（包括取下标）、时间格式化、null判断；   
    1. **String类型**   
        Java代码：
        ``` java
        @RequestMapping("string/{name}")
        public String demo(@PathVariable String name, Model model){
            model.addAttribute("name",name);
            return "freemarker/demo";
        }
        ```  
        效果图： ![String类型](https://github.com/ZephyrLai/SpringBoot-BasicModules/raw/master/springboot-freemarker/src/main/resources/static/pic/fm-string.png)  
    1. **对象类型**  
        Java代码：  
        新增Person类：  
        ``` java 
        public class Person {
            private Integer id;
            private String name;
        }
        ```
        FreemarkerController.java
        ``` java
        @RequestMapping("obj")
        public String fmObj( Model model){
            model.addAttribute("person",new Person(1,"tony"));
            return "freemarker/demo";
        }
        ```
        改造模板文件demo.ftl：
        ``` html
        <body>
            <#--Hello World! --Name:${name}-->
            Hello World! --Name:${person.name}
        </body>
        ```
         效果图：![对象类型](https://github.com/ZephyrLai/SpringBoot-BasicModules/raw/master/springboot-freemarker/src/main/resources/static/pic/fm-obj.png)  
    1. **List类型**  
        Java代码：
        ``` java
        @RequestMapping("list")
        public String fmList( Model model){
            List<Person> personList = new ArrayList<>();
            for (int i = 0; i < 10; ) {
                personList.add(new Person(i+10,"张三"+ ++i));
            }
            model.addAttribute("personList",personList);
            return "freemarker/demo";
        }
        ``` 
        改造模板文件demo.ftl：
        ``` html
        <body>
            <#--Hello World! --Name:${name}-->
            <#--Hello World! --Name:${person.name}-->
            <#list personList as person >
                <h2>索引：${person_index}, 编号：${person.id}, 姓名：${person.name},Hello World!</h2>
            </#list>
        </body>
        ```
        效果图：  ![List类型](https://github.com/ZephyrLai/SpringBoot-BasicModules/raw/master/springboot-freemarker/src/main/resources/static/pic/fm-list.png)  
    1. **Map类型**：  
        Java代码：  
        ``` java
        @RequestMapping("map")
        public String fmMap( Model model){
            Map<String,Person> personMap = new HashMap<>();
            for (int i = 0; i < 10; ) {
                personMap.put("key"+i,new Person(i+10,"张三"+ ++i));
            }
            model.addAttribute("personMap",personMap);
            return "freemarker/demo";
        }
        ```
        改造模板文件：
        ``` html
        <body>
            <#--Hello World! --Name:${name}-->
            <#--Hello World! --Name:${person.name}-->
            <#--<#list personList as person >
                <h2>索引：${person_index}, 编号：${person.id}, 姓名：${person.name},Hello World!</h2>
            </#list>-->
            <#list personMap?keys as key >
                <h2>编号：${personMap[key].id}, 姓名：：${personMap[key].name},Hello World!</h2>
            </#list>
        </body>
        ```
        效果图：![Map类型](https://github.com/ZephyrLai/SpringBoot-BasicModules/raw/master/springboot-freemarker/src/main/resources/static/pic/fm-map.png)  
    1. **时间格式**：  
        Java代码：  
        ``` java
        @RequestMapping("date")
        public String fmDate( Model model){
            model.addAttribute("date",new Date());
            return "freemarker/demo";
        }
        ```
        改造模板文件：
        ``` html
        <h1>日期：${date?date}</h1>
        <h1>时间：${date?time}</h1>
        <h1>日期+时间：${date?datetime}</h1>
        <h1>自定义时间格式：${date?string("yyyy-MM/dd HH:mm:ss")}</h1>
        ```
        效果图：  ![Date类型](https://github.com/ZephyrLai/SpringBoot-BasicModules/raw/master/springboot-freemarker/src/main/resources/static/pic/fm-date.png)  
    1. **null判断**  
        Java代码：
        ``` java
        @RequestMapping("null")
        public String fmNull( Model model){
            model.addAttribute("notNullKey","haha");
            model.addAttribute("nullKey",null);
            return "freemarker/demo";
        }
        ```
        改造模板文件：
        ``` html
        <h1>非null：${notNullKey}</h1>
        <h1>null：${nullKey!}(相当于${nullKey!""})</h1>
        <h1>wasd：${wasd!"abcdefg"}</h1>
        ```
        效果图：  ![Null类型](https://github.com/ZephyrLai/SpringBoot-BasicModules/raw/master/springboot-freemarker/src/main/resources/static/pic/fm-null.png)  

### 三、使用Freemarker生成实体文件
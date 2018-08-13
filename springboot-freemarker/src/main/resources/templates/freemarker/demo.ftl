<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <#--Hello World! --Name:${name}-->
    <#--Hello World! --Name:${person.name}-->
    <#--<#list personList as person >
        <h2>索引：${person_index}, 编号：${person.id}, 姓名：${person.name},Hello World!</h2>
    </#list>-->
    <#--<#list personMap?keys as key >
        <h2>编号：${personMap[key].id}, 姓名：：${personMap[key].name},Hello World!</h2>
    </#list>-->
    <#--<h1>日期：${date?date}</h1>
    <h1>时间：${date?time}</h1>
    <h1>日期+时间：${date?datetime}</h1>
    <h1>自定义时间格式：${date?string("yyyy-MM/dd HH:mm:ss")}</h1>-->
    <h1>非null：${notNullKey}</h1>
    <h1>null：${nullKey!}(相当于${nullKey!""})</h1>
    <h1>wasd：${wasd!"abcdefg"}</h1>
</body>
</html>
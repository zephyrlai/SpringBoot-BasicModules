## XML与Java实体之间的映射
### 一、概述
1. 手段：
    1. XStream、Jaxb是java中用于对象xml序列化/反序列化 的经典开源项目
1. 功能：
    1. 读取存放在Xml文件中的数据，并根据指定的class，匹配为对应的对象
    1. 根据代码，生成对应的xml文件

### 二、基于Jaxb的实现
1. 常用注解：
    __@XmlRootElement__：用于在Java类中指定xml文件的根节点
    __@XmlElementWrapper__：与@XmlElement结合使用，用于声明当前结点的父节点
    __@XmlElement__：xml的结点（Java类中的属性）
    __@XmlJavaTypeAdapter__：用于指定自定义的格式转换器（例如：时间转换器等）
    __@XmlType__:生成xml文件时使用，用于指定xml文件中结点（属性）的顺序（详见Book.java）
    __@XmlAccessorType__：指定访问类型（field、method）

MapAdpter：自定义Map转换器
DateAdpter：时间格式自定义转换器

### 三、基于XStream的实现-todo


参考：
> https://www.cnblogs.com/520playboy/p/5785873.html
> https://www.cnblogs.com/yjmyzz/p/xstream-jaxb-format-date-and-number.html
> Jeesite源码

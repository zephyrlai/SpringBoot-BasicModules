## XML与Java实体之间的映射

### 功能概述
1. 读取存放在Xml文件中的数据，并根据指定的class，匹配为对应的对象
1. 根据代码，生成对应的xml文件

常用注解：
@XmlRootElement：用于在Java类中指定xml文件的根节点
@XmlElementWrapper：与@XmlElement结合使用，用于声明当前结点的父节点
@XmlElement：xml的结点（Java类中的属性）
@XmlJavaTypeAdapter：用于指定自定义的格式转换器（例如：时间转换器等）
@XmlType:生成xml文件时使用，用于指定xml文件中结点（属性）的顺序（详见Book.java）
@XmlAccessorType：指定访问类型（field、method）


MapAdpter：格式自定义转换器


参考：
> https://www.cnblogs.com/520playboy/p/5785873.html
> Jeesite源码

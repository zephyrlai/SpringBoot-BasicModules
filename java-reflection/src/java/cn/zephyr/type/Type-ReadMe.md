## 一、概述
1. Java的Type类型可以总结为5大类型
    1. 原始类型(Class)
    1. 参数化类型(ParameterizedType):就是包含泛型的对象；例如：List<T>、Map<K,V>等带有参数化的对象;
    1. 类型变量(TypeVariable)：泛型中的变量；例如：T、K、V等变量，可以表示任何类
    1. 数组类型(GenericArrayType):泛型的数组类型，用来描述ParameterizedType、TypeVariable类型的数组；即List<T>[] 、T[]等；
    1. 基本类型(Class)：基本数据类型（int、float、double等）

## 二、代码演示
1. Type的5大类型分析
```java
import cn.zephyr.entity.User;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * @Title: SpringBoot-BasicModules
 * @Package: cn.zephyr
 * @Description: Java反射中Type的使用
 * @author: Lai
 * @date 2018/8/6 9:56
 */
public class TypeReflection<T,K> {

    //包装类
    private Double d;
    //自建对象
    private User user;
    //泛型数组
    private T[] tList ;
    //泛型对象
    private T t;
    //泛型Map、泛型List
    private Map<T,K> dataMap;
    private List<T> dataList;
    //基本数据类型
    private int num = 0 ;

    public static void main(String[] args)  {
        try {
            Field d = TypeReflection.class.getDeclaredField("d");
            System.err.println("包装类的Type类型："+d.getGenericType().getClass().getName());
            Field user = TypeReflection.class.getDeclaredField("user");
            System.err.println("自建对象的Type类型："+user.getGenericType().getClass().getName());
            Field tList = TypeReflection.class.getDeclaredField("tList");
            System.err.println("泛型数组的Type类型："+tList.getGenericType().getClass().getName());
            Field t = TypeReflection.class.getDeclaredField("t");
            System.err.println("泛型对象的Type类型："+t.getGenericType().getClass().getName());
            Field dataMap = TypeReflection.class.getDeclaredField("dataMap");
            System.err.println("泛型Map对应的Type类型："+dataMap.getGenericType().getClass().getName());
            Field dataList = TypeReflection.class.getDeclaredField("dataList");
            System.err.println("泛型List对应的Type类型："+dataList.getGenericType().getClass().getName());
            Field num = TypeReflection.class.getDeclaredField("num");
            System.err.println("基本数据类型的Type类型："+num.getGenericType().getClass().getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```




> 参考链接
    https://www.jianshu.com/p/7649f86614d3
    https://www.jianshu.com/p/e8eeff12c306

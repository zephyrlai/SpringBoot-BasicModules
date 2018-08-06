## 一、概述
1. Java的Type类型可以总结为5大类型
    1. 原始类型(Class)：当我们没有声明泛型的时候，我们普通的对象就是一个Class类型，是Type中的一种;
    1. 参数化类型(ParameterizedType):就是包含泛型的对象；例如：List<T>、Map<K,V>等带有参数化的对象;
    1. 类型变量(TypeVariable)：泛型中的变量；例如：T、K、V等变量，可以表示任何类;
    1. 数组类型(GenericArrayType):泛型的数组类型，用来描述ParameterizedType、TypeVariable类型的数组；即List<T>[] 、T[]等;

## 二、代码演示
1. Type的5大类型验证  
    通过class.getDeclaredField("fieldName")拿到Field对象，再通过field.getGenericType().getClass().getName()拿到parameterizedType的具体类型名称
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
                parameterizedTypeAnalize();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
        *
        * @throws NoSuchFieldException
        */
        private static void parameterizedTypeAnalize() throws NoSuchFieldException{
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
        }
    }
    ```
    执行结果：
    ``` txt
    包装类的Type类型：java.lang.Class
    自建对象的Type类型：java.lang.Class
    泛型数组的Type类型：sun.reflect.generics.reflectiveObjects.GenericArrayTypeImpl
    泛型对象的Type类型：sun.reflect.generics.reflectiveObjects.TypeVariableImpl
    泛型Map对应的Type类型：sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
    泛型List对应的Type类型：sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
    基本数据类型的Type类型：java.lang.Class
    ```
1. ParameterizedType  
    包含三个方法
    1. getActualTypeArguments：获取泛型对应的实际的类
    1. getRawType：获取声明泛型的类或者接口，也就是泛型中<>前面的那个值
    1. getOwnerType：针对内部类对象，用于获取内部类对象的外部类  
    
    ``` java
    //改造User类
    public class User {
        private Long id;
        private String name;
        private Integer age;
        // 新增内部类
        public class Account<T>{
            private T account;
        }
    }
    ```
    ``` java
    // 新增三个属性
    private Map<String,Integer> actualTypeMap01 ;
    private Map<List<Double>,Integer> actualTypeMap02 ;
    private User.Account<String> account;
    //实例方法
    public static void parameterizedTypeAnalize() throws NoSuchFieldException{
        Type actualTypeMap01 = TypeReflection.class.getDeclaredField("actualTypeMap01").getGenericType();
        Type actualTypeMap02 = TypeReflection.class.getDeclaredField("actualTypeMap02").getGenericType();
        Type actualTypeMap03 = TypeReflection.class.getDeclaredField("account").getGenericType();

        ParameterizedType parameterizedType01 = (ParameterizedType) actualTypeMap01;
        Type[] types01 = parameterizedType01.getActualTypeArguments();
        ParameterizedType parameterizedType02 = (ParameterizedType) actualTypeMap02;
        Type[] types02 = parameterizedType02.getActualTypeArguments();
        ParameterizedType parameterizedType03= (ParameterizedType) actualTypeMap03;
        Type[] types03 = parameterizedType03.getActualTypeArguments();
        System.err.println("----");
        System.err.println(Arrays.asList(types01));
        System.err.println(Arrays.asList(types02));
        System.err.println(Arrays.asList(types03));
        System.err.println("----");
        System.err.println(parameterizedType01.getRawType());
        System.err.println(parameterizedType02.getRawType());
        System.err.println(parameterizedType03.getRawType());
        System.err.println("----");
        System.err.println(parameterizedType01.getOwnerType());
        System.err.println(parameterizedType02.getOwnerType());
        System.err.println(parameterizedType03.getOwnerType());
    }
    ```  
    执行结果：
    ``` txt
    ----
    [class java.lang.String, class java.lang.Integer]
    [java.util.List<java.lang.Double>, class java.lang.Integer]
    [class java.lang.String]
    ----
    interface java.util.Map
    interface java.util.Map
    class cn.zephyr.entity.User$Account
    ----
    null
    null
    class cn.zephyr.entity.User
    ```
1. GenericArrayType
    针对泛型的数组类型（不是集合），这个类仅有1个方法：getGenericComponentType，用于返回泛型数组中元素的Type类型，即List<String>[] 中的 List<String>（ParameterizedTypeImpl）、T[] 中的T（TypeVariableImpl）；
    ``` java
    // 新增属性
    private T[] tList ;
    private List<T>[] dataListArray;
    // 实例方法
    public static void genericArrayTypeAnalize() throws NoSuchFieldException {
        Type tList = TypeReflection.class.getDeclaredField("tList").getGenericType();
        Type dataList = TypeReflection.class.getDeclaredField("dataListArray").getGenericType();

        GenericArrayType genericArrayType01 = (GenericArrayType) tList;
        Type genericComponentType11 = genericArrayType01.getGenericComponentType();

        GenericArrayType genericArrayType02 = (GenericArrayType) dataList;
        Type genericComponentType22 = genericArrayType02.getGenericComponentType();

        System.err.println(genericComponentType11);
        System.err.println(genericComponentType22);
    }
    ```  
    执行结果：
    ``` txt
    T
    java.util.List<T>
    ```
1. TypeVariable  
    泛型的类型变量，还可以对类型变量加上extend限定，这样会有类型变量对应的上限；  
    包含三个方法：
    1. getBounds：获取泛型的extend上限（例如：Integer）
    1. getGenericDeclaration：获取声明该类型变量的类（例如：TypeReflection）
    1. getName：获取泛型的名称（例如：T）
    ``` java
    // 实例方法
    public static void typeVariableAnalyze() throws NoSuchFieldException {
        TypeVariable t = (TypeVariable)TypeReflection.class.getDeclaredField("t").getGenericType();
        System.err.println(Arrays.asList(t.getBounds()));
        System.err.println(t.getGenericDeclaration());
        System.err.println(t.getName());
    }
    ```  
    执行结果：
    ```
    [class java.lang.Integer]
    class cn.zephyr.type.TypeReflection
    T
    ```
1. 关于GenericDeclaration  
    它是声明类型变量的所有实体的公共接口；也就是说该接口定义了哪些地方可以定义类型变量（泛型）；
    从类图上可以看出并不包含Field类，这是因为我们在Field中并没有声明泛型，而是在使用泛型。  
    ![GenericDeclaration类图](https://github.com/ZephyrLai/SpringBoot-BasicModules/raw/master/java-reflection/src/resources/pic/type/GenericDeclaration.png)
    ``` java
    // class:声明泛型
    class GenericDemo<O>{
        // field:使用泛型
        private O o;
        
        // method:声明泛型
        private <P> P  getN(){
            return (P)o;
        }
        
        // constructor:声明泛型
        public <Q> GenericDemo(Q q){
            this.o =(O)q;
        }
    }
    ```


> 参考链接  
    https://www.jianshu.com/p/7649f86614d3  
    https://www.jianshu.com/p/e8eeff12c306

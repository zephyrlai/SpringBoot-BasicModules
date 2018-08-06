package cn.zephyr.type;

import cn.zephyr.entity.User;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Title: SpringBoot-BasicModules
 * @Package: cn.zephyr
 * @Description: Java反射中Type的使用
 * @author: Lai
 * @date 2018/8/6 9:56
 */
public class TypeReflection<T extends Integer,K> {

    //包装类
    private Double d;
    //自建对象
    private User user;
    private User<T> tUser;
    //泛型数组
    private T[] tList ;
    private List<T>[] dataListArray;
    //泛型对象
    private T t;
    //泛型Map、泛型List
    private Map<T,K> dataMap;
    private List<T> dataList;
    //基本数据类型
    private int num = 0 ;

    private Map<String,Integer> actualTypeMap01 ;
    private Map<List<Double>,Integer> actualTypeMap02 ;
    private User<String>.Account<String> account;

    public static void main(String[] args)  {
        try {
//            typeAnalize();
//            parameterizedTypeAnalize();
//            genericArrayTypeAnalize();
            typeVariableAnalyze();
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
    private static void typeAnalize() throws NoSuchFieldException{
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

    public static void typeVariableAnalyze() throws NoSuchFieldException {
        TypeVariable t = (TypeVariable)TypeReflection.class.getDeclaredField("t").getGenericType();
        System.err.println(Arrays.asList(t.getBounds()));
        System.err.println(t.getGenericDeclaration());
        System.err.println(t.getName());
    }

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

}

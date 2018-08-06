package cn.zephyr.entity;

/**
 * @Title: SpringBoot-BasicModules
 * @Package: cn.zephyr.entity
 * @Description:
 * @author: Lai
 * @date 2018/8/6 10:40
 */
public class User<T> {
    private Long id;
    private String name;
    private Integer age;
    private T t;

    public class Account<K>{
        private K account;
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public T getT() {
        return t;
    }

    public User<T> setT(T t) {
        this.t = t;
        return this;
    }
}

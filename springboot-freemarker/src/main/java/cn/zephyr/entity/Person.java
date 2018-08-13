package cn.zephyr.entity;

/**
 * @Title: SpringBoot-BasicModules
 * @Package: cn.zephyr.entity
 * @Description:
 * @author: Lai
 * @date 2018/8/13 13:51
 */
public class Person {
    private Integer id;
    private String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Person setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }
}

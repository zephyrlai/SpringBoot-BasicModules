package cn.zephyr.entity;



/**
 * @Title: SpringBoot-BasicModules
 * @Package: cn.zephyr.module.entity
 * @Description:
 * @author: Lai
 * @date 2018/8/6 18:49
 */
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String grade;
    private String clazz;

    public Integer getId() {
        return id;
    }

    public Student setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Student setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Student setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getGrade() {
        return grade;
    }

    public Student setGrade(String grade) {
        this.grade = grade;
        return this;
    }

    public String getClazz() {
        return clazz;
    }

    public Student setClazz(String clazz) {
        this.clazz = clazz;
        return this;
    }
}

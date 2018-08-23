package cn.zephyr.entity;

import cn.zephyr.adapter.DateAdapter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement
@XmlType(propOrder={"id","name","age","enterDate"})
public class Student {
    private Long id;
    private String name;
    private int age;
    private Date enterDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getEnterDate() {
        return enterDate;
    }

    public Student setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
        return this;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", enterDate=" + enterDate +
                '}';
    }

    public Student(Long id, String name, int age, Date enterDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.enterDate = enterDate;
    }
}

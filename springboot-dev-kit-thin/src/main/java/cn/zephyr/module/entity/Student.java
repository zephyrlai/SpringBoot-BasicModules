package cn.zephyr.module.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Title: SpringBoot-BasicModules
 * @Package: cn.zephyr.module.entity
 * @Description:
 * @author: Lai
 * @date 2018/8/6 18:49
 */
@Data
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String grade;
    private String clazz;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}

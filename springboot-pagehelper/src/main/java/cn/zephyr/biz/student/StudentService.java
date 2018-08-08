package cn.zephyr.biz.student;


import cn.zephyr.entity.Student;
import cn.zephyr.framework.Page;

import java.util.List;

/**
 * @Title: SpringBoot-BasicModules
 * @Package: cn.zephyr.module.biz
 * @Description:
 * @author: Lai
 * @date 2018/8/6 18:54
 */
public interface StudentService {

    Student getById(Integer id);

    List<Student> getList4Page(Student student,Page page);
}

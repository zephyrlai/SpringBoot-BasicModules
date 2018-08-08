package cn.zephyr.controller;


import cn.zephyr.biz.student.StudentService;
import cn.zephyr.entity.Student;
import cn.zephyr.framework.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Title: SpringBoot-BasicModules
 * @Package: cn.zephyr.module.controller
 * @Description:
 * @author: Lai
 * @date 2018/8/6 18:53
 */
@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("getById")
    public Student getById(Integer id){
        return studentService.getById(id);
    }

    @RequestMapping("getList4Page")
    public List<Student> getList4Page(Student student, Page page){
        return studentService.getList4Page(student,page);
    }
}

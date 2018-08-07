package cn.zephyr.module.controller;

import cn.zephyr.common.result.PageResultBean;
import cn.zephyr.framework.dao.Page;
import cn.zephyr.module.biz.student.StudentService;
import cn.zephyr.module.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public PageResultBean<Student> getList4Page(Student student,Page page){
        return studentService.getList4Page(student,page);
    }
}

package cn.zephyr.module.biz.student;

import cn.zephyr.common.result.PageResultBean;
import cn.zephyr.framework.dao.Page;
import cn.zephyr.module.entity.Student;

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

    PageResultBean<Student> getList4Page(Student student, Page page);
}

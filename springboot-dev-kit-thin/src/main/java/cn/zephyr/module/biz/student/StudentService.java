package cn.zephyr.module.biz.student;

import cn.zephyr.module.entity.Student;

/**
 * @Title: SpringBoot-BasicModules
 * @Package: cn.zephyr.module.biz
 * @Description:
 * @author: Lai
 * @date 2018/8/6 18:54
 */
public interface StudentService {
    Student getById(Integer id);
}

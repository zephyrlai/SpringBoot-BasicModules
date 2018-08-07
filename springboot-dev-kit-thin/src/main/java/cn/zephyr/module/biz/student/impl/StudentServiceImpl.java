package cn.zephyr.module.biz.student.impl;

import cn.zephyr.framework.dao.BaseService;
import cn.zephyr.module.biz.student.StudentService;
import cn.zephyr.module.entity.Student;
import org.springframework.stereotype.Service;

/**
 * @Title: SpringBoot-BasicModules
 * @Package: cn.zephyr.module.biz.impl
 * @Description:
 * @author: Lai
 * @date 2018/8/6 18:55
 */
@Service
public class StudentServiceImpl extends BaseService<Student,Integer> implements StudentService {
    @Override
    public Student getById(Integer id) {
        return this.dao.executeSelectOneMethod(id,"selectByPrimaryKey",Student.class);
    }
}

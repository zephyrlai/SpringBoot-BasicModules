package cn.zephyr.biz.student.impl;


import cn.zephyr.biz.student.StudentService;
import cn.zephyr.entity.Student;
import cn.zephyr.framework.BaseService;
import cn.zephyr.framework.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.*;

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

    @Override
    public List<Student> getList4Page(Student student, Page page) {
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<Student> queryList = dao.executeListMethod(student, "queryList",Student.class);
        PageInfo<Student> appsPageInfo = new PageInfo<>(queryList);
        System.err.println(appsPageInfo.getTotal());
        return queryList;
    }


}

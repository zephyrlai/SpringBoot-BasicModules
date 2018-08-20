package cn.zephyr.module.service.impl;

import cn.zephyr.module.entity.Employee;
import cn.zephyr.module.service.EmployeeService;
import cn.zephyr.sys.BaseService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends BaseService<Employee,Integer> implements EmployeeService {
    @Override
    public Employee getById(Integer id) {
        return dao.executeSelectOneMethod(id, "selectByPrimaryKey", Employee.class);
    }
}

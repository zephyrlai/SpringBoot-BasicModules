package cn.zephyr.module.controller;

import cn.zephyr.module.entity.Employee;
import cn.zephyr.module.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/getById")
    public Employee getById(Integer id){
        return employeeService.getById(id);
    }
}

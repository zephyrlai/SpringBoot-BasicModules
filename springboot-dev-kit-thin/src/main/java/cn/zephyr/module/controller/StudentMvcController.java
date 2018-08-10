package cn.zephyr.module.controller;

import cn.zephyr.common.result.PageResultBean;
import cn.zephyr.common.result.ResultBean;
import cn.zephyr.module.biz.student.StudentService;
import cn.zephyr.module.entity.Student;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @Title: SpringBoot-BasicModules
 * @Package: cn.zephyr.module.controller
 * @Description:
 * @author: Lai
 * @date 2018/8/7 16:17
 */
@Controller
@RequestMapping("student")
public class StudentMvcController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/toInfo",method = RequestMethod.GET)
    public ModelAndView toInfo(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stuInfoList.html");
        return modelAndView;
    }

    @RequestMapping(value = "/toAdd",method = RequestMethod.GET)
    public ModelAndView toAdd(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stuInfoMod");
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public ResultBean<Boolean> add(Student student){
        student.setCreateTime(new Date());
        student.setUpdateTime(student.getCreateTime());
        return studentService.insert(student);
    }
}

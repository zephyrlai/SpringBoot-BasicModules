package cn.zephyr.module.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
}

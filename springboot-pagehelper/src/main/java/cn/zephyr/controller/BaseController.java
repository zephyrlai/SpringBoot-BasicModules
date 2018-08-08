package cn.zephyr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Title: SpringBoot-BasicModules
 * @Package: cn.zephyr.module.controller
 * @Description:
 * @author: Lai
 * @date 2018/8/3 11:40
 */
@Controller
public class BaseController {

    @RequestMapping("/")
    public ModelAndView index(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }
}

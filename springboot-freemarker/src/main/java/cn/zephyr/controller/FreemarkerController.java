package cn.zephyr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: SpringBoot-BasicModules
 * @Package: cn.zephyr.controller
 * @Description:
 * @author: Lai
 * @date 2018/8/13 11:11
 */
@Controller
@RequestMapping("fm")
public class FreemarkerController {

    /**
     * 跳转到index（基本映射测试）
     * @return
     */
    @RequestMapping("")
    public String index(){
        return "index";
    }

    /**
     * freemarker动态渲染(String)
     * @param name
     * @param model
     * @return
     */
    @RequestMapping("string/{name}")
    public String demo(@PathVariable String name, Model model){
        model.addAttribute("name",name);
        return "freemarker/demo";
    }

    public Boolean genFile(){
        return false;
    }
}

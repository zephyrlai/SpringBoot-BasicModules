package cn.zephyr.controller;

import cn.zephyr.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

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
    public String fmString(@PathVariable String name, Model model){
        model.addAttribute("name",name);
        return "freemarker/demo";
    }

    @RequestMapping("obj")
    public String fmObj( Model model){
        model.addAttribute("person",new Person(1,"tony"));
        return "freemarker/demo";
    }

    @RequestMapping("list")
    public String fmList( Model model){
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; ) {
            personList.add(new Person(i+10,"张三"+ ++i));
        }
        model.addAttribute("personList",personList);
        return "freemarker/demo";
    }

    @RequestMapping("map")
    public String fmMap( Model model){
        Map<String,Person> personMap = new HashMap<>();
        for (int i = 0; i < 10; ) {
            personMap.put("key"+i,new Person(i+10,"张三"+ ++i));
        }
        model.addAttribute("personMap",personMap);
        return "freemarker/demo";
    }

    @RequestMapping("date")
    public String fmDate( Model model){
        model.addAttribute("date",new Date());
        return "freemarker/demo";
    }

    @RequestMapping("null")
    public String fmNull( Model model){
        model.addAttribute("notNullKey","haha");
        model.addAttribute("nullKey",null);
        return "freemarker/demo";
    }

    public Boolean genFile(){
        return false;
    }
}

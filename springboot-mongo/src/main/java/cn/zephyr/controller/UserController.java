package cn.zephyr.controller;

import cn.zephyr.dao.UserRepository;
import cn.zephyr.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("queryList")
    public List<User> queryList(){
        return userRepository.findAll();
    }

    @RequestMapping("insertBatch")
    public String insertBatch(){
        userRepository.save(new User(1L, "zhangsan", 30));
        userRepository.save(new User(2L, "lisi", 40));
        userRepository.save(new User(3L, "wangwu", 50));
        return "操作成功";
    }
}

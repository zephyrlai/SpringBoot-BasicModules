package cn.zephyr.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: DemoController
 * @Author: laizonghao
 * @Description:
 * @Date: 2019/11/5 15:17
 */
@RestController
@RequestMapping("/")
public class DemoController {
    @Autowired
    private MyProvider provider;

    @RequestMapping("send")
    public String sendMsg(String msg){
        provider.send(msg);
        return "succ";
    }
}

package cn.zephyr.redis.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: laizonghao
 * @Description:
 * @Date: 2019-07-10 11:08
 */
@RestController
@RequestMapping("redismq")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @RequestMapping("topic01/{msg}")
    public String send01Message(@PathVariable("msg") String msg) {
        return publisherService.send01Message(msg);
    }
    @RequestMapping("topic02/{msg}")
    public String send02Message(@PathVariable("msg") String msg) {
        return publisherService.send02Message(msg);
    }
}
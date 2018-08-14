package cn.zephyr.helloservice.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: eureka-server
 * @Package: cn.zephyr.helloservice.controller
 * @Description:
 * @author: Lai
 * @date 2018/5/17 22:07
 */
@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/hello")
    public String index(){
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        logger.info("/hello,host:+"+instance.getHost()+",service_id:"+instance.getServiceId());
        return "Hello World!";
    }
}

package cn.zephyr.controller;

import cn.zephyr.enenty.DemoEntity;
import cn.zephyr.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: DemoController
 * @Author: laizonghao
 * @Description:
 * @Date: 2019/11/10 16:45
 */
@RestController
@Slf4j
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("demo")
    public String comboOperation(){
        log.info("=== 客户端执行新增操作：id=1,name=张三 ===");
        demoService.insert(1,"张三");
        log.info("=== 客户端执行新增操作：id=2,name=李四 ===");
        demoService.insert(2,"李四");
        log.info("=== 客户端执行查询操作：id=1 ===");
        DemoEntity demoEntity = demoService.selectByPrimaryKey(1);
        log.info("=== 查询结果：{}===",demoEntity);
        log.info("=== 客户端再次执行查询操作：id=1 ===");
        demoEntity = demoService.selectByPrimaryKey(1);
        log.info("=== 查询结果：{}===",demoEntity);
        log.info("=== 客户端再次执行删除操作：id=1 ===");
        demoService.deleteByPrimaryKey(1);
        log.info("=== 客户端再次执行查询操作：id=1 ===");
        demoEntity = demoService.selectByPrimaryKey(1);
        log.info("=== 查询结果：{}===",demoEntity);
        return "succ";
    }
}

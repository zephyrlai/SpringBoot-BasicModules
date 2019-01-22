package cn.zephyr.controller;

import cn.zephyr.entity.FincAdvanceMng;
import cn.zephyr.service.FincAdvanceMngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: zephyrLai
 * @Date: 2019/1/22 20:21
 * @Description:
 */
@RestController
public class FincAdvanceMngController {

    @Autowired
    private FincAdvanceMngService fincAdvanceMngService;

    @RequestMapping("queryList")
    public List<FincAdvanceMng> queryList(){
        return fincAdvanceMngService.queryList(new FincAdvanceMng());
    }
}

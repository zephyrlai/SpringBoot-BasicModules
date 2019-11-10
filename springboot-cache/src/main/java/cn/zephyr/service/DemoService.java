package cn.zephyr.service;

import cn.zephyr.enenty.DemoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName: DemoService
 * @Author: laizonghao
 * @Description:
 * @Date: 2019/11/10 16:45
 */
@Service
@Slf4j
public class DemoService {

    private Map<Integer, DemoEntity> mockDB=new HashMap<>();

    /**
     * 模拟单条查询
     * @return
     */
    @Cacheable(value="myCache1",key = "'demo_entity_'+#id")
    public DemoEntity selectByPrimaryKey(Integer id){
        log.info("进入{}类,执行{}方法","DemoService","selectByPrimaryKey");
        produceMockData();
        DemoEntity demoEntity = mockDB.get(id);
        return demoEntity;
    }

    /**
     * 模拟单条新增
     * @param ele
     * @return
     */
    @CachePut(value="myCache1",key = "'demo_entity_'+#id")
    public DemoEntity insert(Integer id,String ele){
        log.info("进入{}类,执行{}方法","DemoService","insert");
        produceMockData();
        DemoEntity demoEntity = new DemoEntity(id, ele);
        mockDB.put(id,demoEntity);
        return demoEntity;
    }

    /**
     * 模拟单条删除
     * @param id
     * @return
     */
    @CacheEvict(value="myCache1",key = "'demo_entity_'+#id")
    public String deleteByPrimaryKey(Integer id){
        log.info("进入{}类,执行{}方法","DemoService","deleteByPrimaryKey");
        produceMockData();
        mockDB.remove(id);
        return "succ";

    }

    /**
     * 模拟数据库查询
     * @return
     */
    private void produceMockData(){
        log.info("进行mock sql操作");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package cn.zephyr.service.impl;

import cn.zephyr.entity.FincAdvanceMng;
import cn.zephyr.mapper.FincAdvanceMngDao;
import cn.zephyr.service.FincAdvanceMngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: zephyrLai
 * @Date: 2019/1/22 20:23
 * @Description:
 */
@Service
public class FincAdvanceMngServiceImpl implements FincAdvanceMngService {

    @Autowired
    private FincAdvanceMngDao fincAdvanceMngDao;

    /**
     * 列表查询
     * @param fincAdvanceMng
     * @return
     */
    @Override
    public List<FincAdvanceMng> queryList(FincAdvanceMng fincAdvanceMng) {
        return fincAdvanceMngDao.queryList();
    }
}

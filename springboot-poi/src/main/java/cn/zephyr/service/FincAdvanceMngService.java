package cn.zephyr.service;

import cn.zephyr.entity.FincAdvanceMng;

import java.util.List;

/**
 * @Auther: zephyrLai
 * @Date: 2019/1/22 20:22
 * @Description:
 */
public interface FincAdvanceMngService {

    /**
     * 列表查询
     * @param fincAdvanceMng
     * @return
     */
    List<FincAdvanceMng> queryList(FincAdvanceMng fincAdvanceMng);

}

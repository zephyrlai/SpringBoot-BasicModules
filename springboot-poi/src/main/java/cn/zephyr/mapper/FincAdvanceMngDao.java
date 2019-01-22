package cn.zephyr.mapper;

import cn.zephyr.entity.FincAdvanceMng;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: zephyrLai
 * @Date: 2019/1/22 20:20
 * @Description:
 */
@Mapper
@Component
public interface FincAdvanceMngDao {
    // 列表查询
    List<FincAdvanceMng> queryList();
}

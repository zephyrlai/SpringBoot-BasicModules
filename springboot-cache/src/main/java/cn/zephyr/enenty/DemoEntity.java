package cn.zephyr.enenty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: DemoEntity
 * @Author: laizonghao
 * @Description:
 * @Date: 2019/11/10 17:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoEntity {
    private Integer id;
    private String name;
}

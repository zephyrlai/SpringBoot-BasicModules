package cn.zephyr.excelUtils;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Auther: zephyrLai
 * @Date: 2019/1/24 09:57
 * @Description: 导入导出时用于自动映射的注解，属性值是默认值-1，属性值小于0时不解析
 */
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Excel {
    // 导入用，导入时相对的列号
    int importIndex() default -1;

    // 导出用，导出时相对的列号
    int exportIndex() default -1;
}

package cn.zephyr.excelUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: zephyrLai
 * @Date: 2019/1/29 14:42
 * @Description:
 */
@AllArgsConstructor
public enum FieldTypeEnum {

    DEFAULT("默认","DEFAULT"),
    OBJ("对象","OBJ"),
    LIST("列表","LIST")


    ;
    private @Getter @Setter String desc;
    private @Getter @Setter String code;
}

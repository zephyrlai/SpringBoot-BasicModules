package cn.zephyr.entity;

import cn.zephyr.excelUtils.Excel;
import cn.zephyr.excelUtils.FieldTypeEnum;
import lombok.Data;

/**
 * @Auther: zephyrLai
 * @Date: 2019/1/29 13:57
 * @Description:
 */
@Data
public class StudentInfo {
    @Excel(columnNum = "0-0", rowNum = "1-4")
    private String id;
    @Excel(columnNum = "1-1", rowNum = "", fieldType = FieldTypeEnum.OBJ)
    private BasicInfo basicInfo;
}

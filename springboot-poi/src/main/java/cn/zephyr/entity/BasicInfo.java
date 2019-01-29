package cn.zephyr.entity;

import cn.zephyr.excelUtils.Excel;
import lombok.Data;

/**
 * @Auther: zephyrLai
 * @Date: 2019/1/29 13:57
 * @Description: 学生基本信息
 */
@Data
public class BasicInfo {
    @Excel(columnNum = "1-1",rowNum = "1-1")
    private String name;    // 姓名
    @Excel(columnNum = "1-1",rowNum = "2-2")
    private String gender;  // 性别
    @Excel(columnNum = "1-1",rowNum = "3-3")
    private String hometown;    // 生源地
    @Excel(columnNum = "1-1",rowNum = "4-4")
    private Integer age;    // 年龄
}

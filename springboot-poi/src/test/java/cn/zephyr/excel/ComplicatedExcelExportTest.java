package cn.zephyr.excel;

import cn.zephyr.PoiApplication;
import cn.zephyr.entity.BasicInfo;
import cn.zephyr.entity.FincAdvanceMng;
import cn.zephyr.entity.StudentInfo;
import cn.zephyr.excelUtils.ExcelExportAnalyse;
import cn.zephyr.service.FincAdvanceMngService;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zephyrLai
 * @Date: 2019/1/28 10:49
 * @Description:
 */
@Rollback(false)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PoiApplication.class)
@WebAppConfiguration
public class ComplicatedExcelExportTest {
    private static final String EXCEL_EXPORT_TEMPLATE = "excelTemplates/advanceMng.xlsx";
    @Autowired
    private FincAdvanceMngService fincAdvanceMngService;

    @Test
    public void ExcelExportBasicTest() throws Exception {
        StudentInfo studentInfo1 = new StudentInfo();
        StudentInfo studentInfo2 = new StudentInfo();
        StudentInfo studentInfo3 = new StudentInfo();
        BasicInfo basicInfo = new BasicInfo();
        basicInfo.setAge(21);
        basicInfo.setGender("F");
        basicInfo.setHometown("浙江");
        basicInfo.setName("张三");
        studentInfo1.setId("123");
        studentInfo1.setBasicInfo(basicInfo);
        studentInfo2.setId("456");
        studentInfo2.setBasicInfo(basicInfo);
        studentInfo3.setId("789");
        studentInfo3.setBasicInfo(basicInfo);
        List<StudentInfo> stuList = new ArrayList<>();
        stuList.add(studentInfo1);
        stuList.add(studentInfo2);
        stuList.add(studentInfo3);
        Resource resource = new ClassPathResource(EXCEL_EXPORT_TEMPLATE);   // 定位导出模板
        File file = ExcelExportAnalyse.generateComplicatedExportExcel(StudentInfo.class, stuList, 0, 1, resource.getInputStream());
        FileUtils.copyFile(file,new File("D://1111111.xlsx"));
    }
}

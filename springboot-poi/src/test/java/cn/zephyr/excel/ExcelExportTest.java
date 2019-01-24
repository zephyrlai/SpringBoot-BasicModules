package cn.zephyr.excel;

import cn.zephyr.PoiApplication;
import cn.zephyr.entity.FincAdvanceMng;
import cn.zephyr.excelUtils.ExcelExportAnalyse;
import cn.zephyr.service.FincAdvanceMngService;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.util.List;

/**
 * @Auther: zephyrLai
 * @Date: 2019/1/24 10:49
 * @Description:
 */
@Rollback(false)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PoiApplication.class)
@WebAppConfiguration
public class ExcelExportTest {
    private static final String EXCEL_EXPORT_TEMPLATE = "excelTemplates/advanceMng.xlsx";
    @Autowired
    private FincAdvanceMngService fincAdvanceMngService;

    @Test
    public void ExcelExportBasicTest() throws Exception {
        List<FincAdvanceMng> queryList = fincAdvanceMngService.queryList(new FincAdvanceMng()); // 生成数据集
        Resource resource = new ClassPathResource(EXCEL_EXPORT_TEMPLATE);   // 定位导出模板
        File file = ExcelExportAnalyse.generateExportExcel(FincAdvanceMng.class, queryList, 0, resource.getInputStream());
        FileUtils.copyFile(file,new File("D://122.xlsx")); // 随便写到本地来看看内容
    }
}

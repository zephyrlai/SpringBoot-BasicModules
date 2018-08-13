package cn.zephyr.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: SpringBoot-BasicModules
 * @Package: cn.zephyr.controller
 * @Description:
 * @author: Lai
 * @date 2018/8/13 15:09
 */
@RestController
@RequestMapping("fm")
public class FreemarkerGenController {
    @Autowired
    private Configuration configuration;

    @Value("${freemarker.module.name}")
    private String projectName;

    @RequestMapping("gen")
    public Boolean genFile(){
        String fileName="genFile01.html" ;
        String packageName="/src/main/resources/templates/";
        try {
            // 1、从spring注入FreeMarker的Configuration对象中获得Template对象。
            Template template = configuration.getTemplate("gen.ftl");
            // 2、创建数据集
            Map dataModel = new HashMap<>();
            dataModel.put("name", "haha");
            // 3、创建输出文件的Writer对象。
            Writer out = new FileWriter(new File(fixFilePath(packageName)+fileName));
            // 4、调用模板对象的process方法，生成文件。
            template.process(dataModel, out);
            // 5、关闭流。
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private String fixFilePath(String packageName) {
        if(StringUtils.isEmpty(projectName))
            projectName = "";
        else
            projectName = "/"+projectName;
        return System.getProperty("user.dir")+projectName+packageName;
    }
}

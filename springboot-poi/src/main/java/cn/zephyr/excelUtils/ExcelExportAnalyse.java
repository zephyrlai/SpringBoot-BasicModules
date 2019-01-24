package cn.zephyr.excelUtils;

import cn.zephyr.utils.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther: zephyrLai
 * @Date: 2019/1/24 10:02
 * @Description: Excel导出解析工具类
 * 应用场景：
 * 1. 基本的单行导出：一条数据就是一行，此时只在导出类的属性上使用@Excel注解即可
 * 2. 合并单元格的导出：导出的Bean中有List属性，List数据显示在同一列，其余数据合并单元格
 * 3. 完全自定义：各种横着、竖着的单元格合并，需要手动指定每个数据所占的单元格大小
 */
public class ExcelExportAnalyse {
    private Integer startRow;
//    private Map<Integer, AnalyseData> cellMap;
//    private Map<Integer,String> excelDataMap ;
//    private DecimalFormat df = new DecimalFormat("#.####");
//    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    public static <T> File generateExportExcel(Class<?> clazz, List<T> dataList, Integer sheetNum, InputStream inputStream) throws Exception {
        Workbook wb = new XSSFWorkbook(inputStream);    // 获取导出模板工作簿
        Sheet sheet = wb.getSheetAt(sheetNum);          // 获取导出数据即将写入的sheet页
        File resultFile ;
        Map<Integer, AnalyseData> analyseDataMap = antiAnalysis(clazz);
        List<Map<Integer, Object>> analyseData = antiAnalysisData(analyseDataMap, dataList);
        // 如果解析出了有效数据，则写入Excel文件
        if(!CollectionUtils.isEmpty(analyseData)){
            for (int i = 0; i < analyseData.size(); i++) {
                Row row = sheet.createRow(1+i);
                Map<Integer, Object> map = analyseData.get(i);
                for (Map.Entry<Integer, Object> entry : map.entrySet()) {
//                    System.err.println(entry.getValue().getClass().getName());
                    if(entry.getValue() == null ){
                        continue;
                    }
                    else if(entry.getValue().getClass().getName().contains("Integer")){
                        row.createCell(entry.getKey()).setCellValue(String.valueOf(entry.getValue()));
                    }
                    else if(entry.getValue().getClass().getName().contains("Date")){
                        row.createCell(entry.getKey()).setCellValue(DateUtil.dateFormatTime((Date)entry.getValue(),DateUtil.DateMode_12));
                    }else if(entry.getValue().getClass().getName().contains("BigDecimal")){
                        row.createCell(entry.getKey()).setCellValue((entry.getValue()).toString());
                    }else{
                        row.createCell(entry.getKey()).setCellValue((String)entry.getValue());
                    }
                }
            }
        }
        // 默认写入创建临时文件，方法结束自动删除
        resultFile = File.createTempFile(UUID.randomUUID().toString().replace("-", ""), ".xlsx");
        OutputStream out = new FileOutputStream(resultFile);
        wb.write(out);
        return resultFile;
    }

    /**
     * 解析类
     * @Excel clazz
     * @return
     * @throws Exception
     */
    private static Map<Integer, AnalyseData> antiAnalysis(Class<?> clazz) throws Exception{
        Field[] fields = clazz.getDeclaredFields();
        String fieldName;
        String getMethod;
        Method method;
        Class<?> returnType ;
        // key-index(excel的列编号),value-method(属性对应的getter方法)
        Map<Integer, AnalyseData> singleLineDataMap = new HashMap<>();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Excel.class)) {
                Excel Excel = field.getAnnotation(Excel.class);
                if(Excel.exportIndex() < 0){
                    continue;
                }
                fieldName = field.getName();
                getMethod = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                returnType = field.getType();
                method = clazz.getMethod(getMethod);
                singleLineDataMap.put(Excel.exportIndex(), new AnalyseData(method, returnType));

            }
        }
        return singleLineDataMap;
    }

    /**
     * 将数据拆解成形如“0：张三、1：男、...”(即生成表格数据：列号为key，属性值为value)
     * @param analysisDataMap
     * @param dataList
     * @param <T>
     * @return
     * @throws Exception
     */
    private static <T> List<Map<Integer, Object>> antiAnalysisData(Map<Integer, AnalyseData> analysisDataMap, List<T> dataList) throws Exception {
        Map<Integer, Object> finalDataMap ;
        List<Map<Integer, Object>> resultDataList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(dataList)){
            for (T t : dataList) {
                finalDataMap = new HashMap<>();
                for (Map.Entry<Integer, AnalyseData> dataEntry : analysisDataMap.entrySet()) {
                    finalDataMap.put(dataEntry.getKey(), dataEntry.getValue().getMethod().invoke(t));
                }
                resultDataList.add(finalDataMap);
            }
        }
        return resultDataList;
    }

}

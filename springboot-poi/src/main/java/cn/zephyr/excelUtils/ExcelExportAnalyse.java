package cn.zephyr.excelUtils;

import cn.zephyr.utils.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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

    public static <T> File generateExportExcelDefault(Class<T> clazz, List<T> dataList,InputStream inputStream) throws Exception {
        return generateExportExcel(clazz,dataList, 0, 1,inputStream);
    }

    public static <T> File generateExportExcelDefaultSheet(Class<T> clazz, List<T> dataList,Integer startRow,InputStream inputStream) throws Exception {
        return generateExportExcel(clazz,dataList, 0, startRow,inputStream);
    }

    public static <T> File generateExportExcelDefaultRow(Class<T> clazz, List<T> dataList,Integer sheetNum,InputStream inputStream) throws Exception {
        return generateExportExcel(clazz,dataList, sheetNum, 1,inputStream);
    }
        /**
         *
         * @param clazz     数据实体对应的class
         * @param dataList  数据集
         * @param sheetNum  数据写入的Excel Sheet页
         * @param startRow  数据写入的起始行（0表示第一行）
         * @param inputStream   模板文件流
         * @param <T>       数据对象泛型
         * @return
         * @throws Exception
         */
    public static <T> File generateExportExcel(Class<T> clazz, List<T> dataList, Integer sheetNum, Integer startRow,InputStream inputStream) throws Exception {
        Workbook wb = new XSSFWorkbook(inputStream);    // 获取导出模板工作簿
        Sheet sheet = wb.getSheetAt(sheetNum);          // 获取导出数据即将写入的sheet页
        File resultFile ;
        Map<Integer, AnalyseData> analyseDataMap = antiAnalysis(clazz);
        List<Map<Integer, Object>> analyseData = antiAnalysisData(analyseDataMap, dataList);
        // 如果解析出了有效数据，则写入Excel文件
        if(!CollectionUtils.isEmpty(analyseData)){
            for (int i = 0; i < analyseData.size(); i++) {
                Row row = sheet.createRow(startRow+i);
                Map<Integer, Object> map = analyseData.get(i);
                for (Map.Entry<Integer, Object> entry : map.entrySet()) {
//                    System.err.println(entry.getValue().getClass().getName());
                    if(entry.getValue() == null ){
                        continue;
                    }else if(entry.getValue().getClass().getName().contains("Date")){
                        row.createCell(entry.getKey()).setCellValue(DateUtil.dateFormatTime((Date)entry.getValue(),DateUtil.DateMode_12));
                    }else if(entry.getValue().getClass().getName().contains("BigDecimal")){
                        row.createCell(entry.getKey()).setCellValue((entry.getValue()).toString());
                    }/*else if(entry.getValue().getClass().getName().contains("List")){

                    }*/else{
                        row.createCell(entry.getKey()).setCellValue(String.valueOf(entry.getValue()));
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
     * 解析类：
     * 将List数据组装成Map数据，
     * key是Excel的列编号（列编号在注解中定义），
     * value存放的是属性对应的getter方法与返回值类型
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

    /*******************************************************************************************/
    /*******************************************************************************************/
    /*******************************************************************************************/


    /**
     *
     * @param clazz
     * @param dataList
     * @param sheetNum
     * @param inputStream
     * @param <T>
     * @return
     * @throws Exception
     * @description
     */
    public static <T> File generateComplicatedExportExcel(Class<T> clazz, List<T> dataList, Integer sheetNum,InputStream inputStream,Integer dataSize) throws Exception {
        Workbook wb = new XSSFWorkbook(inputStream);    // 获取导出模板工作簿
        Sheet sheet = wb.getSheetAt(sheetNum);          // 获取导出数据即将写入的sheet页
        File resultFile ;
        // 数据重组：单元格横纵坐标——数据实体
        List<Map<String, Object>> analyseData  = antiAnalysisComplicated(clazz,dataList);
        // 如果解析出了有效数据，则写入Excel文件
        if(!CollectionUtils.isEmpty(analyseData)){
            Integer currentRowNum ;// 当前单元格所在的行号
            Integer baseDataRowIndex = 0-dataSize; // 当前数据实体所在的行
            Row row ;
            String[] cellSize ;
            String[] cellRowSize ;
            String[] cellColumnSize ;
            Integer rowNumStart ;
            Integer rowNumEnd ;
            Integer columnNumStart ;
            Integer columnNumEnd ;
            CellRangeAddress region ;   // 合并单元格的poi对象
            // 行数据写入
            for (int i = 0; i < analyseData.size(); i++) {
                Map<String, Object> map = analyseData.get(i);
                baseDataRowIndex +=dataSize;
                // 首先创建单条数据所占用的所有行
                for (int j = 1; j <= dataSize; j++) {
                    row = sheet.createRow(baseDataRowIndex+j);
                }
                // 列数据写入
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    cellSize = entry.getKey().split("\\+");
                    cellRowSize = cellSize[0].split("-");
                    cellColumnSize = cellSize[1].split("-");
                    currentRowNum = baseDataRowIndex + new Integer(cellRowSize[0]);
                    rowNumStart = baseDataRowIndex + new Integer(cellRowSize[0]);
                    rowNumEnd = baseDataRowIndex + new Integer(cellRowSize[1]);
                    columnNumStart = new Integer(cellColumnSize[0]) ;
                    columnNumEnd = new Integer(cellColumnSize[1]) ;
                    row = sheet.getRow(currentRowNum);
                    // 如果需要创建合并单元格，则创建
                    if(!rowNumStart.equals(rowNumEnd)){
                        region = new CellRangeAddress(rowNumStart, rowNumEnd, columnNumStart,columnNumEnd);
                        sheet.addMergedRegion(region);
                    }
                    if(entry.getValue() == null ){
                        // do nothing,next loop
                    }else if(entry.getValue().getClass().getName().contains("Date")){
                        row.createCell(new Integer(cellColumnSize[0])).setCellValue(DateUtil.dateFormatTime((Date)entry.getValue(),DateUtil.DateMode_12));
                    }else if(entry.getValue().getClass().getName().contains("BigDecimal")){
                        row.createCell(new Integer(cellColumnSize[0])).setCellValue((entry.getValue()).toString());
                    }else{
                        row.createCell(new Integer(cellColumnSize[0])).setCellValue(String.valueOf(entry.getValue()));
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
     * @param clazz
     * @return
     * @throws Exception
     * @description  如果属性的数据类型是一个对象或者List/数组，则下方法包括了对这些类型数据的处理
     * 注意：@Excel注解的columnNum与rowNum不能同时为空
     */
    private static <T> List<Map<String, Object>> antiAnalysisComplicated(Class<?> clazz, List<T> dataList) throws Exception{
        Field[] fields = clazz.getDeclaredFields();
        String fieldName;
        String getMethod;
        Method method;
        Class<?> returnType ;
        // key-index(excel的单元格坐标),value-method(属性对应的getter方法)
        Map<String, AnalyseData> singleLineDataMap = new HashMap<>();
        // 最终返回的数据集
        Map<String, Object> finalDataMap ;
        String cellSizeInfo;
        // todo 用递归处理
        for (Field field : fields) {
            if (field.isAnnotationPresent(Excel.class)) {
                Excel excel = field.getAnnotation(Excel.class);
                if(StringUtils.isEmpty(excel.columnNum()) && StringUtils.isEmpty(excel.rowNum())){
                    continue;
                }else if(excel.fieldType().equals(FieldTypeEnum.LIST)){// todo 针对List类型属性的处理
                    cellSizeInfo="";
                }else if(excel.fieldType().equals(FieldTypeEnum.OBJ)){// todo 针对对象类型属性的处理
                    Class<?> subClass = field.getType();
                    Field[] subClassDeclaredFields = subClass.getDeclaredFields();
                    if(null == subClassDeclaredFields || subClassDeclaredFields.length == 0){
                        continue;
                    }
                    for (Field subField : subClassDeclaredFields) {
                        if(subField.isAnnotationPresent(Excel.class)){
                            Excel subExcel = subField.getAnnotation(Excel.class);
                            if(StringUtils.isEmpty(excel.columnNum()) && StringUtils.isEmpty(excel.rowNum())){
                                continue;
                            }else{// 针对默认类型（基本数据类型包括包装类型）的数据
                                cellSizeInfo = subExcel.rowNum() + "+" +  subExcel.columnNum();
                                fieldName = subField.getName();
                                getMethod = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                                String getPreMethod = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                                returnType = subField.getType();
                                Method preMethod = clazz.getMethod(getPreMethod);
                                method = subClass.getMethod(getMethod);
                                singleLineDataMap.put(cellSizeInfo, new AnalyseData(method,preMethod, returnType));
                            }
                        }

                    }
                }else{// 针对默认类型（基本数据类型包括包装类型）的数据
                    cellSizeInfo = excel.rowNum() + "+" + excel.columnNum() ;
                    fieldName = field.getName();
                    getMethod = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    returnType = field.getType();
                    method = clazz.getMethod(getMethod);
                    singleLineDataMap.put(cellSizeInfo, new AnalyseData(method, returnType));
                }
            }
        }
//        singleLineDataMap = sortMapByKey(singleLineDataMap);
        List<Map<String, Object>> resultDataList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(dataList)){
            for (T t : dataList) {
                finalDataMap = new HashMap<>();
                for (Map.Entry<String, AnalyseData> dataEntry : singleLineDataMap.entrySet()) {
                    if(null != dataEntry.getValue().getPreMethod()){
                        finalDataMap.put(dataEntry.getKey(), dataEntry.getValue().getMethod().invoke(dataEntry.getValue().getPreMethod().invoke(t)));
                    }else
                        finalDataMap.put(dataEntry.getKey(), dataEntry.getValue().getMethod().invoke(t));
                }
//                finalDataMap = sortMapByKey(finalDataMap);
                resultDataList.add(finalDataMap);
            }
        }

        return resultDataList;
    }

    public static Map<String, Object> sortMapByKey(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<String, Object> sortMap = new TreeMap<String, Object>(
                new MapKeyComparator());

        sortMap.putAll(map);

        return sortMap;
    }

}

class MapKeyComparator implements Comparator<String>{

    @Override
    public int compare(String str1, String str2) {
        String s1 = str1.split("\\+")[0].split("-")[0];
        String s2 = str2.split("\\+")[0].split("-")[0];
        return new Integer(s1).compareTo(new Integer(s2));
    }
}
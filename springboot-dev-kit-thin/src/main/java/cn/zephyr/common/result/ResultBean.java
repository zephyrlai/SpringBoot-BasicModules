package cn.zephyr.common.result;

import java.util.Map;

/**
 * @Title: SpringBoot-BasicModules
 * @Package: cn.zephyr.common.result
 * @Description:
 * @author: Lai
 * @date 2018/8/7 9:26
 */
public class ResultBean<T> {
    private T result;
    private Map<String,Object> resultExt;
    private Integer code;
    private String msg;
    private String alertMsg;

    public T getResult() {
        return result;
    }

    public ResultBean<T> setResult(T result) {
        this.result = result;
        return this;
    }

    public Map<String, Object> getResultExt() {
        return resultExt;
    }

    public ResultBean<T> setResultExt(Map<String, Object> resultExt) {
        this.resultExt = resultExt;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public ResultBean<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultBean<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getAlertMsg() {
        return alertMsg;
    }

    public ResultBean<T> setAlertMsg(String alertMsg) {
        this.alertMsg = alertMsg;
        return this;
    }

    private ResultBean(T result, Map<String, Object> resultExt, Integer code, String msg,String alertMsg) {
        this.result = result;
        this.resultExt = resultExt;
        this.code = code;
        this.msg = msg;
        this.alertMsg = alertMsg;
    }

    public static <T> ResultBean<T> build(T result, Map<String, Object> resultExt, Integer code, String msg,String alertMsg){
        return new ResultBean<>(result, resultExt, code, msg,alertMsg);
    }

    public static <T> ResultBean<T> buildException(String msg,String alertMsg){
        return new ResultBean<>(null,null, 500, msg,alertMsg);
    }

    public static <T> ResultBean<T> querySuccess(T result){
        return new ResultBean<>(result,null, 200, "查询成功",null);
    }

    public static <T> ResultBean<T> querySuccessExt(T result,Map<String, Object> resultExt){
        return new ResultBean<>(result,null, 200, "查询成功",null);
    }


    public static <T> ResultBean<T> operSuccess(){
        return new ResultBean<>(null,null, 200, "操作成功",null);
    }


}

package cn.zephyr.common.result;

import lombok.Data;

import java.util.List;

/**
 * @Title: SpringBoot-BasicModules
 * @Package: cn.zephyr.common.result
 * @Description:
 * @author: Lai
 * @date 2018/8/7 9:27
 */
public class PageResultBean<T> {
    private Integer code;
    private Integer count;
    private List<T> data;
    private String msg;

    public PageResultBean(Integer code, Integer count, List<T> data,String msg) {
        this.code = code;
        this.count = count;
        this.data = data;
        this.msg= msg;
    }

    public String getMsg() {
        return msg;
    }

    public PageResultBean<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public PageResultBean<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public PageResultBean<T> setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<T> getData() {
        return data;
    }

    public PageResultBean<T> setData(List<T> data) {
        this.data = data;
        return this;
    }

    public static <K> PageResultBean<K> build(Integer code, Integer count, List<K> data,String msg){
        return new PageResultBean<K>(code,count,data,msg);
    }

    public static <K> PageResultBean<K> querySucc(Integer count, List<K> data){
        return build(200,count,data,"查询成功！");
    }
}

package cn.zephyr.excelUtils;

import java.lang.reflect.Method;

/**
 * @Auther: zephyrLai
 * @Date: 2019/1/24 10:06
 * @Description:
 */
public class AnalyseData {
    private Method method;
    private Method preMethod;
    private Class<?> type;

    public AnalyseData(Method method, Method preMethod, Class<?> type) {
        this.method = method;
        this.preMethod = preMethod;
        this.type = type;
    }

    public AnalyseData(Method method, Class<?> type) {
        this.method = method;
        this.type = type;
    }

    public Method getMethod() {
        return method;
    }

    public AnalyseData setMethod(Method method) {
        this.method = method;
        return this;
    }

    public Method getPreMethod() {
        return preMethod;
    }

    public AnalyseData setPreMethod(Method preMethod) {
        this.preMethod = preMethod;
        return this;
    }

    public Class<?> getType() {
        return type;
    }

    public AnalyseData setType(Class<?> type) {
        this.type = type;
        return this;
    }
}

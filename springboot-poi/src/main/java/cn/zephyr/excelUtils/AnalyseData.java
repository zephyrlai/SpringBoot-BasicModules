package cn.zephyr.excelUtils;

import java.lang.reflect.Method;

/**
 * @Auther: zephyrLai
 * @Date: 2019/1/24 10:06
 * @Description:
 */
public class AnalyseData {
    private Method method;
    private Class<?> type;

    public AnalyseData(Method method, Class<?> type) {
        this.method = method;
        this.type = type;

    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
            this.type = type;
        }

}

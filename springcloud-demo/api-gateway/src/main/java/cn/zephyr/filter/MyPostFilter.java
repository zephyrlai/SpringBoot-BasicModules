package cn.zephyr.filter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyPostFilter extends ZuulFilter {

    public static final Logger logger = LoggerFactory.getLogger(MyPostFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        logger.info("---------------后置执行---------------");
        return null;
    }
}

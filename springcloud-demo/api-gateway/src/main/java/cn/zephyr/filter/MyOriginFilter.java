package cn.zephyr.filter;

import com.netflix.zuul.ZuulFilter;

public class MyOriginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "route";
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
        System.err.println("--------------route--------------");
        return null;
    }
}

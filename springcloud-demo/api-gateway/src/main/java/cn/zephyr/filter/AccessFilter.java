package cn.zephyr.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 定义过滤器类型（此处指定为pre，表示前置执行）
     * <p><strong>spring cloud zuul支持如下的值：</strong></p>
     * <p>"pre"：前置路由过滤,</p>
     * <p>"route" for routing to an origin,</p>
     * <p>"post" 后置路由过滤；</p>
     * <p>"error"：异常处理.</p>
     * <p>("static"：静态的response,详见 StaticResponseFilter)</p>
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 指定过滤器的执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断过滤器是否需要执行的一个标志位
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的真正逻辑
     * @return
     */
    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        logger.info("send {} to {}",request.getMethod(),request.getRequestURL().toString());
        String token = request.getParameter("token");
        if(StringUtils.isEmpty(token)){
            logger.warn("Token does not exist!");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(302);
            return null;
        }
        logger.info("Token check!");
        return null;
    }
}

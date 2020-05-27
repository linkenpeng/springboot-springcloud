package com.intecsec.mall.zuulserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-05-17 10:53
 **/
@Component
public class GlobalErrorFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterUtils.ERROR_FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        Throwable throwable = context.getThrowable();

        context.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        context.set("error.exception", throwable.getCause());

        return null;
    }
}

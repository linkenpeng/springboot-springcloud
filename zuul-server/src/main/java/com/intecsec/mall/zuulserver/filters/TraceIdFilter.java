package com.intecsec.mall.zuulserver.filters;

import brave.Tracer;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author peter.peng
 * @date 2020/7/21
 */
@Component
public class TraceIdFilter extends ZuulFilter {

	@Autowired
	private Tracer tracer;

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.getResponse().addHeader("scd-trace-id", tracer.currentSpan().toString());
		return null;
	}
}

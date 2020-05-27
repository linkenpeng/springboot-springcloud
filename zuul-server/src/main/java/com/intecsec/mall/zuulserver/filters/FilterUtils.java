package com.intecsec.mall.zuulserver.filters;

import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

/**
 * Zuul Filter工具类
 *
 */
@Component
public class FilterUtils {

    public static final String AUTH_TOKEN       = "Authorization";
    public static final String USER_ID          = "scd-user-id";
    public static final String SHOP_ID          = "scd-shop-id";

    public static final String PRE_FILTER_TYPE  = "pre";
    public static final String ROUTING_FILTER_TYPE  = "routing";
    public static final String POST_FILTER_TYPE  = "post";
    public static final String ERROR_FILTER_TYPE  = "error";

    public final String getShopId(){
        RequestContext ctx = RequestContext.getCurrentContext();
        if (ctx.getRequest().getHeader(SHOP_ID) != null) {
            return ctx.getRequest().getHeader(SHOP_ID);
        } else {
            return ctx.getZuulRequestHeaders().get(SHOP_ID);
        }
    }

    public void setShopId(String shopId){
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader(SHOP_ID, shopId);
    }

    public final String getUserId(){
        RequestContext ctx = RequestContext.getCurrentContext();
        if (ctx.getRequest().getHeader(USER_ID) !=null) {
            return ctx.getRequest().getHeader(USER_ID);
        } else {
            return  ctx.getZuulRequestHeaders().get(USER_ID);
        }
    }

    public void setUserId(String userId){
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader(USER_ID, userId);
    }

    public final String getAuthToken(){
        RequestContext ctx = RequestContext.getCurrentContext();
        return ctx.getRequest().getHeader(AUTH_TOKEN);
    }
}

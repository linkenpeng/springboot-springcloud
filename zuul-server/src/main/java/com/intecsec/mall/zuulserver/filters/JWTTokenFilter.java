package com.intecsec.mall.zuulserver.filters;

import com.netflix.zuul.ZuulFilter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 解析店铺的Id示例Filter
 */
@Component
public class JWTTokenFilter extends ZuulFilter{
    private static final int      FILTER_ORDER =  1;

    @Autowired
    private FilterUtils filterUtils;

    @Override
    public String filterType() {
        return FilterUtils.PRE_FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    public Object run() {
        this.parseJWTToken();
        return null;
    }

    /**
     * 解析JWT Token中的信息
     * @return
     */
    private void parseJWTToken(){
        if (null == filterUtils.getAuthToken())
            return;

        String authToken = filterUtils.getAuthToken().replace("bearer ","");
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("abc123".getBytes("UTF-8"))
                    .parseClaimsJws(authToken).getBody();
            filterUtils.setShopId((String) claims.get("shopId"));
            filterUtils.setUserId((String) claims.get("user_name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
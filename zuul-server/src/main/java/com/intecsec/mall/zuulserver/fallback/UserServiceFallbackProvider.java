package com.intecsec.mall.zuulserver.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.client.ClientHttpResponse;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-29 10:40
 **/
public class UserServiceFallbackProvider implements ZuulFallbackProvider {

    @Override
    public String getRoute() {
        return "user-service";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return null;
    }
}

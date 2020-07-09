package com.intecsec.mall.zuulserver.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-29 10:40
 **/
public class UserServiceFallbackProvider implements FallbackProvider {

    @Override
    public String getRoute() {
        return "user-service";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return null;
    }
}

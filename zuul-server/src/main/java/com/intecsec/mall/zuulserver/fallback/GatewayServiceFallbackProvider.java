package com.intecsec.mall.zuulserver.fallback;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-29 10:40
 **/
@Component
public class GatewayServiceFallbackProvider implements ZuulFallbackProvider {

    @Override
    public String getRoute() {
        return "gateway-service";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                String mockJson = "{\n" +
                        "    \"code\": 10000,\n" +
                        "    \"msg\": \"请求处理成功\",\n" +
                        "    \"data\": {}\n" +
                        "}";
                return new ByteArrayInputStream(mockJson.getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return httpHeaders;
            }
        };
    }
}

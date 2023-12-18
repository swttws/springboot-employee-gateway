package com.su.filter;

import com.su.common.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import springfox.documentation.schema.Maps;

import java.util.HashMap;

/**
 * @author suweitao
 * 请求参数拦截器
 */
@Component
@Slf4j
public class RequestGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("=================================请求开始=====================================================");
        ServerHttpRequest request = exchange.getRequest();
        //打印请求日志
        log.info("请求方式：{}",request.getMethod());
        log.info("请求路径：{}",request.getURI());
        log.info("请求头信息:{}",request.getHeaders());
        //统计请求时间
        long begin = System.currentTimeMillis();
        HashMap<String, String> map = new HashMap<>();
        map.put(CommonConstant.BEGIN_TIME_KEY,String.valueOf(begin));
        ServerWebExchangeUtils.putUriTemplateVariables(exchange,map);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -20;
    }
}

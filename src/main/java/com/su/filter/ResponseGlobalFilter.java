package com.su.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author suweitao
 */
@Component
@Slf4j
public class ResponseGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取返回响应体
        ServerHttpResponse response = exchange.getResponse();

        log.info("=================================请求结束=====================================================");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -2;
    }
}

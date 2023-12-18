package com.su.filter.oauth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author suweitao
 * 用户信息注册拦截器
 */
@Component
@Slf4j
public class RegisterFactoryFilter extends AbstractGatewayFilterFactory<Object> implements Ordered {
    @Override
    public GatewayFilter apply(Object config) {
        return null;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

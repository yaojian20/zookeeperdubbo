package com.yao.provider.config;

import com.alibaba.dubbo.config.ProtocolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yaojian
 * @date 2021/12/19 18:04
 */

@Configuration
public class HessianConfig {

    // 配置rest协议
    @Bean("hessian")
    public ProtocolConfig restProtocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("hessian");
        protocolConfig.setId("hessian");
        protocolConfig.setServer("jetty");
        protocolConfig.setPort(9090);
        protocolConfig.setAccepts(500);
        protocolConfig.setThreads(100);
        // 可继续增加其它配置
        return protocolConfig;
    }



}

package com.yao.comsumer;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Protocol;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class ComsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComsumerApplication.class, args);
        Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getExtension("myprotocol");
        System.out.println(protocol.getDefaultPort());
    }

}

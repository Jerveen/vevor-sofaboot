package com.vevor.sofaboot.config;

import com.alipay.sofa.rpc.config.ProviderConfig;
import com.alipay.sofa.rpc.config.RegistryConfig;
import com.alipay.sofa.rpc.config.ServerConfig;
import com.google.common.collect.Lists;
import com.vevor.sofaboot.sevice.HelloService;
import com.vevor.sofaboot.sevice.impl.HelloServiceImpl;
import org.springframework.context.annotation.Bean;

/**
 * @Description:
 * @Author: xyw
 * @CreateDt: 2019-09-23
 */
public class SofaRpcConfig {

    @Bean
    public void test(){
        /**
         * 构建服务注册中心
         */
        RegistryConfig registryConfig = new RegistryConfig()
                .setProtocol("nacos")
                .setSubscribe(true)
                .setAddress("127.0.0.1:8848")
                .setRegister(true);

        /**
         * 构建服务端口配置
         */
        ServerConfig serverConfig  = new ServerConfig()
                .setProtocol("bolt")
                .setHost("0.0.0.0")
                .setPort(12200);

        /**
         * 构建服务发布者
         */
        ProviderConfig<HelloService> providerConfig = new ProviderConfig<HelloService>()
                .setInterfaceId(HelloService.class.getName())
                .setRef(new HelloServiceImpl())
                .setServer(serverConfig)
                .setRegister(true)
                .setRegistry(Lists.newArrayList(registryConfig));
        providerConfig.export();
    }
}

package com.vevor.sofaboot.sevice.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.vevor.sofaboot.sevice.HelloService;
import org.springframework.stereotype.Service;

/**
 * @Description: 测试服务注册实现类
 * @Author: xyw
 * @CreateDt: 2019-09-23
 */
@SofaService(interfaceType = HelloService.class, bindings = {@SofaServiceBinding(bindingType = "bolt")})
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello Sofa Boot to Sofa Rpc:" + name;
    }
}

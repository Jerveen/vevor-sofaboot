package com.vevor.sofaboot.controller;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.vevor.sofaboot.sevice.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 测试Controller
 * @Author: xyw
 * @CreateDt: 2019-09-23
 */
@RestController
public class HelloController {

    @SofaReference(interfaceType = HelloService.class, binding = @SofaReferenceBinding(bindingType = "bolt"))
    private HelloService helloService;

    @GetMapping("/sayHello")
    public String sayHello(String name) {

        String result = helloService.sayHello(name);

        return result;
    }
}

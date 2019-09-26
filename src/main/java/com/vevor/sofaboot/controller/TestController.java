package com.vevor.sofaboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description: 测试Controller
 * @Author: xyw
 * @CreateDt: 2019-09-26
 */
@Controller
public class TestController {

    @GetMapping("test")
    public String test(){
        return "test";
    }
}

package com.theboyaply.springboot1.core.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author senlin.yang@hand-china.com
 * @version V1.0
 * @Date 2019-3-25
 * @description
 */

@RestController
public class TestController {

    @GetMapping(value = "/hello")
    public String hello(String name) {
        return "hello " + name;
    }

}

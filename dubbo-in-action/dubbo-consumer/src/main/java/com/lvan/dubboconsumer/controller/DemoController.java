package com.lvan.dubboconsumer.controller;

import com.lvan.dubbointerface.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvan
 * @date 2022/6/10
 */
@RequestMapping("demo")
@RestController
public class DemoController {

    /**
     * check = false，在系统启动时不检测 DemoService 是否可用
     */
    @DubboReference(check = false)
    private DemoService demoService;

    @GetMapping("sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return demoService.sayHello(name);
    }
}

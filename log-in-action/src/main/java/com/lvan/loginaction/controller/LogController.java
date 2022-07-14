package com.lvan.loginaction.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Qibin Liu
 * @since 2022-07-11 20:29
 */
@Slf4j(topic = "com.lvan")
@RestController
@RequestMapping("log")
public class LogController {

    @PostMapping("info")
    public void printInfoLog(@RequestParam String msg) {
        log.info("receive info log:{}", msg);
    }

    @PostMapping("error")
    public void printErrorLog(@RequestParam String msg) {
        log.error("receive error log:{}", msg);
    }

    @PostMapping("sys/error")
    public void printSysErrorLog(@RequestParam Integer num) {
        // 模拟系统异常
        int result = 5 / num;
    }
}

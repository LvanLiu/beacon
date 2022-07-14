package com.lvan.monitorinaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Qibin Liu
 * @since 2022-07-14 10:50
 */
@Slf4j
@RequestMapping("prometheus")
@RestController
public class PrometheusMonitorController {

    @GetMapping("hello")
    public Object helloPrometheus() {
        Map<String, String> map = new HashMap<>(1);
        map.put("result", "hello prometheus");
        return map;
    }


}

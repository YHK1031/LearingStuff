package com.yh.controller;

import com.yh.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/around")
    public void around() {
        testService.around("firstArg", "secondArg");
    }

    @GetMapping("/before")
    public void before() {
        testService.before();
    }

    @GetMapping("/after")
    public void after() {
        testService.after();
    }
}

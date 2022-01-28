package com.yh.service;

import com.yh.aop.AfterLog;
import com.yh.aop.AroundLog;
import com.yh.aop.BeforeLog;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @AroundLog("testYH")
    public void around(String arg1, String arg2) {
        System.out.println("*****test method******");
    }

    @BeforeLog
    public void before() {
        System.out.println("*****test method******");
    }

    @AfterLog
    public void after() {
        System.out.println("*****test method******");
    }
}

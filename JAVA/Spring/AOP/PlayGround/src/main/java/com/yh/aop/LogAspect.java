package com.yh.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class LogAspect {

    @Around("@annotation(AroundLog)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("========This is first around log======");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("========This is second around log======");
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        AroundLog annotation = AnnotationUtils.getAnnotation(method, AroundLog.class);
        System.out.println("===This is value : "+annotation.value());
        Object[] args = proceedingJoinPoint.getArgs();
        for(Object arg : args) {
            System.out.println("==Arguments : "+arg);
        }

        return proceed;
    }

    @Before("@annotation(BeforeLog)")
    public void beforeLog() {
        System.out.println("========This is before log======");
    }

    @After("@annotation(AfterLog)")
    public void afterLog() {
        System.out.println("========This is after log======");
    }
}

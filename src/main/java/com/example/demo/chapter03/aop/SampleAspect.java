package com.example.demo.chapter03.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Aspect // 어드바이스를 기술하는 클래스에 작성
@Component // 인스턴스 생성
public class SampleAspect {
    //@Before("execution(* com.example.demo.chapter03.used.*Greet.*(..))") // 매서드 실행 전에 호출하는 Before Advice
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("===== Before Advie =====");
        System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date()));
        System.out.println(String.format("메서드:%s", joinPoint.getSignature().getName()));
    }

    //@After("execution(* com.example.demo.chapter03.used.*Greet.*(..))") // 매서드 실행 후에 호출하는 After Advice
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("===== After Advie =====");
        System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date()));
        System.out.println(String.format("메서드:%s", joinPoint.getSignature().getName()));
    }

    @Around("execution(* com.example.demo.chapter03.used.*Greet.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("===== Around Advie =====");
        System.out.println("*** 처리전 ***");
        Object result = joinPoint.proceed();
        System.out.println("*** 처리후 ***");
        return result;
    }
}

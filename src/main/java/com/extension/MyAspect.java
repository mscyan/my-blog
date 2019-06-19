package com.extension;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(public !void com.pic.service.*.*(..))")
    public void performance(){

    }

    @Pointcut("execution(void com.*.service.*.*(..))")
    public void noReturn(){

    }

    @Pointcut("execution(com.utils.ResponseData com.*.service.*.*(..))")
    public void forRespon(){

    }

    @Around("forRespon()")
    public Object logResponseDataFunction(ProceedingJoinPoint joinPoint) throws Throwable {
        Object j = joinPoint.proceed();
        System.out.print(joinPoint.getTarget().getClass().getName() + " ");
        System.out.print(joinPoint.getSignature().getName() + " ");
        System.out.println("the return type is " + "ResponseData");
        return j;
    }

    @Around("performance()")
    public Object logExeTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object j = joinPoint.proceed();
        System.out.print(joinPoint.getTarget().getClass().getName() + " ");
        System.out.print(joinPoint.getSignature().getName() + " ");
        System.out.print("cost time :" + (System.currentTimeMillis() - start) + "ms  ");
        System.out.println(j.getClass());
        return j;
    }

    @Around("noReturn()")
    public void noReturnValue(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(joinPoint.getSignature().getName() + " " + "this function has no return value");
        joinPoint.proceed();
    }
}

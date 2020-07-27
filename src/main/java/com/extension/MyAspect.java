package com.extension;

import com.utils.ArrayToList;
import com.utils.ResponseData;
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

    @Pointcut("execution(!void com.*..*Controller.*(..))")
    public void controllerExceptionHandler(){

    }

    @Around("execution(com.utils.ResponseData com.*.service.*.*(..))")
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
        System.out.print("PerformanceLog ==> " + joinPoint.getTarget().getClass().getName() + " ");
        System.out.print(joinPoint.getSignature().getName() + " ");
        System.out.print("cost time :" + (System.currentTimeMillis() - start) + " ms ");
        System.out.println(j.getClass());
        return j;
    }

    @Around("noReturn()")
    public void noReturnValue(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(joinPoint.getSignature().getName() + " " + "this function has no return value");
        joinPoint.proceed();
    }

    @Around("controllerExceptionHandler()")
    public Object controllerExceptionLogger(ProceedingJoinPoint joinPoint){
        try {
            Object re = joinPoint.proceed();
            System.out.println("ExceptionHandler ==> " + joinPoint.getSignature().getName() + "  " + ArrayToList.printArray(joinPoint.getArgs()));
            return re;
        } catch (Exception exception) {
            exception.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return new ResponseData(500, "error", "操作执行失败");
    }
}

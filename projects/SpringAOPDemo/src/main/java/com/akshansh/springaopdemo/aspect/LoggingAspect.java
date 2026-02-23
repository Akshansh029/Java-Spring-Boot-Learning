package com.akshansh.springaopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    // --- POINTCUT EXPRESSION ---
    // "execution" means: intercept method execution
    // "* com.example.service.*.*(..)":
    //    *         = any return type
    //    com.example.service.*.* = any class in service package, any method
    //    (..)      = any number of arguments
    @Pointcut("execution(* com.akshansh.springaopdemo.service.*.*(..))")
    public void serviceLayer(){};

    @Before("serviceLayer()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("[BEFORE] About to call: " + joinPoint.getSignature().getName());
    }

    @After("serviceLayer()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("[AFTER] Finished: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "serviceLayer()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result){
        System.out.println("[AFTER-RETURNING] " + joinPoint.getSignature().getName()
                + " returned: " + result);
    }

    @AfterThrowing(pointcut = "serviceLayer()", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex){
        System.out.println("[AFTER-THROWING] " + joinPoint.getSignature().getName()
                + " threw: " + ex.getMessage());
    }

    @Around("serviceLayer()")
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed(); // <-- THIS calls the real method

        long elapsed = System.currentTimeMillis() - start;
        System.out.println("[AROUND] " + joinPoint.getSignature().getName()
                + " took " + elapsed + "ms");
        return result; // Always return the result, or callers get null
    }
}

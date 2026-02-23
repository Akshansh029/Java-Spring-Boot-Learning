package com.akshansh.springaopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimerAspect {

    @Around("@annotation(com.akshansh.springaopdemo.annotation.Timed)")
    public Object time(ProceedingJoinPoint pjp) throws Throwable{
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        System.out.printf("\n[TIMER] %s executed in %dms%n",
                pjp.getSignature().toShortString(),
                System.currentTimeMillis() - start);
        return result;
    }
}

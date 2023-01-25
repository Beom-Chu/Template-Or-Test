package com.kbs.templateortest.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAopHelperCLS {

    /**
     *   @GetMapping 설정된 메소드 또는 클래스 설정
     *   GetMapping 노테이션이 설정된 특정 클래스/메소드에만 AspectJ가 적용됨.
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void GetMapping(){ }

    /**
     * @param joinPoint
     */
    @Before("GetMapping()")
    public void before(JoinPoint joinPoint) {
        log.info("=====================AspectJ TEST  : Before Logging =====================");
    }

    /**
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = "GetMapping()", returning = "result")
    public void AfterReturning(JoinPoint joinPoint, Object result) {
        log.info("=====================AspectJ TEST  : AfterReturning Logging =====================");
    }

    /**
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("GetMapping()")
    public Object Around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("=====================AspectJ TEST  : Around Logging Start=====================");
        try {
            Object result = joinPoint.proceed();
            log.info("=====================AspectJ TEST  : Around Logging END=====================");
            return result;
        }catch (Exception e) {
            log.error("=====================AspectJ Around Exception=====================");
            log.error(e.toString());
            return null;
        }
    }

}
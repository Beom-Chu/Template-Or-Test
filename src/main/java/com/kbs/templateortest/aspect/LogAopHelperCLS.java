package com.kbs.templateortest.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
@Slf4j
public class LogAopHelperCLS {

    /**
     *   aspectJ를 적용할 타겟을 정의해준다. 전체 컨트롤러의 함수대상, 특정 어노테이션을 설정한 함수대상,
     *   특정 메소드 대상 등 개발자가 적용하길 원하는 범위를 정의하는 어노테이션
     *
     *   GetMapping 노테이션이 설정된 특정 클래스/메소드에만 AspectJ가 적용됨.
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void GetMapping(){ }

    /* 포인트컷(Pointcut) execution() 표현식 사용법 : https://lasbe.tistory.com/118 */
    @Pointcut("execution(* com.kbs..*.*(..))")
    public void AspectSample(){ }

    /**
     * Before => aspectJ를 적용할 타겟 메소드가 실행되기 '전' 수행됨
     */
    @Before("GetMapping()")
    public void before(JoinPoint joinPoint) {
        log.info("=====================AspectJ TEST  : Before Logging =====================");
        log.info("[[[joinPoint.getKind() = " + joinPoint.getKind());
        log.info("[[[joinPoint.getArgs() = " + Arrays.toString(joinPoint.getArgs()));
        log.info("[[[joinPoint.getSignature().getName() = " + joinPoint.getSignature().getName());
    }

    /**
     * AfterReturning => aspectJ를 적용할 타겟 메소드가 실행된 '후' 수행됨 (제일 마지막에 수행됨)
     */
    @AfterReturning(pointcut = "GetMapping()", returning = "result")
    public void AfterReturning(JoinPoint joinPoint, Object result) {
        log.info("=====================AspectJ TEST  : AfterReturning Logging =====================");
    }

    /**
     * Around => aspectJ를 적용할 타겟 메소드 실행 전 , 후 처리를 모두 할 수 있음
     */
    @Around("AspectSample()")
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
package com.sparta.newsfeedhw.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j(topic = "RequestAop")
@Aspect
@Component
@RequiredArgsConstructor
public class RequestAop {

//    @Pointcut("execution(public * com.sparta.newsfeedhw.controller..*(..))")
//    private void controller() {
//    }

    @Around("execution(* com.sparta.newsfeedhw.controller..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            log.info("Request URL: " + request.getRequestURL());
            log.info("Request Method: " + request.getMethod());
        } else {
            log.info("인가 처리 안 됨");
        }
        return joinPoint.proceed();
    }
}

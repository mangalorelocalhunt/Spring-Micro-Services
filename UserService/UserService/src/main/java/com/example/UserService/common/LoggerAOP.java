package com.example.UserService.common;


import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Log4j2
@Aspect
@Component
public class LoggerAOP {


    @Before("execution(public * com.example.UserService..*.*(..))")
    public void beforeMethodInvoke(JoinPoint joinPoint) {
        log.debug("Entered "+ joinPoint.getSignature()+" Method  " );
    }

    @After("within(com.example..*)")
    public void afterMethodInvoke(JoinPoint joinPoint) {
        log.debug("End of  "+ joinPoint.getSignature()+" Method  " );
    }
}

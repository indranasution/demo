package com.homecredit.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect
@Configuration
public class UserAccessAspect {

    @Before("execution(* com.homecredit.demo.controller.*.*(..)))")
    public void before(JoinPoint joinPoint) {
        log.info(" Allowed execution for {}", joinPoint);
    }
}

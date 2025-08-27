package com.xpenses.transaction.aspect;

import com.xpenses.transaction.dto.request.ApiRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ControllerAspect {

    @Pointcut("within(com.xpenses.transaction.controller..*)")
    private void selectAllControllers() {
    }

    @Before("selectAllControllers()")
    public void logBeforeController(JoinPoint joinPoint) {
        log.debug("Start {}", joinPoint.getSignature().getName());
    }

    @Around("selectAllControllers()")
    public Object logAroundController(ProceedingJoinPoint joinPoint) throws Throwable {
        for (Object args : joinPoint.getArgs())
            if (args instanceof ApiRequest)
                log.debug("Request[{}]", args);

        Object result = joinPoint.proceed();
        log.debug("Response[{}]", result);
        return result;
    }

    @After("selectAllControllers()")
    public void logAfterController(JoinPoint joinPoint) {
        log.debug("End {}", joinPoint.getSignature().getName());
    }

}

package pl.labs.lab1;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log
public class StatusCheckAspect {


    @Around("@annotation(statusCheck)")
    public Object tryExecute(ProceedingJoinPoint joinPoint, StatusCheck statusCheck) throws Throwable {
        var result = joinPoint.proceed();
        if (result instanceof Order order && order.getStatus() == Status.NOTCOMPLETED) {
            throw new RuntimeException();
        }
        return result;
    }
}

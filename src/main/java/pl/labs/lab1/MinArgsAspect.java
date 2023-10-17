package pl.labs.lab1;


import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log
public class MinArgsAspect {


    @Before("@annotation(minArgs)")
    public void validate(JoinPoint joinPoint, MinArgs minArgs) throws NoSuchMethodException {
        var arguments = joinPoint.getArgs();
        if(arguments.length != minArgs.args()){
            log.info("Validation is failed!");
        }
    }
}

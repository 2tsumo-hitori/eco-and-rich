package com.ecoandrich.aop;

import com.ecoandrich.support.PreCondition;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.ecoandrich.support.PreCondition.*;

@Aspect
@Component
public class RateRangeValidationAspect {

    @Before("@annotation(annotation)")
    public void execute(JoinPoint joinPoint, RateRangeValidation annotation) {
        String[] parameterNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();

        String rate = Arrays.stream(parameterNames)
                .filter(parameterName -> parameterName.equals(annotation.rate()))
                .findAny()
                .orElseThrow(PreCondition::wrongParameterMessage);

        int sequence = 0;

        for (int i = 0; i < parameterNames.length; i++) {
            if (parameterNames[i].equals(rate)) {
                sequence = i;
                break;
            }
        }

        requireNormalRange((Integer) joinPoint.getArgs()[sequence] < 1);
    }
}

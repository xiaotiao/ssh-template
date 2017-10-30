package com.wondersoft.ndlp.controller.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Created by zhuzhenghuan on 2017/10/30.
 */
@Component
@Aspect
public class UserControllerAdvice {

    public UserControllerAdvice(){
        System.out.println("UserControllerAdvice.init");
    }

    @After("execution(* com.wondersoft.ndlp.controller.UserController.*(..))")
    public void before(){
        System.out.println("UserControllerAdvice.before..");
    }
}

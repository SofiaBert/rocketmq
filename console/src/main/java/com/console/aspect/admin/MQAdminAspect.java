package com.console.aspect.admin;

import com.console.service.client.MQAdminInstance;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/**
 * Created by frintasse
 * 2018/02/05
 * jarvisbert@foxmail.com
 */
@Aspect
@Service
public class MQAdminAspect {
    public MQAdminAspect() {
    }

    @Pointcut("execution(* com.console.service.client.MQAdminExtImpl..*(..))")
    public void mQAdminMethodPointCut(){

    }
    @Pointcut("@annotation(com.console.aspect.admin.annotation.MultiMQAdminCmdMethod)")
    public void multiMQAdminMethodPointCut(){

    }
    @Around(value = "mQAdminMethodPointCut() || multiMQAdminMethodPointCut()")
    public Object aroundMQAdminMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object obj = null;
        try {
            MQAdminInstance.initMQAdminInstance();
            obj = joinPoint.proceed();
        } finally {
            MQAdminInstance.destroyMQAdminInstance();
        }
        return obj;
    }
}

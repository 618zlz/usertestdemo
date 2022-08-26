package com.example.usertestdemo.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.usertestdemo.domain.CourseInfo;
import com.example.usertestdemo.domain.MyException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class PermissionSecondAdvice {

    @Pointcut("@annotation(com.example.usertestdemo.aspect.PermissionAnnotation)")
    private void permissionCheck() {
    }

    @Around("permissionCheck()")
    public Object permissionCheckSecond(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("===================第二个切面===================：" + System.currentTimeMillis());

        //获取请求参数，详见接口类
        Object[] objects = joinPoint.getArgs();
        Integer id = ((CourseInfo) objects[0]).getId();
        String name = ((CourseInfo) objects[0]).getName();
        System.out.println("id->>>>>>>>>>>>>>>>>>>>>>" + id);
        System.out.println("name->>>>>>>>>>>>>>>>>>>>>>" + name);

        // name不是管理员则抛出异常
        if (!name.equals("admin")) {
            throw new MyException("not admin");
        }
        return joinPoint.proceed();
    }
}

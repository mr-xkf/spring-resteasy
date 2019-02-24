/*
 * FileName: LogAop
 * Author:   13235
 * Date:     2019/1/20 4:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述

 */

package com.example.demo.aop;

import com.example.demo.annotation.LogMark;
import com.example.demo.domain.LogOperate;
import com.example.demo.domain.OpreateLog;
import com.example.demo.service.LogService;
import com.example.demo.utils.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;


@Aspect
@Component
@Slf4j
public class LogAop {

    @Autowired
    private LogService logService;

    @Pointcut("@annotation(com.example.demo.annotation.LogMark)")
    public void pointLog() {
    }

    @Around("pointLog()")
    public Object process(ProceedingJoinPoint pjp) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String requestURI = request.getRequestURI();
        Object obj = null;
        String simpleName = pjp.getTarget().getClass().getSimpleName();
        System.out.println("target Class:" + simpleName);
        System.out.println("method name" + pjp.getSignature().getName());
        Object[] args = pjp.getArgs();
        Method[] methods = pjp.getTarget().getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals(pjp.getSignature().getName())) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == args.length) {
                    boolean annotationPresent = method.isAnnotationPresent(LogMark.class);
                    if (annotationPresent) {
                        LogMark annotation = method.getAnnotation(LogMark.class);
                        String name = annotation.operatType().name();
                        if (LogMark.LogType.EDIT.name().equals(name) && args[0] instanceof OpreateLog) {
                            LogOperate newLog = (LogOperate) args[0];
                            //修改
                            if (newLog.getId() != null) {
                                LogOperate oldLog = logService.findLogById(newLog.getId());
                                List<Map<String, Object>> maps = ReflectionUtils.compareObj2Obj(oldLog, newLog);
                                StringBuffer sb = new StringBuffer();
                                maps.forEach(map ->
                                        sb.append(map.get("name")).append("由原来的:").append(map.get("old"))
                                                .append("变成了:").append(map.get("new")));
                                System.out.println(sb.toString());


                            } else {
                                System.out.println("新增了:" + newLog.toString());
                            }
                        }
                        //删除操作
                        else if (LogMark.LogType.DELETE.name().equals(name) && args[0] instanceof Long) {
                            Long id = (Long) args[0];
                            LogOperate logById = logService.findLogById(id);
                            System.out.println("删除了:" + logById.toString());
                        }
                    }
                    break;
                }
            }
        }
        try {
            obj = pjp.proceed();
        } catch (Throwable throwable) {
            log.error(throwable.getMessage());
        }
        return obj;
    }
}

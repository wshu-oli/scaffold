package net.ws.dev.aop;

import net.ws.auth.core.pojo.LoginUser;
import net.ws.auth.core.util.StpLoginUserUtil;
import net.ws.common.annotation.CommonLog;
import net.ws.dev.util.DevLogUtil;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;

/**
 * 业务日志aop切面
 *
 */
@Aspect
@Order
@Component
public class DevLogAop {

    /**
     * 日志切入点
     */
    @Pointcut("@annotation(net.ws.common.annotation.CommonLog)")
    private void getLogPointCut() {
    }

    /**
     * 操作成功返回结果记录日志
     */
    @AfterReturning(pointcut = "getLogPointCut()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        CommonLog commonLog = method.getAnnotation(CommonLog.class);
        String userName = "未知";
        try {
            LoginUser loginUser = StpLoginUserUtil.getLoginUser();
            if(ObjectUtil.isNotNull(loginUser)) {
                userName = loginUser.getName();
            }
        } catch (Exception ignored) {
        }
        // 异步记录日志
        DevLogUtil.executeOperationLog(commonLog, userName, joinPoint, JSONUtil.toJsonStr(result));
    }

    /**
     * 操作发生异常记录日志
     *
     * @author xuyuxiang
     * @date 2022/9/2 15:24
     */
    @AfterThrowing(pointcut = "getLogPointCut()", throwing = "exception")
    public void doAfterThrowing(JoinPoint joinPoint, Exception exception) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        CommonLog commonLog = method.getAnnotation(CommonLog.class);
        String userName = "未知";
        try {
            LoginUser loginUser = StpLoginUserUtil.getLoginUser();
            if(ObjectUtil.isNotNull(loginUser)) {
                userName = loginUser.getName();
            }
        } catch (Exception ignored) {
        }
        //异步记录日志
        DevLogUtil.executeExceptionLog(commonLog, userName, joinPoint, exception);
    }
}

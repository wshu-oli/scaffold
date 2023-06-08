package net.ws.dev.util;

import net.ws.common.annotation.CommonLog;
import net.ws.common.util.*;
import net.ws.dev.core.log.entity.DevLog;
import net.ws.dev.core.log.service.DevLogService;
import net.ws.dev.enums.DevLogCategory;
import net.ws.dev.enums.DevLogExeStatus;

import org.aspectj.lang.JoinPoint;

import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.extra.spring.SpringUtil;

/**
 * 日志工具类
 */
public class DevLogUtil {

    private static final DevLogService devLogService = SpringUtil.getBean(DevLogService.class);

    /**
     * 记录操作日志
     */
    public static void executeOperationLog(CommonLog commonLog, String userName, JoinPoint joinPoint,
                                           String resultJson) {
        HttpServletRequest request = CommonServletUtil.getRequest();
        DevLog devLog = genBasOpLog();
        ThreadUtil.execute(() -> {
            devLog.setCategory(DevLogCategory.OPERATE);
            devLog.setName(commonLog.value());
            devLog.setExeStatus(DevLogExeStatus.SUCCESS);
            devLog.setClassName(joinPoint.getTarget().getClass().getName());
            devLog.setMethodName(joinPoint.getSignature().getName());
            devLog.setReqUrl(request.getRequestURI());
            devLog.setReqJson(CommonJoinPointUtil.getArgsJsonString(joinPoint));
            devLog.setRespJson(resultJson);
            devLog.setOpTime(LocalDateTime.now());
            devLog.setOpUserName(userName);
            creatLogSignValue(devLog);
            devLogService.save(devLog);
        });
    }

    /**
     * 记录异常日志
     */
    public static void executeExceptionLog(CommonLog commonLog, String userName, JoinPoint joinPoint,
                                           Exception exception) {
        HttpServletRequest request = CommonServletUtil.getRequest();
        DevLog devLog = genBasOpLog();
        ThreadUtil.execute(() -> {
            devLog.setCategory(DevLogCategory.EXCEPTION);
            devLog.setName(commonLog.value());
            devLog.setExeStatus(DevLogExeStatus.FAIL);
            devLog.setExeMessage(ExceptionUtil.stacktraceToString(exception, Integer.MAX_VALUE));
            devLog.setClassName(joinPoint.getTarget().getClass().getName());
            devLog.setMethodName(joinPoint.getSignature().getName());
            devLog.setReqMethod(request.getMethod());
            devLog.setReqUrl(request.getRequestURI());
            devLog.setReqJson(CommonJoinPointUtil.getArgsJsonString(joinPoint));
            devLog.setOpTime(LocalDateTime.now());
            devLog.setOpUserName(userName);
            creatLogSignValue(devLog);
            devLogService.save(devLog);
        });
    }

    /**
     * 记录登录日志
     */
    public static void executeLoginLog(String userName) {
        DevLog devLog = genBasOpLog();
        ThreadUtil.execute(() -> {
            devLog.setCategory(DevLogCategory.LOGIN);
            devLog.setName("用户登录");
            devLog.setExeStatus(DevLogExeStatus.SUCCESS);
            devLog.setOpTime(LocalDateTime.now());
            devLog.setOpUserName(userName);
            creatLogSignValue(devLog);
            devLogService.save(devLog);
        });
    }

    /**
     * 记录登出日志
     */
    public static void executeLogoutLog(String userName) {
        DevLog devLog = genBasOpLog();
        ThreadUtil.execute(() -> {
            devLog.setCategory(DevLogCategory.LOGOUT);
            devLog.setName("用户登出");
            devLog.setExeStatus(DevLogExeStatus.SUCCESS);
            devLog.setOpTime(LocalDateTime.now());
            devLog.setOpUserName(userName);
            creatLogSignValue(devLog);
            devLogService.save(devLog);
        });
    }

    /**
     * 构建基础操作日志
     */
    private static DevLog genBasOpLog() {
        HttpServletRequest request = CommonServletUtil.getRequest();
        String ip = CommonIpAddressUtil.getIp(request);
        DevLog devLog = new DevLog();
        devLog.setOpIp(CommonIpAddressUtil.getIp(request));
        devLog.setOpAddress(CommonIpAddressUtil.getCityInfo(ip));
        devLog.setOpBrowser(CommonUaUtil.getBrowser(request));
        devLog.setOpOs(CommonUaUtil.getOs(request));
        return devLog;
    }

    /**
     * 构建日志完整性保护签名数据
     */
    private static void creatLogSignValue(DevLog devLog) {
        String logStr = devLog.toString().replaceAll(" +", "");
        devLog.setSign(CommonCryptogramUtil.encrypt(logStr));
    }
}

package net.ws.dev.api;

import java.util.List;

import cn.hutool.json.JSONObject;

/**
 * 日志API
 */
public interface DevLogApi {

    /**
     * 记录登录日志
     */
    void executeLoginLog(String userName);

    /**
     * 记录登出日志
     */
    void executeLogoutLog(String userName);

    /**
     * 获取当前用户的访问日志列表
     */
    List<JSONObject> currentUserVisLogList();

    /**
     * 获取当前用户的操作日志列表
     */
    List<JSONObject> currentUserOpLogList();
}

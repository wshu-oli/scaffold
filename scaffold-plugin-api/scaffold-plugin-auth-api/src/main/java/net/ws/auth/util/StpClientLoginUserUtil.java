package net.ws.auth.util;

import net.ws.auth.dto.ClientLoginDto;

import java.util.List;

import cn.hutool.core.collection.CollectionUtil;

/**
 * C端登录用户工具类
 **/
public class StpClientLoginUserUtil {

    /**
     * 获取当前C端登录用户
     **/
    public static ClientLoginDto getClientLoginUser() {
        return (ClientLoginDto) StpClientUtil.getTokenSession().get("loginUser");
    }

    /**
     * 获取当前C端登录用户的当前请求接口的数据范围（暂无数据范围）
     **/
    public static List<String> getLoginUserDataScope() {
        return CollectionUtil.newArrayList();
    }
}

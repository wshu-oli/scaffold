package net.ws.auth.core.util;

import net.ws.auth.core.pojo.LoginUser;
import net.ws.common.util.CommonServletUtil;

import java.util.List;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollectionUtil;

/**
 * B端登录用户工具类
 **/
public class StpLoginUserUtil {

    /**
     * 获取当前B端登录用户
     **/
    public static LoginUser getLoginUser() {
        return (LoginUser) StpUtil.getTokenSession().get("loginUser");
    }

    /**
     * 获取当前B端登录用户的当前请求接口的数据范围
     *
     * @author xuyuxiang
     * @date 2022/7/8 10:41
     **/
    public static List<String> getLoginUserDataScope() {
        List<String> resultList = CollectionUtil.newArrayList();
        getLoginUser().getDataScopeList().forEach(dataScope -> {
            if(dataScope.getApiUrl().equals(CommonServletUtil.getRequest().getServletPath())) {
                resultList.addAll(dataScope.getDataScope());
            }
        });
        return resultList;
    }
}

package net.ws.sys.listener;

import net.ws.auth.core.pojo.LoginUser;
import net.ws.auth.core.util.StpLoginUserUtil;
import net.ws.common.listener.CommonDataChangeListener;
import net.ws.sys.enums.RedisKey;
import net.ws.sys.enums.SysDataType;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

import java.util.List;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;

/**
 * 系统模块数据变化侦听器
 *
 * @author xuyuxiang
 * @date 2023/3/3 10:44
 **/
@Component
public class SysDataChangeListener implements CommonDataChangeListener {

    @Resource
    @Qualifier("strRedisTemplate")
    private RedisTemplate<String, String> strRedisTemplate;

    @Override
    public void doAddWithDataIdList(String dataType, List<String> dataIdList) {
        // 如果检测到机构增加，则将机构的数据缓存清除
        if (dataType.equals(SysDataType.ORG.getValue())) {
            strRedisTemplate.delete(RedisKey.ORG_CACHE_ALL_KEY.buildKey());
            // 并将该机构加入到当前登录用户的数据范围缓存
            LoginUser loginUser = StpLoginUserUtil.getLoginUser();
            loginUser.getDataScopeList().forEach(dataScope -> dataScope.getDataScope().addAll(dataIdList));
            loginUser.setDataScopeList(loginUser.getDataScopeList());
            // 重新缓存当前登录用户信息
            StpUtil.getTokenSession().set("loginUser", JSONUtil.toJsonStr(loginUser));
        }
        // 如果检测到用户增加，则将用户数据缓存清除
        if (dataType.equals(SysDataType.USER.getValue())) {
            strRedisTemplate.delete(RedisKey.USER_CACHE_ALL_KEY.buildKey());
        }
    }

    @Override
    public void doAddWithDataList(String dataType, JSONArray jsonArray) {
        // 此处可做额外处理
    }

    @Override
    public void doUpdateWithDataIdList(String dataType, List<String> dataIdList) {
        // 如果检测到机构更新，则将机构的数据缓存清除
        if (dataType.equals(SysDataType.ORG.getValue())) {
            strRedisTemplate.delete(RedisKey.ORG_CACHE_ALL_KEY.buildKey());
        }
        // 如果检测到用户更新，则将用户数据缓存清除
        if (dataType.equals(SysDataType.USER.getValue())) {
            strRedisTemplate.delete(RedisKey.USER_CACHE_ALL_KEY.buildKey());
        }
    }

    @Override
    public void doUpdateWithDataList(String dataType, JSONArray jsonArray) {
        // 此处可做额外处理
    }

    @Override
    public void doDeleteWithDataIdList(String dataType, List<String> dataIdList) {
        // 如果检测到机构增加，则将机构的数据缓存清除
        if (dataType.equals(SysDataType.ORG.getValue())) {
            strRedisTemplate.delete(RedisKey.ORG_CACHE_ALL_KEY.buildKey());
        }
        // 如果检测到用户删除，则将用户数据缓存清除，并将这些用户踢下线
        if (dataType.equals(SysDataType.USER.getValue())) {
            strRedisTemplate.delete(RedisKey.USER_CACHE_ALL_KEY.buildKey());
            dataIdList.forEach(StpUtil::kickout);
        }
    }
}

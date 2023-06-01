/*
 * Copyright [2022] [https://www.xiaonuo.vip]
 *
 * Snowy采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：
 *
 * 1.请不要删除和修改根目录下的LICENSE文件。
 * 2.请不要删除和修改Snowy源码头部的版权声明。
 * 3.本项目代码可免费商业使用，商业使用请保留源码和相关描述文件的项目出处，作者声明等。
 * 4.分发源码时候，请注明软件出处 https://www.xiaonuo.vip
 * 5.不可二次分发开源参与同类竞品，如有想法可联系团队xiaonuobase@qq.com商议合作。
 * 6.若您的项目无法满足以上几点，需要更多功能代码，获取Snowy商业授权许可，请在官网购买授权，地址为 https://www.xiaonuo.vip
 */
package net.ws.sys.listener;

import net.ws.auth.dto.LoginUserDto;
import net.ws.auth.util.StpLoginUserUtil;
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
            LoginUserDto loginUser = StpLoginUserUtil.getLoginUser();
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

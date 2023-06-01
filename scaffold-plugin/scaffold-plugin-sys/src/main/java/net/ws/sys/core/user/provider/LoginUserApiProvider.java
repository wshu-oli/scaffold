package net.ws.sys.core.user.provider;

import net.ws.auth.api.LoginUserApi;
import net.ws.auth.core.dto.ClientLogin;
import net.ws.auth.core.dto.LoginUser;
import net.ws.sys.core.user.service.SysUserService;

import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * 登录用户API接口实现类
 *
 * @author xuyuxiang
 * @date 2022/4/29 13:36
 **/
@Service("loginUserApi")
public class LoginUserApiProvider implements LoginUserApi {

    @Resource
    private SysUserService sysUserService;

    /**
     * 根据id获取B端用户信息，查不到则返回null
     *
     * @author xuyuxiang
     * @date 2022/3/10 16:14
     **/
    @Override
    public LoginUser getUserById(String id) {
        return sysUserService.getUserById(id);
    }

    /**
     * 不实现C端用户信息
     *
     * @author xuyuxiang
     * @date 2022/3/10 16:14
     **/
    @Override
    public ClientLogin getClientUserById(String id) {
        return null;
    }

    /**
     * 根据账号获取B端用户信息，查不到则返回null
     *
     * @author xuyuxiang
     * @date 2021/12/28 15:35
     **/
    @Override
    public SysLoginUser getUserByAccount(String account) {
        return sysUserService.getUserByAccount(account);
    }

    /**
     * 不实现C端用户信息
     *
     * @author xuyuxiang
     * @date 2022/7/8 10:36
     **/
    @Override
    public ClientLogin getClientUserByAccount(String account) {
        return null;
    }

    /**
     * 根据手机号获取B端用户信息，查不到则返回null
     *
     * @author xuyuxiang
     * @date 2022/8/25 14:09
     **/
    @Override
    public LoginUser getUserByPhone(String phone) {
        return sysUserService.getUserByPhone(phone);
    }

    /**
     * 不实现C端用户信息
     *
     * @author xuyuxiang
     * @date 2022/8/25 14:09
     **/
    @Override
    public ClientLogin getClientUserByPhone(String phone) {
        return null;
    }

    /**
     * 根据用户id获取用户集合
     *
     * @author xuyuxiang
     * @date 2022/4/27 22:53
     */
    @Override
    public List<JSONObject> listUserByUserIdList(List<String> userIdList) {
        return sysUserService.listByIds(userIdList).stream().map(JSONUtil::parseObj).collect(Collectors.toList());
    }

    /**
     * 根据用户id获取角色集合
     *
     * @author xuyuxiang
     * @date 2022/4/27 22:53
     */
    @Override
    public List<JSONObject> getRoleListByUserId(String userId) {
        return sysUserService.getRoleList(userId);
    }

    /**
     * 根据角色id和用户id集合获取按钮码集合
     *
     * @author xuyuxiang
     * @date 2022/4/27 22:54
     */
    @Override
    public List<String> getButtonCodeListListByUserAndRoleIdList(List<String> userAndRoleIdList) {
        return sysUserService.getButtonCodeList(userAndRoleIdList);
    }

    /**
     * 根据角色id和用户id集合获取移动端按钮码集合
     *
     * @author xuyuxiang
     * @date 2022/4/27 22:54
     */
    @Override
    public List<String> getMobileButtonCodeListListByUserIdAndRoleIdList(List<String> userAndRoleIdList) {
        return sysUserService.getMobileButtonCodeList(userAndRoleIdList);
    }

    /**
     * 根据角色id和用户id集合获取权限集合
     *
     * @author xuyuxiang
     * @date 2022/4/27 22:54
     */
    @Override
    public List<JSONObject> getPermissionListByUserIdAndRoleIdList(List<String> userAndRoleIdList, String orgId) {
        return sysUserService.getPermissionList(userAndRoleIdList, orgId);
    }

    /**
     * 更新用户的登录时间和登录ip等信息
     *
     * @author xuyuxiang
     * @date 2022/4/27 22:57
     */
    @Override
    public void updateUserLoginInfo(String userId, String device) {
        sysUserService.updateUserLoginInfo(userId, device);
    }
}
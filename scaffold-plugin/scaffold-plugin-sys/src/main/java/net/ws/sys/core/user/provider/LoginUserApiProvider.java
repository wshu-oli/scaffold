package net.ws.sys.core.user.provider;

import net.ws.auth.api.LoginUserApi;
import net.ws.auth.core.pojo.ClientLogin;
import net.ws.auth.core.pojo.LoginUser;
import net.ws.sys.core.user.service.SysUserService;

import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * 登录用户API接口实现类
 **/
@Service("loginUserApi")
public class LoginUserApiProvider implements LoginUserApi {

    @Resource
    private SysUserService sysUserService;

    /**
     * 根据id获取B端用户信息，查不到则返回null
     **/
    @Override
    public LoginUser getUserById(Long id) {
        return sysUserService.getUserById(id);
    }

    /**
     * 不实现C端用户信息
     **/
    @Override
    public ClientLogin getClientUserById(Long id) {
        return null;
    }

    /**
     * 根据账号获取B端用户信息，查不到则返回null
     **/
    @Override
    public LoginUser getUserByAccount(String account) {
        return sysUserService.getUserByAccount(account);
    }

    /**
     * 不实现C端用户信息
     **/
    @Override
    public ClientLogin getClientUserByAccount(String account) {
        return null;
    }

    /**
     * 根据手机号获取B端用户信息，查不到则返回null
     **/
    @Override
    public LoginUser getUserByPhone(String phone) {
        return sysUserService.getUserByPhone(phone);
    }

    /**
     * 不实现C端用户信息
     **/
    @Override
    public ClientLogin getClientUserByPhone(String phone) {
        return null;
    }

    /**
     * 根据用户id获取用户集合
     */
    @Override
    public List<JSONObject> listUserByUserIdList(List<Long> userIdList) {
        return sysUserService.listByIds(userIdList).stream().map(JSONUtil::parseObj).collect(Collectors.toList());
    }

    /**
     * 根据用户id获取角色集合
     */
    @Override
    public List<JSONObject> getRoleListByUserId(Long userId) {
        //return sysUserService.getRoleList(userId);
        return null;
    }

    /**
     * 根据角色id和用户id集合获取按钮码集合
     */
    @Override
    public List<String> getButtonCodeListListByUserAndRoleIdList(List<Long> userAndRoleIdList) {
        //return sysUserService.getButtonCodeList(userAndRoleIdList);
        return null;
    }

    /**
     * 根据角色id和用户id集合获取移动端按钮码集合
     */
    @Override
    public List<String> getMobileButtonCodeListListByUserIdAndRoleIdList(List<Long> userAndRoleIdList) {
        //return sysUserService.getMobileButtonCodeList(userAndRoleIdList);
        return null;
    }

    /**
     * 根据角色id和用户id集合获取权限集合
     */
    @Override
    public List<JSONObject> getPermissionListByUserIdAndRoleIdList(List<Long> userAndRoleIdList, Long orgId) {
        //return sysUserService.getPermissionList(userAndRoleIdList, orgId);
        return null;
    }

    /**
     * 更新用户的登录时间和登录ip等信息
     */
    @Override
    public void updateUserLoginInfo(Long userId, String device) {
        //sysUserService.updateUserLoginInfo(userId, device);
    }
}
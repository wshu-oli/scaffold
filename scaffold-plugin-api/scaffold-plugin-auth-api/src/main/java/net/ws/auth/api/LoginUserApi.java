package net.ws.auth.api;

import net.ws.auth.core.pojo.ClientLogin;
import net.ws.auth.core.pojo.LoginUser;

import java.util.List;

import cn.hutool.json.JSONObject;

/**
 * 登录用户API，由其他模块实现
 *
 * @author xuyuxiang
 * @date 2021/12/23 21:48
 */
public interface LoginUserApi {

    /**
     * 根据id获取B端用户信息，查不到则返回null
     *
     * @author xuyuxiang
     * @date 2022/3/10 16:14
     **/
    LoginUser getUserById(Long id);

    /**
     * 根据id获取C端用户信息，查不到则返回null
     *
     * @author xuyuxiang
     * @date 2022/3/10 16:14
     **/
    ClientLogin getClientUserById(Long id);

    /**
     * 根据账号获取B端用户信息，查不到则返回null
     *
     * @author xuyuxiang
     * @date 2022/3/10 16:14
     **/
    LoginUser getUserByAccount(String account);

    /**
     * 根据账号获取C端用户信息，查不到则返回null
     *
     * @author xuyuxiang
     * @date 2022/3/10 16:14
     **/
    ClientLogin getClientUserByAccount(String account);

    /**
     * 根据手机号获取B端用户信息，查不到则返回null
     *
     * @author xuyuxiang
     * @date 2022/3/10 16:14
     **/
    LoginUser getUserByPhone(String phone);

    /**
     * 根据手机号获取C端用户信息，查不到则返回null
     *
     * @author xuyuxiang
     * @date 2022/3/10 16:14
     **/
    ClientLogin getClientUserByPhone(String phone);

    /**
     * 根据用户id获取用户集合
     *
     * @author xuyuxiang
     * @date 2022/4/27 22:53
     */
    List<JSONObject> listUserByUserIdList(List<Long> userIdList);

    /**
     * 根据用户id获取角色集合
     *
     * @author xuyuxiang
     * @date 2022/4/27 22:53
     */
    List<JSONObject> getRoleListByUserId(Long userId);

    /**
     * 根据角色id和用户id集合获取按钮码集合
     *
     * @author xuyuxiang
     * @date 2022/4/27 22:54
     */
    List<String> getButtonCodeListListByUserAndRoleIdList(List<Long> userAndRoleIdList);

    /**
     * 根据角色id和用户id集合获取移动端按钮码集合
     *
     * @author xuyuxiang
     * @date 2022/4/27 22:54
     */
    List<String> getMobileButtonCodeListListByUserIdAndRoleIdList(List<Long> userAndRoleIdList);

    /**
     * 根据角色id和用户id集合获取权限集合
     *
     * @author xuyuxiang
     * @date 2022/4/27 22:54
     */
    List<JSONObject> getPermissionListByUserIdAndRoleIdList(List<Long> userAndRoleIdList, Long orgId);

    /**
     * 更新用户的登录时间和登录ip等信息
     *
     * @author xuyuxiang
     * @date 2022/4/27 22:57
     */
    void updateUserLoginInfo(Long userId, String device);
}

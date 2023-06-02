package net.ws.sys.core.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import net.ws.sys.core.user.entity.SysUser;
import net.ws.sys.core.user.request.SysUserAddRequest;
import net.ws.sys.core.user.request.SysUserPageRequest;
import net.ws.sys.core.user.resp.SysLoginUserResp;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author Oliver
 * @since 2023-06-01
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 根据id获取用户信息，查不到则返回null
     */
    SysLoginUserResp getUserById(Long id);

    /**
     * 根据账户获取用户信息，查不到则返回null
     */
    SysLoginUserResp getUserByAccount(String account);

    /**
     * 根据手机号获取用户信息，查不到则返回null
     */
    SysLoginUserResp getUserByPhone(String phone);

    /**
     * 根据邮箱获取用户信息，查不到则返回null
     */
    SysLoginUserResp getUserByEmail(String email);

    /**
     * 获取用户分页
     */
    Page<SysUser> page(SysUserPageRequest request);

    /**
     * 添加用户
     */
    void add(SysUserAddRequest request);

}

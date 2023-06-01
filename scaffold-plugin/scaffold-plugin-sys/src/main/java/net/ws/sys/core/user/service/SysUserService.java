package net.ws.sys.core.user.service;

import com.baomidou.mybatisplus.extension.service.IService;

import net.ws.auth.core.dto.LoginUser;
import net.ws.sys.core.user.entity.SysUser;

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
    LoginUser getById(Long id);

}

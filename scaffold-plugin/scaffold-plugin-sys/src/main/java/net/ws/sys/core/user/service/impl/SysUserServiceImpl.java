package net.ws.sys.core.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import net.ws.sys.core.user.entity.SysUser;
import net.ws.sys.core.user.mapper.SysUserMapper;
import net.ws.sys.core.user.service.SysUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author Oliver
 * @since 2023-06-01
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {


    @Override
    public LoginUserDto getById(Long id) {
        SysUser sysUser = this.baseMapper.selectById(id);
        return null;
    }
}

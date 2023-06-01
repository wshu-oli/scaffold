package net.ws.sys.core.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import net.ws.sys.core.user.entity.SysUser;
import net.ws.sys.core.user.mapper.SysUserMapper;
import net.ws.sys.core.user.resp.SysLoginUserResp;
import net.ws.sys.core.user.service.SysUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import cn.hutool.core.bean.BeanUtil;
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
    public SysLoginUserResp getUserById(Long id) {
        SysUser sysUser = this.getById(id);
        if (Objects.nonNull(sysUser)) {
            return BeanUtil.copyProperties(sysUser, SysLoginUserResp.class);
        }
        return null;
    }

    @Override
    public SysLoginUserResp getUserByAccount(String account) {
        SysUser sysUser = this.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getAccount, account));
        if (Objects.nonNull(sysUser)) {
            return BeanUtil.copyProperties(sysUser, SysLoginUserResp.class);
        }
        return null;
    }

    @Override
    public SysLoginUserResp getUserByPhone(String phone) {
        /*SysUser one = this.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getPhone,
                CommonCryptogramUtil.doSm4CbcEncrypt(phone)));*/
        return null;
    }

    @Override
    public SysLoginUserResp getUserByEmail(String email) {
        SysUser sysUser = this.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getEmail, email));
        if (Objects.nonNull(sysUser)) {
            return BeanUtil.copyProperties(sysUser, SysLoginUserResp.class);
        }
        return null;
    }
}

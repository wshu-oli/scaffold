package net.ws.sys.core.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import net.ws.auth.core.enums.UserStatus;
import net.ws.common.exception.CommonException;
import net.ws.common.listener.CommonDataChangeEventCenter;
import net.ws.common.util.*;
import net.ws.sys.core.user.entity.SysUser;
import net.ws.sys.core.user.mapper.SysUserMapper;
import net.ws.sys.core.user.request.SysUserAddRequest;
import net.ws.sys.core.user.request.SysUserPageRequest;
import net.ws.sys.core.user.resp.SysLoginUserResp;
import net.ws.sys.core.user.service.SysUserService;
import net.ws.sys.enums.CommonSortOrderEnum;
import net.ws.sys.enums.SysDataType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.*;
import cn.hutool.json.JSONUtil;
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
        SysUser sysUser = this.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getPhone,
                CommonCryptogramUtil.encrypt(phone)));
        if (Objects.nonNull(sysUser)) {
            return BeanUtil.copyProperties(sysUser, SysLoginUserResp.class);
        }
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

    @Override
    public Page<SysUser> page(SysUserPageRequest request) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        // 关键词
        String searchKey = request.getSearchKey();
        if (ObjectUtil.isNotEmpty(searchKey)) {
            wrapper.lambda().like(SysUser::getAccount, searchKey).or().like(SysUser::getName, searchKey);
        }
        //所属组织
        Long orgId = request.getOrgId();
        wrapper.lambda().eq(ObjectUtil.isNotEmpty(orgId), SysUser::getOrgId, orgId);
        //用户状态
        UserStatus userStatus = request.getUserStatus();
        wrapper.lambda().eq(ObjectUtil.isNotEmpty(userStatus), SysUser::getStatus, userStatus);
        //排序
        String sortField = request.getSortField();
        CommonSortOrderEnum sortOrder = request.getSortOrder();
        if (ObjectUtil.isAllNotEmpty(sortField, sortOrder)) {
            CommonSortOrderEnum.validate(sortOrder);
            wrapper.orderBy(true, sortOrder.equals(CommonSortOrderEnum.ASC), StrUtil.toUnderlineCase(sortField));
        } else {
            wrapper.lambda().orderByAsc(SysUser::getSortCode).orderByDesc(SysUser::getModifyTime);
        }
        return this.page(CommonPageUtil.defaultPage(), wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SysUserAddRequest request) {
        checkAddParam(request);
        SysUser sysUser = BeanUtil.toBean(request, SysUser.class);
        if (ObjectUtil.isEmpty(sysUser.getAvatar())) {
            // 设置默认头像
            sysUser.setAvatar(CommonAvatarUtil.generateImg(sysUser.getName()));
        }
        // 设置默认密码
        /*sysUser.setPassword(CommonCryptogramUtil.encrypt(devConfigApi.getValueByKey
        (SNOWY_SYS_DEFAULT_PASSWORD_KEY)));
        // 设置状态
        sysUser.setUserStatus(SysUserStatusEnum.ENABLE.getValue());
        this.save(sysUser);*/

        // 发布增加事件
        CommonDataChangeEventCenter.doAddWithData(SysDataType.USER.getValue(), JSONUtil.createArray().put(sysUser));
    }

    /**
     * 校验创建用户参数
     */
    private void checkAddParam(SysUserAddRequest request) {
        String account = request.getAccount();
        String phone = request.getPhone();
        String email = request.getEmail();
        if (this.count(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getAccount, account)) > 0) {
            throw new CommonException("存在重复的账号，账号为：{}", account);
        }
        if (ObjectUtil.isNotEmpty(phone)) {
            if (!PhoneUtil.isMobile(phone)) {
                throw new CommonException("手机号码：{}格式错误", request.getPhone());
            }
            if (this.count(new LambdaQueryWrapper<SysUser>()
                    .eq(SysUser::getPhone, phone)) > 0) {
                throw new CommonException("存在重复的手机号，手机号为：{}", request.getPhone());
            }
        }
        if (ObjectUtil.isNotEmpty(email)) {
            if (!CommonEmailUtil.isEmail(email)) {
                throw new CommonException("邮箱：{}格式错误", email);
            }
            if (this.count(new LambdaQueryWrapper<SysUser>()
                    .eq(SysUser::getEmail, email)) > 0) {
                throw new CommonException("存在重复的邮箱，邮箱为：{}", email);
            }
        }
    }

}

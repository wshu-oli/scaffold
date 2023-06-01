package net.ws.sys.core.user.resp;

import net.ws.auth.core.enums.UserStatus;
import net.ws.auth.core.pojo.LoginUser;

/**
 * 登录用户对象
 **/
public class SysLoginUserResp extends LoginUser {

    /**
     * 实现是否可以登录
     **/
    @Override
    public Boolean getEnabled() {
        // 仅判断状态是否正常，可自行扩展
        return getUserStatus().equals(UserStatus.ENABLE);
    }
}

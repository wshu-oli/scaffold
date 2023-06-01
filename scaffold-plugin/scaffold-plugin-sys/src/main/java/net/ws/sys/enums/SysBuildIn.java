package net.ws.sys.enums;

import lombok.Getter;

/**
 * 系统内置的不可删除的标识枚举
 **/
@Getter
public enum SysBuildIn {

    /** 超管用户账号 */
    BUILD_IN_USER_ACCOUNT("superAdmin", "超管"),

    /** 超管角色编码 */
    BUILD_IN_ROLE_CODE("superAdmin", "超管"),

    /** 系统内置模块编码 */
    BUILD_IN_MODULE_CODE("system", "系统内置"),

    /** 系统内置单页面编码 */
    BUILD_IN_SPA_CODE("system", "系统内置");

    private final String value;

    private final String name;

    SysBuildIn(String value, String name) {
        this.value = value;
        this.name = name;
    }
}

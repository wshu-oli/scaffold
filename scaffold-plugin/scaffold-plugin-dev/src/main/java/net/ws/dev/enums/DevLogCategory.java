package net.ws.dev.enums;

import lombok.Getter;

/**
 * 日志分类枚举
 **/
@Getter
public enum DevLogCategory {

    /** 操作日志 */
    OPERATE("OPERATE"),

    /** 异常日志 */
    EXCEPTION("EXCEPTION"),

    /** 登录日志 */
    LOGIN("LOGIN"),

    /** 登出日志 */
    LOGOUT("LOGOUT");

    private final String value;

    DevLogCategory(String value) {
        this.value = value;
    }
}

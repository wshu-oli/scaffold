package net.ws.auth.core.enums;

import lombok.Getter;

/**
 * 用户状态
 **/
@Getter
public enum UserStatus {

    NORMAL(0, "正常"),
    DISABLE(1, "禁用"),
    ;
    private final int value;
    private final String name;

    UserStatus(int value, String name) {
        this.value = value;
        this.name = name;
    }
}

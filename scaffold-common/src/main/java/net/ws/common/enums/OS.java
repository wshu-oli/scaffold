package net.ws.common.enums;

import lombok.Getter;

/**
 * 操作系统枚举
 **/
@Getter
public enum OS {

    WINDOWS("windows"),
    IOS("ios"),
    MAC("mac"),
    ANDROID("android");

    private final String value;

    OS(String value) {
        this.value = value;
    }
}

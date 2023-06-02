package net.ws.dev.enums;

import lombok.Getter;

/**
 * 日志执行状态枚举
 **/
@Getter
public enum DevLogExeStatus {

    /** 成功 */
    SUCCESS("SUCCESS"),

    /** 失败 */
    FAIL("FAIL");

    private final String value;

    DevLogExeStatus(String value) {
        this.value = value;
    }
}

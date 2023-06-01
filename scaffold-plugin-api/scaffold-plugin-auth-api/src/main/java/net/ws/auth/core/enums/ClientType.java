package net.ws.auth.core.enums;

import net.ws.common.exception.CommonException;

import lombok.Getter;

/**
 * 登录端类型枚举
 **/
@Getter
public enum ClientType {

    /**
     * B端用户
     */
    B("B"),

    /**
     * C端用户
     */
    C("C");

    private final String value;

    ClientType(String value) {
        this.value = value;
    }

    public static void validate(String value) {
        boolean flag = B.getValue().equals(value) || C.getValue().equals(value);
        if(!flag) {
            throw new CommonException("不支持的登录端类型：{}", value);
        }
    }
}

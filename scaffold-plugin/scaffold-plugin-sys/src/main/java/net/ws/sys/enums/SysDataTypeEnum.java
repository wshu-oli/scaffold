package net.ws.sys.enums;

import lombok.Getter;

/**
 * 系统模块数据类型枚举
 **/
@Getter
public enum SysDataTypeEnum {

    /**
     * 组织
     */
    ORG("ORG"),

    /**
     * 职位
     */
    POSITION("POSITION"),

    /**
     * 资源
     */
    RESOURCE("RESOURCE"),

    /**
     * 角色
     */
    ROLE("ROLE"),

    /**
     * 用户
     */
    USER("USER");

    private final String value;

    SysDataTypeEnum(String value) {
        this.value = value;
    }

}

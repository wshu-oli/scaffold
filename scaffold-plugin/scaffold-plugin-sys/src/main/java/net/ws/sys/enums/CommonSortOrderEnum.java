package net.ws.sys.enums;

import net.ws.common.exception.CommonException;

import lombok.Getter;

/**
 * 通用排序方式枚举
 **/
@Getter
public enum CommonSortOrderEnum {

    /** 升序 */
    ASC("ASCEND"),

    /** 降序 */
    DESC("DESCEND");

    private final String value;

    CommonSortOrderEnum(String value) {
        this.value = value;
    }

    public static void validate(CommonSortOrderEnum value) {
        boolean flag = ASC.equals(value) || DESC.equals(value);
        if(!flag) {
            throw new CommonException("不支持该排序方式：{}", value);
        }
    }
}

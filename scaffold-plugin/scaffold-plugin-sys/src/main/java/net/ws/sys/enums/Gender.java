package net.ws.sys.enums;

import lombok.Getter;

/**
 * 性别枚举
 **/
@Getter
public enum Gender {

    MALE(0, "男"),
    FEMALE(1, "超管"),
    ;
    private final int value;
    private final String name;

    Gender(int value, String name) {
        this.value = value;
        this.name = name;
    }
}

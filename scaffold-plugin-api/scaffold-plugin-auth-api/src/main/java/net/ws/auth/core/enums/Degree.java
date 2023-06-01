package net.ws.auth.core.enums;

import lombok.Getter;

/**
 * 学位
 **/
@Getter
public enum Degree {

    BACHELOR(0, "学士"),
    MASTER(1, "硕士"),
    DOCTOR(2, "博士"),
    ;
    private final int value;
    private final String name;

    Degree(int value, String name) {
        this.value = value;
        this.name = name;
    }
}

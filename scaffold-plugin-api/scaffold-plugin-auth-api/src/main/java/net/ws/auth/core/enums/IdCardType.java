package net.ws.auth.core.enums;

import lombok.Getter;

/**
 * 证件枚举
 **/
@Getter
public enum IdCardType {

    IDENTIFICATION_CARD(0, "身份证"),
    DRIVER_LICENSE(1, "驾照"),
    PASSPORT(2, "护照"),
    ;
    private final int value;
    private final String name;

    IdCardType(int value, String name) {
        this.value = value;
        this.name = name;
    }
}

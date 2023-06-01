package net.ws.sys.enums;

import lombok.Getter;

/**
 * 政治面貌枚举
 **/
@Getter
public enum PoliticalAffiliation {

    MASSES(0, "群众"),
    CYL(1, "共青团员"),
    CCP(2, "共产党员"),
    ;
    private final int value;
    private final String name;

    PoliticalAffiliation(int value, String name) {
        this.value = value;
        this.name = name;
    }
}

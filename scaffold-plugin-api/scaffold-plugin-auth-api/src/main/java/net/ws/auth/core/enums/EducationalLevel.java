package net.ws.auth.core.enums;

import lombok.Getter;

/**
 * 文化程度枚举
 **/
@Getter
public enum EducationalLevel {

    ELEMENTARY(0, "小学"),
    MIDDLE(1, "初中"),
    HIGH(2, "高中"),
    COLLEGE(3, "大专"),
    UNDERGRADUATE(4, "本科"),
    MASTER(5, "硕士"),
    DOCTORAL(6, "博士"),
    POSTDOCTORAL(7, "博士后"),
    ;
    private final int value;
    private final String name;

    EducationalLevel(int value, String name) {
        this.value = value;
        this.name = name;
    }
}

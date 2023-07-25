package com.wty.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeEnums {
    NORMAL("NORMAL"),
    COMMON("COMMON"),
    DEFAULT("DEFAULT"),
    ;
    private String code;
}

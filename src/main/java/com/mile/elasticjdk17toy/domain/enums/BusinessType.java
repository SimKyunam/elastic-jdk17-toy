package com.mile.elasticjdk17toy.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum BusinessType {

    FOOD("음식", "F"),
    HEALTH("건강", "H");

    private final String codeName;
    private final String code;
}

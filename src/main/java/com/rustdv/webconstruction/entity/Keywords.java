package com.rustdv.webconstruction.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum Keywords {

    BRICKLAYER("каменщик"),
    CARPENTER("столяр"),
    WINDOW_FITTER("монтажник окон"),
    PAINTER("маляр"),
    JOINER("плотник"),
    INSTALLER("монтажник"),
    FOREMAN("прораб"),
    CRANE_OPERATOR("крановщик"),
    ESTIMATOR("сметчик"),
    FITTER("арматурщик"),
    COOPER("бондарь"),
    CONCRETE_WORKER("бетонщик"),
    FINISHER("отделочник"),
    TILER("плиточник"),
    TURNKEY_HOUSE("дом под ключ");

    private final String name;

}

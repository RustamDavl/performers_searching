package com.rustdv.webconstruction.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum Measurements {

    SERVICE("за услугу"),
    SQ_M("за кв метр"),
    M("за метр"),
    H("за час"),
    KM("за км"),
    UNIT("за"),
    DAY("за единицу"),
    CUBIC_M("за куб м");

    private final String name;


}

package com.rustdv.webconstruction.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Experience {

    LESS_ONE("Меньше года"),
    ONE("1 год"),
    TWO("2 года"),
    THREE("3 года"),
    FOUR("4 года"),
    FIVE("5 лет"),
    SIX("6 лет"),
    SEVEN("7 лет"),
    EIGHT("8 лет"),
    NINE("9 лет"),
    TEN("10 лет"),
    MORE_TEN("Больше 10 лет");

    private String name;
}

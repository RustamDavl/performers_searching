package com.rustdv.webconstruction.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Roles {

    CUSTOMER("Работодатель"),
    EXECUTOR("Специалист");
    private final String name;

    public static Roles getEnumByName(String role) {

        return switch (role) {
            case "Работодатель" -> Roles.CUSTOMER;

            case "Специалист" -> Roles.EXECUTOR;

            default -> null;
        };

    }
}

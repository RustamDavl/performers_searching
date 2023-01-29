package com.rustdv.webconstruction.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Team {

    ALONE("работаю один"),
    ALONE_TEAM("работаю один или в команде"),
    TEAM("работаю в команде");

    @Getter
    private final String description;

    public static Team getEnumByName(String name) {
        return switch (name) {
            case "работаю один" -> ALONE;
            case "работаю один или в команде" -> ALONE_TEAM;
            case "работаю в команде" -> TEAM;
            default -> null;
        };
    }
}

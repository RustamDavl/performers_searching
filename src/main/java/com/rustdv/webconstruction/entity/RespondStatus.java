package com.rustdv.webconstruction.entity;

import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

public enum RespondStatus {
    ACCEPTED,
    FROM,
    TO,
    FINISHED,
    NONE,
    ANY,
    TO_OR_NONE,
    EXCEPT_TO;

    public static RespondStatus getStatusByFilter(String filter) {
        return switch (filter) {
            case "accepted" -> ACCEPTED;
            case "notaccepted" -> TO;
            case "finished" -> FINISHED;
            default -> {
                throw new NoSuchElementException();
            }
        };

    }
}

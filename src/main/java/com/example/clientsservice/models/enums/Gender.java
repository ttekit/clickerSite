package com.example.clientsservice.models.enums;

import java.util.Arrays;

public enum Gender {
    NONE,
    MALE,
    FEMALE,
    DOG,
    CAT,
    IDE;

    public static String[] getNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }
}

package com.example.clientsservice.models.enums;

import java.util.Arrays;

public enum Gender {
    NONE,
    MALE,
    FEMALE,
    DOG,
    CAT,
    IDE;

    public static String[] getNames() {
        return Arrays.stream(Gender.class.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }
}

package com.side.cooktime.domain.model;

import java.util.regex.Pattern;

public class Validator {
    public static void notBlank(String input, String inputName) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(inputName + " is cannot be null or empty");
        }
    }

    public static void pattern(String REGEX, String input, String inputName) {
        if (!Pattern.compile(REGEX).matcher(input).matches()) {
            throw new IllegalArgumentException(inputName + " is invalid format");
        }
    }

    public static void length(int minimumLength, int inputLength, String inputName) {
        if (inputLength < minimumLength) {
            throw new IllegalArgumentException(inputName + " must be at least " + minimumLength + " characters long");
        }
    }

    public static void positive(int input, String inputName) {
        if (input <= 0) {
            throw new IllegalArgumentException(inputName + " must be positive value");
        }
    }
}

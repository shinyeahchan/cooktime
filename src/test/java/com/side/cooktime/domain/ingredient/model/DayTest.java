package com.side.cooktime.domain.ingredient.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DayTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    public void validateDay(final int day){
        assertThrows(IllegalArgumentException.class, () -> new Day(day), "올바른 날짜 값이 아닙니다.");
    }

}
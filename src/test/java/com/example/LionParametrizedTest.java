package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    private final String gender;
    private final boolean expected;
    private Feline feline;

    public LionParametrizedTest(String gender, boolean expected) {
        this.gender = gender;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getNewInstanceLionData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void newInstanceLion() throws Exception {
        Lion lion = new Lion(gender, feline);
        boolean actual = lion.doesHaveMane();

        assertEquals(expected, actual);
    }
}

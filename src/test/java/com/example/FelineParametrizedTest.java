package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {
    private final int kittensCount;
    private final int expected;

    public FelineParametrizedTest(int kittensCount, int expected) {
        this.kittensCount = kittensCount;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensTheArgData() {
        return new Object[][] {
                {1, 1},
                {2, 2},
                {3, 3}
        };
    }

    @Test
    public void getKittensTheArg() {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittensCount);

        assertEquals(expected, actual);
    }
}

package com.example;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineTest {
    private final int kittensCount;
    private final int expected;
    private Feline feline;

    public FelineTest(int kittensCount, int expected) {
        this.kittensCount = kittensCount;
        this.expected = expected;
    }

    @Before
    public void initNewFeline() {
        feline = new Feline();
    }

    @Test
    public void eatMeat() throws Exception {
        List<String> list = feline.eatMeat();
        int actual = list.size();
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    public void getFamily() {
        String actual = feline.getFamily();
        String expected = "Кошачьи";

        assertEquals(expected, actual);
    }

    @Test
    public void getKittens() {
        int actual = feline.getKittens();
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    public void getKittensTheArg() {
        int actual = feline.getKittens(kittensCount);

        assertEquals(expected, actual);
    }

    @Parameterized.Parameters
    public static Object[][] getKittensTheArgData() {
        return new Object[][] {
                {1, 1},
                {2, 2},
                {3, 3}
        };
    }
}

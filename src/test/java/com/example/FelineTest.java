package com.example;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    private Feline feline;

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
}

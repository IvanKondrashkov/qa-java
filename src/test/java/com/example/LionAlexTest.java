package com.example;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {
    private LionAlex alex;
    @Mock
    private Feline feline;

    @Before
    public void initNewLionAlex() throws Exception {
        alex = new LionAlex(feline);
    }

    @Test
    public void getKittens() {
        int actual = alex.getKittens();
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    public void getFriends() {
        List<String> list = alex.getFriends();
        int actual = list.size();
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    public void getPlaceOfLiving() {
        String actual = alex.getPlaceOfLiving();
        String expected = "Нью-Йоркский зоопарк";

        assertEquals(expected, actual);
    }

    @Test
    public void newInstanceLionAlex() {
        boolean actual = alex.doesHaveMane();

        assertTrue(actual);
    }
}

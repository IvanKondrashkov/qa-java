package com.example;

import java.util.List;
import org.mockito.Mock;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {
    private final String gender;
    private final boolean expected;
    private Lion lion;
    @Mock
    Feline feline;

    public LionTest(String gender, boolean expected) {
        this.gender = gender;
        this.expected = expected;
    }

    @Before
    public void openMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Before
    public void initNewLion() throws Exception {
        lion = new Lion(gender, feline);
    }

    @Test
    public void getKittens() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean actual = lion.doesHaveMane();

        assertTrue(actual);
    }

    @Test
    public void getFood() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void newInstanceLionCheckException() throws Exception {
        Lion lion = new Lion("invalidGender", feline);
    }

    @Test
    public void newInstanceLion() {
        boolean actual = lion.doesHaveMane();

        assertEquals(expected, actual);
    }

    @Parameterized.Parameters
    public static Object[][] getNewInstanceLionData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }
}

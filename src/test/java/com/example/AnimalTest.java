package com.example;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalTest {
    private final String animalKind;
    private final List<String> expected;
    private Animal animal;

    public AnimalTest(String animalKind, List<String> expected) {
        this.animalKind = animalKind;
        this.expected = expected;
    }

    @Before
    public void openMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Before
    public void initAnimalSpy() {
        animal = Mockito.spy(Animal.class);
    }

    @Test
    public void getFood() throws Exception {
        List<String> list = animal.getFood(animalKind);
        int actual = list.size();

        assertEquals(expected.size(), actual);
    }

    @Test(expected = Exception.class)
    public void getFoodCheckException() throws Exception {
        Mockito.when(animal.getFood(Mockito.anyString())).thenThrow(new Exception());
    }

    @Test
    public void getFamily() {
        String actual = animal.getFamily();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

        assertEquals(expected, actual);
    }

    @Parameterized.Parameters
    public static Object[][] getFoodData() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };
    }
}

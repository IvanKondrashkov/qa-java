package ru.yandex.praktikum;

import java.util.List;

public class LionAlex extends Lion {
    public static final String GENDER_ALEX = "Самец";
    private Feline feline;

    public LionAlex(Feline feline) throws Exception {
        super(GENDER_ALEX, feline);
        this.feline = feline;
    }

    @Override
    public int getKittens() {
        return feline.getKittens(0);
    }

    public List<String> getFriends() {
        return List.of("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }
}

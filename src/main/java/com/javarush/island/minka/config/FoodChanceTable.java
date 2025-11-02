package com.javarush.island.minka.config;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public final class FoodChanceTable {
    private static final Map<String, Map<String, Integer>> chanceMap = new HashMap<>();

//  Наверное всё же лучше всюду использовать английский.
//
// "Wolf", "Boa", "Fox", "Bear", "Eagle",
// "Horse", "Deer", "Rabbit", "Mouse", "Goat", "Sheep", "Boar", "Buffalo", "Duck", "Caterpillar", "Grass"

    static {
        chanceMap.put("Волк", Map.of(
                "Лошадь", 10,
                "Олень", 15,
                "Кролик", 60,
                "Мышь", 80,
                "Коза", 60,
                "Овца", 70,
                "Кабан", 15,
                "Буйвол", 10,
                "Утка", 40
        ));

        chanceMap.put("Удав", Map.of(
                "Лиса", 15,
                "Кролик", 20,
                "Мышь", 40,
                "Утка", 10
        ));

        chanceMap.put("Лиса", Map.of(
                "Кролик", 70,
                "Мышь", 90,
                "Утка", 60,
                "Гусеница", 40
        ));

        chanceMap.put("Медведь", Map.of(
                "Удав", 80,
                "Лошадь", 40,
                "Олень", 80,
                "Кролик", 80,
                "Мышь", 90,
                "Коза", 70,
                "Овца", 70,
                "Кабан", 50,
                "Буйвол", 20,
                "Утка", 10
        ));

        chanceMap.put("Орел", Map.of(
                "Лиса", 10,
                "Кролик", 90,
                "Мышь", 90,
                "Утка", 80
        ));

        chanceMap.put("Утка", Map.of(
                "Гусеница", 90,
                "Растения", 100
        ));

        chanceMap.put("Гусеница", Map.of());
    }

    public static int getChance(String predator, String prey) {
        return chanceMap.getOrDefault(predator, Map.of())
                .getOrDefault(prey, 0);
    }
}

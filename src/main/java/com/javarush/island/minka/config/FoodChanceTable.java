package com.javarush.island.minka.config;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public final class FoodChanceTable {
    private static final Map<String, Map<String, Integer>> chanceMap = new HashMap<>();

    static {
        chanceMap.put("Bear", Map.of(
                "Boa", 80,
                "Horse", 40,
                "Deer", 80,
                "Rabbit", 80,
                "Goat", 70,
                "Sheep", 70,
                "Boar", 50,
                "Buffalo", 20,
                "Duck", 10
        ));

        chanceMap.put("Boar", Map.of(
                "Boa", 80,
                "Horse", 40,
                "Deer", 80,
                "Goat", 70,
                "Sheep", 70,
                "Buffalo", 20,
                "Grass", 30
        ));

        chanceMap.put("Wolf", Map.of(
                "Horse", 10,
                "Deer", 15,
                "Rabbit", 60,
                "Mouse", 80,
                "Goat", 60,
                "Sheep", 70,
                "Boar", 15,
                "Buffalo", 10,
                "Duck", 40
        ));

        chanceMap.put("Fox", Map.of(
                "Rabbit", 70,
                "Mouse", 90,
                "Duck", 60,
                "Caterpillar", 40
        ));

        chanceMap.put("Boa", Map.of(
                "Fox", 15,
                "Rabbit", 20,
                "Mouse", 40,
                "Duck", 10
        ));

        chanceMap.put("Eagle", Map.of(
                "Fox", 30,
                "Rabbit", 70,
                "Mouse", 20,
                "Duck", 60
        ));

        chanceMap.put("Buffalo", Map.of(
                "Grass", 100
        ));

        chanceMap.put("Horse", Map.of(
                "Grass", 100
        ));

        chanceMap.put("Goat", Map.of(
                "Grass", 100
        ));

        chanceMap.put("Sheep", Map.of(
                "Grass", 100
        ));

        chanceMap.put("Deer", Map.of(
                "Grass", 100
        ));

        chanceMap.put("Rabbit", Map.of(
                "Grass", 100,
                "Caterpillar", 50
        ));

        chanceMap.put("Duck", Map.of(
                "Caterpillar", 80,
                "Grass", 90
        ));

        chanceMap.put("Caterpillar", Map.of(
                "Grass", 100
        ));
    }

    public static int getChance(String predator, String prey) {
        return chanceMap.getOrDefault(predator, Map.of())
                .getOrDefault(prey, 0);
    }
}

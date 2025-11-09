package com.javarush.island.minka.config;

import java.util.HashMap;
import java.util.Map;

public final class AnimalProperties {
    public static final Map<String, AnimalInfo> PROPERTIES = new HashMap<>();

    static {
        // species, weight, maxCountPerCell, maxSpeed, foodToSate, groupSize
        PROPERTIES.put("Wolf",  new AnimalInfo(50, 30, 3, 8, 5));
        PROPERTIES.put("Boa",   new AnimalInfo(15, 30, 1, 3, 1));
        PROPERTIES.put("Fox",   new AnimalInfo(8, 30, 2, 2, 1));
        PROPERTIES.put("Bear",  new AnimalInfo(500, 5, 2, 80, 1));
        PROPERTIES.put("Eagle", new AnimalInfo(6, 20, 3, 1, 1));
        PROPERTIES.put("Horse", new AnimalInfo(400, 20, 4, 60, 10));
        PROPERTIES.put("Deer",  new AnimalInfo(300, 20, 4, 50, 10));
        PROPERTIES.put("Rabbit",new AnimalInfo(2, 150, 2, 0.45, 20));
        PROPERTIES.put("Mouse", new AnimalInfo(0.05, 500, 1, 0.01, 50));
        PROPERTIES.put("Goat",  new AnimalInfo(60, 140, 3, 10, 15));
        PROPERTIES.put("Sheep", new AnimalInfo(70, 140, 3, 15, 15));
        PROPERTIES.put("Boar",  new AnimalInfo(400, 50, 2, 50, 8));
        PROPERTIES.put("Buffalo", new AnimalInfo(700, 10, 3, 100, 5));
        PROPERTIES.put("Duck",  new AnimalInfo(1, 200, 4, 0.15, 25));
        PROPERTIES.put("Caterpillar", new AnimalInfo(0.01, 1000, 0, 0, 100));
        PROPERTIES.put("Grass", new AnimalInfo(1, 200, 0, 0, 2));
    }

    public static AnimalInfo get(String species) {
        return PROPERTIES.get(species);
    }

    public static class AnimalInfo {
        public final double weight;
        public final int maxCountPerCell;
        public final int maxSpeed;
        public final double foodToSate;
        public final int groupSize;

        public AnimalInfo(double weight, int maxCountPerCell, int maxSpeed, double foodToSate, int groupSize) {
            this.weight = weight;
            this.maxCountPerCell = maxCountPerCell;
            this.maxSpeed = maxSpeed;
            this.foodToSate = foodToSate;
            this.groupSize = groupSize;
        }

        public int size() {
            return groupSize; //???
        }
    }
}

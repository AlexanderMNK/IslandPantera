package com.javarush.island.minka.config;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public final class AnimalProperties {
    public static final Map<String, OrganismLimits> PROPERTIES = new HashMap<>();

    static {
        /*species,      maxWeight, maxCountPerCell, maxSpeed, maxFoodToSate, maxGroupSize
        *               - лимиты, которые инициализируются в OrganismFactory, и находятся в PROTOTYPES */
        PROPERTIES.put("Wolf",  new OrganismLimits(50, 30, 3, 8, 5));
        PROPERTIES.put("Boa",   new OrganismLimits(15, 30, 1, 3, 1));
        PROPERTIES.put("Fox",   new OrganismLimits(8, 30, 2, 2, 1));
        PROPERTIES.put("Bear",  new OrganismLimits(500, 5, 2, 80, 1));
        PROPERTIES.put("Eagle", new OrganismLimits(6, 20, 3, 1, 1));
        PROPERTIES.put("Horse", new OrganismLimits(400, 20, 4, 60, 10));
        PROPERTIES.put("Deer",  new OrganismLimits(300, 20, 4, 50, 10));
        PROPERTIES.put("Rabbit",new OrganismLimits(2, 150, 2, 0.45, 20));
        PROPERTIES.put("Mouse", new OrganismLimits(0.05, 500, 1, 0.01, 50));
        PROPERTIES.put("Goat",  new OrganismLimits(60, 140, 3, 10, 15));
        PROPERTIES.put("Sheep", new OrganismLimits(70, 140, 3, 15, 15));
        PROPERTIES.put("Boar",  new OrganismLimits(400, 50, 2, 50, 8));
        PROPERTIES.put("Buffalo", new OrganismLimits(700, 10, 3, 100, 5));
        PROPERTIES.put("Duck",  new OrganismLimits(1, 200, 4, 0.15, 25));
        PROPERTIES.put("Caterpillar", new OrganismLimits(0.01, 1000, 0, 0, 100));
        PROPERTIES.put("Grass", new OrganismLimits(1, 200, 0, 0, 2));
    }

    public static OrganismLimits get(String species) {
        return PROPERTIES.get(species);
    }

    @Getter
    public static class OrganismLimits {
        public final double maxWeight;
        public final int maxCountPerCell;
        public final int maxSpeed;
        public final double maxFoodToSate;
        public final int maxGroupSize;

        public OrganismLimits(double maxWeight, int maxCountPerCell, int maxSpeed, double maxFoodToSate, int maxGroupSize) {
            this.maxWeight = maxWeight;
            this.maxCountPerCell = maxCountPerCell;
            this.maxSpeed = maxSpeed;
            this.maxFoodToSate = maxFoodToSate;
            this.maxGroupSize = maxGroupSize;
        }

//        public int size() {
//            return maxGroupSize; //???
//        }
    }
}

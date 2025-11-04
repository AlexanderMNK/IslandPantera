package com.javarush.island.minka.entity.organisms;

import com.javarush.island.minka.api.Reproducible;

@SuppressWarnings({"unused", "FieldCanBeLocal"})
public abstract class Organism implements Cloneable, Reproducible, AnimalConstants {
    private final String species;
    private final String icon;
    private final double weight;
    private final int maxValuePerCell;
    private final int groupSize;

    protected Organism(String species, String icon, double weight, int maxValue, int groupSize) {
        this.species = species;
        this.icon = icon;
        this.weight = weight;
        this.maxValuePerCell = maxValue;
        this.groupSize = groupSize;
    }

    @Override
    public Organism clone() {
        try {
            // Здесь необходимо выполнить глубокое копирование всех изменяемых полей объекта.
            return (Organism) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Organism{" +
                "species='" + species + '\'' +
                ", icon='" + icon + '\'' +
                ", weight=" + weight +
                ", maxValuePerCell=" + maxValuePerCell +
                ", groupSize=" + groupSize +
                '}';
    }
}

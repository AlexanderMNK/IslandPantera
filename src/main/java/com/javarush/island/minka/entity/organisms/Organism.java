package com.javarush.island.minka.entity.organisms;

import com.javarush.island.minka.api.Reproducible;

@SuppressWarnings({"unused", "FieldCanBeLocal"})
public abstract class Organism implements Cloneable, Reproducible {
    private final String species;
    private final String icon;
    private final double weight;
    private final int maxValue;

    protected Organism(String species, String icon, double weight, int maxValue) {
        this.species = species;
        this.icon = icon;
        this.weight = weight;
        this.maxValue = maxValue;
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
}

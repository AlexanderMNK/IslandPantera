package com.javarush.island.minka.entity.organisms.animals.predator;

import com.javarush.island.minka.entity.organisms.animals.Animal;

public abstract class Predator extends Animal {
    protected Predator(String species, String icon, double weight, int maxValue) {
        super(species, icon, weight, maxValue);
    }

    @Override
    public void eat() {
        // Логика охоты и питания мясом
    }

    @Override
    public void move() {
        System.out.println(getIcon() + " движется.");
    }

    @Override
    public void reproduce() {
        // Размножение хищника
    }

//    public void hunt() {
//
//    }
}

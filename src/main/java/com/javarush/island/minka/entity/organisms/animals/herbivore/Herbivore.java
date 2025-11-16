package com.javarush.island.minka.entity.organisms.animals.herbivore;

import com.javarush.island.minka.entity.organisms.animals.Animal;

public abstract class Herbivore extends Animal {
    protected Herbivore(String species, String icon, double weight, int maxValue) {
        super(species, icon, weight, maxValue);
    }

    @Override
    public void eat() {

    }

    @Override
    public void move() {
//        System.out.println(getIcon() + " движется.");
    }

    @Override
    public void reproduce() {

    }
}

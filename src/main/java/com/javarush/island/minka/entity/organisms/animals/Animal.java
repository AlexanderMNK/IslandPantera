package com.javarush.island.minka.entity.organisms.animals;

import com.javarush.island.minka.entity.organisms.Organism;

public class Animal extends Organism {
    protected Animal(String species, String icon, double weight, int maxValue) {
        super(species, icon, weight, maxValue);
    }

    @Override
    public void reproduce() {

    }
}

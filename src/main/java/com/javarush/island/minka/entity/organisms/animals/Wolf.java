package com.javarush.island.minka.entity.organisms.animals;

import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.organisms.Organism;

public class Wolf extends Animal {

    public Wolf() {
        super(WOLF, ICON_WOLF, AnimalProperties.get(WOLF).maxWeight, AnimalProperties.get(WOLF).maxCountPerCell);
    }

    @Override
    public void move() {

    }

    @Override
    public void reproduce() {

    }

    @Override
    public void eat() {

    }

    @Override
    public Organism clone() {
        return super.clone();
    }
}

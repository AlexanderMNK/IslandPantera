package com.javarush.island.minka.entity.organisms.animals;

import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.organisms.Organism;

public class Rabbit extends Animal {
    public Rabbit() {
        super(RABBIT, ICON_RABBIT, AnimalProperties.get(RABBIT).weight, AnimalProperties.get(RABBIT).maxCountPerCell, AnimalProperties.get(RABBIT).groupSize);
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

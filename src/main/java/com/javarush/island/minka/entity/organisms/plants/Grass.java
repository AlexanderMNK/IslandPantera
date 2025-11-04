package com.javarush.island.minka.entity.organisms.plants;

import com.javarush.island.minka.api.Movable;
import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.organisms.Organism;

public class Grass extends Organism implements Movable {
    public Grass() {
        super(GRASS, ICON_GRASS, AnimalProperties.get(GRASS).weight, AnimalProperties.get(GRASS).maxCountPerCell, AnimalProperties.get(GRASS).groupSize);
    }

    @Override
    public void reproduce() {

    }

    @Override
    public void move() {

    }
}

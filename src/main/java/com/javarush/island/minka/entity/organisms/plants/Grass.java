package com.javarush.island.minka.entity.organisms.plants;

import com.javarush.island.minka.api.Movable;
import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.organisms.Organism;

public class Grass extends Organism implements Movable {
    public Grass() {
        super(GRASS, ICON_GRASS, AnimalProperties.get(GRASS).maxWeight, AnimalProperties.get(GRASS).maxCountPerCell);
    }

    @Override
    public void reproduce() {

    }

    @Override
    public void move() {

    }
}

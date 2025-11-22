package com.javarush.island.minka.entity.organisms.animals.predator;

import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.organisms.Organism;

public class Boar extends Predator {
    public Boar() {
        super(BOAR, ICON_BOAR, AnimalProperties.get(BOAR).maxWeight, AnimalProperties.get(BOAR).maxCountPerCell);
    }

    @Override
    public Organism clone() {
        return super.clone();
    }
}


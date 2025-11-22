package com.javarush.island.minka.entity.organisms.animals.predator;

import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.organisms.Organism;

public class Eagle extends Predator {
    public Eagle() {
        super(EAGLE, ICON_EAGLE, AnimalProperties.get(EAGLE).maxWeight, AnimalProperties.get(EAGLE).maxCountPerCell);
    }

    @Override
    public Organism clone() {
        return super.clone();
    }
}


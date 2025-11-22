package com.javarush.island.minka.entity.organisms.animals.predator;

import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.organisms.Organism;

public class Bear extends Predator {
    public Bear() {
        super(BEAR, ICON_BEAR, AnimalProperties.get(BEAR).maxWeight, AnimalProperties.get(BEAR).maxCountPerCell);
    }

    @Override
    public Organism clone() {
        return super.clone();
    }
}

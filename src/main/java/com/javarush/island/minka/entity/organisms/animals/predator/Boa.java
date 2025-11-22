package com.javarush.island.minka.entity.organisms.animals.predator;

import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.organisms.Organism;

public class Boa extends Predator {
    public Boa() {
        super(BOA, ICON_BOA, AnimalProperties.get(BOA).maxWeight, AnimalProperties.get(BOA).maxCountPerCell);
    }

    @Override
    public Organism clone() {
        return super.clone();
    }
}

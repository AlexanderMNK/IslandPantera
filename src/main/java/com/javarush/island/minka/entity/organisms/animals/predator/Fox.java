package com.javarush.island.minka.entity.organisms.animals.predator;

import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.organisms.Organism;

public class Fox extends Predator {
    public Fox() {
        super(FOX, ICON_FOX, AnimalProperties.get(FOX).maxWeight, AnimalProperties.get(FOX).maxCountPerCell);
    }

    @Override
    public Organism clone() {
        return super.clone();
    }
}

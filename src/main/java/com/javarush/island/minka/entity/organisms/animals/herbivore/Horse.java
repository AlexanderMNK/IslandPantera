package com.javarush.island.minka.entity.organisms.animals.herbivore;

import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.organisms.Organism;

public class Horse extends Herbivore {
    public Horse() {
        super(HORSE, ICON_HORSE, AnimalProperties.get(HORSE).maxWeight, AnimalProperties.get(HORSE).maxCountPerCell);
    }

    @Override
    public Organism clone()  {
        return super.clone();
    }
}

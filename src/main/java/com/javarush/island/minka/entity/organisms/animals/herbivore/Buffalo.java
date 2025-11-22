package com.javarush.island.minka.entity.organisms.animals.herbivore;

import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.organisms.Organism;

public class Buffalo extends Herbivore {
    public Buffalo() {
        super(BUFFALO, ICON_BUFFALO, AnimalProperties.get(BUFFALO).maxWeight, AnimalProperties.get(BUFFALO).maxCountPerCell);
    }

    @Override
    public Organism clone()  {
        return super.clone();
    }
}

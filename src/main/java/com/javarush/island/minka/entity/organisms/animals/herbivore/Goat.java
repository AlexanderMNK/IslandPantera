package com.javarush.island.minka.entity.organisms.animals.herbivore;

import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.organisms.Organism;

public class Goat extends Herbivore {
    public Goat() {
        super(GOAT, ICON_GOAT, AnimalProperties.get(GOAT).maxWeight, AnimalProperties.get(GOAT).maxCountPerCell);
    }

    @Override
    public Organism clone()  {
        return super.clone();
    }
}

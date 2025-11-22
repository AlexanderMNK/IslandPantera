package com.javarush.island.minka.entity.organisms.animals.herbivore;

import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.organisms.Organism;

public class Caterpillar extends Herbivore {
    public Caterpillar() {
        super(CATERPILLAR, ICON_CATERPILLAR, AnimalProperties.get(CATERPILLAR).maxWeight, AnimalProperties.get(CATERPILLAR).maxCountPerCell);
    }

    @Override
    public Organism clone()  {
        return super.clone();
    }
}

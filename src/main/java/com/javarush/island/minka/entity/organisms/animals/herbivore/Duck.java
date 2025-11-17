package com.javarush.island.minka.entity.organisms.animals.herbivore;

import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.organisms.Organism;

public class Duck extends Herbivore {
    public Duck() {
        super(DUCK, ICON_DUCK, AnimalProperties.get(DUCK).maxWeight, AnimalProperties.get(DUCK).maxCountPerCell);
    }

    @Override
    public Organism clone()  {
        return super.clone();
    }
}

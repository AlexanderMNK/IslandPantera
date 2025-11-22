package com.javarush.island.minka.entity.organisms.animals.herbivore;

import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.organisms.Organism;

public class Deer extends Herbivore {
    public Deer() {
        super(DEER, ICON_DEER, AnimalProperties.get(DEER).maxWeight, AnimalProperties.get(DEER).maxCountPerCell);
    }

    @Override
    public Organism clone()  {
        return super.clone();
    }
}

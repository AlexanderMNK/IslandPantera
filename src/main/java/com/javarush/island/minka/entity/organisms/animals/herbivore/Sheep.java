package com.javarush.island.minka.entity.organisms.animals.herbivore;

import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.organisms.Organism;

public class Sheep extends Herbivore {
    public Sheep() {
        super(SHEEP, ICON_SHEEP, AnimalProperties.get(SHEEP).maxWeight, AnimalProperties.get(SHEEP).maxCountPerCell);
    }

    @Override
    public Organism clone()  {
        return super.clone();
    }
}

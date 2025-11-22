package com.javarush.island.minka.entity.organisms.animals.herbivore;

import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.organisms.Organism;

public class Mouse extends Herbivore {
    public Mouse() {
        super(MOUSE, ICON_MOUSE, AnimalProperties.get(MOUSE).maxWeight, AnimalProperties.get(MOUSE).maxCountPerCell);
    }

    @Override
    public Organism clone()  {
        return super.clone();
    }
}

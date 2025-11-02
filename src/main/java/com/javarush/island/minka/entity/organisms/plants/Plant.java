package com.javarush.island.minka.entity.organisms.plants;

import com.javarush.island.minka.entity.organisms.Organism;

public class Plant extends Organism {
    protected Plant(String species, String icon, double weight, int maxValue) {
        super(species, icon, weight, maxValue);
    }

    @Override
    public void reproduce() {

    }
}

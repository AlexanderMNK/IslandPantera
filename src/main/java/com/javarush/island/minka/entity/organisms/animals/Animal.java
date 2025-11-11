package com.javarush.island.minka.entity.organisms.animals;

import com.javarush.island.minka.api.Eatable;
import com.javarush.island.minka.api.Movable;
import com.javarush.island.minka.entity.organisms.Organism;


public abstract class Animal extends Organism implements Movable, Eatable {
    protected Animal(String species, String icon, double weight, int maxValue) {
        super(species, icon, weight, maxValue);
    }
}

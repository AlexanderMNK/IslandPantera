package com.javarush.island.minka.entity.organisms.animals.herbivore;

import com.javarush.island.minka.entity.organisms.Organism;
import com.javarush.island.minka.entity.organisms.animals.Animal;
import com.javarush.island.minka.entity.organisms.plants.Grass;

public class Herbivore extends Animal {
    public Herbivore(String species, String icon, double weight, int maxValue) {
        super(species, icon, weight, maxValue);
    }

    @Override
    protected boolean canEat(Organism prey) {
        return prey instanceof Grass;
    }

//    @Override
//    public void move() {
//
//    }
//
//    @Override
//    public void reproduce() {
//
//    }
}

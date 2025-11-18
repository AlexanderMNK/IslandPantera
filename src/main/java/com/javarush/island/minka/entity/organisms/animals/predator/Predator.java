package com.javarush.island.minka.entity.organisms.animals.predator;

import com.javarush.island.minka.entity.organisms.Organism;
import com.javarush.island.minka.entity.organisms.animals.Animal;

public class Predator extends Animal {
    public Predator(String species, String icon, double weight, int maxValue) {
        super(species, icon, weight, maxValue);
    }

    @Override
    protected boolean canEat(Organism prey) {
        // Хищник ест только животных
        return prey instanceof Animal;
    }

//    @Override
//    public void move() {
//
//    }

    @Override
    public void reproduce() {

    }
}

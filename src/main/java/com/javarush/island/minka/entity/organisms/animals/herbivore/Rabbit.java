package com.javarush.island.minka.entity.organisms.animals.herbivore;

import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.organisms.Organism;

public class Rabbit extends Herbivore {
    public Rabbit() {
        super(RABBIT, ICON_RABBIT, AnimalProperties.get(RABBIT).maxWeight, AnimalProperties.get(RABBIT).maxCountPerCell);
    }

//    @Override
//    public void move() {
//        System.out.println("Кролик движется.");
//    }
//
//    @Override
//    public void reproduce() {
//
//    }
//
//    @Override
//    public void eat() {
//
//    }

    @Override
    public Organism clone()  {
        return super.clone();
    }
}

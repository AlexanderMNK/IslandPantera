package com.javarush.island.minka;

import com.javarush.island.minka.entity.organisms.Organism;
import com.javarush.island.minka.entity.organisms.animals.Rabbit;
import com.javarush.island.minka.entity.organisms.animals.Wolf;
import com.javarush.island.minka.entity.organisms.plants.Grass;
import com.javarush.island.minka.view.Intro;

public class ConsoleRunner {
    public static void main(String[] args) {
        Intro.epigraph();

        Organism animal = new Wolf();
        Organism animal1 = new Rabbit();
        Organism plant = new Grass();

        System.out.println(animal);
        System.out.println(animal1);
        System.out.println(plant);
    }
}

package com.javarush.island.minka.entity.island;

import com.javarush.island.minka.entity.organisms.animals.Animal;
import com.javarush.island.minka.entity.organisms.plants.Grass;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Cell {
    @Getter
    private final int x;
    @Getter
    private final int y;
    private final List<Animal> animals = new ArrayList<>();
    private final List<Grass> plants = new ArrayList<>();

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized void addAnimal(Animal animal) {
    }

    public synchronized void removeAnimal(Animal animal) {
    }

    public synchronized void addPlant(Grass plant) {

    }

    public synchronized void removePlant(Grass plant) {

    }
}

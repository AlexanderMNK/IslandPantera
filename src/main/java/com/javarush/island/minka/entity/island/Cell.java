package com.javarush.island.minka.entity.island;

import com.javarush.island.minka.entity.organisms.Organism;
import com.javarush.island.minka.entity.organisms.animals.Animal;
import com.javarush.island.minka.entity.organisms.plants.Grass;
import lombok.Getter;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@SuppressWarnings("unused")
public class Cell {
    private final int x;
    private final int y;
    private final Lock lock = new ReentrantLock();
    private final List<Cell> possibleMove = new ArrayList<>();
    // Лист всех организмов обитающих в клетке впоследствии лучше сделать map.
    private final ResidentSet residents = new ResidentSet();
    //    @Getter
    //    private final List<Animal> organisms = new LinkedList<>();

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized void addOrganism(Organism organism) {
        residents.add(organism);
    }

    public synchronized void removeAnimal(Animal animal) {
    }

    public synchronized void addPlant(Grass plant) {

    }

    public synchronized void removePlant(Grass plant) {

    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
//                ", lock=" + lock +
//                ", possibleMove=" + possibleMove +
                ", residents=" + residents +
                '}';
    }
}

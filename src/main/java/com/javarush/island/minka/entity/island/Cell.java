package com.javarush.island.minka.entity.island;

import com.javarush.island.minka.config.GameConfig;
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
    // Лист всех организмов обитающих в клетке впоследствии лучше сделать map?
    private final ResidentSet residents = new ResidentSet();

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void possibleMoveInit() {
        int[][] directions8 = {
                {-1, 0}, // вверх
                {1, 0},  // вниз
                {0, -1}, // влево
                {0, 1},  // вправо
                {-1, -1},// вверх-влево
                {-1, 1}, // вверх-вправо
                {1, -1}, // вниз-влево
                {1, 1}   // вниз-вправо
        };

        int maxDirections = Math.min(GameConfig.CELL_DIRECTIONS, directions8.length);

        for (int i = 0; i < maxDirections; i++) {
            int newY = this.y + directions8[i][0];
            int newX = this.x + directions8[i][1];

            Cell neighbor = Island.getInstance().getCells(newX, newY);
            if (neighbor != null) {
                possibleMove.add(neighbor);
            }
        }
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
//                "x=" +
                x +
//                ", y=" +
                ", " +
                y +
//                ", possibleMove=[" + possibleMoveString + "]\n" +
                //", residents=" + residents +
                '}';
    }
}

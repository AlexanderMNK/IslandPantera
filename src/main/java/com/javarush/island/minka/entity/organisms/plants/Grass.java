package com.javarush.island.minka.entity.organisms.plants;

import com.javarush.island.minka.api.Movable;
import com.javarush.island.minka.api.Reproducible;
import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.island.Cell;
import com.javarush.island.minka.entity.island.Island;
import com.javarush.island.minka.entity.organisms.Organism;
import com.javarush.island.minka.util.Random;

public class Grass extends Organism implements Movable, Reproducible {
    public Grass() {
        super(GRASS, ICON_GRASS, AnimalProperties.get(GRASS).maxWeight, AnimalProperties.get(GRASS).maxCountPerCell);
    }

    @Override
    public void reproduce() {
        Cell currentCell = Island.getInstance().getCellsOfOrganism(this);
        if (currentCell == null) return;

        long grassCount;
        synchronized (currentCell) {
            grassCount = currentCell.getResidents().stream()
                    .filter(o -> o instanceof Grass)
                    .count();
        }

        int maxGrassCount = AnimalProperties.get(GRASS).maxCountPerCell / this.getCountToFlock();

        if (grassCount < maxGrassCount) {
            if (Random.random(1, 101) <= 50) {
                Grass newGrass = (Grass) this.clone();
                synchronized (currentCell) {
                    currentCell.addOrganism(newGrass);
                }
                System.out.println(getIcon() + " размножилась в клетке.");
            }
        }
    }

    @Override
    public void move() {
//        System.out.println(getIcon() + " распространяется.");
    }
}

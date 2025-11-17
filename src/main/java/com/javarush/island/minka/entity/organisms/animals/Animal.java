package com.javarush.island.minka.entity.organisms.animals;

import com.javarush.island.minka.api.Eatable;
import com.javarush.island.minka.api.Movable;
import com.javarush.island.minka.api.Reproducible;
import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.config.FoodChanceTable;
import com.javarush.island.minka.entity.island.Cell;
import com.javarush.island.minka.entity.island.Island;
import com.javarush.island.minka.entity.organisms.Organism;
import com.javarush.island.minka.entity.organisms.plants.Grass;
import com.javarush.island.minka.util.Random;

import java.util.ArrayList;
import java.util.List;


public abstract class Animal extends Organism implements Movable, Eatable, Reproducible {
    protected Animal(String species, String icon, double flockWeight, int countToFlock) {
        super(species, icon, flockWeight, countToFlock);
    }

    public Cell getCurrentCell() {
        return Island.getInstance().getCellsOfOrganism(this);
    }

    public final void eat() {
        Cell currentCell = getCurrentCell();
        if (currentCell == null) return;

        boolean ate = false;
        List<Organism> residents = new ArrayList<>(currentCell.getResidents());
        for (Organism prey : residents) {
            if (prey == this) continue;
            int chance = FoodChanceTable.getChance(this.getSpecies(), prey.getSpecies());
            if (chance > 0
                    && Random.random(1, 101) <= chance
                    && canEat(prey)
                    && this.getFlockWeight() < AnimalProperties.get(this.getSpecies()).maxWeight) {

                consumePrey(prey, currentCell);
                ate = true;
                break;
            }
        }

        if (!ate) {
            double newWeightFlock = this.getFlockWeight() * 0.8;
            this.setFlockWeight(newWeightFlock);
            System.out.println(this.getIcon() + " из " + this.getCountToFlock() + " не нашёл еды и похудел до " + String.format("%.2f", newWeightFlock));

            double minWeight = AnimalProperties.get(this.getSpecies()).maxWeight * this.getCountToFlock() * 0.3;

            if (newWeightFlock < minWeight) {
                currentCell.removeAnimal(this);
                System.out.println(this.getIcon() + " умер из-за сильного голода.");
            }
        }
    }

    protected abstract boolean canEat(Organism prey);

    public void consumePrey(Organism prey, Cell currentCell) {
        int preyCount = prey.getCountToFlock();
        int eatenCount = Math.min(preyCount, this.getCountToFlock());

        prey.setCountToFlock(preyCount - eatenCount);
        this.setFlockWeight(this.getFlockWeight() + eatenCount * AnimalProperties.get(prey.getSpecies()).maxWeight);

        if (prey.getCountToFlock() <= 0) {
            if (prey instanceof Animal) {
                currentCell.removeAnimal((Animal) prey);
            } else if (prey instanceof Grass) {
                currentCell.removePlant((Grass) prey);
            }
        }
    }
}

package com.javarush.island.minka.entity.organisms.animals.predator;

import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.config.FoodChanceTable;
import com.javarush.island.minka.entity.island.Cell;
import com.javarush.island.minka.entity.island.Island;
import com.javarush.island.minka.entity.organisms.Organism;
import com.javarush.island.minka.entity.organisms.animals.Animal;
import com.javarush.island.minka.entity.organisms.plants.Grass;
import com.javarush.island.minka.util.Random;

import java.util.ArrayList;
import java.util.List;

public abstract class Predator extends Animal {
    protected Predator(String species, String icon, double weight, int maxValue) {
        super(species, icon, weight, maxValue);
    }

    @Override
    public void eat() {
        Cell currentCell = Island.getInstance().getCellsOfOrganism(this);
        if (currentCell == null) return;

        boolean ate = false;
        List<Organism> residents = new ArrayList<>(currentCell.getResidents());
        for (Organism prey : residents) {
            if (prey == this) continue; // Себя не едим.
            int chance = FoodChanceTable.getChance(this.getSpecies(), prey.getSpecies());
            if (chance > 0) {
                if (Random.random(1, 101) <= chance) {
                    int preyCount = prey.getCountToFlock();
                    if (preyCount > 0) {

                        consumePrey(prey, currentCell);

                        if (prey.getCountToFlock() <= 0) {
                            if (prey instanceof Animal) {
                                currentCell.removeAnimal((Animal) prey);
                            } else if (prey instanceof Grass) {
                                currentCell.removePlant((Grass) prey);
                            }
                        }
                        ate = true;
                        break; // Жертва съедена
                    }
                }
            }
        }
        if (!ate) {
            // Худеем на 20% если не поели
            double newWeightFlock = this.getFlockWeight() * 0.8;
            this.setFlockWeight(newWeightFlock);
            System.out.println(this.getIcon() + "Стая из " + this.getCountToFlock() + "ед. не нашла еды и похудела до " + newWeightFlock);

            double minWeight = AnimalProperties.get(this.getSpecies()).maxWeight * this.getCountToFlock() * 0.3;

            if (newWeightFlock < minWeight) {
                currentCell.removeAnimal(this);
                System.out.println(this.getIcon() + " умер из-за сильного голода.");
            }
        }
    }

    @Override
    public void move() {
//        System.out.println(getIcon() + " движется.");
    }

    @Override
    public void reproduce() {
        // Размножение хищника
    }
}

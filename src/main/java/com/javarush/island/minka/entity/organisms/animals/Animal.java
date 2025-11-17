package com.javarush.island.minka.entity.organisms.animals;

import com.javarush.island.minka.api.Eatable;
import com.javarush.island.minka.api.Movable;
import com.javarush.island.minka.api.Reproducible;
import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.island.Cell;
import com.javarush.island.minka.entity.organisms.Organism;
import com.javarush.island.minka.entity.organisms.plants.Grass;


public abstract class Animal extends Organism implements Movable, Eatable, Reproducible {
    protected Animal(String species, String icon, double weight, int maxValue) {
        super(species, icon, weight, maxValue);
    }

    public void consumePrey(Organism prey, Cell currentCell) {
        int preyCount = prey.getCountToFlock();
        int eatenCount = Math.min(preyCount, this.getCountToFlock());

        prey.setCountToFlock(preyCount - eatenCount);

        // Увеличиваем сытость или вес хищника/травоядного
        this.setFlockWeight(this.getFlockWeight() + eatenCount * AnimalProperties.get(prey.getSpecies()).maxWeight);

//        System.out.println(this.getIcon() + " съел " + eatenCount + " из " + prey.getSpecies());

        // Удаляем жертву, если она полностью съедена
        if (prey.getCountToFlock() <= 0) {
            if (prey instanceof Animal) {
                currentCell.removeAnimal((Animal) prey);
            } else if (prey instanceof Grass) {
                currentCell.removePlant((Grass) prey);
            }

        }
    }
}

package com.javarush.island.minka.entity.organisms.animals;

import com.javarush.island.minka.api.Eatable;
import com.javarush.island.minka.api.Movable;
import com.javarush.island.minka.api.Reproducible;
import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.config.FoodChanceTable;
import com.javarush.island.minka.entity.island.Cell;
import com.javarush.island.minka.entity.island.Island;
import com.javarush.island.minka.entity.organisms.Organism;
import com.javarush.island.minka.entity.organisms.animals.predator.Predator;
import com.javarush.island.minka.entity.organisms.plants.Grass;
import com.javarush.island.minka.util.Random;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public abstract class Animal extends Organism implements Movable, Eatable, Reproducible {
    protected Animal(String species, String icon, double flockWeight, int countToFlock) {
        super(species, icon, flockWeight, countToFlock);
    }

    public Cell getCurrentCell() {
        Cell cell = Island.getInstance().getCellsOfOrganism(this);
        if (cell == null) {
            throw new IllegalStateException("Организм " + this + " не найден в ячейке!");
        }
        return cell;
    }

    public final void eat() {
        Cell currentCell = getCurrentCell();
        if (currentCell == null) return;

        boolean ate = false;
        List<Organism> residents;
        currentCell.getLock().lock();
        try {
            residents = new ArrayList<>(currentCell.getResidents());
        } finally {
            currentCell.getLock().unlock();
        }

        for (Organism prey : residents) {
            if (prey == this) continue;
            int chance = FoodChanceTable.getChance(this.getSpecies(), prey.getSpecies());

            final double maxFlockWeight = AnimalProperties.get(this.getSpecies()).maxWeight * this.getCountToFlock();

            if (chance > 0
                    && Random.random(1, 101) <= chance
                    && canEat(prey)
                    && this.getFlockWeight() < maxFlockWeight) {

                consumePrey(prey, currentCell);
                ate = true;
                break;
            }
        }

        if (!ate) {
            double newWeightFlock = this.getFlockWeight() * 0.8;
            this.setFlockWeight(newWeightFlock);
//            System.out.println(this.getIcon() + " из " + this.getCountToFlock() + " не нашёл еды и похудел до " + String.format("%.2f", newWeightFlock));

            double minWeight = AnimalProperties.get(this.getSpecies()).maxWeight * this.getCountToFlock() * 0.3;

            if (newWeightFlock < minWeight) {
                currentCell.getLock().lock();
                try {
                    currentCell.removeAnimal(this);
                } finally {
                    currentCell.getLock().unlock();
                }
//                System.out.println(this.getIcon() + " умер из-за сильного голода.");
            }
        }
    }

    protected abstract boolean canEat(Organism prey);

    public void consumePrey(Organism prey, Cell currentCell) {
        currentCell.getLock().lock();
        try {
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
        } finally {
            currentCell.getLock().unlock();
        }
    }

    public void move() {
        Cell currentCell = getCurrentCell();
        if (currentCell == null) return;

        int maxSpeed = AnimalProperties.get(this.getSpecies()).maxSpeed;
        Set<Cell> reachableCells = new HashSet<>();
        Set<Cell> frontier = new HashSet<>();
        frontier.add(currentCell);

        for (int step = 0; step < maxSpeed; step++) {
            Set<Cell> nextFrontier = new HashSet<>();
            for (Cell cell : frontier) {
                for (Cell neighbor : cell.getPossibleMove()) {
                    if (!reachableCells.contains(neighbor)) {
                        reachableCells.add(neighbor);
                        nextFrontier.add(neighbor);
                    }
                }
            }
            frontier = nextFrontier;
        }

        reachableCells.remove(currentCell);

        if (reachableCells.isEmpty()) return;

        int index = Random.random(0, reachableCells.size() - 1);
        Cell[] arr = reachableCells.toArray(new Cell[0]);
        Cell newCell = arr[index];

        Cell firstLock = currentCell.hashCode() < newCell.hashCode() ? currentCell : newCell;
        Cell secondLock = currentCell.hashCode() < newCell.hashCode() ? newCell : currentCell;

        boolean lockedFirst = false;
        boolean lockedSecond = false;
        try {
            lockedFirst = firstLock.getLock().tryLock(100, TimeUnit.MILLISECONDS);
            if (!lockedFirst) return;
            lockedSecond = secondLock.getLock().tryLock(100, TimeUnit.MILLISECONDS);
            if (!lockedSecond) return;

            currentCell.removeAnimal(this);
            newCell.addOrganism(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            if (lockedSecond) secondLock.getLock().unlock();
            if (lockedFirst) firstLock.getLock().unlock();
        }
    }

    public void reproduce() {
        Cell currentCell = getCurrentCell();
        if (currentCell == null) return;
        int currentCount;
        currentCell.getLock().lock();
        try {
            currentCount = currentCell.getResidents().stream()
                    .filter(o -> o.getSpecies().equals(this.getSpecies()))
                    .mapToInt(Organism::getCountToFlock)
                    .sum();
            int maxCount = AnimalProperties.get(this.getSpecies()).maxCountPerCell;
            if (currentCount < maxCount) {
                int reproductionChance;
                if (this instanceof Predator) {
                    reproductionChance = REPRODUCTION_CHANCE_PREDATOR;
                } else {
                    reproductionChance = REPRODUCTION_CHANCE_HERBIVORE;
                }
                final int randomChance = Random.random(1, 101);
                if (randomChance <= reproductionChance) {
                    Organism newOrganism = this.clone();
                    currentCell.addOrganism(newOrganism);
                }
            }
        } finally {
            currentCell.getLock().unlock();
        }
    }
}

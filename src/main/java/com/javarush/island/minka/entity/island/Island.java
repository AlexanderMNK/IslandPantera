package com.javarush.island.minka.entity.island;

import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.config.GameConfig;
import com.javarush.island.minka.entity.organisms.Organism;
import com.javarush.island.minka.services.OrganismFactory;
import com.javarush.island.minka.util.Random;
import lombok.Getter;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Island {
    @Getter
    private static Island instance;
    @Getter
    private final int width;
    @Getter
    private final int height;
    private final Cell[][] cells;
    private final Organism[] prototype;

    public Island(OrganismFactory prototype) {
        instance = this;
        this.prototype = prototype.getPROTOTYPES();
        this.width = GameConfig.ISLAND_WIDTH;
        this.height = GameConfig.ISLAND_HEIGHT;
        this.cells = new Cell[height][width];
        createCells();
        initializeCellsPossibleMove();

//        initialFillingOrganisms();  // !!!
        initialFillingOrganisms();
    }

    private void initializeCellsPossibleMove() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                cells[y][x].possibleMoveInit();
            }
        }
    }

    private void createCells() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                cells[y][x] = new Cell(x, y);
            }
        }
    }

    public Cell getCells(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return cells[y][x];
        }
        return null;
    }

    public void simulateTick() {
    }


    /**
     *  Создаём группы пока не достигнем лимита
     *  по заполнению клетки в соответствии PERCENT_CELL_COMPLETION
     *  от максимально возможного количества особей в клетке.
     */public void initialFillingOrganisms() {
        // Проходим по всем клеткам острова
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Cell cell = cells[y][x];

                for (Organism prototype : prototype) {
                    int maxCountPerCell = AnimalProperties.get(prototype.getSpecies()).maxCountPerCell;
                    int currentCompletionCell = 0;

                    while (currentCompletionCell < GameConfig.PERCENT_CELL_COMPLETION) {
                        int totalCountAtMoment = cell.getResidents()
                                .stream()
                                .mapToInt(Organism::getCountToFlock)
                                .sum();
                        currentCompletionCell = totalCountAtMoment * 100 / maxCountPerCell;

                        Organism organism = prototype.clone();
                        Organism newOrganism = createOrganism(organism);
                        cell.addOrganism(newOrganism);
                    }
                }
            }
        }
    }

    /**
     * Создаём группу.
     * Группа заполняется от START_PERCENT_GROUP_COMPLETION до 100%.
     * Вес каждой особи в группе максимальный.
     */
    public Organism createOrganism(Organism organism) {
        String species = organism.getSpecies();
        // Генерируем количество особей в группе в зависимости от процента заполнения группы.
        final int startPercentGroupCompletion = GameConfig.START_PERCENT_GROUP_COMPLETION;
        int countOfGroup = Random.percent(AnimalProperties.get(species).maxGroupSize, startPercentGroupCompletion);
        // Вычисляем общий вес группы. Считаем, что вес каждого животного в группе максимальный.
        double weightOfGroup = AnimalProperties.get(species).maxWeight * countOfGroup;
        // Добавляем организмы в клетку до maxCount
        organism.setCountToFlock(countOfGroup);
        organism.setFlockWeight(weightOfGroup);
        return organism;
    }

    @Override
    public String toString() {
        return "Island{" +
                "cells=" + Arrays.toString(cells) +
                '}';
    }
}

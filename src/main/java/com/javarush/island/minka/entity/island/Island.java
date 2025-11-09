package com.javarush.island.minka.entity.island;

import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.config.GameConfig;
import com.javarush.island.minka.entity.organisms.Organism;
import com.javarush.island.minka.services.OrganismFactory;
import lombok.Getter;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Island {
    @Getter
    private final int width;
    @Getter
    private final int height;
    private final Cell[][] cells;
    private final Organism[] prototype;

    public Island(OrganismFactory prototype) {
        this.prototype = prototype.getPROTOTYPES();
        this.width = GameConfig.ISLAND_WIDTH;
        this.height = GameConfig.ISLAND_HEIGHT;
        this.cells = new Cell[height][width];
        initializeCells();
        initialFilling();
    }

    private void initializeCells() {
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

    public void printStatistics() {
        for (int y = 0; y < cells.length; y++) {
            for (int x = 0; x < cells[y].length; x++) {
                System.out.println("\nCell[" + x + "][" + y + "]" + getCells(x, y).getResidents().toString());
            }
        }
    }

    public void initialFilling() {
        // Проходим по всем клеткам острова
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Cell cell = cells[y][x];
                // Для каждого прототипа из PROTOTYPES пытаемся добавить организмы до максимума для этой клетки
                for (Organism prototype : prototype) {
                    String species = prototype.getSpecies();
                    int maxCount = AnimalProperties.get(species).maxCountPerCell;

                    // Добавляем организмы в клетку до maxCount
                    for (int i = 0; i < maxCount; i++) {
                        Organism organism = prototype.clone();
//                        if (organism instanceof Animal) {
                            cell.addOrganism(organism);
//                        } else if (organism instanceof Grass) {
//                            cell.addPlant((Grass) organism);
//                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Island{" +
                "cells=" + Arrays.toString(cells) +
                '}';
    }
}

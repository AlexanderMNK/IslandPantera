package com.javarush.island.minka.entity.island;

import com.javarush.island.minka.config.IslandConfig;
import lombok.Getter;

@SuppressWarnings("unused")
public class Island {
    @Getter
    private final int width;
    @Getter
    private final int height;
    private final Cell[][] cells;

    public Island() {
        this.width = IslandConfig.WIDTH;
        this.height = IslandConfig.HEIGHT;
        this.cells = new Cell[height][width];
        initializeCells();
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
            return cells[x][y];
        }
        return null;
    }

    public void simulateTick() {
    }

    public void printStatistics() {
    }
}

package com.javarush.island.minka.view;

import com.javarush.island.minka.config.GameConfig;
import com.javarush.island.minka.entity.island.Cell;
import com.javarush.island.minka.entity.island.Island;
import com.javarush.island.minka.entity.organisms.Organism;
import com.javarush.island.minka.util.Statistics;

import java.util.Map;

@SuppressWarnings("unused")
public class View {
    public static final int CONSOLE_WIDTH = GameConfig.CONSOLE_WIDTH;   // 20
    public static final int CONSOLE_HEIGHT = GameConfig.CONSOLE_HEIGHT; // 5
    private final Statistics statistics;

    public View(Statistics statistics) {
        this.statistics = statistics;
    }

    public void printStatisticsAfterIslandCreate(Island island) {
        for (int y = 0; y < island.getHeight(); y++) {
            for (int x = 0; x < island.getWidth(); x++) {
                Cell cell = island.getCells(x, y);
                System.out.println("\nCell[" + x + "][" + y + "]\n"
                        + cell.getPossibleMove()
                        + "\n"
                        + cell.getResidents().toString()
                );
            }
        }
    }

    public void printIsland() {
        Island island = Island.getInstance();
        if (island == null) {
            System.out.println("Island is not initialized.");
            return;
        }
        int islandWidth = island.getWidth();
        int islandHeight = island.getHeight();

        int blockWidth = CONSOLE_WIDTH;
        int blockHeight = CONSOLE_HEIGHT;

        for (int startY = 0; startY < islandHeight; startY += blockHeight) {
            for (int startX = 0; startX < islandWidth; startX += blockWidth) {

                int endX = Math.min(startX + blockWidth, islandWidth);
                int endY = Math.min(startY + blockHeight, islandHeight);

                System.out.print("    ");
                for (int x = startX; x < endX; x++) {
                    System.out.printf(" %2d ", x);
                }
                System.out.println();

                System.out.print("   ┌");
                for (int x = startX; x < endX; x++) {
                    System.out.print("───");
                    if (x < endX - 1) System.out.print("┬");
                }
                System.out.println("┐");

                for (int y = startY; y < endY; y++) {
                    System.out.printf("%3d│", y);
                    for (int x = startX; x < endX; x++) {
                        Cell cell = island.getCells(x, y);
                        String symbol = " ";

                        synchronized (cell) {
                            Organism first = null;
                            for (Organism o : cell.getResidents()) {
                                first = o;
                                break;
                            }

                            if (first != null) {
                                String species = first.getSpecies();
                                if (species != null && !species.isEmpty()) {
                                    symbol = species.substring(0, 1).toUpperCase();
                                } else {
                                    symbol = "?";
                                }
                            }
                        }
                        System.out.print(" " + symbol + " │");
                    }
                    System.out.println();

                    if (y < endY - 1) {
                        System.out.print("   ├");
                        for (int x = startX; x < endX; x++) {
                            System.out.print("───");
                            if (x < endX - 1) System.out.print("┼");
                        }
                        System.out.println("┤");
                    }
                }

                System.out.print("   └");
                for (int x = startX; x < endX; x++) {
                    System.out.print("───");
                    if (x < endX - 1) System.out.print("┴");
                }
                System.out.println("┘");

                System.out.println();
            }
        }
    }

    public void printStatisticIslandPercent() {
        Map<String, Statistics.SpeciesStatistic> stats = statistics.getIslandStatistic();

        System.out.println("=== Текущая статистика острова ===");
        stats.forEach((species, stat) ->
                System.out.printf("%s: %d / %d (%.2f%%)%n",
                        species, stat.currentCount, stat.maxPossibleCount, stat.percentOfMax));
    }
}

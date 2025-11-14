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

                // Печать заголовка со столбцами
                System.out.print("    "); // 4 пробела под номера строк слева
                for (int x = startX; x < endX; x++) {
                    // Ширина заголовка — 3 символа + один пробел по краям
                    System.out.printf(" %2d ", x);
                }
                System.out.println();

                // Верхняя рамка блока
                System.out.print("   ┌");
                for (int x = startX; x < endX; x++) {
                    System.out.print("───");
                    if (x < endX - 1) System.out.print("┬");
                }
                System.out.println("┐");

                // Вывод строк с нумерацией и содержимым клеток
                for (int y = startY; y < endY; y++) {
                    // Номер строки ровно 3 символа + символ │
                    System.out.printf("%3d│", y);
                    for (int x = startX; x < endX; x++) {
                        Cell cell = island.getCells(x, y);
                        String symbol = " ";

                        synchronized (cell) {
                            if (!cell.getResidents().isEmpty()) {
                                Organism first = cell.getResidents().getFirst();
                                String species = first.getSpecies();
                                if (species != null && !species.isEmpty()) {
                                    symbol = species.substring(0, 1).toUpperCase();
                                } else {
                                    symbol = "?";
                                }
                                // Если иконка — эмодзи, ширина на одном "пробеле" визуально может быть больше,
                                // но в консоли учитывайте фиксированный размер символа
                            }
                        }
                        // Выводим ячейку с ровно одной позицией + пробелы с каждой стороны
                        System.out.print(" " + symbol + " │");
                    }
                    System.out.println();

                    // Горизонтальный разделитель ячеек (кроме последней строки блока)
                    if (y < endY - 1) {
                        System.out.print("   ├");
                        for (int x = startX; x < endX; x++) {
                            System.out.print("───");
                            if (x < endX - 1) System.out.print("┼");
                        }
                        System.out.println("┤");
                    }
                }

                // Нижняя рамка блока
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
        final Map<String, Statistics.SpeciesStatistic> islandStatistic = statistics.getIslandStatistic();
        islandStatistic.forEach((species, stat) -> System.out.println(species + ": " + stat.toString()));
    }
}

package com.javarush.island.minka.util;

import com.javarush.island.minka.config.AnimalProperties;
import com.javarush.island.minka.entity.island.Cell;
import com.javarush.island.minka.entity.island.Island;
import com.javarush.island.minka.entity.organisms.Organism;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private final Island island;
    /**
     * В коллекции храним: ключ - вид животного, значение - объект (вид животного)
     * с информацией: текущее количество, максимальное возможное, процент заполнения.
     */
    private final Map<String, SpeciesStatistic> stats = new HashMap<>();
    public static class SpeciesStatistic {
        public int currentCount;
        public int maxPossibleCount;
        public double percentOfMax;

        public SpeciesStatistic(int currentCount, int maxPossibleCount) {
            this.currentCount = currentCount;
            this.maxPossibleCount = maxPossibleCount;
            this.percentOfMax = maxPossibleCount > 0 ? 100.0 * currentCount / maxPossibleCount : 0.0;
        }
        @Override
        public String toString() {
            return String.format("Current: %d, Max: %d, Filled: %.2f%%", currentCount, maxPossibleCount, percentOfMax);
        }
    }

    public Statistics(Island island) {
        this.island = island;
    }

    public Map<String, SpeciesStatistic> getIslandStatistic() {
        stats.clear();
        for (String species : AnimalProperties.PROPERTIES.keySet()) {
            AnimalProperties.OrganismLimits limits = AnimalProperties.get(species);
            int maxTotalCount = limits.getMaxCountPerCell() * island.getWidth() * island.getHeight();
            stats.put(species, new SpeciesStatistic(0, maxTotalCount));
        }
        for (int y = 0; y < island.getHeight(); y++) {
            for (int x = 0; x < island.getWidth(); x++) {
                Cell cell = island.getCells(x, y);
                cell.getLock().lock();
                try {
                    for (Organism organism : cell.getResidents()) {
                        String species = organism.getSpecies();
                        SpeciesStatistic stat = stats.get(species);
                        if (stat != null) {
                            stat.currentCount += organism.getCountToFlock();
                        }
                    }
                } finally {
                    cell.getLock().unlock();
                }
            }
        }
        for (SpeciesStatistic stat : stats.values()) {
            stat.percentOfMax = stat.maxPossibleCount > 0 ? 100.0 * stat.currentCount / stat.maxPossibleCount : 0.0;
        }

        return stats;
    }
}

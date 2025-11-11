package com.javarush.island.minka.services;

import com.javarush.island.minka.entity.island.Island;

public class GameProcessing {
    private final Island island;
    private final OrganismFactory organismFactory;

    public GameProcessing(Island island, OrganismFactory organismFactory) {
        this.island = island;
        this.organismFactory = organismFactory;
    }

    public void start() {
        System.out.println(organismFactory);
        island.printStatistics();
    }
}

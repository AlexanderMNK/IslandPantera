package com.javarush.island.minka.services;

import com.javarush.island.minka.entity.island.Island;
import com.javarush.island.minka.view.View;

@SuppressWarnings("unused")
public class GameProcessing extends Thread {
    private final Island island;
    private final View view;

    public GameProcessing(Island island, View view) {
        this.island = island;
        this.view = view;
    }

    @Override
    public void run() {
        int ticks = 30;
        for (int i = 0; i < ticks; i++) {
            island.simulateTick();
//            view.printStatisticsAfterIslandCreate(island);
//            view.printStatisticIslandPercent();
            view.printIsland();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

//    @Override
//    public void run() {
//        island.simulateTick();
//        view.printStatisticsAfterIslandCreate(island);
//        view.printStatisticIslandPercent();
//        view.printIsland();
//    }
}

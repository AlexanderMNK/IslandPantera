package com.javarush.island.minka.services;

import com.javarush.island.minka.entity.island.Island;
import com.javarush.island.minka.view.View;

@SuppressWarnings("unused")
public class GameProcessing extends Thread {
    private final Island island;
    private final View view;

    public GameProcessing(Island island, View view1) {
        this.island = island;
        this.view = view1;
    }

    @Override
    public void run() {
//        System.out.println(organismFactory);
                island.simulateTick();
//        view.printStatisticsAfterIslandCreate(island);




        view.printStatisticIslandPercent();

        view.printIsland();
    }
}

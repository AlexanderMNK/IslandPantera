package com.javarush.island.minka;

import com.javarush.island.minka.entity.island.Island;
import com.javarush.island.minka.services.GameProcessing;
import com.javarush.island.minka.services.OrganismFactory;
import com.javarush.island.minka.util.Statistics;
import com.javarush.island.minka.view.Intro;
import com.javarush.island.minka.view.View;

public class ConsoleRunner {
    public static void main(String[] args) {
        Intro.epigraph();
        OrganismFactory organismFactory = new OrganismFactory();
        Island island = new Island(organismFactory);

        Statistics statistics = new Statistics(island);
        View viewer = new View(statistics);
        GameProcessing game = new GameProcessing(island, viewer);
        game.start();
    }
}

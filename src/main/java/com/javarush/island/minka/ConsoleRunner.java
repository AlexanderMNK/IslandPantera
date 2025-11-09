package com.javarush.island.minka;

import com.javarush.island.minka.entity.island.Island;
import com.javarush.island.minka.services.OrganismFactory;
import com.javarush.island.minka.view.Intro;

public class ConsoleRunner {
    public static void main(String[] args) {
        Intro.epigraph();
        OrganismFactory organismFactory = new OrganismFactory();
        Island island = new Island(organismFactory);

//        System.out.println(organismFactory);

        island.printStatistics();
    }
}

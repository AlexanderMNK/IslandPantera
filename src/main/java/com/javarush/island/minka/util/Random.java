package com.javarush.island.minka.util;

import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("unused")
public class Random {

    public Random() {
    }

    public static int random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static int percent(int count, int minPercent) {
        int percent = ThreadLocalRandom.current().nextInt(minPercent, 100);
        if (count == 0) {
            throw new IllegalArgumentException("Деление на ноль!!!");
        }
        return count * percent / 100;
    }

    public static double random(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }
}

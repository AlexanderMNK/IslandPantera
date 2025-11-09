package com.javarush.island.minka.entity.island;

import com.javarush.island.minka.entity.organisms.Organism;

import java.util.LinkedHashSet;

@SuppressWarnings("unused")
public class ResidentSet extends LinkedHashSet<Organism> {
    private final LinkedHashSet<Organism> residentSet = new LinkedHashSet<>();

}

package com.javarush.island.minka.entity.organisms;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@SuppressWarnings({"unused", "FieldCanBeLocal"})
@EqualsAndHashCode(of = "id")
public abstract class Organism implements Cloneable, AnimalConstants {

    private static final AtomicLong idCounter = new AtomicLong(System.currentTimeMillis());

    @Setter
    private long id;
    private final String species;
    private final String icon;
    @Setter
    private double flockWeight;
    @Setter
    private int countToFlock;

    protected Organism(String species, String icon, double weight, int value) {
        this.species = species;
        this.icon = icon;
        this.flockWeight = weight;
        this.countToFlock = value;
        this.id = idCounter.incrementAndGet();
    }

    @Override
    public Organism clone() {
        try {
            Organism organism = (Organism) super.clone();
            organism.id = idCounter.incrementAndGet();
            return organism;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "\nOrganism{" +
//                "species='" + species + '\'' +
                "icon='" + icon + '\'' +
                ", flockWeight=" + flockWeight +
                ", countToFlock=" + countToFlock +
                ", id=" + id +
                '}';
    }
}

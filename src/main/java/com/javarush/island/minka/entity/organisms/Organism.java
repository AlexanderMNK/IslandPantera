package com.javarush.island.minka.entity.organisms;

import com.javarush.island.minka.api.Reproducible;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicLong;

@SuppressWarnings({"unused", "FieldCanBeLocal"})
@EqualsAndHashCode(of = "id")
public abstract class Organism implements Cloneable, Reproducible, AnimalConstants {

    private final static AtomicLong idCounter = new AtomicLong(System.currentTimeMillis());

    @Getter
    private long id = idCounter.incrementAndGet();
    @Getter
    private final String species;
    @Getter
    private final String icon;
    @Setter
    private double flockWeight;
//    private final double weight;
    @Setter
    private int countToFlock;
//    private final int maxValuePerCell;
//    private final int groupSize;
    protected Organism(String species, String icon, double weight, int value) {
//    protected Organism(String species, String icon, double weight, int maxValue, int groupSize) {
        this.species = species;
        this.icon = icon;
        this.flockWeight = weight;
        this.countToFlock = value;
//        this.groupSize = groupSize;
    }

    @Override
    public Organism clone() {
        Organism organism;
        try {
            organism = (Organism) super.clone();
            organism.id = idCounter.incrementAndGet();
//            organism.numberOfIndividuals =
            return organism;
//            return (Organism) super.clone();
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

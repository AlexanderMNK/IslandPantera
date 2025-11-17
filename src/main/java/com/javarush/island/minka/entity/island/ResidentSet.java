package com.javarush.island.minka.entity.island;

import com.javarush.island.minka.entity.organisms.Organism;
import lombok.Getter;

import java.util.HashSet;

//@SuppressWarnings("unused")
//public class ResidentSet extends LinkedHashSet<Organism> {
//    private final LinkedHashSet<Organism> residentSet = new LinkedHashSet<>();
//}

@Getter
@SuppressWarnings("unused")
public class ResidentSet extends HashSet<Organism> {
    private final HashSet<Organism> residentSet;

    public ResidentSet() {
        this.residentSet = new HashSet<>();
    }

    public ResidentSet(HashSet<Organism> initialSet) {
        this.residentSet = new HashSet<>(initialSet);
    }

    public boolean addResident(Organism organism) {
        return residentSet.add(organism);
    }
}
package com.javarush.island.minka.services;

import com.javarush.island.minka.entity.organisms.AnimalConstants;
import com.javarush.island.minka.entity.organisms.Organism;
import com.javarush.island.minka.entity.organisms.animals.herbivore.*;
import com.javarush.island.minka.entity.organisms.animals.predator.*;
import com.javarush.island.minka.entity.organisms.plants.Grass;
import lombok.Getter;

import java.lang.reflect.InvocationTargetException;

public class OrganismFactory implements AnimalConstants {
    @Getter
    Organism[] PROTOTYPES;
    /** "Wolf", "Boa" - удав, "Fox", "Bear", "Eagle",
     *  "Horse", "Deer" - олень, "Rabbit", "Mouse", "Goat" - козёл,
     *  "Sheep", "Boar" - кабан, "Buffalo", "Duck", "Caterpillar", "Grass"
     */
    Class<?>[] TYPES = {
            Bear.class,
            Boar.class,
            Wolf.class,
            Fox.class,
            Boa.class,
            Eagle.class,
            Buffalo.class,
            Horse.class,
            Goat.class,
            Sheep.class,
            Deer.class,
            Rabbit.class,
            Duck.class,
            Mouse.class,
            Grass.class,
            Caterpillar.class,
    };

    public OrganismFactory() {
        this.PROTOTYPES = create(TYPES);
    }

    public Organism create(Class<?> type) {
        try {
            return (Organism) type.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new IllegalArgumentException("Неопределённый вид или ошибка создания: " + type.getSimpleName(), e);
        }
    }

    public Organism[] create(Class<?>[] types) {
        Organism[] prototypes = new Organism[types.length];
        for (int i = 0; i < types.length; i++) {
            prototypes[i] = create(types[i]);
        }
        return prototypes;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Organism prototype : PROTOTYPES) {
            s.append(prototype).append("\n");
        }
        return "OrganismFactory\n{\n" +
                "PROTOTYPES=\n" + s +
                "\n}";
    }
}

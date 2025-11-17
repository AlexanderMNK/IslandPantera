package com.javarush.island.minka.services;

import com.javarush.island.minka.entity.organisms.AnimalConstants;
import com.javarush.island.minka.entity.organisms.Organism;
import com.javarush.island.minka.entity.organisms.animals.herbivore.Duck;
import com.javarush.island.minka.entity.organisms.animals.herbivore.Rabbit;
import com.javarush.island.minka.entity.organisms.animals.predator.Wolf;
import com.javarush.island.minka.entity.organisms.plants.Grass;
import lombok.Getter;

import java.lang.reflect.InvocationTargetException;

public class OrganismFactory implements AnimalConstants {
    @Getter
    Organism[] PROTOTYPES;

    Class<?>[] TYPES = {
            Wolf.class,
//                Boa.class, Fox.class, Bear.class, Eagle.class, Horse.class, Deer.class,
            Rabbit.class,
//                Mouse.class, Goat.class, Sheep.class, Boar.class, Buffalo.class,
            Duck.class,
//            Caterpillar.class,
            Grass.class
    };


    public OrganismFactory() {
        this.PROTOTYPES = create(TYPES);
    }

    public Organism create(Class<?> type) {
        try {
            // Вызываем конструктор без параметров и создаем новый экземпляр
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

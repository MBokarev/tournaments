package ru.netology.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Player {
    private int id;
    private String name;
    private int strength;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }
}

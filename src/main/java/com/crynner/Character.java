package com.crynner;

public abstract class Character {

    public Character(String name, int level) {
    }

    public abstract String attack();

    public String getDetails() {
        return "Name: " + null + ", Level: " + null;
    }
}

class Warrior extends Character {

    public Warrior(String name, int level, String weaponType) {}

    @Override
    public String attack() {
        return "";
    }
}

class Mage extends Character {

    public Mage(String name, int level, String element) {}

    @Override
    public String attack() {
        return "";
    }
}


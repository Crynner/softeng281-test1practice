package com.crynner;

public abstract class Character {
    String name;
    int level;

    public Character(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public abstract String attack();

    public String getDetails() {
        return "Name: " + name + ", Level: " + level;
    }
}

class Warrior extends Character {
    String weaponType;

    public Warrior(String name, int level, String weaponType) {
        super(name, level);
        this.weaponType = weaponType;
    }

    @Override
    public String attack() {
        return String.format("%s swings his %s!", name, weaponType);
    }
}

class Mage extends Character {
    String element;

    public Mage(String name, int level, String element) {
        super(name, level);
        this.element = element;
    }

    @Override
    public String attack() {
        return String.format("%s casts a %s spell!", name, element);
    }
}


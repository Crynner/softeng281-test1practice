package com.crynner;

import java.util.List;
import java.util.ArrayList;

class Pet {
    private String name;
    private String species;
    private String owner = null;

    public Pet(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public void assignOwner(String ownerName) {
        owner = ownerName;
    }

    public String getOwner() {
        return owner;
    }

    public void removeOwner() {
        owner = null;
    }

    public String toString() {
        return "testString";
    }
}

class PetHotel {
    List<Pet> pets = new ArrayList<>();

    public void checkIn(Pet pet) {
        if (!pets.contains(pet)) {
            pets.add(pet);
        }
    }

    public void checkOut(Pet pet) {
        pets.remove(pet);
    }

    public boolean isGuest(Pet pet) {
        return pets.contains(pet);
    }

    public int guestCount() {
        return pets.size();
    }

    public String listCheckedInPets() {
        String joinedStr = "";
        for (Pet pet : pets) {
            if (!joinedStr.equals("")) {
                joinedStr += ",";
            }
            joinedStr += pet.getName();
        }
        return joinedStr;
    }
}
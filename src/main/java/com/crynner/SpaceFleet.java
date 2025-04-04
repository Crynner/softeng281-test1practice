package com.crynner;

import java.util.ArrayList;

public class SpaceFleet {
    ArrayList<Spaceship> fleet = new ArrayList<>();

    public SpaceFleet() {
    }

    public void addSpaceship(String name) {
        fleet.add(new Spaceship(name));
    }

    public void updateMissionStatus(String name, String status) {
        for (Spaceship ship : fleet) {
            if (ship.getName().equals(name)) {
                ship.setStatus(status);
                return; // short-circuit
            }
        }
    }

    public String getMissionStatus(String name) {
        for (Spaceship ship : fleet) {
            if (ship.getName().equals(name)) {
                return ship.getStatus();
            }
        }
        return null;
    }

    public ArrayList<String> listSpaceships() {
        ArrayList<String> shipNames = new ArrayList<>();
        for (Spaceship ship : fleet) {
            shipNames.add(ship.getName());
        }
        return shipNames;
    }

    public ArrayList<String> getSpaceshipsByStatus(String status) {
        ArrayList<String> shipNames = new ArrayList<>();
        for (Spaceship ship : fleet) {
            if (ship.getStatus().equals(status)) {
                shipNames.add(ship.getName());
            }
        }
        return shipNames;
    }

    public void removeSpaceship(String name) {
        for (Spaceship ship : fleet) {
            if (ship.getName().equals(name)) {
                fleet.remove(ship);
                return;
            }
        }
    }

    public void printFleetSummary() {
        for (Spaceship ship : fleet) {
            System.out.println(String.format("Spaceship %s - Status: %s", ship.getName(), ship.getStatus()));
        }
    }
}

class Spaceship {
    String name;
    String status = "Unset"; // trivial non-null filler value

    public Spaceship(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
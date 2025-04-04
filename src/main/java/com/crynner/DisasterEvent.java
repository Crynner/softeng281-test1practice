package com.crynner;

public class DisasterEvent {
    String id;
    String name;
    String location;
    String impactLevel;
    double damageCost;

    public DisasterEvent(String id, String name) {
        this.id = id;
        this.name = name;
        location = "Unknown";
        impactLevel = "Unknown";
        damageCost = 0;
    }

    public DisasterEvent(String id, String name, String location, String impactLevel, double damageCost) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.impactLevel = impactLevel;
        this.damageCost = damageCost;
    }

    public DisasterEvent(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        impactLevel = "Unknown";
        damageCost = 0;
    }

    public String getDisasterDetails() {
        return String.format("ID: %s, Name: %s, Location: %s, Impact Level: %s, Damage Cost: %.1f",
            id, name, location, impactLevel, damageCost);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getImpactLevel() {
        return impactLevel;
    }

    public double getDamageCost() {
        return damageCost;
    }

    public void updateDamageCost(double newDamageCost) {
        damageCost = newDamageCost;
    }
}


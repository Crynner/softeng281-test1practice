package com.crynner;

import java.util.ArrayList;

public class SteelFabricationManager {
    ArrayList<FabricationProject> projects = new ArrayList<>();

    public SteelFabricationManager() {
    }

    public void addProject(String name, double cost) {
        for (FabricationProject project : projects) {
            if (project.getName().equals(name)) {
                project.setCost(cost);
                return;
            }
        }
        projects.add(new FabricationProject(name, cost));
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (FabricationProject project : projects) {
            totalCost += project.getCost();
        }
        return totalCost;
    }

    public double getProjectCost(String name) {
        for (FabricationProject project : projects) {
            if (project.getName().equals(name)) {
                return project.getCost();
            }
        }
        return -1;
    }

    public int getProjectCount() {
        return projects.size();
    }
}

class FabricationProject {
    String name;
    double cost;

    public FabricationProject(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}


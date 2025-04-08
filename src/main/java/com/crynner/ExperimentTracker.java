package com.crynner;

import java.util.ArrayList;

class Experiment {
    private String name;
    private boolean success;

    public Experiment(String name, boolean success) {
        this.name = name;
        this.success = success;
    }

    public String getName() {
        return name;
    }

    public boolean wasSuccessful() {
        return success;
    }

    public String toString() {
        return name + " - " + (success ? "Success" : "Failure");
    }
}

class ExperimentTracker {
    private ArrayList<Experiment> experiments = new ArrayList<>();

    public void addExperiment(Experiment exp) {
        experiments.add(exp);
    }

    public int countSuccessful() {
        int count = 0;
        for (Experiment exp : experiments) {
            if (exp.wasSuccessful()) count++;
        }
        return count;
    }
}
package com.crynner;

import java.util.ArrayList;

class Nucleotide {

    public Nucleotide(char base) {
    }

    public char getBase() {
        return ' ';
    }

    public String getComplement() {
        return "";
    }
}

class Gene {

    public Gene(String sequence) {
    }

    public String getSequence() {
        return "";
    }

    public String getComplementarySequence() {
        return "";
    }

    public boolean containsPattern(String pattern) {
        return false;
    }

    public int countOccurrences(String subsequence) {
        return -1;
    }
}

class Organism {

    public Organism(String name) {
    }

    public void addGene(Gene gene) {
    }

    public String getFullDNA() {
        return "";
    }

    public boolean hasMatchingGene(Organism other) {
        return false;
    }

    public String getName() {
        return "";
    }

    public int getGeneCount() {
        return -1;
    }
}

class DnaLab {
    private ArrayList<Organism> organisms;

    public DnaLab() {
    }

    public void registerOrganism(Organism org) {
    }

    public ArrayList<String> getOrganismsWithGenePattern(String pattern) {
        return new ArrayList<>();
    }

    public String generateReport() {
        return "";
    }
}

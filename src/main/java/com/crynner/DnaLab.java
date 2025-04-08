package com.crynner;

import java.util.List;
import java.util.ArrayList;

class Nucleotide {
    public static String validBases = "ACTG";
    private char base;

    public Nucleotide(char base) {
        if (validBases.indexOf(base) == -1) {
            this.base = 'A';
            return;
        }
        this.base = base;
    }

    public char getBase() {
        return base;
    }

    public String getComplement() {
        switch (base){
        case 'A':
            return "T";
        case 'T':
            return "A";
        case 'C':
            return "G";
        case 'G':
            return "C";
        default: // base is invalid - impossible case
            return "\0";
        }
        
    }
}

class Gene {
    private List<Nucleotide> bases = new ArrayList<>();

    public Gene(String sequence) {
        for (char c : sequence.toCharArray()) {
            if (Nucleotide.validBases.indexOf(c) != -1) { // valid base
                bases.add(new Nucleotide(c));
            }
        }
    }

    public String getSequence() {
        String sequence = "";
        for (Nucleotide n : bases) {
            sequence += n.getBase();
        }
        return sequence;
    }

    public String getComplementarySequence() {
        String sequence = "";
        for (Nucleotide n : bases) {
            sequence += n.getComplement();
        }
        return sequence;
    }

    public boolean containsPattern(String pattern) {
        return getSequence().contains(pattern);
    }

    public int countOccurrences(String subsequence) {
        String mainString = getSequence();
        int index = 0;
        int counter = 0;
        while (index != -1) {
            index = mainString.indexOf(subsequence, index);
            if (index != -1) { // if match found
                counter++;
                index += subsequence.length();
            }
        }
        return counter;
    }
}

class Organism {
    private String name;
    private List<Gene> genes = new ArrayList<>();

    public Organism(String name) {
        this.name = name;
    }

    public void addGene(Gene gene) {
        genes.add(gene);
    }

    public List<Gene> getGenes() {
        return genes;
    }

    public String getFullDNA() {
        String totalStr = "";
        for (Gene gene : genes) {
            totalStr += gene.getSequence();
        }
        return totalStr;
    }

    public boolean hasMatchingGene(Organism other) {
        for (Gene gene : genes) {
            for (Gene otherGene : other.getGenes()) {
                if (gene.getSequence().equals(otherGene.getSequence())) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getGeneCount() {
        return genes.size();
    }
}

class DnaLab {
    private List<Organism> organisms = new ArrayList<>();

    public DnaLab() {}

    public void registerOrganism(Organism org) {
        organisms.add(org);
    }

    public ArrayList<String> getOrganismsWithGenePattern(String pattern) {
        ArrayList<String> matching = new ArrayList<>();
        for (Organism org : organisms) {
            for (Gene gene : org.getGenes()) {
                if (gene.getSequence().contains(pattern)) {
                    matching.add(org.getName());
                }
            }
        }
        return matching;
    }

    public String generateReport() {
        String joinedTotal = "";
        for (Organism org : organisms) {
            joinedTotal += String.format("Organism: %s\nGene Count: %d\n", org.getName(), org.getGeneCount());
        }
        return joinedTotal;
    }
}

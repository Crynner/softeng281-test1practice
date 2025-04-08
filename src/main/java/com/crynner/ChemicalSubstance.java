package com.crynner;

import java.util.ArrayList;

abstract class ChemicalSubstance {
    private String name;
    private String symbol;

    public ChemicalSubstance(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract String describe();
    public abstract boolean reactsWith(ChemicalSubstance other);

    @Override
    public String toString() {
        return describe();
    }
}

class Element extends ChemicalSubstance {

    public Element(String name, String symbol, int atomicNumber) {
    }

    public int getAtomicNumber() {
        return 0;
    }

    @Override
    public String describe() {
        return null;
    }

    @Override
    public boolean reactsWith(ChemicalSubstance other) {
        return false;
    }
}

class Compound extends ChemicalSubstance {

    public Compound(String name, String symbol, ArrayList<Element> components) {
    }

    public ArrayList<Element> getComponents() {
    }

    @Override
    public String describe() {
        return null;
    }

    @Override
    public boolean reactsWith(ChemicalSubstance other) {
        return false;
    }
}

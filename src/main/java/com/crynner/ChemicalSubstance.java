package com.crynner;

import java.util.ArrayList;

abstract class ChemicalSubstance {

    public ChemicalSubstance(String name, String symbol) {
    }

    public String getName() {
        return "";
    }

    public String getSymbol() {
        return "";
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

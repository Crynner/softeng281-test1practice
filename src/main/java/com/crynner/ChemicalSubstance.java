package com.crynner;

import java.util.ArrayList;

abstract class ChemicalSubstance {
    protected String name;
    protected String symbol;

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
    private int atomicNumber;

    public Element(String name, String symbol, int atomicNumber) {
        super(name, symbol);
        this.atomicNumber = atomicNumber;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    @Override
    public String describe() {
        return String.format("%s [%s] - Atomic Number: %d", name, symbol, atomicNumber);
    }

    @Override
    public boolean reactsWith(ChemicalSubstance other) {
        if (other.getClass() == Compound.class) {
            return other.reactsWith(this);
        }
        return false;
    }
}

class Compound extends ChemicalSubstance {
    private ArrayList<Element> components;

    public Compound(String name, String symbol, ArrayList<Element> components) {
        super(name, symbol);
        this.components = components;
    }

    public ArrayList<Element> getComponents() {
        return components;
    }

    @Override
    public String describe() {
        String joinedStr = "";
        for (Element element : components) {
            if (!joinedStr.equals("")) {
                joinedStr += ", ";
            }
            joinedStr += element.getSymbol();
        }
        return String.format("%s [%s] - Composed of: %s", name, symbol, joinedStr);
    }

    @Override
    public boolean reactsWith(ChemicalSubstance other) {
        return other != null && Element.class == other.getClass() && components.contains(other);
    }
}

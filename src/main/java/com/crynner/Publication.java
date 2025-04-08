package com.crynner;

abstract class Publication {
    // TODO: fields, constructor

    public String getSummary() {
        return null; // return "<title> - <year>"
    }

    public abstract int getLength();

    public abstract void updateInfo();
}

class Book extends Publication {
    // TODO: fields, constructors

    @Override
    public int getLength() {
        return -1;
    }

    @Override
    public void updateInfo() {
        // increase page count
    }

    @Override
    public String toString() {
        return "";
    }
}

class Magazine extends Publication {
    // TODO: fields, constructor

    @Override
    public int getLength() {
        return -1;
    }

    @Override
    public void updateInfo() {
        // increase issue number, maybe year
    }

    @Override
    public String toString() {
        return "";
    }
}
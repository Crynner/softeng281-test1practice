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
    // TODO: fields

    public Book(String name, int yearPublished, String author, int pageNumber){
    }

    public Book(String name, String author){
    }

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
    // TODO: fields

    public Magazine(String name, int yearPublished, int issueNumber, boolean monthly){
    }

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
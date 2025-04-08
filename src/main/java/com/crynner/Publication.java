package com.crynner;

abstract class Publication {
    protected String name;
    protected int yearPublished;

    public Publication(String name, int year) {
        this.name = name;
        this.yearPublished = year;
    }

    public String getSummary() {
        return String.format("%s - %d", name, yearPublished); // return "<title> - <year>"
    }

    public abstract int getLength();

    public abstract void updateInfo();
}

class Book extends Publication {
    private String author;
    private int pageNumber;

    public Book(String name, int yearPublished, String author, int pageNumber){
        super(name, yearPublished);
        this.author = author;
        this.pageNumber = pageNumber;
    }

    public Book(String name, String author){
        super(name, 2024);
        this.author = author;
        pageNumber = 100;
    }

    @Override
    public int getLength() {
        return pageNumber;
    }

    @Override
    public void updateInfo() {
        pageNumber += 10;
    }

    @Override
    public String toString() {
        return String.format("%s by %s (%d pages)", name, author, pageNumber);
    }
}

class Magazine extends Publication {
    private int issueNum;
    private boolean monthly;

    public Magazine(String name, int yearPublished, int issueNumber, boolean monthly){
        super(name, yearPublished);
        issueNum = issueNumber;
        this.monthly = monthly;
    }

    @Override
    public int getLength() {
        return issueNum;
    }

    @Override
    public void updateInfo() {
        issueNum += 1;
        if (monthly) {
            yearPublished += 1;
        }
    }

    @Override
    public String toString() {
        return String.format("%s - Issue %d (%d)", name, issueNum, yearPublished);
    }
}
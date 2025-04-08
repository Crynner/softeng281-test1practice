package com.crynner;

import java.util.List;

public class Library {
    // Method to add a specific number of copies of a book to the library
    public void addBook(LibraryBook book, int copies) {
        // Implement this method
    }

    // Method to allow a user to borrow a book if available
    public void borrowBook(User user, LibraryBook book) {
        // Implement this method
    }

    // Method to allow a user to return a borrowed copy of a book
    public void returnBook(User user, LibraryBook book) {
        // Implement this method
    }

    // Method to get the number of available copies of the specified book
    public int getAvailableCopies(LibraryBook book) {
        // Implement this method
        return 0;
    }

    // Method to get a list of users who currently have a copy of the specified book
    public List<User> getPossessors(LibraryBook book) {
        // Implement this method
        return null;
    }
}

class User {
    // Constructor to initialize a user with a given name
    public User(String name) {
        // Implement this method
    }

    // Method to return a list of books currently borrowed by the user
    public List<LibraryBook> borrowedBooks() {
        // Implement this method
        return null;
    }

    // Method to add a borrowed book to the user's list of borrowed books
    public void borrowBook(LibraryBook book) {
        // Implement this method
    }

    // Method to remove a book from the user's borrowed books list
    public void returnBook(LibraryBook book) {
        // Implement this method
    }

    // Method to return a string representation of the user’s name followed by the list of books they are currently in possession of
    @Override
    public String toString() {
        // Implement this method
        return null;
    }
}

class LibraryBook {
    // Constructor to initialize a book with a title
    public LibraryBook(String title) {
        // Implement this method
    }

    // Method to return the title of the book
    public String getTitle() {
        // Implement this method
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        // Implement this method
        return false;
    }

    @Override
    public int hashCode() {
        // Implement this method
        return 0;
    }
}

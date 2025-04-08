package com.crynner;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Library {
    private Map<LibraryBook, Integer> bookList = new HashMap<>();
    private Map<LibraryBook, List<User>> borrowList = new HashMap<>();
    public void addBook(LibraryBook book, int copies) {
        bookList.put(book, copies);
        borrowList.put(book, new ArrayList<>());
    }

    public void borrowBook(User user, LibraryBook book) {
        if (bookList.get(book) != 0 && bookList.get(book) != null) {
            bookList.put(book, bookList.get(book) - 1);
            borrowList.get(book).add(user);
            user.borrowBook(book);
        }
    }

    // Method to allow a user to return a borrowed copy of a book
    public void returnBook(User user, LibraryBook book) {
        if (borrowList.get(book).contains(user)) {
            bookList.put(book, bookList.get(book) + 1);
            borrowList.get(book).remove(user);
            user.returnBook(book);
        }
    }

    // Method to get the number of available copies of the specified book
    public int getAvailableCopies(LibraryBook book) {
        return bookList.get(book);
    }

    // Method to get a list of users who currently have a copy of the specified book
    public List<User> getPossessors(LibraryBook book) {
        return borrowList.get(book);
    }
}

class User {
    private String name;
    private List<LibraryBook> borrowedBooks = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    // Method to return a list of books currently borrowed by the user
    public List<LibraryBook> borrowedBooks() {
        return borrowedBooks;
    }

    // Method to add a borrowed book to the user's list of borrowed books
    public void borrowBook(LibraryBook book) {
        borrowedBooks.add(book);
    }

    // Method to remove a book from the user's borrowed books list
    public void returnBook(LibraryBook book) {
        borrowedBooks.remove(book);
    }

    // Method to return a string representation of the user’s name followed by the list of books they are currently in possession of
    @Override
    public String toString() {
        String joinedBooks = "";
        if (borrowedBooks.size() == 0) {
            joinedBooks = "No books borrowed";
        } else {
            for (LibraryBook book : borrowedBooks) {
                if (!joinedBooks.equals("")) {
                    joinedBooks += ", ";
                }
                joinedBooks += book.getTitle();
            }
        }
        return String.format("%s: %s", name, joinedBooks);
    }
}

class LibraryBook {
    private String title;

    public LibraryBook(String title) {
        this.title  = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LibraryBook)) {
            return false;
        }
        if (title == ((LibraryBook)obj).getTitle()) {
            return true;
        }
        return false;
    }
}

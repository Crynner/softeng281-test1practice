package com.crynner;

public class BankAccount {
    // Add necessary fields here
    static int totalAccounts = 0;

    public BankAccount() {
        // Constructor implementation
    }

    public void deposit(double amount) {
        // Implement this method
    }

    public void withdraw(double amount) {
        // Implement this method
    }

    public void transferTo(BankAccount other, double amount) {
        // Implement this method
    }

    public static int getTotalAccounts() {
        // Implement this method
        return 0;
    }

    // DO NOT EDIT
    public static void resetTotalAccounts() {
        totalAccounts = 0;
    }
}


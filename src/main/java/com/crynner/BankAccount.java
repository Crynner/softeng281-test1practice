package com.crynner;

public class BankAccount {
    static int totalAccounts = 0;
    double balance;

    public BankAccount(double balance) {
        this.balance = balance;
        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (balance > amount) {
            balance -= amount;
        }
    }

    public void transferTo(BankAccount other, double amount) {
        if (balance > amount) {
            withdraw(amount);
            other.deposit(amount);
        }
    }

    public double getBalance(){
        return balance;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    // DO NOT EDIT
    public static void resetTotalAccounts() {
        totalAccounts = 0;
    }
}


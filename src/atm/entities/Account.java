package atm.entities;

import java.util.HashMap;
import java.util.Map;

public class Account {
    private final String accountNumber;
    private final String accountOwner;
    private double balance;
    private final Map<String, Card> cards;

    public Account(String accountNumber, String accountOwner) {
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
        this.cards = new HashMap<>();
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Map<String, Card> getCards() {
        return cards;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
    }

    public synchronized boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

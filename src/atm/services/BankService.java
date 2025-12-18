package atm.services;

import atm.entities.Account;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankService {
    private final Map<String, Account> accounts = new ConcurrentHashMap<>();

    public void addAccount(Account account){
        accounts.put(account.getAccountNumber(),account);
    }

    public Account getAccount(String accountId){
        return accounts.get(accountId);
    }


    public double getBalance(String accountId) {
        return getAccount(accountId).getBalance();
    }

    public void withdraw(String accountId, double amount) {
        getAccount(accountId).withdraw(amount);
    }

    public void deposit(String accountId, double amount) {
        getAccount(accountId).deposit(amount);
    }
}

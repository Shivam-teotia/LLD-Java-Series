package atm.services;

import atm.entities.CashDispenser;

public class AtmService {
    private final BankService bankService;
    private final CashDispenser cashDispenser;

    public AtmService(BankService bankService, CashDispenser cashDispenser) {
        this.bankService = bankService;
        this.cashDispenser = cashDispenser;
    }

    public double checkBalance(String accountNumber){
        return bankService.getBalance(accountNumber);
    }

    public void withdraw(String accountId, double amount) {
        synchronized (this) {
            bankService.withdraw(accountId, amount);
            cashDispenser.dispense(amount);
        }
    }

    public void deposit(String accountId, double amount) {
        synchronized (this) {
            bankService.deposit(accountId, amount);
            cashDispenser.acceptDeposit(amount);
        }
    }
}

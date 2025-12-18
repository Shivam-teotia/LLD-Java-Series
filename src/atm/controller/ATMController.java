package atm.controller;

import atm.entities.ATMContext;
import atm.services.AtmService;
import atm.state.AuthenticatedState;

public class ATMController {
    private final AtmService atmService;
    private final ATMContext atmContext;

    public ATMController(AtmService atmService, ATMContext atmContext) {
        this.atmService = atmService;
        this.atmContext = atmContext;
    }

    public void withdraw(double amount) {
        atmContext.withdraw(amount);
        atmService.withdraw(atmContext.getCurrentCard().getAccountNumber(), amount);
        atmContext.setState(new AuthenticatedState());
        System.out.println("Withdrawn: " + amount);
    }

    public void deposit(double amount) {
        atmContext.deposit(amount);
        atmService.deposit(atmContext.getCurrentCard().getAccountNumber(), amount);
        atmContext.setState(new AuthenticatedState());
        System.out.println("Deposited: " + amount);
    }

    public void balance() {
        double balance = atmService.checkBalance(atmContext.getCurrentCard().getAccountNumber());
        System.out.println("Balance: " + balance);
    }
}

package atm.entities;

public class CashDispenser {
    private double totalCash;

    public CashDispenser(double initialCash) {
        this.totalCash = initialCash;
    }

    public synchronized void dispense(double amount) {
        if (totalCash < amount) {
            throw new IllegalStateException("ATM out of cash");
        }
        totalCash -= amount;
    }

    public synchronized void acceptDeposit(double amount) {
        totalCash += amount;
    }
}

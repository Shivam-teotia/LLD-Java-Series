package atm.state;

import atm.entities.ATMContext;
import atm.entities.Card;

public interface ATMState {
    void insertCard(ATMContext atm, Card card);
    void enterPin(ATMContext atm, String pin);
    void withdraw(ATMContext atm, double amount);
    void deposit(ATMContext atm, double amount);
    void ejectCard(ATMContext atm);
}

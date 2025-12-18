package atm.state;

import atm.entities.ATMContext;
import atm.entities.Card;

public class TransactionState implements ATMState{
    public void insertCard(ATMContext atm, Card card) { throw new RuntimeException("Transaction in progress"); }
    public void enterPin(ATMContext atm, String pin) { throw new RuntimeException("Transaction in progress"); }
    public void withdraw(ATMContext atm, double amount) { throw new RuntimeException("Already processing"); }
    public void deposit(ATMContext atm, double amount) { throw new RuntimeException("Already processing"); }
    public void ejectCard(ATMContext atm) { throw new RuntimeException("Wait for completion"); }
}

package atm.state;

import atm.entities.ATMContext;
import atm.entities.Card;

public class AuthenticatedState implements ATMState{
    public void insertCard(ATMContext atm, Card card) { throw new RuntimeException("Session active"); }
    public void enterPin(ATMContext atm, String pin) { throw new RuntimeException("Already authenticated"); }

    public void withdraw(ATMContext atm, double amount) {
        atm.setState(new TransactionState());
    }

    public void deposit(ATMContext atm, double amount) {
        atm.setState(new TransactionState());
    }

    public void ejectCard(ATMContext atm) {
        atm.setCurrentCard(null);
        atm.setState(new IdleState());
        System.out.println("Card ejected");
    }
}

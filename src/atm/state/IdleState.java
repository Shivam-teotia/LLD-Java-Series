package atm.state;

import atm.entities.ATMContext;
import atm.entities.Card;

public class IdleState implements ATMState{
    public void insertCard(ATMContext atm, Card card) {
        atm.setCurrentCard(card);
        atm.setState(new CardInsertedState());
        System.out.println("Card inserted");
    }
    public void enterPin(ATMContext atm, String pin) { throw new RuntimeException("Insert card first"); }
    public void withdraw(ATMContext atm, double amount) { throw new RuntimeException("Authenticate first"); }
    public void deposit(ATMContext atm, double amount) { throw new RuntimeException("Authenticate first"); }
    public void ejectCard(ATMContext atm) { throw new RuntimeException("No card to eject"); }
}

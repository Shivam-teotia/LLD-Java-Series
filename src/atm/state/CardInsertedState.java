package atm.state;

import atm.entities.ATMContext;
import atm.entities.Card;

public class CardInsertedState implements ATMState{
    public void insertCard(ATMContext atm, Card card) {
        throw new RuntimeException("Card already inserted");
    }

    public void enterPin(ATMContext atm, String pin) {
        if (validatePin(pin,atm)) {
            atm.setState(new AuthenticatedState());
            System.out.println("PIN validated");
        } else {
            throw new RuntimeException("Invalid PIN");
        }
    }

    public void withdraw(ATMContext atm, double amount) { throw new RuntimeException("Enter PIN first"); }
    public void deposit(ATMContext atm, double amount) { throw new RuntimeException("Enter PIN first"); }

    public void ejectCard(ATMContext atm) {
        atm.setCurrentCard(null);
        atm.setState(new IdleState());
        System.out.println("Card ejected");
    }

    private boolean validatePin(String pin, ATMContext atm){
        String cardPin = atm.getCurrentCard().getPin();
        return cardPin.equals(pin);
    }
}

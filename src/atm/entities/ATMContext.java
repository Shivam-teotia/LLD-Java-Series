package atm.entities;

import atm.state.ATMState;
import atm.state.IdleState;

public class ATMContext {
    private ATMState currentState;
    private Card currentCard;

    public ATMContext() {
        this.currentState = new IdleState();
    }

    public void setState(ATMState state) {
        this.currentState = state;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card card) {
        this.currentCard = card;
    }

    public void insertCard(Card card) {
        currentState.insertCard(this, card);
    }

    public void enterPin(String pin) {
        currentState.enterPin(this, pin);
    }

    public void withdraw(double amount) {
        currentState.withdraw(this, amount);
    }

    public void deposit(double amount) {
        currentState.deposit(this, amount);
    }

    public void ejectCard() {
        currentState.ejectCard(this);
    }
}

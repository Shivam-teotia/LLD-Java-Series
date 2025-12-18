package atm.entities;

public class Card {
    private final String cardNumber;
    private String pin;
    private boolean isActivate;
    private final String accountNumber;

    public Card(String cardNumber, String accountNumber) {
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
        this.pin = null;
        this.isActivate = true;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public boolean isActivate() {
        return isActivate;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setActivate(boolean activate) {
        isActivate = activate;
    }
}

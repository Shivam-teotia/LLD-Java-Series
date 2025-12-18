package atm.entities;

import java.time.LocalDateTime;

public abstract class Transaction {
    protected final String transactionId;
    protected final double amount;
    protected final LocalDateTime timestamp;

    protected Transaction(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public abstract void execute();
}

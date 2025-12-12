package designPatterns.adapter;

public class Main {
    public static void main(String[] args){
        PaymentProcessor processor = new InhousePayment();
        CheckoutService checkout = new CheckoutService(processor);
        checkout.checkout(199.99, "USD");

        System.out.println("\n--- Using Legacy Gateway via Adapter ---");
        LegacyGateway legacy = new LegacyGateway();
        processor = new LegacyGatewayAdapter(legacy);
        CheckoutService legacyCheckout = new CheckoutService(processor);
        legacyCheckout.checkout(75.50, "USD");
    }
}

package atm;

import atm.controller.ATMController;
import atm.entities.ATMContext;
import atm.entities.Account;
import atm.entities.Card;
import atm.entities.CashDispenser;
import atm.services.AtmService;
import atm.services.BankService;

public class Main {
    public static void main(String[] args) {

        // Setup
        BankService bankingService = new BankService();
        Account account = new Account("ACC123", "Shivam");
        bankingService.addAccount(account);

        Card card = new Card("CARD123", "ACC123");

        AtmService atmService = new AtmService(bankingService, new CashDispenser(10000));
        ATMContext atmContext = new ATMContext();
        ATMController controller = new ATMController(atmService,atmContext);

        System.out.println("\n✅ VALID FLOW");
        try {
            atmContext.insertCard(card);
            atmContext.enterPin("1234");
            controller.balance();
            controller.withdraw(1000);
            controller.deposit(500);
            controller.balance();
            atmContext.ejectCard();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n❌ INVALID FLOW (Wrong PIN)");
        try {
            atmContext.insertCard(card);
            atmContext.enterPin("9999");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n❌ INVALID FLOW (Withdraw without auth)");
        try {
            atmContext.withdraw(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

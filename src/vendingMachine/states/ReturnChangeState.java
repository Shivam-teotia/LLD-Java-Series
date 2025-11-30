package vendingMachine.states;

import vendingMachine.entities.VendingMachine;
import vendingMachine.enums.ItemType;

public class ReturnChangeState implements VendingMachineState{
    @Override
    public void selectItem(VendingMachine vendingMachine, ItemType itemType) {
        System.out.println("Returning change...");
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, int amount) {
        System.out.println("Returning change...");
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        System.out.println("Returning change...");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        int price = vendingMachine.getInventory().getItem(vendingMachine.getSelectedItem()).getPrice();
        int change = vendingMachine.getCurrentAmount() - price;
        if (change > 0) {
            System.out.println("Returning change: " + change);
        }
        vendingMachine.reset();
    }
}

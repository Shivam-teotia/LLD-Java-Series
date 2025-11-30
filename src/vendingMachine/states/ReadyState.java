package vendingMachine.states;

import vendingMachine.entities.VendingMachine;
import vendingMachine.enums.ItemType;

public class ReadyState implements VendingMachineState{
    @Override
    public void selectItem(VendingMachine vendingMachine, ItemType itemType) {
        System.out.println("Item already selected. Cancel or insert money.");
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, int amount) {
        vendingMachine.setCurrentAmount(vendingMachine.getCurrentAmount() + amount);
        int price = vendingMachine.getInventory().getItem(vendingMachine.getSelectedItem()).getPrice();

        if(vendingMachine.getCurrentAmount() >= price){
            vendingMachine.setState(new DispenseState());
            System.out.println("Money sufficient. Dispensing...");
        }
        else{
            System.out.println("Insert more money. Remaining: " + (price - vendingMachine.getCurrentAmount()));
        }
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        System.out.println("Insert money first!");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        System.out.println("Insert money first!");
    }
}

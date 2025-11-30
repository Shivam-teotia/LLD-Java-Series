package vendingMachine.states;

import vendingMachine.entities.VendingMachine;
import vendingMachine.enums.ItemType;

public class IdleState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine vendingMachine, ItemType itemType) {
        if(!vendingMachine.getInventory().isAvailable(itemType)){
            System.out.println("Item out of stock!");
            return;
        }
        vendingMachine.setSelectedItem(itemType);
        vendingMachine.setState(new ReadyState());
        System.out.println("Item selected: " + itemType);
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, int amount) {
        System.out.println("Select item first!");
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        System.out.println("Select item first!");
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        System.out.println("Select item first!");
    }
}

package vendingMachine.states;

import vendingMachine.entities.VendingMachine;
import vendingMachine.enums.ItemType;

public class DispenseState implements VendingMachineState{
    @Override
    public void selectItem(VendingMachine vendingMachine, ItemType itemType) {
        System.out.println("Dispensing in progress!");
    }

    @Override
    public void insertMoney(VendingMachine vendingMachine, int amount) {
        System.out.println("Dispensing in progress!");
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        ItemType itemType = vendingMachine.getSelectedItem();
        vendingMachine.getInventory().reduce(itemType);
        System.out.println("Dispensed: " + itemType);
        vendingMachine.setState(new ReturnChangeState());
    }

    @Override
    public void returnChange(VendingMachine vendingMachine) {
        System.out.println("Dispensing in progress!");
    }
}

package vendingMachine.states;

import vendingMachine.entities.VendingMachine;
import vendingMachine.enums.ItemType;

public interface VendingMachineState {
    void selectItem(VendingMachine vendingMachine , ItemType itemType);
    void insertMoney(VendingMachine vendingMachine, int amount);
    void dispense(VendingMachine vendingMachine);
    void returnChange(VendingMachine vendingMachine);
}

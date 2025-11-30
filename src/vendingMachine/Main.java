package vendingMachine;

import vendingMachine.entities.Item;
import vendingMachine.entities.VendingMachine;
import vendingMachine.enums.ItemType;

public class Main {
    public static void main(String[] args){
        VendingMachine machine = new VendingMachine();

        machine.getInventory().addItem(new Item(ItemType.COKE, 25), 10);
        machine.getInventory().addItem(new Item(ItemType.PEPSI, 35), 5);

        machine.selectItem(ItemType.COKE);
        machine.insertMoney(10);
        machine.insertMoney(20);
        machine.dispense();
        machine.returnChange();
    }
}

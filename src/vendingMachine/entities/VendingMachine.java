package vendingMachine.entities;

import vendingMachine.enums.ItemType;
import vendingMachine.states.IdleState;
import vendingMachine.states.VendingMachineState;

public class VendingMachine {
    private VendingMachineState state;
    private final Inventory inventory;
    private ItemType selectedItem;
    private int currentAmount=0;

    public VendingMachine(){
        this.state = new IdleState();
        this.inventory = new Inventory();
    }

    public void selectItem(ItemType itemType){
        state.selectItem(this,itemType);
    }

    public void insertMoney(int amount) {
        state.insertMoney(this, amount);
    }

    public void dispense() {
        state.dispense(this);
    }

    public void returnChange() {
        state.returnChange(this);
    }

    public void setState(VendingMachineState state){
        this.state = state;
    }

    public VendingMachineState getState() {
        return state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setSelectedItem(ItemType selectedItem) {
        this.selectedItem = selectedItem;
    }

    public ItemType getSelectedItem() {
        return selectedItem;
    }

    public void setCurrentAmount(int amount) {
        this.currentAmount = amount;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public void reset(){
        this.state = new IdleState();
        this.currentAmount = 0;
        this.selectedItem = null;
    }
}

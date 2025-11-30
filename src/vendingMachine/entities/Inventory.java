package vendingMachine.entities;

import vendingMachine.enums.ItemType;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<ItemType,Integer> stocks=new HashMap<>();
    private final Map<ItemType, Item> itemInfo = new HashMap<>();

    public void addItem(Item item, int quantity){
        stocks.put(item.getItemType(),stocks.getOrDefault(item.getItemType(),0) + quantity);
        itemInfo.put(item.getItemType(),item);
    }

    public boolean isAvailable(ItemType itemType){
        return stocks.getOrDefault(itemType,0) > 0;
    }

    public void reduce(ItemType itemType){
        stocks.put(itemType,stocks.get(itemType)-1);
    }

    public Item getItem(ItemType itemType){
        return itemInfo.get(itemType);
    }
}

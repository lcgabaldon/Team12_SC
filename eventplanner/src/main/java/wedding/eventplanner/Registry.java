package wedding.eventplanner;

import java.util.ArrayList;

public class Registry {
    private String couple; // i.e., "Jane Doe"
    private String wedDate; // i.e., "December 12, 2024"
    private ArrayList<Item> items; // this is the list of items in the registry

    public Registry(String couple, String wedDate) {
        this.couple = couple;
        this.wedDate = wedDate;
        this.items = new ArrayList<>(); // initialize the list with the items in the "Item" class
    }

    public String getCouple() {
        return couple;
    }

    public String getWedDate() {
        return wedDate;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(String itemName, String description, double price, int itemNum, int requestedAmt, int amtNeeded,
            boolean purchased) {
        items.add(new Item(itemName, description, price, itemNum, requestedAmt, amtNeeded, purchased));
    }

    /**
     * Displays the contents of the registry list for the corresponding couple
     */
    public void displayRegistry() {
        System.out.println("Registry for " + couple + ":");
        for (Item item : items) {
            System.out.println(item);
        }
    }

    /**
     * Purchases the item from the registry and marks the item as purchased
     */
    public boolean purchaseItem(String itemName) {
        for (Item item : items) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                if (item.getAmtNeeded() <= 0) {
                    System.out.println("This item has already been purchased");
                } else {
                    item.setPurchasedStatus(true);
                    return true;
                }
            }
        }
        System.out.println("Item not found in registry.");
        return false;
    }
}
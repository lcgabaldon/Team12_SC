package com;
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

    public void addItem(String itemName, String description, double price, int itemNum, int requestedAmt, int amtNeeded, boolean purchased) {
        items.add(new Item(itemName, description, price, itemNum, requestedAmt, amtNeeded, purchased));
    }

    /**
     * Displays the contents of the registry list for the corresponding couple
     */
    public void displayRegistry(String couple, ArrayList<Item> items) {
        for (Item itemN : items) { 
            System.out.println(itemN); 
        }
    }

    /**
     * Purchases the item from the registry and marks the item as purchased
     */
    public boolean purchaseItem(String itemName, ArrayList<Item> items) {
        for (Item item : items) {
            if (item.getAmtNeeded() <= 0) {
                System.out.println("This item has already been purchased");
            } else if (item.getAmtNeeded() > 0) {
                // Assuming there's a setter method for purchased status
                item.setPurchasedStatus(true); // Corrected line
                return true;
            }
        }
        return false;
    }

    
}
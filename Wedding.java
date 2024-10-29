import java.util.ArrayList;

public class Wedding {
    private String couple;         // Names of the couple getting married
    private String weddingDate;    // Date of the wedding
    private String location;       // Location of the wedding
    private Registry registry;     // Registry object associated with this wedding

    // Constructor for the Wedding class
    public Wedding(String couple, String weddingDate, String location) {
        this.couple = couple;
        this.weddingDate = weddingDate;
        this.location = location;
        this.registry = new Registry(couple, weddingDate); // Create a new registry for the couple
    }

    // Getters for Wedding attributes
    public String getCouple() {
        return couple;
    }

    public String getWeddingDate() {
        return weddingDate;
    }

    public String getLocation() {
        return location;
    }

    public Registry getRegistry() {
        return registry;
    }

    // Displays wedding details along with the registry items
    public void displayWeddingDetails() {
        System.out.println("Wedding Details:");
        System.out.println("Couple: " + couple);
        System.out.println("Date: " + weddingDate);
        System.out.println("Location: " + location);
        System.out.println("Registry Items:");
        registry.displayRegistry(couple);
    }

    // Adds an item to the wedding registry
    public void addRegistryItem(String itemName, String description, double price, int itemNum, int requestedAmt, int amtNeeded, boolean purchased) {
        registry.addItem(itemName, description, price, itemNum, requestedAmt, amtNeeded, purchased);
    }

    // Purchases an item from the registry
    public boolean purchaseRegistryItem(String itemName) {
        return registry.purchaseItem(itemName);
    }
}

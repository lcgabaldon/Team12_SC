package wedding.eventplanner;

public class RegistryItem {

    private String id; // Unique identifier for the registry item
    private String eventId; // ID of the associated event (wedding)
    private String itemName; // Name of the item (e.g., "Dinnerware Set")
    private String description; // Description of the item
    private int quantity; // Desired quantity of the item
    private int purchasedQuantity; // Quantity already purchased (optional)

    // Constructors
    public RegistryItem() {
        // Default constructor required for Firebase or Jackson
        // serialization/deserialization
    }

    public RegistryItem(String id, String eventId, String itemName, String description, int quantity,
            int purchasedQuantity) {
        this.id = id;
        this.eventId = eventId;
        this.itemName = itemName;
        this.description = description;
        this.quantity = quantity;
        this.purchasedQuantity = purchasedQuantity;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPurchasedQuantity() {
        return purchasedQuantity;
    }

    public void setPurchasedQuantity(int purchasedQuantity) {
        this.purchasedQuantity = purchasedQuantity;
    }

    // Additional methods like toString, equals, and hashCode can be added if needed
}

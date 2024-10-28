public class Item {
    private String itemName;
    private String description;
    private double price;
    private int itemNum;
    private int amtNeeded;
    private int requestedAmt;
    private boolean purchased;

    public Item(String itemName, String description, double price, int itemNum, int requestedAmt, int amtNeeded, boolean purchased) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.itemNum = itemNum;
        this.requestedAmt = requestedAmt;
        this.amtNeeded = amtNeeded;
        this.purchased = purchased;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getItemNum() {
        return itemNum;
    }

    public int getRequestedAmt() {
        return requestedAmt;
    }

    public int getAmtNeeded() {
        return amtNeeded;
    }

    public boolean getPurchaseStatus() {
        return purchased;
    }

    public void purchase() {
        purchased = true;
    }
}
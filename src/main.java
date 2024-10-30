public class main {
    public static void main(String[] args) {
        Registry registry = new Registry("John & Jane Doe", "December 12, 2024");
    
        // add items
        // get user input from bride and groom then add items
        Registry.addItem();
    
        // display registry
        Registry.displayRegistry(Registry.getCouple().get);
        
        // purchase item
    
        // we need to get an item via input from the bride/groom (they can do something like registry.addItem(cuttingBoard)) 
        // -> keep in mind this will need to come from a database of items, where exactly will we get them from?
    }
}


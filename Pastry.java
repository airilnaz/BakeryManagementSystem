public class Pastry extends Product {
    private PastryType type;
    
    public Pastry(String pID, String pName, double bPrice, int qInStock, String cat, PastryType type) {
    super(pID, pName, bPrice, qInStock, cat);
    this.type = type;
    }
    
    public void displayProduct() {
    System.out.printf("%-6s %-25s %-15s RM%-8.2f %d\n",getID(), getName(), type, getPrice(), getQuantityInStock());
    }
    
    public PastryType getType() {
        return type;
    }
}

public class Cake extends Product {
    private String customMessage;
    private double weight;
    
    public Cake(String pID, String pName, double bPrice, int qInStock, String cat, String cMsg, double wt) {
        super(pID, pName, bPrice, qInStock, cat);
        customMessage = cMsg;
        weight = wt;
        
    } 
    
    @Override
    public void displayProduct() {
    System.out.printf("%-6s %-25s %-6.1f %-20s RM%-8.2f %d\n", getID(), getName(), getWeight(), getCustomMessage(), getPrice(), getQuantityInStock());
    }
    
    public String getCustomMessage() {
        return customMessage;
    }
    
    public double getWeight() {
        return weight;
    }
}

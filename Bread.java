public class Bread  extends Product {
    private boolean isSliced;
    
    public Bread(String pID, String pName, double bPrice, int qInStock, String cat, boolean iSl) {
        super(pID, pName, bPrice, qInStock, cat);
        isSliced = iSl;
    }
    
    public void displayProduct() {
        String breadType = isSliced ? "Sliced Loaf" : "Whole Loaf";
        
        System.out.printf("%-6s %-25s %-15s RM%-8.2f %d\n", getID(), getName(), breadType, getPrice(), getQuantityInStock());
    }
    
    public boolean getIsSliced() { return isSliced; }
}

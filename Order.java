import java.util.ArrayList;

public class Order {

    private static int orderCounter = 1000;

    private int orderNumber;
    private String customerName;
    private ArrayList<CartItem> items;
    private double total;
    private double subtotal;
    private double discount;

    public Order(String customerName, Cart cart, double finalTotal, double discount, double subtotal) {
        this.orderNumber = ++orderCounter;
        this.customerName = customerName;
        this.total = finalTotal;
        this.discount = discount;
        this.subtotal = subtotal;

        // Copy cart items into this order's own list (snapshot)
        this.items = new ArrayList<>();
        for (CartItem ci : cart.getCartItems()) {
            items.add(new CartItem(ci.getItem(), ci.getQuantity()));

            ci.getItem().updateStock(-ci.getQuantity());
        }
    }

    public int    getOrderNumber()  { 
        return orderNumber;
    }
    public String getCustomerName() {
        return customerName;
    }
    public double getTotal()        { 
        return total;        

    }

    public void displayReceipt() {
        System.out.println();
        System.out.println("  ==========================================");
        System.out.printf ("  Order #%d%n", orderNumber);
        System.out.printf ("  Customer : %s%n", customerName);
        System.out.println("  ------------------------------------------");

        for (CartItem ci : items) {
            System.out.println(ci);
        }

        System.out.println("  ------------------------------------------");
        System.out.printf ("  SUBTOTAL : RM%.2f%n", subtotal);
        System.out.printf ("  Discount Applied : RM%.2f%n", discount);
        System.out.printf ("  TOTAL PAID : RM%.2f%n", total);
        System.out.println("  Thank you! Please collect at the counter.");
        System.out.println("  ==========================================");
    }
}

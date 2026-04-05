public class Payment {
    private String paymentID;
    private double amountTendered;
    private PaymentMethod method;
    private boolean isSuccessful;
    
    public Payment(String pID, double amount, PaymentMethod method) {
        if (amount < 0) {
            throw new IllegalArgumentException("Error: Payment amount cannot be negative");
        }
        paymentID = pID;
        amountTendered = amount;
        this.method = method;
        isSuccessful = false;
    }
    
    public void processPayment(double orderTotal) {
        if(orderTotal <= 0) {
            throw new IllegalArgumentException("Error: Order total must be greater than 0.");
        }
        
        System.out.println("Processing " + method + " payment with RM" + String.format("%.2f", orderTotal) + "....");
        if (amountTendered >= orderTotal) {
            isSuccessful = true;
            System.out.println("Payment Approved!");
        }
        else {
            isSuccessful = false;
            double shortAmount = orderTotal - amountTendered;
            System.out.println("Payment Failed: Insufficient Funds. Short by RM" + String.format("%.2f", shortAmount))
        }
    }
    
    public double calculateChange(double orderTotal) {
        if (!isSuccessful || method != PaymentMethod.CASH) {
            return 0.00;
        }
        return amountTendered - orderTotal;
    }
     
    public String getPaymentID() { 
        return paymentID; 
    }
    
    public double getAmountTendered() { 
        return amountTendered; 
    }
    
    public PaymentMethod getMethod() { 
        return method; 
    }
    
    public boolean getIsSuccessful() { 
        return isSuccessful; 
    }

    public void setPaymentID(String pID) { 
        paymentID = pID; 
    }
    
    public void setAmountTendered(double amount) { 
        if (amount < 0) {
            throw new IllegalArgumentException("Error: Payment amount cannot be negative.");
        }
        amountTendered = amount; 
    }
    
    public void setMethod(PaymentMethod newMethod) { 
        method = newMethod; 
    }

    @Override
    public String toString() {
        String status = isSuccessful ? "Successful" : "Pending/Failed";
        return String.format("Payment [%s] | Method: %s | Tendered: %.2f | Status: %s", paymentID, method, amountTendered, status);
    }  
}

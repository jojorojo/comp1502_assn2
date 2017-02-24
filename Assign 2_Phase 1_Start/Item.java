
/**
 * This is the class that defines the Inventory Item of a company 
 * 
 * @author 
 * 
 */
public class Item
{
    //Item Details
    private String itemNo;
    private String itemName;
    private double unitPrice;
    private int onHand;
    private int committed;
    private int onOrder;
    private int reorderPoint;
    private int econOrderQty;

    // Default Constructor
    public Item()
    {
        this.itemNo = null;
        this.itemName = null;
        this.onHand = 0;
        this.committed = 0;
        this.onOrder = 0;
        this.unitPrice = 0;
        this.reorderPoint = 0;
        this.econOrderQty = 0;
    }
    
    // full argument Constructor -- assigns value to every item detail.
    public Item( String itemNo,    String itemName,  int onHand,       int committed,
                 int onOrder,      double unitPrice, int reorderPoint, int econOrderQty )
    {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.onHand = onHand;
        this.committed = committed;
        this.onOrder = onOrder;
        this.unitPrice = unitPrice;
        this.reorderPoint = reorderPoint;
        this.econOrderQty = econOrderQty;
    }
    
    // partial argument Constructor -- leaves 2 item details default: committed and onOrder
    public Item( String itemNo,    String itemName,  int onHand,
                 double unitPrice, int reorderPoint, int econOrderQty )
    {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.onHand = onHand;
        this.unitPrice = unitPrice;
        this.reorderPoint = reorderPoint;
        this.econOrderQty = econOrderQty;
    }
    
    //copy Constructor -- takes another item object as parameter and constructs an exact copy
    public Item(Item copy)
    {
        this.itemNo = copy.getItemNo();
        this.itemName = copy.getItemName();
        this.onHand = copy.getOnHand();
        this.committed = copy.getCommitted();
        this.onOrder = copy.getOnOrder();
        this.unitPrice = copy.getUnitPrice();
        this.reorderPoint = copy.getReorderPoint();
        this.econOrderQty = copy.getEconOrderQty();
    }
    
    //  *--accessors--*
    public String getItemNo() // returns the item's number as String.
    {
        String copyItemNo = this.itemNo;
        return copyItemNo;
    }
    public String getItemName() //returns the name of the item as String.
    {
        String copyItemName = this.itemName;
        return copyItemName;
    }
    public double getUnitPrice() //returns the price a single item as double.
    {
        double copyUnitPrice = this.unitPrice;
        return copyUnitPrice;
    }
    public int getOnHand() //returns the amount of this item "on the shelf" as int
    {
        int copyOnHand = this.onHand;
        return copyOnHand;
    }
    public int getReorderPoint() //returns point at which an automatic reOrder
    {
        int copyReorderPoint = this.reorderPoint;
        return copyReorderPoint;
    }
    public int getEconOrderQty() //returns number of units ordered when automatic reorder takes place
    {
        int copyEconOrderQty = this.econOrderQty;
        return copyEconOrderQty;
    }
    public int getCommitted() //returns amount of this item going to customers today as int
    {
        int copyCommitted = this.committed;
        return copyCommitted;
    }
    public int getOnOrder() //returns amount of this item incoming from shipments as int
    {
        int copyOnOrder = this.onOrder;
        return copyOnOrder;
    }
    
    //  *--mutators--*
    public void setItemNo(String newItemNo)
    {
        this.itemNo = newItemNo;
    }
    public void setItemName(String newItemName)
    {
        this.itemName = newItemName;
    }
    public void setUnitPrice(double newUnitPrice)
    {
        this.unitPrice = newUnitPrice;
    }
    public void setOnHand(int newOnHand)
    {
        this.onHand = newOnHand;
    }
    public void setReorderPoint(int newReorderPoint)
    {
        this.reorderPoint = newReorderPoint;
    }
    public void setEconOrderQty(int newEconOrderQty)
    {
        this.econOrderQty = newEconOrderQty;
    }
    public void setCommitted(int newCommitted)
    {
        this.committed = newCommitted;
    }
    public void setOnOrder(int newOnOrder)
    {
        this.onOrder = newOnOrder;
    }
    
    // *--PROCESSORS--*
    /* Inventory Information Inquiry
     * -print each item detail, one per line.
     */
    public void printItemInfo()
    {
        System.out.println("Item no. :\t\t" + itemNo);
        System.out.println("Item Name :\t\t" + itemName);
        System.out.println("Unit Price :\t\t" + unitPrice);
        System.out.println("On Hand amt:\t\t" + onHand);
        System.out.println("Reorder Point:\t\t" + reorderPoint);
        System.out.println("Auto-Reorder Qty:\t" + econOrderQty);
        System.out.println("Committed to customers:\t" + committed);
        System.out.println("On Order amt:\t\t" + onOrder);
        System.out.println();
    }
    
    /* Order Inventory Items
     * -adds given amt to the value of 'onOrder'
     */
    public void addOrder(int amt)
    {
        setOnOrder( getOnOrder() + amt );
    }
    
    /* Received Shipment from Supplier
     * -onOrder goes down by amt received
     * -onHand goes up by amt received
     * -onOrder value must never be negative
     */
    public void receiveShip(int amt)
    {
        int newOnOrder = getOnOrder() - amt;
        setOnOrder(newOnOrder);
        int newOnHand = getOnHand() + amt;
        setOnHand(newOnHand);
    }
    
    public boolean checkShip(int amt){
        boolean valid = false;
        if (amt > this.getOnHand()){
            valid = true;
        }
        return valid;
    }
    
    public boolean checkStock(int amt){
        boolean valid = false;
        if (amt < this.getOnHand()){
            valid = true;
        }
        return valid;
    }
    
    /* Return Items to Supplier
     * -onHand value goes down by amt returned
     */
    public void returnShip(int amt)
    {
        int newOnHand = getOnHand() - amt;
        setOnHand(newOnHand);
    }
    
    
    /* Ship Items to customers
     * -if amt <= committed value, then committed value goes down by amt
     * -if amt > committed but amt <= (committed + onHand) value, then committed is 0, onHand goes down by
     *  amt difference
     * -if amt > (committed + onHand) value, then the order cannot be done and a message is displayed
     *  to the user. No values changed.
     */
    public void sendOrders(int amt)
    {
        if(amt <= this.committed)
        {
            int newCommitted = getCommitted() - amt;
            setCommitted(newCommitted);
        }
        else if( amt > committed && amt <= (committed + onHand) )
        {
            int dif = amt - getCommitted();
            setCommitted(0);
            int newOnHand = getOnHand() - dif;
            setOnHand(newOnHand);
        }
        else
        {
            System.out.println("ERROR! Sum of committed and onHand is less than order amount.");
            System.out.println("No changes have been made. Please try again.");
        }
    }
    
    /* Process Customer Order
     * -if amt ordered <= onHand value, then committed value increased by amt ordered and onHand decreased
     *  by same value
     * -if amt ordered > onHand value, then set onHand to 0 and send order amt difference of amt ordered
     *  and onHand value to supplier
     */
    public void newOrder(int amt)
    {
        if( amt <= this.onHand )
        {
            int newCommitted = getCommitted() + amt;
            setCommitted(newCommitted);
            int newOnHand = getOnHand() - amt;
            setOnHand(newOnHand);
        }
        else if( amt > this.onHand )
        {
            int dif = getOnHand() - amt;
            setOnHand(0);
            addOrder(dif);
        }
        else
        {
            System.out.println("What did you do!?");
        }
    }
    
    /* Process Customer Returns
     * -onHand value increased by amt returned
     */
    public void returnOrder(int amt)
    {
        int newOnHand = getOnHand() + amt;
        setOnHand(newOnHand);
    }
    
    /* Calc Item Value
     * finds the product of unit value and onHand, then outputs the answer as double (UNFORMATTED)
     */
    private double calcItemValue()
    {
        double itemValue = this.unitPrice * this.onHand;
        return itemValue;
    }
    
    public double calcValue(int orderAmt){
        return this.unitPrice * orderAmt;
    }
    
    public void printEndHeader(){
        System.out.println("Item No." + "\t" + "Item Name" + "\t" + "Stock" + "\t" +
                           "Committed" + "\t" + "Ordered" + "\t" + "Unit Price" + "\t" +
                           "Item Value");
    }
    
    /* End of Day Processing
     * -print Inventory Report
     */
    public void printEnd()
    {
        double itemValue = calcItemValue();
        System.out.println(itemNo + "\t\t" + itemName + "\t\t" + onHand  + "\t" + committed + "\t\t" +
                           onOrder  + "\t" + unitPrice  + "\t" + itemValue);
        
    }
    
    /* Item Number verifier
     * 
     */
    public boolean verifyItemNo(String itemNo){
        boolean valid = false;
        String item = getItemNo();
        if (item.equalsIgnoreCase(itemNo)){
                valid = true;
        }
        return valid; 
    }
    
    /* Input amt verifier
     * 
     */
    public boolean verifyAmt (int orderAmt){
        boolean valid = false;
        if (orderAmt > 0){
            valid = true;
        }
        return valid;
    }
    // *--MISC--*
    public String toString()
    {
        return itemNo+" "+itemName+" "+unitPrice+" "+onHand+" "+committed+" "+onOrder;
    }
}

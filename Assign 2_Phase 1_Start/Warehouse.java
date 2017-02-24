import java.util.*;
/**
 * Warehouse contains the different items in stock
 * 
 * @author {Place your name here}
 *
 */
public class Warehouse
{
    //State Variables
    private Item[] inventory = new Item[60];
    private int size;
    
    public Warehouse(){
        size = 0;
    }
    
    /* Inventory Information Inquiry
     * 
     */
    public void inventoryInfo(String itemNo){
        int i = 0;
        boolean valid = false;
        while (valid == false && i < size){
            valid = inventory[i].verifyItemNo(itemNo);
            i++;
        }
        i--;
        if (valid == false){
            System.out.println("Sorry, that is not a valid item number. Please try again.");
            System.out.println();
        }
        else{
            inventory[i].printItemInfo();
        }
    }
    
    /* Order Inventory Items
     * 
     */
    public void orderItem(String itemNo){
        Scanner input = new Scanner(System.in);
        int i = 0;
        int amt = 0;
        boolean valid = false;
        while (valid == false && i < size){
            valid = inventory[i].verifyItemNo(itemNo);
            i++;
        }
        i--;
        if (valid == false){
            System.out.println("Sorry, that is not a valid item number. Please try again.");
            System.out.println();
        }
        else {
            System.out.print("Enter how much of the item you wish to order: ");
            amt = input.nextInt();
            valid = inventory[i].verifyAmt(amt);
            while (valid == false){
                System.out.println("Sorry, you cannot enter a number less than 0");
                System.out.print("Enter how much of the item you wish to order: ");
                amt = input.nextInt();
                valid = inventory[i].verifyAmt(amt);
            }
            inventory[i].addOrder(amt);
            System.out.println("Success! " + amt + " items have been ordered for item #" + inventory[i].getItemNo());
            System.out.println("The total order cost is $" + inventory[i].calcValue(amt));
        }
    }
    
    /* Received Shipment from Supplier
     * 
     */
    public void shipReceive(String itemNo){
        Scanner input = new Scanner(System.in);
        int i = 0;
        int amt = 0;
        boolean valid = false;
        while (valid == false && i < size){
            valid = inventory[i].verifyItemNo(itemNo);
            i++;
        }
        i--;
        if (valid == false){
            System.out.println("Sorry, that is not a valid item number. Please try again.");
            System.out.println();
        }
        else {
            System.out.print("Enter how much of the item received: ");
            amt = input.nextInt();
            valid = inventory[i].verifyAmt(amt);
            while (valid == false){
                System.out.println("Sorry, you cannot enter a number less than 0");
                System.out.print("Enter how much of the item you received: ");
                amt = input.nextInt();
                valid = inventory[i].verifyAmt(amt);
            }
            valid = inventory[i].checkStock(amt);
            while (valid == false){
                System.out.println("Sorry, you do not have that much on order");
                System.out.print("Enter how much of the item you received: ");
                amt = input.nextInt();
                valid = inventory[i].verifyAmt(amt);
            }
            inventory[i].receiveShip(amt);
            System.out.println("Order recorded! You now have " + inventory[i].getOnHand() + 
                               " items in stock and " + inventory[i].getOnOrder() + 
                               " items on order for item #" + inventory[i].getItemNo());
        }
    }
    
    /* Return Items to Supplier
     * 
     */
    public void supReturn(String itemNo){
        Scanner input = new Scanner(System.in);
        int i = 0;
        int amt = 0;
        boolean valid = false;
        while (valid == false && i < size){
            valid = inventory[i].verifyItemNo(itemNo);
            i++;
        }
        i--;
        if (valid == false){
            System.out.println("Sorry, that is not a valid item number. Please try again.");
            System.out.println();
        }
        else {
            System.out.print("Enter how much of the item you are returning: ");
            amt = input.nextInt();
            valid = inventory[i].verifyAmt(amt);
            while (valid == false){
                System.out.println("Sorry, you cannot enter a number less than 0");
                System.out.print("Enter how much of the item you are returning: ");
                amt = input.nextInt();
                valid = inventory[i].verifyAmt(amt);
            }
            valid = inventory[i].checkStock(amt);
            while (valid == false){
                System.out.println("Sorry, you do not have that much you can return");
                System.out.print("Enter how much of the item you are returning: ");
                amt = input.nextInt();
                valid = inventory[i].verifyAmt(amt);
            }
            inventory[i].returnShip(amt);
            System.out.println("Success! " + amt + " items have been returned for item #" + inventory[i].getItemNo());
            System.out.println("The total order payment will be $" + inventory[i].calcValue(amt));
        }
    }
    
    /* Ship Items to Customers
     * 
     */
    public void shipSend(String itemNo){
        Scanner input = new Scanner(System.in);
        int i = 0;
        int amt = 0;
        boolean valid = false;
        while (valid == false && i < size){
            valid = inventory[i].verifyItemNo(itemNo);
            i++;
        }
        i--;
        if (valid == false){
            System.out.println("Sorry, that is not a valid item number. Please try again.");
            System.out.println();
        }
        else {
            System.out.print("Enter how much of the item you are shipping: ");
            amt = input.nextInt();
            valid = inventory[i].verifyAmt(amt);
            while (valid == false){
                System.out.println("Sorry, you cannot enter a number less than 0");
                System.out.print("Enter how much of the item you are shipping: ");
                amt = input.nextInt();
                valid = inventory[i].verifyAmt(amt);
            }
            inventory[i].sendOrders(amt);
            System.out.println("Shipment recorded! You now have " + inventory[i].getOnHand() + 
                               " items in stock and " + inventory[i].getCommitted() + 
                               " items committed for item #" + inventory[i].getItemNo());
        }
    }
    
    /* Process Customer Order
     * 
     */
    public void placeOrder(String itemNo){
        Scanner input = new Scanner(System.in);
        int i = 0;
        int amt = 0;
        boolean valid = false;
        while (valid == false && i < size){
            valid = inventory[i].verifyItemNo(itemNo);
            i++;
        }
        i--;
        if (valid == false){
            System.out.println("Sorry, that is not a valid item number. Please try again.");
            System.out.println();
        }
        else {
            System.out.print("Enter how much of the item you are ordering: ");
            amt = input.nextInt();
            valid = inventory[i].verifyAmt(amt);
            while (valid == false){
                System.out.println("Sorry, you cannot enter a number less than 0");
                System.out.print("Enter how much of the item you are ordering: ");
                amt = input.nextInt();
                valid = inventory[i].verifyAmt(amt);
            }
            inventory[i].newOrder(amt);
            System.out.println("Success! " + amt + " items have been put aside for shipment for item #" + inventory[i].getItemNo());
            System.out.println("The total order payment will be $" + inventory[i].calcValue(amt));
        }
    }
    
    /* Process Customer Returns
     * 
     */
    public void cusReturn(String itemNo){
        
            //System.out.println("Success! " + amt + " items have been ordered for item #" + inventory[i].getItemNo());
            //System.out.println("The total order cost is $" + inventory[i].calcValue(amt));
    }
    
    /* End of Day Processing
     * 
     */
    public void processEnd(){
        
    }
    
    /* Add Item to inventory
     * 
     */
    
    /* Fetch Item from inventory by itemNo
     * 
     */
    public Item fetch(String itemNo)
    {
        int i = 0;
        Item current = new Item();
        while( itemNo != current.getItemNo() )
        {
            current = inventory[i];
            i++;
        }
        return current;
    }
    /* Load hardcoded data**
     * 
     *  **only for phase one testing
     */
    
    /*
     * This is the hardcoded data to be loaded into the instance variables.  
     */
    public void loadInventory()
    {
        inventory[0] = new Item("A11111", "Widgets", 30, 50, 70, 2.50, 20, 50);
        inventory[1] = new Item("B22222", "Gadgets", 10, 20, 0, 4.00, 50, 100);
        inventory[2] = new Item("C33333", "Trinkets", 100, 20, 35, 3.75, 80, 150);
        inventory[3] = new Item("D44444", "Pickets", 0, 100, 20, 8.35, 25, 75);
        inventory[4] = new Item("E55555", "Sockets", 200, 300, 150, 1.00, 200, 400);
        size = 5;
    }
    
    public void loadArray()
    {
        /*
         * 
         */
    }
}

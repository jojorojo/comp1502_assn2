import java.util.*;
/**
 * This is the interface that the user will use to process Inventory
 * 
 * @author  comp1502
 * @ Due Date
 */

public class Interface {
    public static void main(String args[]){
        // define necessary variables here
        Scanner input = new Scanner(System.in);
        Warehouse wh = new Warehouse();
        int choice = 0;
        int amt = 0;
        String num = null;
        // place here the code for the processing requirements
        wh.loadInventory();
        System.out.println("Welcome to the PR Inventory System");
        while (choice != 9){
            showMenu();
            choice = input.nextInt();
            
            switch(choice){
                case 1:
                System.out.print("Enter the number of the item you wish to display: ");
                wh.inventoryInfo(input.next());
                break;
                case 2:
                System.out.print("Enter the number of the item you wish to order: ");
                wh.orderItem(input.next());
                break;
                case 3:
                System.out.print("Enter the number of the item you received: ");
                wh.shipReceive(input.next());
                break;
                case 4:
                System.out.print("Enter the number of the item you are returning: ");
                wh.supReturn(input.next());
                break;
                case 5:
                System.out.print("Enter the number of the item you are shipping: ");
                wh.shipSend(input.next());
                break;
                case 6:
                System.out.print("Enter the number of the item you are ordering: ");
                wh.placeOrder(input.next());
                break;
                case 7:
                System.out.print("Enter the number of the item the customer is returning: ");
                wh.cusReturn(input.next());
                break;
                case 8:
                wh.processEnd();
                break;
            }
        }
        System.out.println ("Thank you for using the Inventory Processing System");
    }
  
    /**
     *  The Inventory processing menu
     */
    public static void showMenu(){
        System.out.println("\nMENU:");
        System.out.println("1) Inventory Item Inquiry");
        System.out.println("2) Order inventory items from Supplier");
        System.out.println("3) Receive shipment from Suppliers");
        System.out.println("4) Return items to Supplier");
        System.out.println("5) Ship items to Customers");
        System.out.println("6) Process Customer Order");
        System.out.println("7) Process Customer Returns");
        System.out.println("8) End of Day Processing");
        System.out.println();
        System.out.println("9) Exit");
        System.out.print("Please enter your choice: ");
    }
}

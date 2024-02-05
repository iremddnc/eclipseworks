
import java.util.Scanner;

public class TwoItemStore_123456789 {
   public static void main(String[] args) {
      Scanner inp = new Scanner(System.in);
      System.out.println("****** Store Inventory ******");
      System.out.print("Enter the name of product 1: ");
      String prod1 = inp.next();
      prod1 = Character.toUpperCase(prod1.charAt(0)) + prod1.substring(1, prod1.length());
      System.out.print("Enter the number of " + prod1 + " we have: ");
      int count1 = inp.nextInt();
      if(count1 < 0) {
         System.out.println("ERROR: value cannot be negative. Exiting.");
         return;
      }
      System.out.print("Enter the cost of " + prod1 + ": ");
      double cost1 = inp.nextDouble();
      if(cost1 < 0) {
         System.out.println("ERROR: value cannot be negative. Exiting.");
         return;
      }
      System.out.print("Enter the name of product 2: ");
      String prod2 = inp.next();
      prod2 = Character.toUpperCase(prod2.charAt(0)) + prod2.substring(1).toLowerCase();
      System.out.print("Enter the number of " + prod2 + " we have: ");
      int count2 = inp.nextInt();
      if(count2 < 0) {
         System.out.println("ERROR: value cannot be negative. Exiting.");
         return;
      }
      System.out.print("Enter the cost of " + prod2 + ": ");
      double cost2 = inp.nextDouble();
      if(cost2 < 0) {
         System.out.println("ERROR: value cannot be negative. Exiting.");
         return;
      }

      System.out.println("****** Customer User Interface ******");
      int reqprod;
      int reqcount1 = 0, reqcount2 = 0;
      do {
         System.out.println("Welcome to our store. We have the following. Please enter what you would like:");
         System.out.println("1 - " + prod1 + "\n2 - " + prod2 + "\n0 - to checkout");
         reqprod = inp.nextInt();
         if(reqprod < 0 || reqprod > 2) {
            System.out.println("ERROR: invalid menu option.");
            continue;
         }
         if(reqprod == 1) {
            System.out.print("How many " + prod1 + " would you like? ");
            int reqamt = inp.nextInt();
            if(reqamt < 0)
               System.out.println("ERROR: Invalind requested amount.");
            else if(reqamt > count1)
               System.out.println("ERROR: we do not have that many remaining");
            else {
               count1 -= reqamt;
               reqcount1 += reqamt;
            }
         } else if(reqprod == 2) {
            System.out.print("How many " + prod2 + " would you like? ");
            int reqamt = inp.nextInt();
            if(reqamt < 0)
               System.out.println("ERROR: Invalind requested amount.");
            else if(reqamt > count2)
                System.out.println("ERROR: we do not have that many remaining");
             else {
                count2 -= reqamt;
                reqcount2 += reqamt;
             }
          }
       } while(reqprod != 0);
       System.out.println("****** Customer Total ******");
       System.out.println(prod1 + " - " + reqcount1 + " X " + cost1 + " = " + reqcount1 * cost1);
       System.out.println(prod2 + " - " + reqcount2 + " X " + cost2 + " = " + reqcount2 * cost2);
       System.out.println("----------------------------");
       System.out.println("Total due - " + (reqcount1 * cost1 + reqcount2 * cost2));
       
       System.out.println("\n****** Final Report ******");
       System.out.println("We now have the remaining amounts of our products:");
       System.out.println(prod1 + " - " + count1);
       System.out.println(prod2 + " - " + count2);
    }
 }
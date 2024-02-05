import java.util.Scanner;

public class TwoItemStore {

	public static void main(String[] args) {
		// author İrem DİNÇ
		// since 11.11.2022

		 System.out.println("******Store Inventory******");
		 Scanner input= new Scanner(System.in);
		 int have,have2 = 0 ;
		 int choose = 0,choose2 = 0;
		 int want = 0,want2 = 0;
		 double cost = 0,cost2; 
		 System.out.print("Enter the name of product 1:");
		 String product,product2 ;
		 product=input.next(); 
		 product=product.substring(0,1).toUpperCase()+product.substring(1).toLowerCase();	
		 System.out.print("Enter the number of "+product+" we have:");
		 have=input.nextInt();
		 if (have>=0 ) {
		   System.out.print("Enter the cost of "+product+":");
		   cost=input.nextInt();
		   if(cost>0) {
			 System.out.print("Enter the name of product 2:");  
			 product2=input.next();
			 product2=product2.substring(0,1).toUpperCase()+product2.substring(1).toLowerCase();
			 System.out.print("Enter the number of "+product2+" we have:");
			 have2=input.nextInt();
			 if(have2>=0) {
			   System.out.print("Enter the cost of "+product2+":");
			   cost2=input.nextDouble(); 
			   if(cost2>0) { 

			   while(true) {
				    System.out.println("Welcome to our store.We have the fallowing.Please enter what you would like:");
				    System.out.println("1 - "+product);
				    System.out.println("2 - "+product2);
				    System.out.println("0 - to checkout");
				   choose=input.nextInt();
			       if(choose==1) {
			    	  System.out.println("How many "+product+" would you like?");
			    	  want=input.nextInt(); 
			    	 if(want>have) {
			    		System.out.println("ERROR:we do not have that many remaining.");  }
			        }
			         else if(choose==2) {
			    	   System.out.println("How many "+product2+" would you like?");
			    	   want2=input.nextInt();
			    	   if(want2>have2) {
			    		   System.out.println("ERROR:we do not have that many remaining."); }
			       }
			         else if(choose==0) {
			    	   break;
			       }
			         else {
			        	 System.out.println("ERROR:invalid menu option.");
			         }
				      }
			          
				     System.out.println("******Customer Total******");
					 System.out.println(product+" - "+want+" * "+cost+" = "+cost*want);
			         System.out.println(product2+" - "+want2+" * "+cost2+" = "+cost2*want2);
			         System.out.println("------------------------------");
			         System.out.println("total due = "+(want*cost)+(want2*cost2));
			         System.out.println();
			         System.out.println("******Final Report******");
			         System.out.println("We now have the remaining amounts of our products:");
			         System.out.println(product+" - "+(have-want));
			         System.out.println(product2+" - "+(have2-want2));
			          
				  
	  }else {System.out.println("ERROR:value cannot be negative. Exiting."); }}		
	   else {System.out.println("ERROR:value cannot be negative. Exiting."); }}		
	  else {System.out.println("ERROR:value cannot be negative. Exiting."); }}		 
       else {System.out.println("ERROR:value cannot be negative. Exiting."); }	
		
		
	}

}

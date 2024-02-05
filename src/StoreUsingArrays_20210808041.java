
import java.util.Scanner;

public class StoreUsingArrays_20210808041{
	//author İremDİNÇ
	//date 04.12.2022
    public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        System.out.println("Welcome the our store,we have the fallowing.");
	
			String[] item= {"Bread","cola","snickers","AYRAN"};
		    int[] quantity = {10,15,12,30};
		    double[] price= {0.75, 2.5, 2.25, 1};
	        storeRun(item,price,quantity);
		}
   
  public static int menu(String []item,double[] price,Scanner scan) {
	   
		System.out.println("Please enter what would you like:");   
		System.out.println((1)+" - for "+(item[0])+" ("+price[0]+")");
     	System.out.println((2)+" - for "+item[1]+" ("+price[1]+")");
     	System.out.println((3)+" - for "+item[2]+" ("+price[2]+")");
     	System.out.println((4)+" - for "+item[3]+" ("+price[3]+")");
     	System.out.println((0)+ " - to checkout");
      int choice=scan.nextInt();
 	  return choice;
	}
	  	
public static void storeRun(String[]item,double[] price,int[] quantity) {
    capitalizeArray(item);
   int buy=0;
   int buy2=0;
   int buy3=0;
   int buy4=0;
   
   while(true) {
	   int choice=menu(item,price,scan);//to use the value in the menu method we call the menu method
	   if(choice==1) {
	    	  System.out.println("How many "+item[0]+" would you like?");
	    	 int want=scan.nextInt(); 
	    	 if(want>quantity[0]) {
	    		System.out.println("ERROR:invalid request.");  }
	    	 else if(want<0) {
	    		 System.out.println("ERROR:value cannot be negative. Exiting.");
	    	 }
	    	 else {
	    		 buy+=want;
	    		 quantity[0]-=want;
	    	 }
	        }
	         else if(choice==2) {
	    	   System.out.println("How many "+item[1]+" would you like?");
	    	 int want2=scan.nextInt();
	    	   if(want2>quantity[1]) {
	    		   System.out.println("ERROR:invalid request."); }
	    	   else if(want2<0) {
		    		 System.out.println("ERROR:value cannot be negative. Exiting.");
		    	 }
	    	   else {
	    		   buy2+=want2;
	    		   quantity[1]-=want2;
	    	   }
	       }
	         else if(choice==3) {
		    	   System.out.println("How many "+item[2]+" would you like?");
		    	  int want3=scan.nextInt();
		    	   if(want3>quantity[2]) {
		    		   System.out.println("ERROR:invalid request."); }
		    	   else if(want3<0) {
			    		 System.out.println("ERROR:value cannot be negative. Exiting.");
			    	 }
		    	   else {
		    		   buy3+=want3;
		    		   quantity[2]-=want3;
		    	   }
		       }
	         else if(choice==4) {
		    	   System.out.println("How many "+item[3]+" would you like?");
		    	 int want4=scan.nextInt();
		    	   if(want4>quantity[3]) {
		    		   System.out.println("ERROR:invalid request."); }
		    	   else if(want4<0) {
			    		 System.out.println("ERROR:value cannot be negative. Exiting.");
			    	 }
		    	   else {
		    		 buy4+=want4 ;
		    		 quantity[3]-=want4;
		    	   } 
					
		       }
	      
	         else if(choice==0) {
	        	 System.out.println("******Customer Total******");
			    		System.out.println(item[0]+" - "+buy+" * "+price[0]);
			    		System.out.println(item[1]+" - "+buy2+" * "+price[1]);
			    		System.out.println(item[2]+" - "+buy3+" * "+price[2]);
			    		System.out.println(item[3]+" - "+buy4+" * "+price[3]);
			            System.out.println("----------------------------");
			            System.out.print("Total due - ");
			        	double total=(price[0]*buy)+(price[1]*buy2)+(price[2]*buy3)+(price[3]*buy4);
			        	double change;
                 System.out.println(total);
	        	 System.out.println("Please enter amount given.");
	        	 double amount=scan.nextDouble();
	        	
	        	 System.out.println("Thank you for your business.Your change given is:");
	       System.out.println(returnedAmounts(amount-total));

	    	   break;
	       }
	         else {
	        	 System.out.println("ERROR:invalid choice.");
	         }
		      }
   
	   
   }
      
 public static String returnedAmounts(double amount) {
	  String returned=" ";
	  
	  int twohundred= (int)((amount)/200);    
	    if (twohundred >=200) { 
	    	amount= amount % 200;
	     returned+= (twohundred+" - 200\n");
	    }
	    int onehundred=(int)(amount/100);
	    if(onehundred>=100) {
	    	 amount= amount % 100;
	    	returned+=(onehundred+" - 100\n");
	     }
	    int fifty=(int)(amount/50);
	     if(fifty>=50) {
	       amount= amount % 50;
	       returned+=(fifty+" - 50\n");
	     }
		    int twenty=(int)(amount/20);
	      if(twenty>=20) {
	     	amount= amount % 20;
	    	returned+=(twenty+" - 20\n");
	    }
		    int  ten=(int)(amount/10);
	       if(ten>=10) {
	    	amount= amount % 10;
	    	returned+=(ten+" - 10\n");
	    }
		    int five=(int)(amount/5);
	       if(five>=5) {
	       amount= amount % 5;
	    	returned+=(five+" - 5\n");
	    }
		  int  one=(int)(amount/1);
	     if(one>=1) {
	    	amount= amount % 1;
	    	returned+=(one+" - 1\n");
	    }
		   int fiftyCent=(int)(amount/0.5);
	      if(fiftyCent>=0.5) {
	    	amount= amount % 0.5;
	    	returned+=(fiftyCent+" - 0.5\n");
	    }
         int twentyfiveCent=(int)(amount/0.25);
	     if(twentyfiveCent>=0.25) {
	    	amount= amount % 0.25;
	    	returned+=(twentyfiveCent+" - 0.25\n");
	    }
	     int tenCent=(int)(amount/0.10);
	     if(tenCent>=0.1) {
	    	amount= amount % 0.1;
	    	returned+=(tenCent+" - 0.10\n");

	    }
		    int fiveCent=(int)(amount/0.05);
	       if(fiveCent>=0.05) {
	    	amount= amount % 0.05;
	    	returned+=(fiveCent+" - 0.05\n");
	    }
		    int oneCent=(int)(amount/0.01);
	      if(oneCent>=0.01) {
	    	amount= amount % 0.01;
	    	returned+=(oneCent+" - 0.01\n");
	    }
	return returned;
	   }
 
 public static String capitalizeString(String name) {
		String name1 =name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
		return name1;
	}

 public static void  capitalizeArray(String[] item) {
		for(int i=0; i<item.length;i++) {
	     item[i]=capitalizeString(item[i]);     }
		}

	
}
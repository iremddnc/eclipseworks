import java.util.Scanner;

public class BreadStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("******Bread Store Inventory******");
		Scanner scan=new Scanner(System.in);
		int bread;
		System.out.println("please enter the number of bread we have:");
		bread=scan.nextInt();
		double cost = 0;
		int want = 0;
		double pay;
		int remain;
		pay=want*cost;
		remain=bread-want;
		if (bread>0) {
			System.out.println("please enter the cost of bread:");
			cost=scan.nextDouble();
			if(cost<0) {
				System.out.println("ERROR:value cannot be negative.Exiting");}
			else{
			System.out.println("******Customer User Interface******");
			System.out.print("Welcome to our breadstore.");
			System.out.print("We have "+bread+" loaves of bread available.How many would you like? ");
			want=scan.nextInt();
			if (want>0 && bread>want) {
			System.out.println("Your cost is:"+pay);
			System.out.println("Thank you for shopping today!");	
			System.out.println("We now have "+remain+" loaves of bread remaining.");
				}
		else if(bread<0){
			System.out.println("ERROR:value cannot be negative.Exiting");
        }
		
		else if(want<0) {
			System.out.println("ERROR:value cannot be negative.Exiting");
		}
		else if(want>bread) {
			System.out.println("We do not have that many remaining.");
		}
		}
		}}}
			
	
			
			
		
		
		
		
		
		
			
		
		
	



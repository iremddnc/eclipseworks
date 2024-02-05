import java.util.Scanner;

public class Ex02{
	public static void main (String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("write a number:");
		int a=scan.nextInt();
		int b=a/10;
		int c=b%10;
		if(c>0) {
		System.out.println(c);}
		else {
			System.out.println(0);
		}
		System.out.println("enter the passing time on the cafe:");
		int spend=scan.nextInt();
		
		int hour =(spend+59)/60; 
	    int total=hour*50;
	    
	    int unspend=(hour*60)-spend;
	    int extratotal=(unspend+59)/60*50;
	    
	    System.out.println("total is " +total+" lira");
        System.out.println("extra is "+ extratotal+ " lira");
	   double p =1.0/6.0;
       System.out.print("enter the value of k:");
       int k = scan.nextInt();
    
       double probability= Math.pow(1-p,k-1)*p;
		System.out.println("the probability of rolling the first"+k+" on trial is"+probability);
	}
}		    	                            
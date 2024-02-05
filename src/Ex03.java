import java.util.Random;
import java.util.Scanner;
//28.10.2023
public class Ex03{

	public static void main(String[] args) {
	 Scanner scan=new Scanner(System.in);
     System.out.println("Id   Meal    Price\n"
     		+ "1   Doner     80 lira\n"
     		+ "2   Kebab    110 lira\n"
     		+ "3   Lahmacun  75 lira");
     System.out.println("please enter food id:");
     int food = scan.nextInt();
     System.out.println("Id   Meal    Price\n"
    	    + "1    Ayran     10 lira\n"
    	    + "2    Kola      20 lira\n"
    	    + "3    Salgam    15 lira");
	System.out.println("please enter drink id");
	int drink =scan.nextInt();
	int price=0;
	String names ="";
	switch(food) {
	case 1:
		price+=80;
		names+="Doner and ";
		break;
	case 2:
		price+=110;
		names+="Kebab and ";
		break;
	case 3:
		price+=75;
		names+="Lahmacun and ";
		break;
	}
	switch(drink) {
	case 1:
	    price+=10;
	    names+="Ayran ";
	    break;
	case 2:
		price+=20;
		names+="Kola ";
		break;
	case 3:
		price+=15;
		names+="Salgam ";
	}
	System.out.println(names+price+" lira");
	
	System.out.println("1 100 GB 80 lira");
	System.out.println("2 200 GB 140 lira");
	System.out.println("please choose type number");
	int choose=scan.nextInt();
	System.out.println("How many Gb internet do you want?");
	int want=scan.nextInt();
	int amount=0;
	if(choose==1) {
		amount+=80+(want-100)/3*15/100;
		System.out.println(amount);
	}
	else if(choose==2) {
	    amount+=140+(want-200)/5*10/100;
	    System.out.println(amount);
	}
	else {
		System.out.println("error:not valid");
	}
	
	System.out.println("choose number of attack 1 or 2");
	int attack=scan.nextInt();	
	int damage=0;
	if(attack==1){
		System.out.println("flip: 1 is heads,0 is tails,2 is random ");
		int coin1=scan.nextInt();
		System.out.print("flip: 1 is heads,0 is tails,2 is random ");
        int coin2=scan.nextInt();
        if(coin1==2){
            coin1=Math.random()<0.5?0 :1;
          }

        if(coin2==2){
           coin2=Math.random()<0.5?0 :1;
            }

        if (coin1==1 && coin2==1) {
           damage=60;
        }
	}
	 else if(attack== 2){
		System.out.print("flip: 1 is heads,0 is tails,2 is random ");
         int coin1 = scan.nextInt();
 		System.out.print("flip: 1 is heads,0 is tails,2 is random ");
         int coin2 = scan.nextInt();

         if(coin1==2) {
             coin1=Math.random()<0.5?0: 1;
         }

         if (coin2==2) {
             coin2=Math.random()< 0.5?0: 1;
         }
         int headsc= coin1+coin2;
           damage =50+(20* headsc);
     }
     System.out.println("Damage dealt by attack: "+damage);
 }
	
}

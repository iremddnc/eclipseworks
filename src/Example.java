import java.util.Scanner;

public class Example {






		static boolean prime(int number) {
			int parameter=0;
			for(int i=2;i<number;i++) {
				if(i%number==0) {
					parameter++;
				}}
				if(parameter==0){
					return true;		
				}
				else {
					return false;
				}
				}		
		public static void main(String[] args) {

	Scanner scan=new Scanner(System.in);
	int number=scan.nextInt();
	if(prime(number)) {//prime(number)==true
		System.out.println("the number is prime");
	}
	else {
		System.out.println("the number is not prime");
	}
	
	}



      public static String middle(String str) {
		int start=str.length()/2;
		int end=1;
		if(str.length()%2==0) {
			end=2;	
			start--;
		}
		return str;

    	  
      }
}





for(int i = 1; i < locker.length; i++){
	   for(int j = i; j< locker.length; j+=i){
	    if (locker[j] == false){
	     locker[j] = true;
	    }else
	    {
	     locker[j] = false;
	    }
	   }
	  } 














package hellojava;

public class Ex05_20210808041 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    System.out.println(computePI(5));
    System.out.println(factorial(5));
    System.out.println(isPrime(135));
    nPrimes(13);
    nPerfectNumbers(3);
    displayStatistics(5);
	}
	public static double computePI(int i) {
		double calculate=4*(1-(Math.pow(-1, i+1))/(2*i-1));
		if(i==0) {
		return 3;
		}
		return calculate;
	}
	public static int factorial(int number) {
		int fact=1;
	for(int i=1;i<=number;i++){    
	      fact*=i;
	  }
	return fact;    
	}

	public static boolean isPrime(int number) {
		for(int i=2;i<=number/2;i++ ) {
		if(number%i==0) {
			return false;
	       }
		}
			return true;
			}
	public static void nPrimes(int number) {
		 int counter=0;
	     int num=2;
	      while(counter<number) {
	        if (isPrime(num)) {
	        System.out.print(num+ " ");
	        counter++;
	            }
	            num++;
	        }
	      System.out.println("");
	}
	public static void nPerfectNumbers(int n) {
        int count=0;
        int number=2;
        while (count<n) {
            if(isPerfectNumber(number)) {
                System.out.println(number);
                count++;
            }
            number++;
        }
    }

    private static boolean isPerfectNumber(int num) {
        int sum=1; 
        for (int i=2;i<= Math.sqrt(num);i++) {
            if(num%i==0) {
              sum +=i;
              if(i!=num/i){
               sum +=num/i;
                }
            }
        }
        return sum==num;
    }
	public static void displayStatistics(int n) {
		double sum=0;
		
			for(int i=0;i<=n;i++) {
				sum+=n;
			
			}
			double mean=sum/n;
			System.out.println(mean);
			
		}	
}
	
	
	
	


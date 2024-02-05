
public class Exercise02_2 {

	public static void swap(int[] array, int i, int j) {
	        int temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	    }

	    public static void display(double[] array) {
	        for (double i : array) {
	            System.out.printf("%.1f\t", i);
	        }
	        System.out.println();
	    }

	    public static void display(int[] array) {
	        for (int i : array) {
	            System.out.printf("%d\t", i);
	        }
	        System.out.println();
	    }

	    public static void display(char[] array) {
	        for (int i : array) {
	            System.out.printf("%c\t", i);
	        }
	        System.out.println();
	    }

	    public static int random(int start, int end) {
	        return start + (int) (Math.random() * (end - start + 1));
	    }

	    public static double random(double start, double end) {
	        return start + Math.random() * (end - start + 1);
	    }
	    public static double round(double value, int places) {
	        double scale = Math.pow(10, places);
	        return Math.round(value * scale) / scale;
	    }

	
	
public static int average(int[] numbers) {
	 
	int length = numbers.length;
    int sum = 0;
    for (int i = 0; i < numbers.length; i++) {
        sum += numbers[i];
    }
    double average = sum / length;

  return (int)average;
	
}

public static double average(double[] doubleNumbers) {

	int length=doubleNumbers.length;
    double sum =-0.5;
    for (int i = 0; i < doubleNumbers.length; i++) {
        sum += doubleNumbers[i];
    }
    double average = sum / length;
    return (double)average;
	
}

public static int random(int start, int end, int... exclude) {
	int exclude1=(int) random(start, end);
	for(int i =0;i<exclude.length;i++) {
		if(exclude1==exclude[i]) {
			exclude1=random(start,end,exclude);
		}
	}
	return exclude1;
		
	}

public static int[] eliminateDuplicates(int[] array) {
	int j=0;
    array[j]=array[0];
    for(int i=0;i<array.length;i++)
    {
        if (array[j]!=array[i])
        {
            j++;
            array[j]=array[i];
        }
    }
  return array;
}
	
public static boolean isSorted(int[] array) {
		for (int i = 0; i < array.length; i++)   
	{  
	for (int j = i + 1; j < array.length; j++)   
	{  
	int tmp = 0;  
	if (array[i] > array[j])   
	{  
	swap(array,i ,j);
	}  
	}}
	return true;
}
	
public static void shuffle(int[] numbers) {
	  for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }

}
	
	
public static int[] lockers(boolean[] locker) {
	int[]openLockers= {};
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
     
	return openLockers ;
     }
	
	
	public static void main(String[] args) {
		 int[] numbers = new int[8];
	        for (int i = 0; i < numbers.length; i++) {
	            numbers[i] = random(0, 10);
	        }
	        display(numbers);
	        System.out.println("Average of numbers is: " + average(numbers));

	        double[] doubleNumbers = new double[8];
	        for (int i = 0; i < doubleNumbers.length; i++) {
	            doubleNumbers[i] = random(-0.5, 0.5);
	        }
	        display(doubleNumbers);
	        System.out.println("Average of numbers is: " + average(doubleNumbers));
	        //3
	        int[] numbers1 = new int[10];
	        for (int i = 0; i < numbers.length; i++) {
	            numbers[i] = random(0, 10, 1, 3, 5, 7, 9);
	        }
	        System.out.println("Generated numbers are: ");
	        display(numbers);
	        //4
	        int[] numbers2 = new int[10];
	        for (int i = 0; i < numbers.length; i++) {
	            numbers[i] = random(0, 10, 0, 1, 3, 5, 7, 9);
	        }
	        System.out.println("Generated numbers with duplicate values are: ");
	        display(numbers);
	        int[] nonDuplicateNumbers = eliminateDuplicates(numbers);
	        
	        System.out.println("Non duplicate numbers");
	         display(nonDuplicateNumbers);
	          //5
	          
	       int[] numbers3 = new int[10];
	        for (int i = 0; i < numbers.length; i++) {
	            numbers[i] = i;
	        }
	        System.out.println("is array in sorted order: " + isSorted(numbers));
	        display(numbers);

	        shuffle(numbers);
	        //6
	        int n = 100;
	        boolean[] lockers = new boolean[n];

	        int[] openLockers = lockers(lockers);

	        System.out.println("Open lockers are:");
	        display(openLockers);

	        System.out.println("for n == 100, open locker amount should be 10: open locker amount: " + openLockers.length);

	        n = 1000;
	        boolean[] bs = lockers = 
	        openLockers = lockers(lockers);

	        System.out.println("for n == 1000, open locker amount should be 31, open locker amount: " + openLockers.length);
	        
	}
	
	
	
}

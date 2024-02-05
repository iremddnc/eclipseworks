import java.util.Scanner;

public class calculatermethod {

	public static int subtraction(int a,int b) {
		return(a-b);
	}
	public static  double divide(int a,int b) {
		return((double)a/b);
	}
	public static int addition(int a,int b) {
		return(a+b);
	}
	public static int multiply(int a,int b) {
		return( a*b);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
      String operations= "1.substraction\n"
    		             +"2.dividing\n"
    		             +"3.addition\n"
    		             +"4.multiplay\n"
    		             +"for exit press q";
      System.out.println("**************************************************");
      System.out.println(operations);
      System.out.println("**************************************************");

       while (true) {
    	   System.out.println("choose operation");
		   String choose=scan.nextLine();
    	      if(choose.equals("1")) {
    	    	  System.out.println("enter a");
                int a=scan.nextInt();
                System.out.println("enter b");
                int b=scan.nextInt();
				System.out.println("subtraction is:"+(subtraction(a,b)));
				break;
    	      }
    	      else if(choose.equals("2")) {
    	    	  System.out.println("enter a");
                  int a=scan.nextInt();
                  System.out.println("enter b");
                  int b=scan.nextInt();
                  System.out.println("dividing is"+(divide(a,b)));
                  break;
    	      }
    	      else if(choose.equals("3")) {
    	    	  
    	      }
       }
	}

}

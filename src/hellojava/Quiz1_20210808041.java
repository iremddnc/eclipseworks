package hellojava;
import java.util.Random;
import java.util.Scanner;

public class Quiz1_20210808041 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	}


public void weekDay() {
	Scanner scan=new Scanner(System.in);
int day=scan.nextInt();
switch(day){
case 1:
	System.out.println("monday");
case 2:
	System.out.println("tuesday");
case 3:
	System.out.println("wednwsday");
case 4:
	System.out.println("thursday");
case 5:
	System.out.println("friday");
case 6:
	System.out.println("saturday");
case 7:
	System.out.println("sunday");
	default:
		System.out.println("invalid");
}


}

public static double calculatePI(int n) {
	double PI = 0;
	if(n==-1||n==0) {
		 return PI=Math.PI;
	}
	if(n>=1) {
		return PI=4*n*(Math.pow(-1,n+1)/(2*n-1));}
	return PI;	

	
}
public static void distance(int x,int y) {
	double radius=Math.pow(x*x-y*y, 1/2);
	
}
public static void area(double radius) {
	double circlearea=2*calculatePI(0)*radius;
}
public static void circumferance(double radius) {
	double circumferance=2*calculatePI(0)*radius;
	}
public static void area2(int height,int weight) {
	double rectangle=2*(height+weight);
}
 public static void reverse(String name) {
	 String name1="";
	 for(int i=0;i<name.length()-1;i--) {
		 name1+=name;
		 
	 }
 }
 public void compareNames(String name1,String name2) {
	 if (name1.length()==name2.length()) {
         if (name1.equals(name2)) {
             System.out.println("The names are same");
         } else {
             char LastChar = name1.charAt(name1.length()-2);
             System.out.println (LastChar);
         }
     } else {
         if (name1.contains(name2)) {
        	 System.out.println(name2.substring(0));}
         }
        	 
	 
 }
 public static boolean isPolindrome(String name) {
	 String name1="";
	 for(int i=0;i<name.length()-1;i--) {
		 name1+=name;
		 
	 }
	 if(name.equals(name1)) {
		 return true;
	 }
	 else
	return false;
 }
 public static void cylinderarea(int x,int y, int height) {

 }

















 
 








}
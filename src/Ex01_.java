import java.util.Scanner;

public class Ex01_ {
//irem dinç
//07.10.2023
	public static void main(String[] args) {
		System.out.println("Question 1:");	
		System.out.println("\ta\ta^2\ta^3");
		System.out.println("\t1\t1\t1");
		System.out.println("\t2\t4\t8");
		System.out.println("\t3\t9\t27");
		System.out.println("\t4\t16\t64");	
		System.out.println("Question 2;");
		System.out.println((9.5*4.5-2.5*3)/(45.5-3.5));
		System.out.println("Question 3:");
		double PI = 4*(1-1.0/3.0+1.0/5.0-1.0/7+1.0/9.0-1.0/11.0);
		double PI2 =4*(1-1.0/3.0+1.0/5.0-1.0/7+1.0/9.0-1.0/11.0+1.0/13.0);
		System.out.println(PI);
		System.out.println(PI2);
		System.out.println("Question 4:");
		double PI3=3.2837384837384844,area, perimeter,r=5.5;
		area = PI3 * r *r;
		perimeter = 2 * PI3* r ;
		System.out.println("the area of the circle:"+ area);
		System.out.println("the perimeter of the circle:"+ perimeter);
		System.out.println("Question 5:");
		double x , y;
		double a=3.4,b=50.2,c=2.1,d=5.5 ,e=44.5,f=5.9;
		x = (e*d-b*f)/(a*d-b*c);
		y = (a*f-e*c)/(a*d-b*c);
		System.out.println("x:"+x);
		System.out.println("y:"+y);
    }
}
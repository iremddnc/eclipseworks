import java.util.Scanner;

public class Exercise01 {
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
	System.out.println("Question 6:");
	double celcius;
	Scanner input = new Scanner(System.in);
	System.out.println("Please enter the degree of celcius:");
	celcius = input.nextDouble();
    double Fahrenheit1 = ((9.0/5.0*celcius) + 32 );
	System.out.println("Fahrenheit:"+ Fahrenheit1);
	System.out.println("Question 7:");
	double pi=3.14 ,length, radius1;
	Scanner input1 = new Scanner(System.in);
	System.out.println("please enter the radius of cylender:");
	radius1 = input.nextDouble();
	System.out.println("please enter the length of cylender:");
	length = input.nextDouble();
	double area1 = pi*radius1*radius1;
	double volume = area1*length;
	System.out.println("the area of cylender:"+area1);
	System.out.println("the volume of cylender:"+volume);
	System.out.println("Question 8:");
	int number;
	Scanner input7 = new Scanner(System.in);
	System.out.println("please enter a number between of 0 and 1000:");
	number=input.nextInt();
	System.out.println("sum of all digits:"+(number/100+number%100/10+number%10));
	System.out.println("Question 9:");
	int minute,day,year;
	Scanner input2 = new Scanner(System.in);
	System.out.println("please enter the minute:");
	minute= input2.nextInt();
	day=minute/(24*60);
    year=day/365;
	System.out.println(day+"day");
	System.out.println(year+"year");
	System.out.println("Question 10:");
	double save , calculation=(1.0+0.05/12.0);
	Scanner input6 = new Scanner(System.in);
	System.out.println("please enter the save a month:");
    save=input.nextDouble();
    double month=save*calculation;
    // System.out.println("first month:"+month);
    //  System.out.println("Second month:");
    //System.out.println(month+month*calculation);
    double second=month+month*calculation;
    //System.out.println("thirth month:");
    //System.out.println(month+second*calculation);
    double thirth=month+second*calculation;
    //System.out.println("fourth month:");
    // System.out.println(month+thirth*calculation);
    double fourth=month+thirth*calculation;
    //System.out.println("fifth month:");
    //System.out.println(month+fourth*calculation);
    double fifth=month+fourth*calculation;
    System.out.println("sixth month:");
    System.out.println(month+fifth*calculation);
    System.out.println("Question 11:");
    double kilograms, meters, pounds , inches,BMI;
	Scanner input3 = new Scanner(System.in);
    System.out.println("please enter your weight in pound:");
    pounds= input.nextDouble();
	kilograms=pounds*0.45359237;
	System.out.println("please enter your height in inches:");
	inches=input.nextDouble();
    meters= inches*0.0254;
	BMI=kilograms/meters;
    System.out.println("your body max index is:"+BMI);
	System.out.println("Question 12:");
    double x1,x2,y1,y2,distance;
	Scanner input4 = new Scanner(System.in);
    System.out.println("please enter the values x1:");
    x1=input.nextDouble();
    System.out.println("please enter the values y1:");
    x2=input.nextDouble();
    System.out.println("please enter the values x2:");
    y1=input.nextDouble();
    System.out.println("please enter the values y2:");
    y2=input.nextDouble();
    distance =((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1));
    System.out.println("distance between coordinates:"+Math.pow(distance, 0.5));
    System.out.println("Question 13:");
    int x3,y3,x4,y4,x5,y5;
    double area2,side1,side2,side3,s;
    Scanner input5= new Scanner(System.in);
    System.out.println("please enter x3:");
    x3=input.nextInt();
    System.out.println("please enter y3:");
    y3=input.nextInt();
    System.out.println("please enter x4:");
    x4=input.nextInt();
    System.out.println("please enter y4:");
    y4=input.nextInt();
    System.out.println("please enter x5:");
    x5=input.nextInt();
    System.out.println("please enter y5:");
    y5=input.nextInt();
    side1 =(x3-x4)*(x3-x4)+(y3-y4)*(y3-y4);
    side2=(x3-x5)*(x3-x5)+(y3-y5)*(y3-y5);
    side3=(x5-x4)*(x5-x4)+(y5-y4)*(y5-y4);
    s=(side1+side2+side3)/3;
    area2=s*(s-side1)*(s-side2)*(s-side3);
    System.out.println("side1"+Math.pow(side1, 0.5));
    System.out.println("side2"+Math.pow(side2, 0.5));
    System.out.println("side3"+Math.pow(side3, 0.5));
    System.out.println("s the triangle:"+s);
    System.out.println("area of triangle:"+Math.pow(area2, 0.5));
     		
	}
}
	
	 


   
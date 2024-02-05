import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
    Scanner scan=new Scanner(System.in);
    System.out.println("please input the center coordinate x");
    int x1 =scan.nextInt(); 
    System.out.println("please input the center coordinate y");
    int y1 =scan.nextInt(); 
    System.out.println("please input the circle edge coordinate x");
    int x2 =scan.nextInt();
    System.out.println("please input the circle edge coordinate y");
    int y2 =scan.nextInt();
    double r=Math.pow(Math.pow(x2-y2,2)-Math.pow(x1-y1,2),1/2);
    double circumference=2*Math.PI*r;
    double area=Math.PI*r*r;
    System.out.println("circumfrance of circle:"+circumference);
    System.out.println("area of circle:"+area);
    String name=scan.nextLine();
    int space= name.indexOf(" ");
    String lastName=name.substring(space+1);
    String firstName=name.substring(0,  space);
    System.out.println(lastName+","+firstName);

    int day=scan.nextInt() ;
    switch(day) {
    case 1:
    	System.out.println("Monday");
    	break;
    case 2:
        System.out.println("Tuesday");
        break;
     case 3:
        System.out.println("Wednesday");
        break;
     case 4:
        System.out.println("Thursday");
        break;
     case 5:
        System.out.println("Friday");
        break;
     case 6:
        System.out.println("Saturday");
        break;
     case 7:
        System.out.println("Sunday");
        break;
    }
    System.out.print("Enter the first city name: ");
    String city1 = scan.nextLine();
    System.out.print("Enter the second city name: ");
    String city2 = scan.nextLine();
    System.out.print("Enter the third city name: ");
    String city3 = scan.nextLine();
    
    String first,second,third;
    if (city1.compareTo(city2)<=0 && city1.compareTo(city3)<=0) {
        first=city1;
        if(city2.compareTo(city3)<=0) {
            second=city2;
            third=city3;
        } else{
            second=city3;
            third=city2;
           }
    } else if(city2.compareTo(city1)<=0 && city2.compareTo(city3)<=0) {
        first=city2;
        if(city1.compareTo(city3) <=0) {
            second=city1;
            third=city3;
        } else{
            second=city3;
            third=city1;
           }
    } else{
        first=city3;
        if (city1.compareTo(city2) <=0) {
            second=city1;
            third=city2;
        } else{
            second=city2;
            third=city1;
           }
    }
    System.out.println(first);
    System.out.println(second);
    System.out.println(third);
    
    double height=scan.nextDouble();
    double base=scan.nextDouble();
    double trieangleArea=(height*base)/2;
    System.out.printf("area of triangle is: %.3f%n",area);

    
	}

}

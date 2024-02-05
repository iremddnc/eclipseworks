import java.util.Scanner;

public class Quiz1_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double height=7.9 , width=4.5,area,perimeter;
        area= height*width;
        System.out.println("the area of rectangle:"+area);
        
       Scanner input=new Scanner(System.in);
       double side,Area;
       System.out.println("please enter the side:");
       side=input.nextInt();
       Area=side*side*3/2*Math.pow(3,0.5);
       System.out.println("area of hexagon:"+Area);
       
       int number;
       Scanner input1=new Scanner(System.in);
       System.out.println("please enter the number:");
       number=input.nextInt();
       if (number<5 && number>-5) {
       }
       else  {
    	   System.out.println("not in range");
       }
       if (number==1) {
    	   System.out.println(Math.pow(number, 2));}
       else if(number==3) {
    	   System.out.println(Math.pow(number, 2));}
       else if(number==-1) {
    	   System.out.println(Math.pow(number, 2));}
       else if(number==-2) {
    	   System.out.println(Math.pow(number, 2));}
       else if(number==-3) {
    	   System.out.println(Math.pow(number, 2));} 
       else if(number==-4) {
    	   System.out.println(Math.pow(number, 2));}	   
	  }
		

	}
    	   
   
       
       
       
     
       
       
       
       
       
       
        
	
	



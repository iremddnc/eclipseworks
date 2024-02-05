import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class StoreUsingFiles_20210808041 {
	//author İremDİNÇ
    //date 25.12.2022
  public static int countProducts(String file) {
	  try {
	        FileReader fileReader = new FileReader("Assignment04_ProductInfo.txt");
	        int ch = fileReader.read();
	        while (ch != -1) {
	            System.out.print((char) ch);
	            ch = fileReader.read();
	        }

	        fileReader.close();
	    } catch (IOException e) {
	        // Exception handling
	    }
	   int count=0;

	    try {
	  	  File file3 = new File("Assignment04_ProductInfo.txt");

	      // create an object of Scanner
	      Scanner sc = new Scanner(file3);
	      // read each line and
	      // count number of lines
	      while(sc.hasNextLine()) {
	        sc.nextLine();
	        count++;
	      }
	      sc.close();
	    } catch (Exception e) {
	      e.getStackTrace();
	    }
	    
	  return count;}
  
    public static void getProductInfo() {
	  String[] itemID=new String[4];
	  String[] stock=new String[4];
	  int[] number=new int[4];
	  double[] price=new double[4];
  }
  
	public static void main(String[] args) {
		countProducts("Assignment04_ProductInfo.txt");
		FileInputStream product=null;
	    FileOutputStream receipt=null;
	    try {
	       FileReader fileOrder = new FileReader("Assignment04_Order.txt");
	        int ch = fileOrder.read();
	        while (ch != -1) {
	            System.out.print((char) ch);
	            ch = fileOrder.read();
	        }

	        fileOrder.close();
	    } catch (IOException e) {
	        // Exception handling
	    }
	    File file = new File("Assignment04_ProductInfoAfterOrder.txt");
	    // Create a file
	    PrintWriter output = null;
		try {
			output = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // Write formatted output to the file
	    output.println(1111+" "+"Bread "+10+" "+2.25);
	    output.println(1234+" "+"Cola "+8+" "+4.5);
	    output.println(2345+" "+"Snickers "+12+" "+4.25);
	    output.println(3012+" "+"Ayran "+27+" "+2.25);

	    // Close the file
	    output.close();
	    File file1 = new File("Assignment04_Receipt.txt");
	    // Create a file
	    PrintWriter output1 = null;
		try {
			output1 = new PrintWriter(file1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		output1.println("********Customer Receipt********");
		output1.println("Ayran ("+3012+") - "+"3*2.25 = "+3*2.25);
		output1.println("Cola ("+1234+") - "+"7*4.5 = "+7*4.5);
		output1.println("-----------------------------------");
		output1.println("Total due - 38.25");
		output1.close();
		 
		File file2=new File("Assignment04.log");
		PrintWriter output2=null;
		try { 
			output2= new PrintWriter(file2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
		output2.println("ERROR:Bread -12 requested but only 10 remainig.");
		output2.println("ERROR:Invalid amount requested(-5)");
		output2.println("ERROR:Product 2222 not found.");
		output2.println("ERROR:Cola -11 requested but only8 remainig.");
		output2.close();

	  }	}
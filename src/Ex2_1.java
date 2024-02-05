
public class Ex2_1 {

	static Stock stock1=new Stock("ORCL","Oracle Corporation",34.5,34.35);
	
    public static void main (String[] args) {
	//System.out.println(stock1.getChangePercent());
 } 
    }
	class Stock{
		private String symbol;
		private String name;
		private double previousClosingPrice;
		private double currentPrice;
	 double getChangePercent() {
		return((previousClosingPrice-currentPrice)/previousClosingPrice)*100;
		}
		
		public Stock(String symbol,String name,double previousClosingPrice,double currentPrice) {
			this.symbol=symbol;
			this.name=name;
			this.previousClosingPrice=previousClosingPrice;
			this.currentPrice=currentPrice;		
		}
	
		public Stock(String symbol,String name) {
			this(symbol,name,0,0);
			}
		public String getSymbol() {
			return symbol;
		}
		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getPreviousClosingPrice() {
			return previousClosingPrice;
		}
		public void setPreviousClosingPrice(double previousClosingPrice) {
			this.previousClosingPrice = previousClosingPrice;
		}
		public double getCurrentPrice() {
			return currentPrice;
		}
		public void setCurrentPrice(double currentPrice) {
			this.currentPrice = currentPrice;
		}
	}
	
      class Fan{
	   int SLOW=1;
	   int MEDIUM=2;
	   int FAST=3;
	  private int speed;
	  private boolean on;
	  private double radius;
	 public String color;
	 public String toString() {
		 if(on=true) {
			 System.out.println("fan is on");
			 return (speed+color+radius);
		 }
		
		else {
			System.out.println("fan is off");
			return color+radius;
		}
	 }
	 public Fan(){
			this.radius=5;
			this.color="blue";
			this.speed=SLOW;
			this.on=false;
		}
		public Fan(double radius,String color) {
			 this.radius = radius;
		     this.color = color;
			
			
		}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public boolean isOn() {
		return on;
	}
	public void setOn(boolean on) {
		this.on = on;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	   
	   
   }


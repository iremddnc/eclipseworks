import java.util.Date;
import java.util.List;

public class Ex2_6 {

}
 abstract class Product implements Comparable<Product>{
	private String name;
	private double price;
	

   public Product(String name,double price) {
	   this.name=name;
	   this.price=price;
   }

   public String getName() {
	return name;
}

   public double getPrice() {
	return price;
}
   public int compareTo(Product another) {
       if(this.price<another.price){ 
           return -1;}
        else if(this.price>another.price){
           return 1;}
       else{
           return 0;
       }
  }
   public String toString() {
	   return "["+"name= "+ name + ", price = "+ price + "]";
   }
 }
    abstract class Book extends Product{
	   private String author;
	   private  int pageCount;
	public Book(String name, double price, String author, int pageCount) {
		super(name, price);
		this.author = author;
		this.pageCount = pageCount;
	}
	public String getAuthor() {
		return author;
	}
	public int getPageCount() {
		return pageCount;
	}
    }
	class ReadingBook extends Book{
		private String genre;

		public ReadingBook(String name, double price, String author, int pageCount) {
			super(name, price, author, pageCount);
			this.genre=genre;
		}

		public String getGenre() {
			return genre;
		}

	}
	class ColoringBook extends Book implements Colorable{
     private String color;
		public ColoringBook(String name, double price, String author, int pageCount) {
			super(name, price, author, pageCount);
		}
		public String getColor() {
			return color;
		}
		@Override
		public void paint(String color) {
		}
		
		
	}
	  class ToyHorse extends Product implements Rideable{

		public ToyHorse(String name, double price) {
			super(name, price);
			
		}
		public void ride() {}
	
	  } 
	   class Bicycle extends Product implements Rideable,Colorable{
		  private String color;
	   
	   public Bicycle(String name, double price, String color) {
			super(name, price);
			this.color = color;
		}

	public String getColor() {
			return color;
		}

	@Override
	public void paint(String color) {
		
	}
	public void ride() {
		
	}

	   }
	   
	  class User{
		  private String username;
		  private String email;
		  private PaymentMethod payment;
		  private List<Product> cart;
		public User(String username, String email) {
			this.username = username;
			this.email = email;
		}
		public String getUsername() {
			return username;
		}
		public String getEmail() {
			return email;
			
		}
		public void setPayment(PaymentMethod payment) {
			this.payment = payment;
		}
		  public Product getProduct(int index ) {
			return null ;
			  
		  }
		  public void removeProduct(int index) {
			  
		  }
		  public void addProduct(Product product) {
			  
		  }
		  public void purchase() {
			  double totalPrice = 0;
			 for(Product product:cart) {
		          totalPrice+= product.getPrice();
		   }
			 
		        cart.clear();
		       
		  
	  }
		  }
    class CreditCard implements PaymentMethod{
    	private Long cardNumber;
    	private String cardHolderName;
    	private Date expirationDate;
    	private int cvv;
		public CreditCard(Long cardNumber, String cardHolderName, Date expirationDate, int cvv) {
			this.cardNumber = cardNumber;
			this.cardHolderName = cardHolderName;
			this.expirationDate = expirationDate;
			this.cvv = cvv;
		}
		@Override
		public boolean pay(double amount) {
			return false;
		}
		}
    	class PayPal{
    		private String username;
    		private String password;
			public PayPal(String username, String password) {
				this.username = username;
				this.password = password;
			}
			public boolean pay(double amount) {
		        return true;
		    }
    	}
    	 interface Colorable{
    	    void paint(String color);
    	}

    	 interface Rideable{
    	    void ride();
    	}

    	 interface PaymentMethod{
    	    boolean pay(double amount);
    	}
    

	

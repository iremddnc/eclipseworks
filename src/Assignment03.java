import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
//import java.util.Collection;
import java.util.List;
import java.util.Map;
//@author İrem DİNÇ
//@date 30.05.2023
public class Assignment03 {
    public static void main (String[]args ){
        Store s1 = new Store("Migros","www.migros.com.tr");
        Store s2 = new Store("Bim","www.bim.com.tr");
        Customer c = new Customer("CSE 102");
        Customer cc = new Customer("Club CSE 102");
        s1.addCustomer(cc);
        s2.addCustomer(cc);
        Product p = new Product(123456L,"Computer",1000.00);
        FoodProduct fp = new FoodProduct(456789L,"Snickers",2,250,true,true,true,false);
        CleaningProduct cp = new CleaningProduct(31654L,"Mop",99,false,"Multi-room");
        System.out.println(cp);
        s1.addToInventory(p,20);
        s2.addToInventory(p,10);
        s2.addToInventory(fp,100);
        s1.addToInventory(cp,28);
        System.out.println(s1.getName()+" has "+ s1.getCount() +" products");
        System.out.println(s1.getProductCount(p));
        System.out.println(s1.purchase(p,2));
        s1.addToInventory(p,3);
        System.out.println(s1.getProductCount(p));
        System.out.println(s2.getProductCount(p));
        c.addToCart(s1,p,2);
        //c.addToCart(s1,fp,1);
        c.addToCart(s1,cp,1);
        System.out.println("Total due - " +c.getTotalDue(s1));

        // System.out.println("After paying:  "+c.pay(s1,2100,true));
        cc.addToCart(s2,fp,2);
        cc.addToCart(s2,fp,1);
        System.out.println(cc.receipt(s2));
        cc.addToCart(s2,fp,10);
        System.out.println(cc.receipt(s2));

    }
}


class Product{
    private Long Id;
    private String Name;

    protected double Price;

    public Product(Long Id, String Name, double Price)throws InvalidPriceException,InvalidAmountException {
        this.Id = Id;
        this.Name = Name;

        this.Price = Price;

    }

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }
    public void setPrice(double price)throws InvalidPriceException{
        Price = price;
        throw new InvalidPriceException(price);
    }

    public String toString() {
        return Id+"-"+Name+"@"+Price;

    }
    public boolean equals(Object o) {
        if(o==null) return false;
        if(o instanceof Product) {
            Product pro=(Product)o;
            if (!pro.Id.equals(Id)) return false;
            if (!pro.Name.equals(Name)) return false;

        }
        return true;
    }


}
class FoodProduct extends Product {

    public FoodProduct(Long Id, String Name, double Price, int calories, boolean dairy,
                       boolean eggs, boolean peanuts, boolean gluten) {
        super(Id, Name, Price);
        Calories = calories;
        Dairy = dairy;
        Eggs = eggs;
        Peanuts = peanuts;
        Gluten = gluten;
        //throw new InvalidAmountException(calories);
    }
    private int Calories;
    private boolean Dairy ;
    private boolean Eggs;
    private boolean Peanuts;
    private boolean Gluten;

    public int getCalories() {
        return Calories;
    }
    public void setCalories(int calories)throws InvalidAmountException {
        Calories = calories;
        if(calories<0) {
            throw new InvalidAmountException(calories);
        }
    }

    public boolean containsDairy() {
        return true;
    }
    public boolean containsEggs() {
        return true;

    }
    public boolean containsPeanuts() {
        return true;
    }
    public boolean containsGluten() {
        return true;
    }  }
class CleaningProduct extends Product{
    public CleaningProduct(Long  Id, String Name, double Price,boolean Liquid,String WhereToUse) {
        super(Id, Name, Price);

    }
    boolean Liquid;
    String WhereToUse;
    public String getWhereToUse() {
        return WhereToUse;
    }
    public void setWhereToUse(String whereToUse) {
        WhereToUse = whereToUse;
    }
    public boolean isLiquid() {
        return true;
    }
}
class Customer {

    protected String Name;
    protected List<Product>customercart;
    protected double tdue;
    private String cart="";
    protected List<Integer>countt;
    protected  Map<Store,Integer>productC;
    public Customer(String name) {
        Name = name;
        this.customercart = new ArrayList<>();
        this.countt=new ArrayList<>();
        this.productC = new HashMap<>();
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String toString() {
        return Name;
    }
    public void addToCart(Store store,Product product,int count){
        	 productC.put(store,count);
             tdue += product.getPrice() * count;
        if (store.getProductCount(product) >= count) {

            for(int i=0;i<count; i++) {
                customercart.add(product);

            }
        } else {
            System.out.println("ERROR: Product is not available in sufficient quantity.");
        } }


    public String receipt(Store store)throws StoreNotFoundException {

        if(!productC.containsKey(store)) {
            throw new  StoreNotFoundException(store.getName());
        }
        String receipt = store.getName()+"\n";

        Map<Product,Integer> productCountMap=new HashMap<>();
        for(Product product : customercart) {
            int count=productCountMap.getOrDefault(product,0);
            productCountMap.put(product,count + 1);
        }
        double totalAmount = 0.0;
        for(Product product : productCountMap.keySet()) {
            int count = productCountMap.get(product);
            double productTotal = count * product.getPrice();
            receipt += product.getId() + " - " + product.getName() + " @ " + product.getPrice() + " X " + count + "\n";
            receipt += ".." + productTotal + "\n";

            totalAmount+=productTotal;
        }
        receipt+="Total Due - "+totalAmount;

        return receipt;
    }
    public int getPoints(Store store) {

        return getPoints(store);
    }
    public double pay(Store store,double amount,boolean usePoints ) {

        if (!customercart.contains(store)) {
            throw new StoreNotFoundException(store.getName());
        }

        double totalDue = getTotalDue(store);

        if (amount >= totalDue) {
            System.out.println("Thank you");
            double change= amount-totalDue;

            if (usePoints && customercart.contains(store)) {
                int points= store.getCustomerPoints(this);

            }

            return change;
        } else {
            throw new InsufficientFundsException(amount, tdue);
        }
    }
    double getTotalDue(Store store) {

        return tdue;
    }

}


class Store{
    protected String Name;
    private String Website;
    private Map<Product,Integer> inventory;
    private List<Customer>cust;
    private String Phone;
    private int Points;
    //private Long Id;
    //private int Quantity;
    //private double Price;



    public Store(String name, String website) {
        Name = name;
        Website = website;
        this.inventory = new HashMap<>();
        this.cust = new ArrayList<>();
    }


    public int getCount() {

        return inventory.size();
    }


    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getWebsite() {
        return Website;
    }
    public void setWebsite(String website) {
        Website = website;
    }
    public int	getInventorySize() {
        return inventory.size();
    }

    public int getProductCount(Product product)throws ProductNotFoundException {
        if (!inventory.containsKey(product)) {
            throw new ProductNotFoundException("Product not found in inventory.");
        }
        return inventory.get(product);
    }

    public int getCustomerPoints(Customer customer)throws CustomerNotFoundException{
        if (cust.contains(customer)){
            return customer.getPoints(this);
        }
        else
            throw new CustomerNotFoundException("customer not found in collection");

    }


    public int getProductIndex(Product p) {
        if(!inventory.containsKey(p)) {
            return -1; }
        return ((List<Product>)inventory).indexOf(p);
    }
    public void addCustomer(Customer customer) {
        cust.add( customer);
        this.Points=0;

    }
    public Customer getCustomer(String phone)throws CustomerNotFoundException{

        for (Customer customer:cust) {
            if(customer.getName().equals(phone)) {
                return customer;
            }}
        throw new CustomerNotFoundException(phone);
    }
    public void removeProduct(Product product) throws ProductNotFoundException{
        if (!inventory.containsKey(product)) {
            throw new ProductNotFoundException(Name);
        }
        inventory.remove(product);
    }
    public void removeProduct(Long ID)throws ProductNotFoundException {
        for(int i=0;i<inventory.size();i++) {
            Integer prodct=inventory.get(i);
            if(inventory.containsKey(ID)) {
                inventory.remove(prodct);
            } }
        throw new ProductNotFoundException(ID);
    }
    public void removeProduct(String name)throws ProductNotFoundException {
        for(int i=0;i<inventory.size();i++) {
            Integer prodct=inventory.get(i);
            if(inventory.containsKey(name)) {
                inventory.remove(prodct);
            }
        }
        throw new ProductNotFoundException( name);
    }
    public void removeCustomer(String phone)throws CustomerNotFoundException {
        for (Customer customer :cust) {
            if (cust.contains(phone)) {
                cust.remove(customer);
            }
        }
        throw new CustomerNotFoundException(phone);
    }
    public int remaining(Product product) {
        if(!inventory.containsKey(product)) {
            throw new ProductNotFoundException("product not found");
        }
        return inventory.get(product);
    }


    public void addToInventory(Product product,int amount)throws InvalidAmountException{
        if(amount<0){
            throw new InvalidAmountException(amount);
        }
        if(inventory.containsKey(product)) {
            inventory.put(product,inventory.get(product) + amount);}

        else if(!inventory.containsKey(product)){
            inventory.put(product, amount);
        }

    }
    public double purchase(Product product,int amount)throws InvalidAmountException {
        if(amount<0 || amount>inventory.get(product)) {
            throw new InvalidAmountException(amount);

        }
        if(inventory.containsKey(product)) {
            double totalPrice = product.getPrice() * amount;
            inventory.put(product, inventory.get(product) - amount);

            return totalPrice;
        }
        else {
            throw new ProductNotFoundException("Product not found in inventory.");
        }
    }

}
class CustomerNotFoundException extends IllegalArgumentException{

    private String phone;
    private String name;
    public CustomerNotFoundException(String phone) {
        this.phone = phone;
        //super(phone);
    }
    public String toString() {
        return ("CustomerNotFoundException"+phone);
    }


}
class InsufficientFundsException extends RuntimeException{
    private double total;
    private double payment;
    //conructor ekle
    public InsufficientFundsException(double total,double payment) {
        this.payment=payment;
        this.total=total;
    }
    public String toString() {
        return ("InsufficientFundsException:"+total+"due, but only"+payment+"given");
    }
}
class InvalidAmountException extends RuntimeException{
    private int amount;
    private int quantity;
    public InvalidAmountException(int amount) {
        this.amount=amount;
    }
    public InvalidAmountException(int amount,int quantity) {
        this.amount=amount;
        this.quantity=quantity;}

    public String toString() {

        if(quantity!=0&& quantity>0) {
            return("InvalidAmountException:"+amount+"was requested,but only"+quantity+"remaining");
        }
        else {
            return "InvalidAmountException: "+amount;
        }

    }
}
class InvalidPriceException extends RuntimeException{
    private double price;
    public InvalidPriceException(double price) {
        this.price=price;
    }
    public String toString() {
        return "InvalidPriceException: "+price;
    }
}

class ProductNotFoundException extends IllegalArgumentException{
    private Long ID;
    private String name;
    private Product product;
    public ProductNotFoundException(Long ID,String name) {
        this.ID=ID;
        this.name=name;
    }
    public ProductNotFoundException(Long ID) {
        this.ID=ID;
        this.name=null;
    }
    public ProductNotFoundException(String name) {
        this.ID=0L;
        this.name=name;

    }
    public String toString() {
        return	"ProductNotFoundException: ID - " + ID + " Name - " + name;
    }
}
class StoreNotFoundException extends IllegalArgumentException{
    private String name;

    public StoreNotFoundException(String name) {
        this.name = name;
    }
    public String toString() {
        return "StoreNotFoundException:"  + name;
    }


}
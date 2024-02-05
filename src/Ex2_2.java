import java.util.Date;

public class Ex2_2 {

}
class Ticket{
	private City from;
	private City to;
	private java.util.Date date;
	private int seat;
	public Ticket(City from, City to, Date date, int seat) {
		this.from = from;
		this.to = to;
		this.date = date;
		this.seat = seat;
	}
	public Ticket(City from, City to, int seat) {
		this.from = from;
		this.to = to;
		this.seat = seat;
		Date today = new Date();
		Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
		this.date=tomorrow; 
	}
	public City getFrom() {
		return from;
	}
	public City getTo() {
		return to;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	
}
class City{
	private String postalCode;
	private String name;
	public City(String name,String postalCode) {
		this.name=name;
		this.postalCode=postalCode;
	}
	public String getPostalCode() {
		return postalCode;
	}
	
	public String getName() {
		return name;
	}
	
}
class Person extends City{
	private String name;
	private String surname;
	private String phoneNumber;
	
	public Person(String postalCode,String name,String surname,String phoneNumber) {
		super(null,name);
		this.surname = surname;
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String setSurname() {
		return surname;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	 
	
	
}
import java.util.ArrayList;
import java.util.List;

public class Ex2_5 {

	public static void main(String[] args) {
	}

}
class Account{
	private String accountNumber;
	private double balance;
	public Account(String accountNumber, double balance)throws InsufficientFundsException{
		this.accountNumber = accountNumber;
		this.balance = balance;
		if (balance<0) {
			throw new InsufficientFundsException(balance);
		}
	
	}
	
   public String getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	public void deposit(double amount)throws InvalidTransactionException {
        balance+= amount;
        if(amount<0){
            throw new InvalidTransactionException(amount);
            }
       }
	public void withdraw(double amount)throws InvalidTransactionException,InsufficientFundsException {
		 balance-= amount;
		if(amount<0){
            throw new InvalidTransactionException(amount);
        }
        if(balance<amount){
            throw new InsufficientFundsException(balance,amount);
           }
        }
	public String toString() {
		return "Account:"+ accountNumber+ ", Balance:"+ balance;
	  }
  }
class Customer{
	private String name;
	private List<Account> accounts;
	public Customer(String name, List<Account> accounts) {
		this.name = name;
		this.accounts = new ArrayList<>();;
	}
	public Account getAccount(String accountNumber)throws AccountNotFoundException{
	    for (Account account:accounts) {
	      if (account.getAccountNumber().equals(accountNumber)) {
	    return account;
	     }
	  }
	      throw new AccountNotFoundException(accountNumber);
	}
	public void addAccount(Account account)throws AccountAlreadyExistsException {
		try {
            getAccount(account.getAccountNumber());
            throw new AccountAlreadyExistsException(account.getAccountNumber());
        } catch(AccountNotFoundException e){
            accounts.add(account);}
            finally {
            System.out.println(this);
            System.out.println("Added account: "+account.getAccountNumber()+ " with "+account.getBalance());
            }
      }
	public void removeAccount(Account accountNumber) {
		accounts.remove(accountNumber);
	  }
	public void transfer(String fromAccount,String toAccount,double amount)throws InvalidTransactionException{
		Account source= getAccount(fromAccount);
        Account target= getAccount(toAccount);
		try{
            source.withdraw(amount);
            target.deposit(amount);
        } catch(InvalidTransactionException e) {
            throw new InvalidTransactionException( e,"cannot transfer funds from account"+ fromAccount+ "toaccount"+ toAccount);
        }
	}
	public String toString(){
		String Detail= "";
	     for(Account account:accounts){
	        Detail+= "\t"+ account.toString()+"\n";
	    }
	    return "Customer "+name+"\n"+Detail;
	   }
	
	}

  class InsufficientFundsException extends RuntimeException{
	  public InsufficientFundsException(double balance) {
	  super("Wrong balance:" +balance);}
	  public InsufficientFundsException(double balance,double amount) {
		  super("Required amount is "+ amount + "but only "+ balance+ "remaining");}
  }
  class AccountAlreadyExistsException extends RuntimeException{
	  public AccountAlreadyExistsException (String accountNumber) {
		 super( "Account number"+ accountNumber+ "already exists");
	  }
  }
  class AccountNotFoundException extends RuntimeException{
	  public AccountNotFoundException(String accountNumber) {
		  super("Account number "+ accountNumber + "already exists");
	  }
  }

  class InvalidTransactionException extends Exception{
	  public InvalidTransactionException(double amount) {
		  super("Invalid amount: "+amount);
	  }
	  public InvalidTransactionException( InvalidTransactionException e,String message) {
	  super(message+ ":\n\t"+ e.getMessage());}
  }
  
  
  
  
  
  
  
  
  
  
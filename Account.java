/* Name: Abdulrahman Al Zaatari
 * ID: 202201380
 * Last modified: Wednesday, April, 5th 2023
 * Code description: Class Account defines what an account is.
 * Files: Node.java, LinkedList.java, Person.java, Queue.java, Transaction.java, ATM.java
 */

package Q2;

public class Account {
	//Attributes
	protected int account_number;
	protected String type;
	protected double balance;
	//Constructor
	public Account(int an, String t, double b) {
		account_number=an;
		type=t;
		balance=b;
	}
	
	//Setters and Getters and ToString methods
	public int getAccount_number() {
		return account_number;
	}

	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	 public String toString() {
	        return "account_number: " + String.valueOf(account_number) + " type: " + type + " balance: "+ String.valueOf(balance);
	    }         
}

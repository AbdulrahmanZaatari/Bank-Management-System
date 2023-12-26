/* Name: Abdulrahman Al Zaatari
 * ID: 202201380
 * Last modified: Wednesday, April, 5th 2023
 * Code description: Defines a transaction.
 * Files: LinkedList.java, ATM.java, Node.java, Queue.java, Person.java, Account.java
 */
package Q2;
import java.time.LocalTime;
import java.time.LocalDate;
public class Transaction {
	//Attributes
	protected Person p;
	protected LocalDate date;
	protected LocalTime time;
	protected String type;
	protected double amount;
	protected int to_acc;
	protected int from_acc;
	
	//Constructor
	public Transaction (Person person, LocalDate d, LocalTime t, String ty, double a, int to) {
		p = person;
		date = d;
		time = t;
		type = ty;
		amount = a;
		to_acc = to;
	}
	//Second Constructor
	public Transaction (Person person, LocalDate d, LocalTime t, String ty, double a, int to, int from) {
		p = person;
		date = d;
		time = t;
		type = ty;
		amount = a;
		to_acc = to;
		from_acc = from;
	}
	
	//Setters and Getters and ToString method
	public Person getP() {
		return p;
	}

	public void setP(Person p) {
		this.p = p;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String toString() {
		return "Transaction: " + p + ", date=" + date + ", time=" + time + ", type=" + type + ", amount=" + amount
				+ ", to_acc=" + to_acc + ", from_acc=" + from_acc + "]";
	}
}


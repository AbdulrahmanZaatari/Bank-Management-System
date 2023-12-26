/* Name: Abdulrahman Al Zaatari
 * ID: 202201380
 * Last modified: Wednesday, April, 5th 2023
 * Code description: Will be used to create both linkedlists and Queues.
 * Files: LinkedList.java, ATM.java, Person.java, Queue.java, Transaction.java, Account.java
 */
package Q2;

public class Node {
	//Attributes
	private Account account;
	private Node next;
	
	//Constructor
	public Node(Account a) {
		account = a;
		next = null;
	}
	
	//Setters and Getters
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account a) {
		account = a;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}	

}

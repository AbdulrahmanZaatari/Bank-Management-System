/* Name: Abdulrahman Al Zaatari
 * ID: 202201380
 * Last modified: Wednesday, April, 5th 2023
 * Code description: Creates a Queue to store transactions if not processed.
 * Files: LinkedList.java, ATM.java, Node.java, Queue.java, Transaction.java, Account.java
 */
package Q2;

public class Queue {
	//Attributes
	protected Transaction[] q;
	protected int front;
	protected int rear;
	//Constructor
	public Queue() {
		q = new Transaction[10];
		front = 0;
		rear = -1;
	}
	
	//Ensure capacity since Queue is implemented using arrays
	public void ensureCapacity(Transaction[] arr) {
		Transaction[] n_arr = new Transaction[arr.length*2 + 1];
		for (int i = 0; i<arr.length; i++) {
			n_arr[i] = arr[i];
		}
		arr = n_arr;
	}
	
	public void enqueue(Transaction t) {
		//Method to add to Queue
		if (rear == q.length-1) {
			ensureCapacity(q);
		}
		rear++;
		q[rear] = t;
	}
	
	public Transaction dequeue() {
		//Method to delete from Queue
		if (empty()) {
			System.out.println("Queue is empty.");
		}
		Transaction dqelement = q[front];
		front++;
		return dqelement;	
		}
	
	public boolean empty() {
		//Method to see if Queue is empty
		if (front==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int size() {
		//Method to get size of Queue
		return rear - front + 1;
	}
	
	 public String toString() {
		 //ToString method
	     String result = "";
	     for (int i = 0; i < q.length; i++) {
	         if (q[i] != null) {
	             result += q[i].toString() + "\n";
	         }
	     }
	     return result;
	 }
	
	
}

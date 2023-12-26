/* Name: Abdulrahman Al Zaatari
 * ID: 202201380
 * Last modified: Wednesday, April, 5th 2023
 * Code description: LinkedList class, will be used to store accounts of individuals.
 * Files: Node.java, ATM.java, Person.java, Queue.java, Transaction.java, Account.java
 */
package Q2;

public class LinkedList {
	//Attribute header
	protected Node header;
	
	//Constructor
	public LinkedList() {
		header = null;
	}
	
	public void add (Account a) {
		//Add an account to the LinkedList
		Node n = new Node (a);
		if (header == null) {
			header = n;
		}
		
		else {
			Node current = header;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(n);
		}
	}
	
	public boolean delete (int i) {
		//Delete an account from the LinkedList
		if (i<0 || i >= size()) {
			return false;
		}
		
		else if (i == 0) {
			Node next = header.getNext();
			header = next;
			return true;
		}
		
		else if (i==size()-1) {
			Node current = header;
			for (int j = 0; j<i-1; j++) {
				current = current.getNext();
			}
			current.setNext(null);
			return true;
			}
		
		else {
			Node current = header;
			for (int j = 0; j<i-1; j++) {
				current = current.getNext();
			}
			current.setNext(current.getNext().getNext());
			return true;
			}
		}
	
	public int size() {
		//Get size of LinkedList
		int count = 0;
		if (header == null) {
			return count;
		}
		else {
			Node current = header;
			while (current.getNext() != null) {
				current = current.getNext();
				count++;
			}
		return count;
		}
		
	}
	
	public Node getAcc(int account_number) {
		//Get account through specific account number
        if (header == null)
            return null;
        Node current = header;
        while (current != null) {
            if (current.getAccount().getAccount_number() == account_number) {
                return current;
            }
            current = current.getNext();
        }
        return null;

    }
	
	public void withdraw(int account_number, double amount) {
		//Method to withdraw money from chosen account
        if (header == null) {
            return;
        }
        
        if (amount < 0) {
            System.out.println("To withdraw from your balance, the amount must be positive. Why should you always be negative!~ ");
            return;
        }
        
        if (amount > getAcc(account_number).getAccount().getBalance()) {
            System.out.println("You don't have enough money! Maybe it's the end of the month :p? ");
            return;
        }
        Node current = header;
        while (current != null) {
            if (current.getAccount().getAccount_number() == account_number) {
                current.getAccount().setBalance(current.getAccount().getBalance() - amount);
                System.out.println("Withdrawal successful");
                return;
            }
            current = current.getNext();
        }
        System.out.println("Account not found");

    }
	
	 public void deposit(int account_number, double amount) {
		//Method to deposit in chosen account
        if (header == null)
            return;
        if (amount < 0) {
            System.out.println("To add to balance, the amount must be positive. Why should you always be negative!~  ");
            return;
        }
        Node current = header;
        while (current != null) {
            if (current.getAccount().getAccount_number() == account_number) {
                current.getAccount().setBalance(current.getAccount().getBalance() + amount);
                System.out.println("Deposit is successful. ");
                return;
            }
            current = current.getNext();
        }
        System.out.println("Check account number, account not found.");
    }
	 
	 public void transfer(int account_number, int account_number2, double amount) {
		 //Method to transfer money from one account to the other
	     if (header == null)
	         return;
	     if (amount < 0) {
	         System.out.println("To transfer, the amount must be positive. Why should you always be negative!~ ");
	         return;
	     }
	     if (amount > getAcc(account_number).getAccount().getBalance()) {
	         System.out.println("You don't have enough money! Maybe it's the end of the month :p?");
	         return;
	     }
	     Node account1 = getAcc(account_number);
	     Node account2 = getAcc(account_number2);
	     if (account1 == null || account2 == null) {
	    	 System.out.println("One of the accounts was not found. ");
	         return;
	     }
	     account1.getAccount().setBalance(account1.getAccount().getBalance() - amount);
	     account2.getAccount().setBalance(account2.getAccount().getBalance() + amount);
	     System.out.println("Transfer successful!");
	 }
	 
	 public String toString() {
		 //ToString method 
	     String accounts = "";
	     Node current = header;
	     while (current != null) {
	         accounts += current.getAccount().toString() + "\n";
	         current = current.getNext();
	     }
	     return accounts;
	 }
}

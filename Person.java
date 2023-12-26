/* Name: Abdulrahman Al Zaatari
 * ID: 202201380
 * Last modified: Wednesday, April, 5th 2023
 * Code description: Creates users of the system, defines a Person.
 * Files: LinkedList.java, ATM.java, Node.java, Queue.java, Transaction.java, Account.java
 */
package Q2;

public class Person {
	//Attributes
	protected String name;
	protected int client_number;
	protected LinkedList accounts;
	protected int ID;
	protected String pass;
	
	//Constructor
	public Person(int id, String n, int cn, String p, String accs) {
		 ID = id;
	     name = n;
	     client_number = cn;
	     pass = p;
	     accounts = new LinkedList();
	     accs = accs.trim();
	     accs = accs.substring(1, accs.length() - 1);
	     String[] actual_accounts = accs.split(" ");
	        for (int i = 0; i < actual_accounts.length; i++) {
	            String[] account_parts = actual_accounts[i].split(";");
	            Account a = new Account(Integer.parseInt(account_parts[0]), account_parts[1], Double.parseDouble(account_parts[2]));
	            this.accounts.add(a);
	        }
	}
	
	//Setters and getters and ToString and Equals methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClient_number() {
		return client_number;
	}

	public void setClient_number(int client_number) {
		this.client_number = client_number;
	}

	public LinkedList getAccounts() {
		return accounts;
	}

	public void setAccounts(LinkedList accounts) {
		this.accounts = accounts;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String password) {
		pass = password;
	}

	public String toString() {
		return "Person [name = " + name + ", client_number = " + client_number + ", accounts = " + accounts + "]";
	}
	
	public boolean equals (Person p) {
		if (client_number == p.getClient_number()) {
			return true;
		}
		
		else {
			return false;
		}
		
	}
	
	
	
	
	
	
}

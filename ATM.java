/* Name: Abdulrahman Al Zaatari
 * ID: 202201380
 * Last modified: Wednesday, April, 5th 2023
 * Code description: Main driver of our code. Mimics an ATM machine.
 * Files: Node.java, LinkedList.java, Person.java, Queue.java, Transaction.java, Account.java
 */
package Q2;
import java.io.*;
import java.util.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Calendar;

public class ATM {
	//Attributes
	protected static ArrayList<Person> customers;
	protected Queue TQ;
	Person current_customer;
	Scanner scan = new Scanner(System.in);
	
	//Constructor
	public ATM() {
		customers = new ArrayList<>();
	    current_customer = null;
	    //Read file and create database
	    createDatabase();
	    //Create Transaction Queue
	    TQ = new Queue();
	}
	
	public static void createDatabase() {
		try {
		BufferedReader br = new BufferedReader(new FileReader("data.txt"));
	    String line = br.readLine();
	    while (line != null) {
	        String[] data = line.split(",");
	        Person person = new Person(Integer.parseInt(data[0].trim()), data[1], Integer.parseInt(data[2].trim()),data[3].trim(), data[4] + data[5] + data[6]);
	        customers.add(person);
	        line = br.readLine();
	    }
	    br.close();
		}
		catch (Exception e) {
            System.out.println("File not found!") ;
		}
	}
	
	public void loginSystem() {
		 //MEthod that asks user for ID and password and then checks if he is found on the database.
		 Scanner scan = new Scanner(System.in);
		 System.out.print("Enter your ID number: ");
	     int id = scan.nextInt();
	     System.out.print("Enter your password: ");
	     String password = scan.next();
	     for (int i = 0; i < customers.size(); i++) {
	            if (customers.get(i).getClient_number() == id && customers.get(i).getPass().equals(password)) {
	                current_customer = customers.get(i);
	                break;
	            }
	        }
	     if (current_customer == null) {
	    	 System.out.println("Invalid client number or password. ");
	         loginSystem();
	     }
	}
	
	public void q_still() {
		//Method that shows you transactions still left in queues
		System.out.println("Transactions still in queue: ");
		System.out.println(TQ.toString());
	}
	
	public boolean isProccessed() {
		//Method that checks if time is after 6 pm or if it is a sunday.
        LocalTime current_time = LocalTime.now();
        LocalTime pm6 = LocalTime.of(18, 0); // 6:00 PM
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (current_time.isAfter(pm6) || dayOfWeek == Calendar.SUNDAY) {
            return false;
        }
        return true;
    }
	
	public void addTransaction(double amount, String type, int account_number, int account_number2, LocalTime currentTime, LocalDate d) {
		//add transaction to Queue
        Transaction new_transaction;
        if (account_number != 0) {
            new_transaction = new Transaction(current_customer, d, currentTime, type, amount, account_number);
        } else {
            new_transaction = new Transaction(current_customer, d, currentTime, type, amount, account_number,
                    account_number2);
        }
        TQ.enqueue(new_transaction);
    }

	
	public int select() {
		//Lets user select a specific account.
		Scanner scan = new Scanner(System.in);
        System.out.println("Select an account:");
        System.out.println(current_customer.getAccounts().toString() + "\n");
        System.out.print("Enter your choice (account_nb): ");
        int choice = scan.nextInt();
        return choice;
    }
	
	
	
	public static void main(String[] args) {
		//Main function where the magic happens.
		Scanner scan = new Scanner(System.in);
		ATM atm = new ATM();
		int choice = 0;
		double amount = 0;
		int acc_num = 0;
		System.out.println("Hello, welcome to our ATM machine. You will be asked to enter your credentials to continue!");
		while (atm.current_customer == null) {
            atm.loginSystem();
		}
		System.out.println("User found successfully!");
		System.out.println("Hello" + atm.current_customer.getName() + "!");
			while (choice!=5) {
				//Menu
				System.out.println("1. Withdraw Money\r\n"
						+ "2. Deposit Money\r\n"
						+ "3. Transfer of Money\r\n"
						+ "4. Display Account Info\r\n"
						+ "5. Exit\r\n"
						+ "----------------------\r\n"
						+ "Enter your choice:");
				choice = scan.nextInt();
				switch(choice) {
				
				case 1:
					//Withdraw
					acc_num = atm.select();
                    System.out.print("Enter the amount: ");
                    amount = atm.scan.nextDouble();
                    if (atm.isProccessed()) {
                    	atm.current_customer.getAccounts().withdraw(acc_num, amount);
                    }
                    atm.addTransaction(amount, "debit", acc_num, 0, LocalTime.now(), LocalDate.now());
                    break;
                    
				case 2:
					//Deposit
					acc_num = atm.select();
                    System.out.print("Enter the amount: ");
                    amount = atm.scan.nextDouble();
                    if (atm.isProccessed()) {
                    	atm.current_customer.getAccounts().deposit(acc_num, amount);
                    	System.out.println("Deposit money successful!");
                    }
                    atm.addTransaction(amount, "credit", acc_num, 0, LocalTime.now(), LocalDate.now());
                    break;
                    
				case 3: 
					//Transfer
					int account_1 = atm.select();
                    int account_2= atm.select();
                    System.out.print("Enter the amount: ");
                    amount = atm.scan.nextDouble();
                    if (atm.isProccessed()) {
                    	atm.current_customer.getAccounts().transfer(account_1, account_2, amount);
                    }
                    atm.addTransaction(amount, "transfer", account_1, account_2, LocalTime.now(), LocalDate.now());
                    break;
					
				case 4:
					//Display Info
					System.out.println(atm.current_customer.getAccounts().toString());
                    break;
                    
				case 5:
					//Exit
					System.out.println("Hello, to exit, you will be asked to enter your credentials! First the transactions still in queue will be shown. ");
					if (!atm.isProccessed()) {
                        atm.q_still();
                    }
					System.out.print("Enter your ID again: ");
				    int id = scan.nextInt();
				    System.out.print("Enter your password again: ");
				    String password = scan.next();
				    atm.current_customer.toString();
				    if (atm.current_customer.getID() == id && atm.current_customer.getPass().equalsIgnoreCase(password)) {
				    	System.out.println("Good bye" + atm.current_customer.getName() + "!");
				    	atm.current_customer = null;
				    }
				    break;
		
					
				default:
					System.out.println("Invalid choice, please re-enter a choice from the menu. ");
					break;
				}
	   }
	}
	
}


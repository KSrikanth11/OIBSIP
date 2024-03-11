package srikanth;

import java.util.*;

public class Main {
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Create a new account or use existing one
	        System.out.println("Welcome to the Srikanth ATM system!");
	        System.out.print("Please Enter user ID: ");
	        String userID = scanner.nextLine();
	        System.out.print("Please Enter PIN: ");
	        int pin = scanner.nextInt();

	        BankAccount account = new BankAccount(userID, pin);

	        // Menu loop
	        boolean quit = false;
	        while (!quit) {
	            System.out.println("\nMenu:");
	            System.out.println("1. Check transaction history");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Deposit");
	            System.out.println("4. Transfer");
	            System.out.println("5. Check balance");
	            System.out.println("6. Quit");
	            System.out.print("Choose an option: ");
	            int option = scanner.nextInt();

	            switch (option) {
	                case 1:
	                    account.displayTransactionHistory();
	                    break;
	                case 2:
	                    System.out.print("Enter withdrawal amount: $");
	                    double withdrawAmount = scanner.nextDouble();
	                    account.withdraw(withdrawAmount);
	                    break;
	                case 3:
	                    System.out.print("Enter deposit amount: $");
	                    double depositAmount = scanner.nextDouble();
	                    account.deposit(depositAmount);
	                    break;
	                case 4:
	                    System.out.print("Enter recipient's user ID: ");
	                    String recipientID = scanner.next();
	                    System.out.print("Enter transfer amount: $");
	                    double transferAmount = scanner.nextDouble();
	                    // Here you would search for the recipient's account based on the ID,
	                    // but for simplicity, let's assume it's the same account
	                    account.transfer(account, transferAmount);
	                    break;
	                case 5:
	                    System.out.println("Current balance: $" + account.getBalance());
	                    break;
	                case 6:
	                    quit = true;
	                    System.out.println("Thank you for using the banking system!");
	                    break;
	                default:
	                    System.out.println("Invalid option. Please choose again.");
	                    break;
	            }
	        }

	        scanner.close();
	    }

}

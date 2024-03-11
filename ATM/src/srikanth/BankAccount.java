package srikanth;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class BankAccount {

	
	
	private String userID;
    private int pin;
    private double balance;
    private HashMap<Integer, Transaction> transactionHistory;

    public BankAccount(String userID, int pin) {
        this.userID = userID;
        this.pin = pin;
        this.balance = 0;
        this.transactionHistory = new HashMap<>();
    }

    public String getUserID() {
        return userID;
    }

    public boolean verifyPin(int pin) {
        return this.pin == pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            Transaction transaction = new Transaction("Deposit", "Self", amount);
            transactionHistory.put(transactionHistory.size() + 1, transaction);
            System.out.println("Deposit of " + amount + " successful.");
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            Transaction transaction = new Transaction("Withdraw", "Self", amount);
            transactionHistory.put(transactionHistory.size() + 1, transaction);
            System.out.println("Withdrawal of " + amount + " successful.");
        } else {
            System.out.println("Insufficient funds or invalid amount for withdrawal.");
        }
    }

    public void transfer(BankAccount recipient, double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            recipient.deposit(amount);
            Transaction transaction = new Transaction("Transfer", recipient.getUserID(), amount);
            System.out.println("Transfer of " + amount + " to " + recipient.getUserID() + " successful.");
        } else {
            System.out.println("Insufficient funds or invalid amount for transfer.");
        }
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (int i = 1; i <= transactionHistory.size(); i++) {
            Transaction transaction = transactionHistory.get(i);
            String type = transaction.getType();
            String accountInvolved = transaction.getAccountInvolved();
            double amount = transaction.getAmount();
            LocalDateTime timestamp = transaction.getTimestamp();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedTimestamp = timestamp.format(formatter);

            System.out.println("Type: " + type + ", Account Involved: " + accountInvolved +
                    ", Amount: " + Math.abs(amount) + ", Timestamp: " + formattedTimestamp);
        }
    }

}

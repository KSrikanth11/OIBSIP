package srikanth;

import java.time.LocalDateTime;

public class Transaction {

	
	 private String type;
	    private String accountInvolved;
	    private double amount;
	    private LocalDateTime timestamp;

	    public Transaction(String type, String accountInvolved, double amount) {
	        this.type = type;
	        this.accountInvolved = accountInvolved;
	        this.amount = amount;
	        this.timestamp = LocalDateTime.now();
	    }

	   

		public String getType() {
	        return type;
	    }

	    public String getAccountInvolved() {
	        return accountInvolved;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public LocalDateTime getTimestamp() {
	        return timestamp;
	    }
	

}

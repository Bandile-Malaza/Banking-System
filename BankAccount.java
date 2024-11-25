/**
 * @author MALAZA BA
 * @version Banking System
 */
package BankAccount;

/**
 * This class is going to contain all the bank account details
 */
public class BankAccount {

	//Declare all my variable first.
	private String accountNumber;
	private String ownername;
    private static double balance;
	
	/**
	 * This is the constructor for my bankAcoount class
	 * @param initialBalance - Initial Balance on your bank account
	 * @param accountNum - account number
	 */

    public BankAccount(String accountNumber,String ownername, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownername = ownername;
        this.balance = initialBalance;
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter for balance
    public static double getBalance() {
        return balance;
    }
    
    public String getOwnerName()
    {
    	return ownername;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public static boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
		return false;
    }
    
    public static boolean transferTo(String recipientAccount, double amount) {
        try {
			try {
				if (amount <= balance && !recipientAccount.isEmpty()) {
				    balance -= amount;
				    // Logic to add to recipient's account can be implemented here
				    return true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return false;
    }
   

    // Method to display balance
    public void displayBalance() {
        System.out.println("Current balance: $" + balance);
    }
}


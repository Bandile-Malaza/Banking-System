/**
 * @author MALAZA BA
 * @version Banking System
 */
package Customer;

import BankAccount.BankAccount;

/*
 * This class is going to contain all the customer details
 */
public class Customer {
	
	//Declaring all my variabless
    private String name;
    private BankAccount account;

    /**
     * 
     * @param name - the name of the customer
     * @param accountNumber - the account number of the customer
     * @param initialBalance - the balance available
     */
    public Customer(String name, String accountNumber, double initialBalance) {
        this.name = name;
        this.account = new BankAccount(accountNumber, accountNumber, initialBalance);
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for account
    public BankAccount getAccount() {
        return account;
    }
}


/**
 * This class provides the attributes and methods for the individual accounts.
 */

public class Account {
    /**
     * These are the fields used in the accounts.
     */
    private int accountNumber;
    private String firstName;
    private String lastName;
    private String socSecurity;
    private String pin;
    private double balance;

    /**
     * This constructor initializes the account object of the class
     */
    public Account(String firstName, String lastName, String socSecurity) {
        // Account number will be a uniquely generated 8-digit number that does
        // not start with a zero.
        this.accountNumber = BankUtility.generateRandomInteger(10000000, 90000000);
        this.firstName = firstName;
        this.lastName = lastName;
        this.socSecurity = socSecurity;
        this.pin = String.valueOf(BankUtility.generateRandomInteger(1000, 9999));
        this.balance = 0.00;
    }

    /**
     * No argument constructor
     */
    public Account() {
        new Account(firstName,lastName, socSecurity);
    }

    public void setPin (String pin) {
        this.pin = pin;
    }


    // Getters

    public int getAccountNumber() {
        return accountNumber;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getSocSecurity() {
        return socSecurity.replaceAll(".(?=.{4})", "X");
    }
    public String getPin() {
        return pin;
    }
    public double getBalance() {
        return balance;
    }

    /**
     * This method deposits money into a user's account.
     * @param amount
     * @return
     */
    public long deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount cannot be negative. Try again.");
            return -1;
        }
        this.balance += amount;
        return BankUtility.convertFromDollarsToCents(amount);
    }


    /**
     * This method withdraws money from a user's account.
     * @param amount
     * @return
     */
    public long withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount cannot be negative. Try again.");
            return -1;
        }
        if (amount > this.balance) {
            System.out.println("Insufficient funds. Try again.");
            return -1;
        }
        this.balance -= amount;
        return BankUtility.convertFromDollarsToCents(amount);
    }

    /**
     * This method takes PIN as a parameter and using the .equals() method it compares
     * the PIN between the account and the user input.
     * @param pin
     * @return
     */
    public boolean isValidPIN(String pin) {
        return this.pin.equals(pin);
    }

    /**
     * This method returns a string of the account information.
     * @return
     */
    @Override // all objects have a toString method - this indicates you are providing your own version
    public String toString() {
        return String.format("Account Number: %08d \n " +
                "Owner First Name: %s \n" +
                " Owner Last Name: %s \n " +
                "Owner SSN: %s \n " +
                "PIN: %s \n " +
                "Balance: $%02.2f \n",
               getAccountNumber(),
                getFirstName(),
                getLastName(),
                getSocSecurity(),
                getPin(),
                getBalance());
    }

    public void transfer(Account toAccount, double transferAmount) {
        if (transferAmount > this.balance) {
            System.out.println("Insufficient funds");
        } else {
            System.out.println("$" + transferAmount + " has been transferred from "
                    + this.accountNumber + " to " + toAccount.getAccountNumber() + " and the new balance is: "
                    + (this.balance - transferAmount));
            this.balance -= transferAmount;
            toAccount.balance += transferAmount;
        }
    }

    public void atmWithdraw(double withdrawAmount) {
        // Get 20, 10, 5, 1 dollar bills from the ATM
        if (withdrawAmount > this.balance) {
            System.out.println("Insufficient funds");
        } else {
            // Get 20 dollar bills
            int twentyDollarBills = (int) (withdrawAmount / 20);
            withdrawAmount -= twentyDollarBills * 20;
            System.out.println("Dispensing " + twentyDollarBills + " $20 dollar bills");
            // Get 10 dollar bills
            int tenDollarBills = (int) (withdrawAmount / 10);
            withdrawAmount -= tenDollarBills * 10;
            System.out.println("Dispensing " + tenDollarBills + " $10 dollar bills");
            // Get 5 dollar bills
            int fiveDollarBills = (int) (withdrawAmount / 5);
            withdrawAmount -= fiveDollarBills * 5;
            System.out.println("Dispensing " + fiveDollarBills + " $5 dollar bills");
            // Get 1 dollar bills
            int oneDollarBills = (int) (withdrawAmount / 1);
            withdrawAmount -= oneDollarBills;
            System.out.println("Dispensing " + oneDollarBills + " $1 dollar bills");
        }
    }

}

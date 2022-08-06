/**
 * This class provides the attributes and methods for the individual accounts.
 */

public class Account {

    /**
     * These are the attributes used in the accounts.
     */
    private Account account;
    private int accountNumber;
    private String firstName;
    private String lastName;
    private String socSecurity;
    private String pin;
    private double balance;  // TODO change datatype to long. Make conversions where necessary.



//    Account account = new Account();

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

    // Setters


    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public void setSocSecurity(String socSecurity) {
        this.socSecurity = socSecurity;
    }

    public void setPin (String pin) {
        this.pin = pin;
    }

    public double setBalance (double balance) {
        this.balance = balance;
        return balance;
    }

    // Getters

    /**
     * The getters below each retrieve a different attribute of the account without
     * accessing the object's attributes directly.
     *
     */

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
        double doubBalance = account.getBalance();
        double newBalance = setBalance(doubBalance + amount);
        return (long) newBalance;
    }


    /**
     * This method withdraws money from a user's account.
     * @param amount
     * @return
     */
    public long withdraw(double amount) {
        double newBalance = this.balance - amount;
        return (long) newBalance;
    }

    /**
     * This method takes PIN as a parameter and using the .equals() method it compares
     * the PIN between the account and the user input.
     * @param pin
     * @return
     */
    public boolean isValidPIN(String pin) {
        String accountPin = this.pin;
        if (accountPin.equals(pin)) {
            System.out.println("PIN is valid!");
            return true;
        }
        System.out.println("PIN is invalid!");
        return false;

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
}

import java.util.ArrayList;


/**
 * This class provides the attributes and methods to add,
 * delete and find accounts as well as add monthly interest.
 */

public class Bank {

    private final ArrayList<Account> accounts;

    /**
     * This constructor initializes the objects of the class.
     */
    public Bank() {
        this.accounts = new ArrayList<Account>();
    }

    /**
     * Getters
     */

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    /**
     * This method iterates through the array of objects and adds an account
     * if space is available.
     *
     * @param account
     * @return
     */
    public boolean addAccountToBank(Account account) {
        if (findAccount(account.getAccountNumber()) >= 0) {
            System.out.println("Account is already on file");
            return false;
        }
        this.accounts.add(account);
        return true;
    }

    /**
     * This method iterates through each account in the accounts array and deletes it at its index.
     *
     * @param account
     * @return
     */
    public boolean removeAccountFromBank(Account account) {
        int foundPosition = findAccount(account.getAccountNumber());
        if (foundPosition < 0) {
            System.out.println(account.getAccountNumber() + ", was not found");
            return false;
        }
        this.accounts.remove(account);
        return true;
    }

    /**
     * This method takes an enhanced for loop to iterate through each account
     * to see if the value of getAccountNumber is the same as account number.
     *
     * @param accountNumber
     * @return The Account object
     */
    public int findAccount(int accountNumber) {
        // Find the account index of accountNumber
        for (int i = 0; i < this.accounts.size(); i++) {
            Account account = this.accounts.get(i);
            if (account.getAccountNumber() == accountNumber) {
                return i;
            }
        }
        System.out.println("Account not found");
        return -1;
    }

    /**
     * This method takes a percentage and adds that as monthly interest to all accounts.
     *
     * @param percent
     */
    public void addMonthlyInterest(double percent) {
        // Calculate the percentage
        double percentage = percent / 100;
        for (int i = 0; i < this.accounts.size(); i++) {
            Account account = this.accounts.get(i);
            double balance = account.getBalance();
            double interest = balance * percentage;
            account.deposit(balance + interest);
        }
    }
}

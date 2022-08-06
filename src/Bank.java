import java.util.Objects;


/**
 * This class provides the attributes and methods to add,
 * delete and find accounts as well as add monthly interest.
 *
 */

public class Bank {

    private final Account[] bankAccounts = new Account[MAX_ACCOUNTS];

    private static final int MAX_ACCOUNTS = 100;
//    private static Account[] bankAccounts = new Account[MAX_ACCOUNTS];



    /**
     * This constructor initializes the objects of the class.
     */
    public Bank() {
        System.out.println("Constructor Called");

    }

    /**
     * Setters
     *
     */

    public void setBankAccounts(Account[] bankAccounts) {

    }

    /**
     * Getters
     *
     */

    public Account[] getBankAccounts() {
        return bankAccounts;
    }

    /**
     * This method iterates through the array of objects and adds an account
     * if space is available.
     * @param account
     * @return
     */
    public boolean addAccountToBank(Account account) {
        if (account == null) {
            return false;
        }
        for (int i = 0; i < MAX_ACCOUNTS; i++) {
            if (bankAccounts[i] == null) {
                bankAccounts[i] = account;

                System.out.println("Account successfully added to bank at index: " + i);
                return true;
            }
        }
        return false;
    }

    /**
     * This method iterates through each account in the accounts array and deletes it at its index.
     * @param account
     * @return
     */
    public boolean removeAccountFromBank(Account account) {
        if (account == null) {
            return false;
        }
        for (int i = 0; i < MAX_ACCOUNTS; i++) {
            if (bankAccounts[i] == account) {
                bankAccounts[i] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * This method takes an enhanced for loop to iterate through each account
     * to see if the value of getAccountNumber is the same as account number.
     *
     * @param accountNumber
     * @return The Account object
     */
    public Account findAccount(int accountNumber) {
        for (int i = 0; i < MAX_ACCOUNTS; i++) {
            int numInBank = bankAccounts[i].getAccountNumber();
            if (bankAccounts[i] != null && Objects.equals(numInBank, accountNumber)) {
                return bankAccounts[i];
            }
        }
        System.out.println("findAccount method didn't find any account");
        return null;
    }

    /**
     * This method takes a percentage and adds that as monthly interest to all accounts.
     * @param percent
     */
    public void addMonthlyInterest(double percent) {
        Account account = new Account();
        double monthlyInterest = (account.getBalance() * percent) / 12;
        double interestBalance = account.setBalance(account.getBalance() + monthlyInterest);

        System.out.println("Deposited Interest: " + monthlyInterest + " into account number: "
                + account.getAccountNumber() +", new balance: " + interestBalance);
    }

    /**
     * This method is just for debugging purposes only to make sure
     * that the array of accounts is populated.
     */
    public void listAccounts() {
        int counter = 1;
        for (int i = 0; i < MAX_ACCOUNTS; i++) {
                System.out.println("" + counter + ". " + bankAccounts[i]);
                counter++;
        }
    }

}

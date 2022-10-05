import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

/**
 * This class is where the Main method will be implemented from. This class will
 * create an instance of a Bank object when the program runs and use that instance to
 * manage the Accounts in the bank.
 * @mfesta
 */

public class BankManager {
    static Bank myBank = new Bank();
    static Scanner scanner = new Scanner(System.in);

    /**
     * This method displays the main menu to the user.
     */
    public static void mainMenu() {
        System.out.println("============================================================");
        System.out.println("What do you want to do?");
        System.out.println("1. Open an account");
        System.out.println("2. Get account information and balance");
        System.out.println("3. Change PIN");
        System.out.println("4. Deposit money in account");
        System.out.println("5. Transfer money between accounts");
        System.out.println("6. Withdraw money from account");
        System.out.println("7. ATM withdrawal");
        System.out.println("8. Deposit change");
        System.out.println("9. Close an account");
        System.out.println("10. Add monthly interest to all accounts");
        System.out.println("11. End Program");
        System.out.println("============================================================");
    }


    /**
     * This method prompts the user for the account number and pin of an existing account.
     * @param bank
     * @return
     */
    public static Account promptForAccountNumberAndPIN(Bank bank) {
        // Prompt for account number
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        // Find account in bank:
        int accountIndex = bank.findAccount(accountNumber);
        if (accountIndex < 0) {
            System.out.println("Account not found");
            return null;
        }
        Account account = bank.getAccounts().get(accountIndex);
        // Prompt for PIN
        System.out.println("Enter PIN: ");
        String pin = scanner.nextLine();
        // Check PIN
        if (!account.isValidPIN(pin)) {
            System.out.println("Incorrect PIN");
            return null;
        } else {
            return account;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        int choice;

        // Loop through main menu options.
        do {
            mainMenu();
            String userSelectionString = BankUtility.promptUserForString("What do you want to do?");
            choice = parseInt(userSelectionString);
            if (choice < 1 || choice > 11) {
                System.out.println("Invalid Choice");
            }
            switch (choice) {
                case 1:
                    // Get user input to open a new account
                    String firstName = BankUtility.promptUserForString("Enter your first name: ");
                    String lastName = BankUtility.promptUserForString("Enter your last name: ");
                    String socSecurity = BankUtility.promptUserForString("Enter your social security number: ");

                    // Create a new account:
                    Account newAccount = new Account(firstName, lastName, socSecurity);
                    // Add account to bank:
                    myBank.addAccountToBank(newAccount);
                    // Display account information using toString:
                    System.out.println(newAccount.toString());
                    break;
                case 2:
                    // Get account information and balance
                    Account account = promptForAccountNumberAndPIN(myBank);
                    if (account != null) {
                        System.out.println(account.toString());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    // Set new pin:
                    account = promptForAccountNumberAndPIN(myBank);
                    if (account != null) {
                        String newPin = BankUtility.promptUserForString("Enter new PIN: ");
                        account.setPin(newPin);
                        System.out.println("PIN changed successfully.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    // Deposit money in account
                    account = promptForAccountNumberAndPIN(myBank);
                    if (account != null) {
                        String depositAmountString = BankUtility.promptUserForString("Enter amount to deposit: ");
                        double depositAmount = Double.parseDouble(depositAmountString);
                        account.deposit(depositAmount);
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    // Transfer money between accounts:
                    // From account:
                    Account fromAccount = promptForAccountNumberAndPIN(myBank);
                    if (fromAccount != null) {
                        // To account:
                        Account toAccount = promptForAccountNumberAndPIN(myBank);
                        if (toAccount != null) {
                            String transferAmountString = BankUtility.promptUserForString("Enter amount to transfer: ");
                            double transferAmount = Double.parseDouble(transferAmountString);
                            fromAccount.transfer(toAccount, transferAmount);
                            System.out.println("Transfer successful.");
                        } else {
                            System.out.println("Transfer to account not found.");
                        }
                    } else {
                        System.out.println("Transfer from account not found.");
                    }
                    break;
                case 6:
                    // Withdraw funds:
                    account = promptForAccountNumberAndPIN(myBank);
                    if (account != null) {
                        String withdrawAmountString = BankUtility.promptUserForString("Enter amount to withdraw: ");
                        double withdrawAmount = Double.parseDouble(withdrawAmountString);
                        account.withdraw(withdrawAmount);
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 7:
                    // ATM withdrawal:
                    account = promptForAccountNumberAndPIN(myBank);
                    if (account != null) {
                        String withdrawAmountString = BankUtility.promptUserForString("Enter amount to withdraw: ");
                        double withdrawAmount = Double.parseDouble(withdrawAmountString);
                        account.atmWithdraw(withdrawAmount); // TOOD: Create atmWithdraw method in Account class.
                        System.out.println("ATM withdrawal successful.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 8:
                    // Deposit change:
                    account = promptForAccountNumberAndPIN(myBank);
                    if (account != null) {
                        String depositAmountString = BankUtility.promptUserForString("Enter amount to deposit: ");
                        // parse change from bank utility:
                        long change = CoinCollector.parseChange(depositAmountString); // TODO: Correct this method.
                        account.deposit(change);
                        System.out.println("Deposit change successful.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 9:
                    // Close account:
                    account = promptForAccountNumberAndPIN(myBank);
                    if (account != null) {
                        myBank.removeAccountFromBank(account);
                        System.out.println("Account closed successfully.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 10:
                    // Get interest rate:
                    String interestRateString = BankUtility.promptUserForString("Enter interest rate: ");
                    double interestRate = Double.parseDouble(interestRateString);
                    // Add interest to all accounts:
                    myBank.addMonthlyInterest(interestRate);
                    break;
                case 11:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        } while (choice != 11);
    }
}

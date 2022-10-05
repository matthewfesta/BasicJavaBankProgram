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
    static Bank myBank = new Bank(Bank);
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
        Account[] bankAccounts = new Account[MAX_ACCOUNTS];
        bank.setBankAccounts(bankAccounts);
        // implement promptForAccountNumberAndPIN here

        // Get the account.
        bank.getBankAccounts();
        int userAccountNumber;
        userAccountNumber = Integer.parseInt(BankUtility.promptUserForString("Enter account number: "));
        Account accountFound = bank.findAccount(userAccountNumber);
        accountFound.getPin();
        String userPin;
        String accountPin = accountFound.getPin();

        userPin = BankUtility.promptUserForString("Enter PIN: ");
        if (accountFound.isValidPIN(userPin)) {
            return accountFound;
        }
        return null;
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

                    break;
                case 2:
                    deleteAccount();
                    break;
                case 3:
                    findAccount();
                    break;
                case 4:
                    deposit();
                    break;
                case 5:
                    withdraw();
                    break;
                case 6:
                    addInterest();
                    break;
                case 7:
                    printAllAccounts();
                    break;
                case 8:
                    printAccount();
                    break;
                case 9:
                    printAccountsWithInterest();
                    break;
                case 10:
                    printAccountsWithInterest();
                    break;
                case 11:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;

            }
            // Open account menu
            if (userSelection == 1) {
                String userFirstName;
                String userLastName;
                String ssnRegex = "[0-9]{3}[0-9]{2}[0-9]{4}";
                String userSSN;

                do {
                    userFirstName = BankUtility.promptUserForString("Enter Account Owner's First Name: ");
                } while (userFirstName == null);

                do {
                    userLastName = BankUtility.promptUserForString("Enter Account Owner's Last Name: ");
                } while (userLastName == null);

                do {
                    userSSN = BankUtility.promptUserForString("Enter Account Owner's SSN (9 digits):");
                } while (!Pattern.matches(ssnRegex, userSSN));


                Account openAccount = new Account(userFirstName, userLastName, userSSN);

                System.out.println(openAccount);
                myBank.getBankAccounts();
                myBank.addAccountToBank(openAccount);

                String accountString = openAccount.toString();
                System.out.println("============================================================");
                System.out.println(accountString);
                System.out.println("============================================================");

            }

            // View account menu
            if (userSelection == 2) {
                myBank.getBankAccounts();
                Account existingAccount = promptForAccountNumberAndPIN(myBank);

                String accountString = null;
                if (existingAccount != null) {
                    accountString = existingAccount.toString();
                }
                System.out.println("============================================================");
                System.out.println(accountString);
                System.out.println("============================================================");
            }

            // Set new PIN menu
            if (userSelection == 3) {
                String newPIN;
                String newPINConfirm;
                String pinRegex = "\\d\\d\\d\\d";

                myBank.getBankAccounts();
                Account existingAccount = promptForAccountNumberAndPIN(myBank);

                do {
                    System.out.println("Enter new PIN");
                    newPIN = scanner.nextLine();
                } while (!Pattern.matches(pinRegex, newPIN));

                do {
                System.out.println("Enter new PIN again");
                    newPINConfirm = scanner.nextLine();
                } while (!newPIN.equals(newPINConfirm));

                if (newPIN.equals(newPINConfirm)) {
                    existingAccount.setPin(newPINConfirm);
                    System.out.println("PIN updated");
                } else {
                    System.out.println("PINs do not match.");
                }
            }

            // Deposit money menu
            if (userSelection == 4) {
                long amount;
                double number;
                // Deposit money
                myBank.getBankAccounts();
                Account existingAccount = promptForAccountNumberAndPIN(myBank);
                do {
                    System.out.println("Enter amount to deposit in dollars and cents (e.g. 2.57)");
                    number = scanner.nextDouble();
                } while (number <= 0);

                if (number <= 0) {
                    System.out.println("Amount cannot be negative. Try again.");
                }
                double newBalance = existingAccount.deposit(number);
                System.out.println("New balance: "+ newBalance);
            }


            // Transfer funds menu
            if (userSelection == 5) {
                myBank.getBankAccounts();

                // Get the transfer FROM account
                System.out.println("Account to Transfer From: ");
                Account fromAccount = promptForAccountNumberAndPIN(myBank);

                // Get the transfer TO account
                System.out.println("Account to Transfer To ");
                Account toAccount = promptForAccountNumberAndPIN(myBank);

                // Transfer amount
                double transferAmount;
                do {
                    System.out.println("Enter amount to transfer in dollars and cents (e.g. 2.57): ");
                    transferAmount = scanner.nextDouble();
                } while (transferAmount > fromAccount.getBalance());

                if (transferAmount > fromAccount.getBalance()) {
                    System.out.println("Insufficient funds in account" + fromAccount.getAccountNumber());
                }

                double fromBalance = fromAccount.setBalance(fromAccount.getBalance() - transferAmount);
                double toBalance = toAccount.setBalance(toAccount.getBalance() + transferAmount);
                System.out.println("Transfer complete");
                System.out.println("New balance in " + fromAccount.getAccountNumber() + ":" + fromBalance);
                System.out.println("New balance in " + toAccount.getAccountNumber() + ":"  + toBalance);

            }

            // Withdraw funds menu
            if (userSelection == 6) {
                long amount;
                double number;
                myBank.getBankAccounts();
                Account existingAccount = promptForAccountNumberAndPIN(myBank);

                do {
                    System.out.println("Enter a number: ");
                    number = scanner.nextDouble();
                } while (number <= 0 || number > existingAccount.getBalance() );

                if (number <= 0) {
                    System.out.println("Account cannot be negative. Try again.");
                }
                if (number > existingAccount.getBalance()) {
                    System.out.println("Insufficient funds in account" + existingAccount.getAccountNumber());
                }
                double newBalance = existingAccount.withdraw(number);
                System.out.println("New Balance: "+ newBalance);
            }

            // ATM withdraw menu
            if (userSelection == 7) {
                myBank.getBankAccounts();
                Account existingAccount = promptForAccountNumberAndPIN(myBank);
                // Withdraw with the ATM
                int atmWithdrawAmount;
                do {
                    System.out.println("Enter amount to withdraw in dollars (no cents) in multiples of $5 (limit $1000):");
                    atmWithdrawAmount = scanner.nextInt();
                } while (atmWithdrawAmount <= 0 || atmWithdrawAmount > existingAccount.getBalance() || atmWithdrawAmount > 1000);

                if (atmWithdrawAmount <= 0) {
                    System.out.println("Account cannot be negative. Try again.");
                }

                if (atmWithdrawAmount > existingAccount.getBalance()) {
                    System.out.println("Insufficient funds in account" + existingAccount.getAccountNumber());
                }

                existingAccount.withdraw(atmWithdrawAmount);
                double newBalance = existingAccount.getBalance() - atmWithdrawAmount;
                // Calculate and display the amount of each bill.
                int numTwenties = atmWithdrawAmount / 20;
                int numTens = (atmWithdrawAmount % 20) / 10;
                int numFives = (atmWithdrawAmount % 10) / 5;
                System.out.println("Number of 20-dollar bills:" + numTwenties);
                System.out.println("Number of 10-dollar bills:" + numTens);
                System.out.println("Number of 5-dollar bills:" + numFives);

                System.out.println("New balance: " + newBalance);
            }

            // Coin deposit menu
            if (userSelection == 8) {
               myBank.getBankAccounts();
               String coinsToDeposit;
               Account existingAccount = promptForAccountNumberAndPIN(myBank);
               coinsToDeposit = BankUtility.promptUserForString("Deposit Coins: ");

               // Deposit change
                long depositCoins = CoinCollector.parseChange(coinsToDeposit);

                existingAccount.setBalance(existingAccount.getBalance() + depositCoins);

                System.out.println(depositCoins + " Deposited into account");
                System.out.println("New balance: " + existingAccount.getBalance());
            }

            // Close account menu
            if (userSelection == 9) {
                Account existingAccount = promptForAccountNumberAndPIN(myBank);

                System.out.println("Account " + account.getAccountNumber() + " closed");

                existingAccount.setFirstName(null);
                existingAccount.setLastName(null);
                existingAccount.setSocSecurity(null);
                existingAccount.setPin(null);
                existingAccount.setBalance(0.00);

                myBank.removeAccountFromBank(existingAccount);
            }

            // Add interest menu
            if (userSelection == 10) {
                myBank.getBankAccounts();
                int counter = 1;
                double percentage;

                System.out.println("Enter annual interest rate percentage (e.g. 2.75 for 2.75%):");
                percentage = scanner.nextDouble();
                for (int i = 0; i < MAX_ACCOUNTS; i++) {
                    if (myBank.getBankAccounts()[i] != null) {
                        myBank.addMonthlyInterest(percentage);
                        counter++;
                    }
                }
            }

            // End program menu
            if (userSelection == 11) {
                System.out.println("End program");
                return;
            }

        } while (true);


    }

}

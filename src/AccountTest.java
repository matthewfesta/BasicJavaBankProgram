import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


class AccountTest {

    @Test
    void deposit() {
        Bank bank = new Bank();
        bank.getBankAccounts();
        Account account = new Account();
        account.setAccountNumber(12345678);
        account.setFirstName("Foo");
        account.setLastName("Bar");
        account.setSocSecurity("123456789");
        account.setPin(String.valueOf(1234));
        account.setBalance(100.00);

        bank.addAccountToBank(account);

        double amount = 50.00;
        double doubBalance = account.getBalance();
        double newBalance = account.setBalance(doubBalance + amount);

        double expectedResult = 150.00;
        double result = newBalance;
        assertEquals(expectedResult, result);

    }

    @Test
    void depositNegative() {
        Account account = new Account();
        account.setAccountNumber(12345678);
        account.setFirstName("Foo");
        account.setLastName("Bar");
        account.setSocSecurity("123456789");
        account.setPin(String.valueOf(1234));
        account.setBalance(50.00);
        Bank bank = new Bank();
        bank.addAccountToBank(account);

        double amount = 100.00;
        double doubBalance = account.getBalance();
        double newBalance = account.setBalance(doubBalance - amount);

        String expectedResult = "Amount cannot be negative. Try again.";
        double result = newBalance;
        assertEquals(expectedResult, result);

    }

    @Test
    void withdraw() {
        Account account = new Account();
        account.setAccountNumber(12345678);
        account.setFirstName("Foo");
        account.setLastName("Bar");
        account.setSocSecurity("123456789");
        account.setPin(String.valueOf(1234));
        account.setBalance(100.00);
        Bank bank = new Bank();
        bank.addAccountToBank(account);

        double amount = 75.00;
        double doubBalance = account.getBalance();
        double newBalance = account.setBalance(doubBalance - amount);

        double expectedResult = 25.00;
        double result = newBalance;
        assertEquals(expectedResult, result);
    }

    void withdrawInsufficientFunds() {
        Account account = new Account();
        account.setAccountNumber(12345678);
        account.setFirstName("Foo");
        account.setLastName("Bar");
        account.setSocSecurity("123456789");
        account.setPin(String.valueOf(1234));
        account.setBalance(100.00);
        Bank bank = new Bank();
        bank.addAccountToBank(account);

        double amount = 200.00;
        double doubBalance = account.getBalance();
        double newBalance = account.setBalance(doubBalance - amount);

        String expectedResult = "Insufficient funds in account" + account.getAccountNumber();
        double result = newBalance;
        assertEquals(expectedResult, result);
    }

    @Test
    void isValidPIN() {
        Account account = new Account();
        account.setAccountNumber(12345678);
        account.setFirstName("Foo");
        account.setLastName("Bar");
        account.setSocSecurity("123456789");
        account.setPin(String.valueOf(1234));
        account.setBalance(100.00);
        Bank bank = new Bank();
        Account[] bankAccounts = new Account[1];
        bank.setBankAccounts(bankAccounts);
        bank.addAccountToBank(account);

        String pinString = "1234";
        boolean expectedResult = true;
        boolean result = account.isValidPIN(pinString);
        assertEquals(expectedResult, result);
    }

    @Test
    void isInvalidPIN() {
        Account account = new Account();
        account.setAccountNumber(12345678);
        account.setFirstName("Foo");
        account.setLastName("Bar");
        account.setSocSecurity("123456789");
        account.setPin(String.valueOf(1234));
        account.setBalance(100.00);
        Bank bank = new Bank();
        bank.addAccountToBank(account);

        String pinString = "4321";
        boolean expectedResult = false;
        boolean result = account.isValidPIN(pinString);
        assertEquals(expectedResult, result);
    }

}
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


class BankTest {

    @Test
    void addAccountToBank() {
        System.out.println("addAccountToBank");
        Account account = new Account();
        account.setAccountNumber(BankUtility.generateRandomInteger(10000000, 90000000));
        account.setFirstName("Foo");
        account.setLastName("Bar");
        account.setSocSecurity("123456789");
        account.setPin(String.valueOf(BankUtility.generateRandomInteger(1000, 9999)));
        Bank bank = new Bank(bankAccounts);
        Account[] bankAccounts = new Account[1];
        bank.setBankAccounts(bankAccounts);
        boolean expResult = true;
        boolean result = bank.addAccountToBank(account);
        assertEquals(expResult, result);
    }

    @Test
    void addNullAccountToBank() {
        System.out.println("addAccountToBank");
        Account account = null;
        Bank bank = new Bank(bankAccounts);
        boolean expResult = false;
        boolean result = bank.addAccountToBank(account);
        assertEquals(expResult, result);
    }

    @Test
    void removeAccountFromBank() {

        System.out.println("removeFromBank");
        Account account = new Account();
        account.setAccountNumber(12345678);
        account.setFirstName("Foo");
        account.setLastName("Bar");
        account.setSocSecurity("123456789");
        account.setPin(String.valueOf(1234));
        Bank bank = new Bank(bankAccounts);
        bank.addAccountToBank(account);

        boolean expResult = true;
        boolean result = bank.removeAccountFromBank(account);
        assertEquals(expResult, result);
    }

    void removeNullAccountFromBank() {
        System.out.println("removeFromBank");
        Account account = null;
        Bank bank = new Bank(bankAccounts);

        boolean expResult = false;
        boolean result = bank.removeAccountFromBank(account);
        assertEquals(expResult, result);
    }

    @Test
    void findExistingAccount() {
        System.out.println("findAccount");
        Account account = new Account();
        account.setAccountNumber(12345678);
        account.setFirstName("Foo");
        account.setLastName("Bar");
        account.setSocSecurity("123-45-6789");
        account.setPin(String.valueOf(1234));
        Bank bank = new Bank(bankAccounts);
        bank.addAccountToBank(account);

        int accountNumber = 12345678;
        Account result = bank.findAccount(accountNumber);
        assertEquals(12345678, result.getAccountNumber());
    }

    @Test
    void findNonExistingAccount() {
        System.out.println("findAccount");

        Account account = new Account();
        account.setAccountNumber(12345678);
        account.setFirstName("Foo");
        account.setLastName("Bar");
        account.setSocSecurity("123456789");
        account.setPin(String.valueOf(1234));
        account.setBalance(100.00);
        Bank bank = new Bank(bankAccounts);
        Account[] bankAccounts = new Account[1];
        bank.setBankAccounts(bankAccounts);
        bank.addAccountToBank(account);

        int accountNumber = 87654321;
        Account result = bank.findAccount(accountNumber);
        assertEquals(null, result);
    }

    @Test
    void addMonthlyInterest() {
        System.out.println("addMonthlyInterest");

        Account account = new Account();
        account.setAccountNumber(12345678);
        account.setFirstName("Foo");
        account.setLastName("Bar");
        account.setSocSecurity("123456789");
        account.setPin(String.valueOf(1234));
        account.setBalance(500.00);
        Bank bank = new Bank(bankAccounts);
        bank.addAccountToBank(account);

        double percentage = 1.25;
        double monthlyInterest = (account.getBalance() * percentage) / 12;

        double expectedResult = 500.52;
        double result = account.setBalance(account.getBalance() + monthlyInterest);
        assertEquals(expectedResult, result);
    }

    void addMonthlyInterestAgain() {
        System.out.println("addMonthlyInterest");

        Account account = new Account();
        account.setAccountNumber(12345678);
        account.setFirstName("Foo");
        account.setLastName("Bar");
        account.setSocSecurity("123456789");
        account.setPin(String.valueOf(1234));
        account.setBalance(2000.00);
        Bank bank = new Bank(bankAccounts);
        bank.addAccountToBank(account);

        double percentage = 1.25;
        double monthlyInterest = (account.getBalance() * percentage) / 12;

        double expectedResult = 2502.60;
        double result = account.setBalance(account.getBalance() + monthlyInterest);
        assertEquals(expectedResult, result);
    }
}
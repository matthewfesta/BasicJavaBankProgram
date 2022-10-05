import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


class BankTest {

    Bank bank = new Bank();
    @Test
    void addAccountToBank() {
        Account account = new Account();
        boolean expResult = true;
        boolean result = bank.addAccountToBank(account);
        assertEquals(expResult, result);
    }


    @Test
    void removeAccountFromBank() {
        Account account = new Account();
        bank.addAccountToBank(account);
        boolean expResult = true;
        boolean result = bank.removeAccountFromBank(account);
        assertEquals(expResult, result);
    }


    @Test
    void addMonthlyInterest() {
        System.out.println("addMonthlyInterest");
        Account account = new Account();
        account.deposit(500);
        bank.addAccountToBank(account);
        bank.addMonthlyInterest(1.25);
    }

}
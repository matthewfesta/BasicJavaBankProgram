import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account testAccount = new Account("John", "Smith",
            "045323232");

    @org.junit.jupiter.api.Test
    void deposit() {
        long testDeposit = testAccount.deposit(500);
        long actualDeposit = 500;
        assertEquals(testDeposit, actualDeposit);
    }

    @org.junit.jupiter.api.Test
    void withdraw() {
        testAccount.deposit(500);
        long testWithdraw = testAccount.withdraw(200);
        long actualWithdraw = 300;
        assertEquals(testWithdraw, actualWithdraw);
    }

    @org.junit.jupiter.api.Test
    void isValidPIN() {
       String testPin = testAccount.getPin();
       System.out.println(testPin);
       boolean expectedResult = testAccount.isValidPIN(testPin);
       boolean actualResult = true;
       assertEquals(expectedResult, actualResult);


    }
}
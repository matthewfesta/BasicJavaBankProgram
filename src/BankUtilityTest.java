
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

class BankUtilityTest {


    @Test
    void convertFromDollarsToCents() {
    }

    @Test
    void isNumeric() {
        String num = "123456789";
        boolean expectedResult = true;
        boolean result = BankUtility.isNumeric(num);
        assertEquals(expectedResult, result);
    }

    @Test
    void isNotNumeric() {
        String notNum = "Hello World";
        boolean expectedResult = false;
        boolean result = BankUtility.isNumeric(notNum);
        assertEquals(expectedResult, result);
    }
}
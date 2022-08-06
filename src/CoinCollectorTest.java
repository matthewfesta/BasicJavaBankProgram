
import static org.junit.jupiter.api.Assertions.*;

class CoinCollectorTest {

    @org.junit.jupiter.api.Test
    void parseChangeOne() {
        String coins = "PPP";
        long expectedResult = 3;
        long result = CoinCollector.parseChange(coins);
        assertEquals(expectedResult, result);

    }

    @org.junit.jupiter.api.Test
    void parseChangeTwo() {
        String coins = "QQQNDDPPPPP";
        long expectedResult = 100;
        long result = CoinCollector.parseChange(coins);
        assertEquals(expectedResult, result);
    }

    @org.junit.jupiter.api.Test
    void parseChangeThree() {
        String coins = "PX";
        long expectedResult = 1;
        long result = CoinCollector.parseChange(coins);
        assertEquals(expectedResult, result);
    }
}
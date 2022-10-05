/**
 * This class deposits strings as coins with certain values into the account.
 *
 */


public final class CoinCollector {

    // private constructor so you cannot instantiate this class
    private CoinCollector() {
        
    }

    /**
     * This method takes the coin string, assess the value and adds the total.
     * @param coins
     * @return
     */
    public static long parseChange(String coins) {
        int countCoins = 0;
        // split the string into an array
        String[] coinArray = coins.split("");
        // iterate through the array
        for (String coin : coinArray) {
            // if the coin is a penny
            if (coin.equals("P")) {
                countCoins += 1;
            }
            // if the coin is a nickel
            if (coin.equals("N")) {
                countCoins += 5;
            }
            // if the coin is a dime
            if (coin.equals("D")) {
                countCoins += 10;
            }
            // if the coin is a quarter
            if (coin.equals("Q")) {
                countCoins += 25;
            }
        }
        return countCoins;
    }    
    
}

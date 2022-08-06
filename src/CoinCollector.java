/**
 * This class deposits strings as coins with certain values into the account.
 *
 *  Author: Matthew Festa
 *  festam@merrimack.edu
 *  CSC 6001 - Foundations of Programming 1
 *  Programming Final Project (Module 8 Assignment 1)
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
        char[] coinArray = coins.toCharArray();
        for (int i = 0; i < coinArray.length; i++) {
            if (coinArray[i] == 'P') {
                countCoins++;
            } else if (coinArray[i] == 'N') {
                countCoins += 5;
            } else if (coinArray[i] == 'D') {
                countCoins += 10;
            } else if (coinArray[i] == 'Q') {
                countCoins += 25;
            } else if (coinArray[i] == 'H') {
                countCoins += 50;
            } else if (coinArray[i] == 'W') {
                countCoins += 100;
            } else {
                System.out.println("Invalid Coin: " + coinArray[i]);
            }
        }

        return countCoins;
    }    
    
}

import java.util.Scanner;

/**
 *  Author: Matthew Festa
 *  festam@merrimack.edu
 *  CSC 6001 - Foundations of Programming 1
 *  Programming Final Project (Module 8 Assignment 1)
 */

public final class BankUtility {
    
    private BankUtility() {
        
    }

    static String promptUserForString(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        return inputString;
    }

    static double promptUserForPositiveNumber(String prompt) {
        Scanner scanner;
        scanner = new Scanner(System.in);
        double userNumber;
        do {
            scanner = new Scanner(System.in);
            System.out.println("Enter a number: ");
            userNumber = scanner.nextDouble();
        } while (userNumber <= 0);

        if (userNumber <= 0) {
            System.out.println("Amount cannot be negative. Try again.");
        }
        return userNumber;
    }

    /**
     * This method generates a random integer with a min and a max
     * @param min
     * @param max
     * @return
     */
    static int generateRandomInteger(int min, int max) {
        // implement generateRandomInteger here
        int randomInt = (int)Math.floor(Math.random()*(max-min+1)+min);
        return randomInt;
    }     


    static long convertFromDollarsToCents(double amount) {        
        return (long) (amount * 100);
    }     

    static boolean isNumeric(String numberToCheck) {        
        if (numberToCheck == null) {
            return false;
        }
        try {
            Long.parseLong(numberToCheck);
            return true; // if we reach this line, then no exception thrown so must be a number
        } catch (NumberFormatException nfe) {
            System.out.println(numberToCheck + " is not a number.");
            return false; // the number could not be parsed
        }        
    }       
}

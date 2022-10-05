

This program will contain five classes.

**BankManager**
The class that will contain the MAIN PROGRAM is called BankManager.
- The MAIN METHOD will display the menu and continuously loop until the user enters 11 to exit the
program. If the user enters 1-10, the program should call a method that implements the
fucntioanlity of that transaction.
The other method in the BankManager class is called:
- promptForAccountNumberAndPIN which takes one parameter, a bank object that represents
the bank. The method should prompt the user to enter an account number and then try to
find a matching account with that account number in the bank. If an account cannot be found,
the program should print “Account not found for account number: 12345678”
(assuming the user entered 12345678) and return null.  If an account is found,
the program should then prompt the user to enter a PIN.  If the PIN entered does
not match the PIN for the account, then the program should print “Invalid PIN”
and return null.  If the PIN matches, then the method should return the Account object.

**CoinCollector**
This class is a static class that cannot be instantiated (similar to the java.util.Math class).  
It represents a machine that can count change and has one method:
- parseChange, This method takes one parameter -  a String that represents a set of coins / change.
The method must look at each character in the String and calculate the amount
it represents in cents as a ‘long’ and return it.

**Account**
The account class must store the following attributes:
- Account Number - A randomly generated 8 digit integer that cannot start with zero.
- Owner First Name - A string that contains the first name of the account owner.
- Owner Last Name - A string that contains the last name of the account owner.
- Social Security Number  - A String that contains the 9 digits of the social.
For the sake of the program, the first three numbers will be 000 or 999.
- PIN - A string that represents the account owner's 4-digit personal identification
that is randomly generated upon account creation and may start with one or more zeros.
- Balance - a number that represents the balance in cents.

This class must implement the following methods:
- Getters and setters to get and set each attribute.
- A method 'deposit' that takes one parameter - an amount to deposit as a long into the
account and returns a long representing the new account balance.
- A method 'withdraw' that takes one parameter - an amount to withdraw from
the account as a ‘long’.  The method then subtracts the amount from the
account balance and returns a ‘long’ representing the new account balance.
- A method ‘isValidPIN’ that takes one parameter – A String that represents
a PIN.  The method then compares the PIN that was passed in against the PIN
that is on the account.  If the PINs match, it returns true, otherwise, it
returns false.
- •	A method ‘toString’ that has no parameters but returns a String that
contains the names and values of all of the attributes.  This method should
NOT print out anything but can be invoked as part of a System.out.println elsewhere.

**Bank**
The Bank class must store the following attributes:
- An array of accounts.
- The array represents all the accounts in the bank.
- A constant that represents the number of accounts supported by the bank.
This will be set to 10 during testing but after set to 100.

The following methods will be included:
- 'addAccountToBank' - takes one parameter, an Account object, to add to the
array of accounts in the bank. The method should iterate through all the
accounts in the array until it finds an empty or null index. It should
then add the account to that index in the array to represent a new account.
that was opened and return true to indicate that the account was created.
If there is no more room for the Bank to accept any more accounts (i.e. there
are already 100 accounts in the array). The method should print a message saying,
“No more accounts available” and should return false.
- ‘removeAccountFromBank’, that takes one parameter, an
Account object, to remove from the accounts array.  The method should
iterate through all the accounts in the array and try to match the account
provided to the accounts in the Bank by the account number.  If the account
number of the provided account matches the account number of the Account in
the array, then that index of the array should be marked ‘null’ to indicate
that the account is closed and no longer exists.
- ‘findAccount’ that takes one parameter, an int representing the account number.  
The method should iterate through all the accounts in the array and try
to match the account number provided to the accounts in the Bank by the
account number.  If a match is found, the Account object should be returned.  
If an account with the provided account number does not exist, the method
should return ‘null’ to indicate a matching Account was not found.
- ‘addMonthlyInterest’ that takes one parameter, a ‘double’ representing
the percentage of the annual interest rate (e.g. if the rate is 2.5%, the
value entered would be 2.5).  The method should then iterate through all
the accounts in the array and deposit a monthly interest payment into every
account.  The monthly interest for the account is calculated by taking
the current balance and multiplying a monthly interest rate.

**BankUtility**
This class is a static class that cannot be instantiated (similar to the java.util.Math class).  
It should provide several utility methods to use throughout the program:
- isNumeric - to determine if a String is a number.  If it is a number,
it will return true, otherwise, it will return false.
- ‘promptUserForString’ that takes one parameter, a String that represents
a prompt to print on the screen (e.g. “Enter your name”). The method
should then read a line of input from the keyboard and return as a String.
- ‘promptUserForPositiveNumber’ that takes one parameter, a String that
represents a prompt to print on the screen (e.g. “Enter a number”).  
The method should then read a double from the keyboard.  If the number
is less than or equal to 0, it should print a message and say “Amount
cannot be negative.  Try again” and continue to loop.  If the number
is positive, the method should return that number as a double.
- ‘generateRandomInteger’ that takes two parameters, an integer representing
the minimum value and an integer representing the maximum value of the
range to generate a random number for and then return the number generated
as an int.  For example, if you invoke generateRandomInteger(0,5),
the method should return a random number from 0-5 (including both 0 and 5).



# 2. Analyze the problem:

**BankManager**
a. What are the inputs?
i.  The numeric choice from the main menu ranging from 1 to 11.
ii. Account number
iii. PIN
b. What are the outputs that should made by the solution to the problem?
i. The main menu.
ii. If the account is valid, it wil prompt for pin, if not it will output the
message "Account not found for account number: 1234568".
iii. If the PIN is valid, return to the account object, if not, it will output
“Invalid PIN” and return null.

c. How are the inputs and outputs related?
i. The numeric choice for the main menu will allow the user to access those
banking choices.
ii. The account number will allow access to the PIN.
iii. The PIN will allow access to the account object.

d. Are there any constraints on the input?
i. The numeric choice must be a number from 1-11.
ii. The account number must be an 8 digit integer that cannot start with 0.
iii. PIN - a string of 4 numbers.


# 3. Design the algorithm to solve the problem

**BankManager**

MAIN:

    1. Output the main menu with the banking choices provided by the bank.
        i. If the user input is less than 1 or greater than 11, output "Invalid
           choice" and loop through the request for input. 
        ii. If the user selects 1, the "Open account" prompt will display.
            a. Prompt user for first name.
            b. Prompt user for last name.
            c. Prompt user for the social security number.
            d. Output the randomly generated account number, first name, last name,
               SSN with the first 6 digits X'd out, randomly generated pin and balance.
            e. Loop back to the main menu when finished.
        iii. If the user selects 2, the "‘Get account information and balance’"
             prompt will display.
            a. Prompt user for account number, if valid, continue, if not loop 
                request for input. 
            b. Prompt user for PIN, if valid, continue, if not loop request for 
                input.
            c. Output the account number, first name, last name,
                SSN with the first 6 digits X'd out, pin and balance. 
            d. Loop back to the main menu when finished.
        iv. If the user selects 3, the "Change PIN" menu prompt will display.
            a. Prompt user for account number, if valid, continue, if not loop
               request for input.
            b. Prompt user for PIN, if valid, continue, if not loop request for 
               input.
            c. Prompt user for new PIN, if valid, continue, if not loop request 
               for input.
            d. Prompt user for new PIN to CONIRM, if valid / matching, continue, 
               if not loop request for input.
            e. Output "PIN Updated". 
            f. Loop back to main menu.
        v. If the user selects 4, the "Deposit Money into account" input menu will display.
            a. Prompt user for account number, if valid, continue, if not loop
               request for input.
            b. Prompt user for PIN, if valid, continue, if not loop request for
               input.
            c. Prompt user to enter deposit in dollars and cents. If input is less than or 
               equal to 0, output the message "Amount cannot be negative.  Try again.”  
               Input must be converted a non-negative long greater than 0.00 and call the function
               deposit on the account. 
            d. Output the new balance.
            e. Loop back to main menu.
        vi. If the user selects 5, the "Transfer Money into account" input menu will display.
            a. Prompt user for account number, if valid, continue, if not loop
               request for input.
            b. Prompt user for PIN, if valid, continue, if not loop request for
               input.
            c. Prompt user for the "Transfer to" account number, if valid, continue, 
               if not loop request for input. 
            d. Prompt user for the "Transfer to" PIN, if valid, continue,
               not loop request for input.
            e. Prompt user to enter deposit in dollars and cents. If input is less than or
               equal to 0, output the message "Amount cannot be negative.  Try again.”  
               Input must be converted a non-negative long greater than 0.00 and call the function
               withdraw on the first account and call deposit on the second account.
            f. Output the new balance of account 1 and account 2. 
            g. Loop back to main menu.
        vii. If the user selects 6, the "Withdraw Money from account" input menu will display.
            a. Prompt user for account number, if valid, continue, if not loop
               request for input.
            b. Prompt user for PIN, if valid, continue, if not loop request for
               input.
            c. Prompt user to enter withrawal amount in dollars and cents. If input is less than or
               equal to 0, output the message "Amount cannot be negative.  Try again.”  
               Input must be converted a non-negative long greater than 0.00 and call the function
               withdraw on the account.
            d. Output the new balance.
            e. Loop back to main menu.
        viii. If the user selects 7, the "Make an ATM withdrawal from account" input menu will display.
            a. Prompt user for account number, if valid, continue, if not loop
               request for input.
            b. Prompt user for PIN, if valid, continue, if not loop request for
               input.
            c. Prompt user to enter withdrawal amount in whole dollars. If input 
               is less than 5, greater than 1000, or not divisible by 5, output 
               the message "Amount cannot be negative.  Try again.” Input must be 
               converted a non-negative long greater than 0.00 and 
            d. Calculate the number of 20s, 10s, and 5s needed to make the withdrawal 
               abd the call the function withdraw on the account.
            e. Output the number of 20s, 10s, and 5s needed.
            d. Output the new balance.
            e. Loop back to main menu.
        ix. If the user selects 8, the "Deposit change into an account" input menu will display.
            a. Prompt user for account number, if valid, continue, if not loop
               request for input.
            b. Prompt user for PIN, if valid, continue, if not loop request for
               input.
            c. Prompt user to enter a string representing these coins:
	                        ‘P’ represents a penny (1 cent)
	                        ‘N’ represents a nickel (5 cents)
	                        ‘D’ represents a dime (10 cents)
	                        ‘Q’ represents a quarter (25 cents)
	                        ‘H’ represents a half-dollar (50 cents)
	                        ‘W’ represents a whole dollar (100 cents)
              If any characters are invalid coins (e.g. X), the program should print 
              “Invalid coin: X”.  Otherwise, convert the String into the appropriate 
              number of cents to a long and call the deposit method on the Account.
            d. Output the total amount of coins.
            e. Output the new balance.
            f. Loop back to main menu.
        x. If the user selects 9, the "Close an account" input menu will display.
            a. Prompt user for account number, if valid, continue, if not loop
               request for input.
            b. Prompt user for PIN, if valid, continue, if not loop request for
               input.
            c. Delete that account from the accounts object in the bank. 
            d. Output "Account  12234567 closed".
            e. Loop back to the main menu.
        xi. If the user selects 10, the "Add monthly interest to all accounts"
            input menu will display. 
            a. Input annual interest rate percentage. 
            b. Output the deposited interest in the account,
            c. Output the new balance.
        xii. If the user selects 11, exit the program. 

promptForAccountNumberAndPIN:

    1. Prompt user to enter account number. 
    2. Invoke the findAccount method in the Bank class by looping through the 
       the account numbers to see if it matches. 
    3. If there is no match, print out to the user "Account not found for account 
       number: 12345678" and return null. 
    4. If an account is found, prompt user to enter a pin. In that same account, 
       the PIN string must match the string that is in that Account object. 
    5. If the PIN does not match, the program will print out "Invalid PIN" and 
       return null. 
    6. If the PIN does match, the method will return the Account object.


**Account**

Class attributes:

    1. Create class attributes for account number, first name, last name, Social Security,
       PIN and balance.
    2. Create getter and setter methods for these attributes so that they can't be accessed
       or modified directly. 

Account Constructor:

    1. Initialize the account number with  uniquely generated 8-digit integer number that does
       not start with a zero.
    2. Initialize the first name with an input string.
    3. Initialize the last name with an input string.
    4. Initialize the social security with an input string.
    5. Initialize the PIN with an input string.
    6. Initialize the balance with a long data type for the number. 

isValidPIN:

    1. Create an if statement with the && operator.
    2. Call the isNumeric function.
    3. If the pin is both numeric and has a length of 4, return true.
    4. Else, return false.

toString:

    1. Create a string formatter that includes all of the attributes of the account. 

***Bank***

Array of Objects attributes:

    1. The array represents all of the accounts in the bank.
    2. The bank must support up to 100 accounts when finished. 

addAccountToBank:

    1. Initialize a for loop with the index of the accounts starting at zero,
       end the loop at the index less than the max number of accounts, iterate by 
       one. 
    2. If the index is at the max number of accounts, print that "No More accounts available"
       and return false.
    3. If the index is less than the max number of accounts, iterate by one from the
       index of the last created account and return true. 

findAccount:

    1. Create an enhanced for loop. 
    2. For each account in the array of accounts if the account number of that account
       is the same value of the one entered by the user, return the account. 
    3. If it is not the same, return null. 

**BankUtility**

generateRandomInteger:

    1. Declare the minimum value of the range.
    2. Declare the maximum value of the range.
    3. Use the formula Math.floor(Math.random()*(max-min+1)+min) to generate 
       values with the min and the max value inclusive.


# 4. Test the correctness of algorithm using a trace:

    (JUnit testing in separate file)
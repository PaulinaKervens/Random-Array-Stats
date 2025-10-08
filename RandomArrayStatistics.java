// This is a program that  a method that creates random
// numbers between two values using the formula
// (int)( Math.random()*(max-min+1)+min)

// Program name: Random array number
// Programmer: Kerv Kervens Paulina
// Date : October 07, 2025

// Call of scanner library
import java.util.Scanner;

// Declaration of the class
public class RandomArrayStatistics {

    // Method to generate a random number between min and max
    public static int getRandomNumber(int minimum, int maximum) {
        return (int)(Math.random() * (maximum - minimum + 1) + minimum);    // return the number chose
    }

    // Method to fill an array with random numbers
    public static void fillArray(int[] arr, int min, int max) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRandomNumber(min, max);       // Fill each case with the array by the random number
        }
    }

    // Method to calculate the sum of an array
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;     // addition the sum to the old value
        }
        return sum;         // return the sum
    }

    // Method to find the minimum value in an array
    public static int minArray(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;         // Return the minimum value
    }

    // Method to find the maximum value in an array
    public static int maxArray(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;          // Return the maximum value
    }


    // Method to print the array using a foreach loop
    // Method to print the array using a foreach loop
    public static void printArray(int[] arr) {
        System.out.println(); // empty line before array
        System.out.print("The array values are: ");

        int count = 0; // Counter for numbers to print 10 numbers by line if it's up to 10.
        for (int num : arr) {
            System.out.print(num + " ");
            count++;
            if (count % 10 == 0) { // after every 5 numbers
                System.out.println( );
                System.out.print("\t\t\t\t\t  "); // go to next line
            }
        }

        // final new line if the last line had less than 5 numbers
        if (count % 10 != 0) {
            System.out.println();
        }
    }


    // Is a valid number
    public static boolean isValidNumber(String userInput) {
        // Check if input is null or empty
        if (userInput == null || userInput.isEmpty()) {
            System.out.println("The value can't be empty.");
            return false;
        }

        // Check if input contains only digits
        if (!userInput.matches("\\d+")) {
            System.out.println("Sorry, that must only digit (1 to 500).");
            return false;
        }

        // Convert to integer and check if > 0
        int number = Integer.parseInt(userInput);

        return number > 0 && number <= 500;         // return true if the number is between 1 to 500
    }


    // Method that print the banner
    public static void printBanner(){
        System.out.println(" ");
        System.out.println("\t\t\t" + "*************************************************");
        System.out.println("\t\t\t" + "******" + "\t\t\tRandom Array Stats" + "\t\t\t*****");
        System.out.println("\t\t\t" + "*************************************************");
    }

    // Method that ask the user for next steps
    public static void askDecision(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" ");
        System.out.print("Would you want to continue Y/N: ");
        char answer = sc.next().charAt(0);

        switch(answer){
            case 'y':
            case 'Y':
                printResult();
                break;
            case 'n':
            case 'N':
                System.out.println("Bye bye, see you soon...");
                break;
            default:
                System.out.println("You chose a wrong option...");
                askDecision();
                break;
        }
    }

    // Function that print
   public static void printResult() {
        Scanner input = new Scanner(System.in);
        String size;
        boolean run = false;

        // Ask the user for number of items he wants in the array
       do {
           System.out.println(" ");
           System.out.print("Enter the number of items in the array: ");
           size = input.nextLine();     // Read the number from the console
           run = isValidNumber(size);

       }while(!run);

       // Convert to integer and check if > 0
       int number = Integer.parseInt(size);
       int[] numbers = new int[number];

        // Customize min and max range here
        int min = 1;
        int max = 100;

        // Fill array with random numbers
        fillArray(numbers, min, max);

        // ----------------------------
        //    CALCULATE STATISTICS
        // ----------------------------
        // Call the sum function to store the result in sum variable
        int sum = sumArray(numbers);
        // Call the min function to store the min number into the minValue variable
        int minValue = minArray(numbers);
        // Call the max function to store the max number into the maxValue variable
        int maxValue = maxArray(numbers);

        // Display results
        printArray(numbers);
        System.out.println("\nHere is the result ");
        System.out.println("The sum is : " + sum);
        System.out.println("The minimum value of the array is : " + minValue);
        System.out.println("The maximum value of the array is : " + maxValue);

        // Closing the Scanner object that was reading input
        // from the keyboard (System.in)
        askDecision();
        input.close();
    }


    // --------------------------
    //      THE MAIN PROGRAM
    // --------------------------

    public static void main(String[] args) {
        // Call of print banner function
        printBanner();

        // Call of function to print the result
        printResult();
    }
}

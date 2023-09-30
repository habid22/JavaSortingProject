package LA2Q1;
// Imports
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class main {
    public static void myHeader(int labE_number, int q_number) { // Header
        System.out.println("=================================================");
        System.out.println("Lab Assignment " + labE_number + "-" + "Q" + q_number);
        System.out.println("Prepared by: " + "Hassan" + " Abid Amin");
        System.out.println("Student Number: " + "251219098");
        System.out.println("Goal of this Exercise: " + "Testing different sorting methods and displaying their time");
        System.out.println("=================================================");
    }

    public static void myFooter(int labE_number, int q_number) { // Footer

        System.out.println("=================================================");
        System.out.println("Completion of Lab Assignment " + labE_number + "-" + "Q" + q_number + " is successful!");
        System.out.println("Signing off -" + " Hassan");
        System.out.println("=================================================");
    }
    public static void main(String[] args) {
        myHeader(2,1);
        // Array creation, both intArray and backUp arrays are created with sz which can be modified as you please
        int sz = 100;
        Integer[] intArray = new Integer[sz];
        Integer[] backUpArray = new Integer[sz];

        // For loop to implement random and add random elements inside the array intArray
        Random r = new Random();
        for (int i = 0; i < intArray.length; i++) //
        {
            intArray[i] = r.nextInt(3,94); // will only add elements from 3 to 93;

        }

        // Copying the elements of our array into back up array
        System.arraycopy(intArray, 0, backUpArray, 0, sz);
        // Creating a list intList with our intArray
        List<Integer> intList = Arrays.asList(intArray);

    //    System.out.println("Testing execution time of different sorting methods for sorting 5 random numbers:");
    //    System.out.printf("The unsorted list: %s%n", intList); // Prints the unsorted list
        long startTime = System.currentTimeMillis(); // Timer Starts
        Collections.sort(intList, null); // Sorts our intList using collections sort
        long endTime = System.currentTimeMillis(); // Timer Ends

        // BELOW ARE PRINT STATEMENTS FOR OUR SORTING METHODS

        System.out.println("Testing execution time of different sorting methods for sorting 50000 random numbers:");


        // COLLECTION SORT
        System.out.printf("My Collections-Sort Time: %.2f milliseconds %n", (double) endTime - startTime); // Prints sorting time
    //    System.out.printf("The sorted list using Collections' sort method: %s%n", intList); // Prints sorted list
        System.arraycopy(backUpArray, 0, intArray, 0, sz); // Copy method to copy elements stored originally in the backUp array above into our intArray to reset it to unsorted
    //    System.out.println();

        // SELECTION SORT
    //    System.out.printf("The unsorted list: %s%n", intList);  // Prints sorting time
        System.out.printf("My Selection-Sort Time: %.2f milliseconds %n", (double) HassansTestingSortingMethods.selectionSort(intArray));
   //     System.out.printf("The sorted list using Selection-Sort method: %s%n", Arrays.toString(intArray)); // Prints sorted list
        System.arraycopy(backUpArray, 0, intArray, 0, sz); // Copy method to copy elements stored originally in the backUp array above into our intArray to reset it to unsorted
    //    System.out.println();

        // BUBBLE SORT
    //    System.out.printf("The unsorted list %s%n", intList);  // Prints sorting time
        System.out.printf("My Bubble-Sort Time: %.2f milliseconds %n", (double) HassansTestingSortingMethods.bubbleSort(intArray)/1_000_000);
    //    System.out.printf("The sorted list using Bubble-Sort method: %s%n", Arrays.toString(intArray)); // Prints sorted list
        System.arraycopy(backUpArray, 0, intArray, 0, sz); // Copy method to copy elements stored originally in the backUp array above into our intArray to reset it to unsorted
    //    System.out.println();

        // INSERTION SORT
    //    System.out.printf("The unsorted list %s%n", intList);  // Prints sorting time
        System.out.printf("My Insertion-Sort Time: %.2f milliseconds %n", (double) HassansTestingSortingMethods.insertionSort(intArray)/1_000_000);
    //    System.out.printf("The sorted list using Insertion-Sort method: %s%n", Arrays.toString(intArray)); // Prints sorted list
        System.arraycopy(backUpArray, 0, intArray, 0, sz); // Copy method to copy elements stored originally in the backUp array above into our intArray to reset it to unsorted
    //    System.out.println();

        // MERGE SORT
    //    System.out.printf("The unsorted list %s%n", intList);  // Prints sorting time
        System.out.printf("My Merge-Sort Time: %.2f milliseconds %n", (double) HassansTestingSortingMethods.mergeSort(intArray)/1_000_000);
    //    System.out.printf("The sorted list using Merge-Sort method: %s%n", Arrays.toString(intArray)); // Prints sorted list
        System.arraycopy(backUpArray, 0, intArray, 0, sz); // Copy method to copy elements stored originally in the backUp array above into our intArray to reset it to unsorted
    //    System.out.println();

        // QUICK SORT
    //    System.out.printf("The unsorted list %s%n", intList);  // Prints sorting time
        System.out.printf("My Quick-Sort Time: %.2f milliseconds %n", (double) HassansTestingSortingMethods.quickSort(intArray,0,intArray.length-1)/1_000_000);
    //    System.out.printf("The sorted list using Quick-Sort method: %s%n", Arrays.toString(intArray)); // Prints sorted list
        System.arraycopy(backUpArray, 0, intArray, 0, sz); // Copy method to copy elements stored originally in the backUp array above into our intArray to reset it to unsorted
    //    System.out.println();

        // BUCKET SORT
   //     System.out.printf("The unsorted list %s%n", intList);  // Prints sorting time
        System.out.printf("My Bucket-Sort Time: %.2f milliseconds %n", (double) HassansTestingSortingMethods.bucketSort(intArray,0,intArray.length-1,2)/1_000_000);
    //    System.out.printf("The sorted list using Bucket-Sort method: %s%n", Arrays.toString(intArray)); // Prints sorted list
        System.arraycopy(backUpArray, 0, intArray, 0, sz); // Copy method to copy elements stored originally in the backUp array above into our intArray to reset it to unsorted


        myFooter(2,1);

    }
}

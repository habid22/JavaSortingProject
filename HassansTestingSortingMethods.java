package LA2Q1;


import java.util.*;
import java.lang.*;


public class HassansTestingSortingMethods {
    public static <T extends Comparable<? super T>> long selectionSort(T[] array) { // Selection Sort Method
        long startTime = System.currentTimeMillis(); // Start of timer
        int n = array.length; // Setting n to length of array
        for (int i = 0; i < n - 1; i++) { // loop from the start of the array to the second last item
            int min = i; // save a copy of our currentIndex
            // loop to locate the smallest index
            for (int j = i + 1; j < n; j++) { // if the value of the index of the current loop is less than the value of the item at min, update min with the new lowest value index
                if (array[j].compareTo(array[min]) < 0) {
                    min = j; // update min with the new lowest value
                }
            } // swap values at min and the current index
            T smallerNumber = array[min];
            array[min] = array[i];
            array[i] = smallerNumber;
        } // timer end

        long endTime = System.currentTimeMillis();
        return endTime - startTime;

    }

    public static <T extends Comparable<? super T>> long bubbleSort(T[] array) {
        boolean nextPassNeeded = true;
        long startTime = System.nanoTime(); // start of timer
        for (int i = 1; i < array.length && nextPassNeeded; i++) { // loop to loop through whole lists
            nextPassNeeded = false;
            for (int j = 0; j < array.length - i; j++) {  // loop to loop till second last index
                if (array[j].compareTo(array[j + 1]) > 0) {
                    // swap elements
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    nextPassNeeded = true;
                }
            }
        } // end of timer
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        return timeElapsed;
    }


    public static <T extends Comparable<? super T>> long insertionSort(T[] array) {
        long startTime = System.nanoTime(); // start of timer

        for (int i = 1; i < array.length; i++) { // loop to iterate through at first index till the end
            int currentIndex = i;
            while (currentIndex > 0 && array[currentIndex - 1].compareTo(array[currentIndex]) > 0) { // checks if index is at least 1 and item directly before the currentIndex is greater than the item at currentIndex
                // swaps elements if both conditions are met
                T temp = array[currentIndex];
                array[currentIndex] = array[currentIndex - 1];
                array[currentIndex - 1] = temp;
                currentIndex--;
            }
        }
        long endTime = System.nanoTime(); // end of timer
        long timeElapsed = endTime - startTime;
        return timeElapsed;
    }


    public static <T extends Comparable<? super T>> long mergeSort(Integer[] array) {
        int n = array.length;
        // For current size of subarrays to
        // be merged curr_size varies from 1 to n/2
        int curr_size;
        // For picking starting index of left subarray to be merged
        int left_start;
        // Merge subarrays in bottom up
        // First merge subarrays
        // of size 1 to create sorted
        // subarrays of size 2, then merge
        // subarrays of size 2 to create
        // sorted subarrays of size 4, and
        // so on.
        long startTime = System.nanoTime();
        for (curr_size = 1; curr_size <= n - 1; curr_size = 2 * curr_size) {
            // Pick starting point of different subarrays of current size
            for (left_start = 0; left_start < n - 1; left_start += 2 *
                    curr_size) {
                // Find ending point of left subarray. mid+1 is starting
                // point of right
                int mid = Math.min(left_start + curr_size - 1, n - 1);
                int right_end = Math.min(left_start + 2 * curr_size - 1, n - 1);
                // Merge Subarrays arr[left_start...mid]
                // & arr[mid+1...right_end]
                merge(array, left_start, mid, right_end);
            }
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        return timeElapsed;
    }
   // Method to merge the two haves arr[l..m] and arr[m+1..r] of array arr[]
    public static void merge(Integer[] array, int start, int mid, int end) {
        //Dividing the array 'arr' into two parts
        int p1StartIndex = start;
        int p1EndIndex = mid;
        int startIndexP2 = mid + 1;
        int endIndexP2 = end;
        int[] temp = new int[end - start + 1]; //to store the sorted data
        int i = 0; //index for the temp array
        while ((p1StartIndex <= p1EndIndex) && (startIndexP2 <= endIndexP2)) {
            if (array[p1StartIndex] < array[startIndexP2]) {
                temp[i] = array[p1StartIndex];
                p1StartIndex++;
            } else {
                temp[i] = array[startIndexP2];
                startIndexP2++;
            }
            i++;
        }
        while (p1StartIndex <= p1EndIndex) {
            temp[i] = array[p1StartIndex];
            p1StartIndex++;
            i++;
        }
        while (startIndexP2 <= endIndexP2) {
            temp[i] = array[startIndexP2];
            startIndexP2++;
            i++;
        }
        //updating part of the arr array with the sorted content in temp
        for (int k = start, j = 0; k <= end; k++, j++)
            array[k] = temp[j];
    }


    public static <T extends Comparable<? super T>> long quickSort(T [] array, int startIndex, int endIndex) {
        long startTime = System.nanoTime();
        // Check if the values given are valid
        if (startIndex < endIndex) {
            // Find the pivot element
            int left =startIndex;
            int right =endIndex;
            T pivot = array[startIndex];
            // Move the left and right pointers until they meet
            while (left < right) {
                // Move the left pointer until it finds an element greater than the pivot
                while (left < right && array[right].compareTo(pivot) >= 0) {
                    right--;
                }

                // If the left pointer is still less than the right pointer, move the element at the left pointer to the right pointer
                if (left < right) {
                    array[left++] = array[right];
                }

                // Move the right pointer until it finds an element less than the pivot
                while (left < right && array[left].compareTo(pivot) <= 0) {
                    left++;
                }

                // If the left pointer is still less than the right pointer, move the element at the right pointer to the left pointer
                if (left < right) {
                    array[right--] = array[left];
                }
            }

            // Move the pivot element to the correct position
            array[left] = pivot;

            // Sort the left and right halves of the array
            quickSort(array, startIndex, left - 1);
            quickSort(array, left + 1, endIndex);
        }

        // Return the time it took to sort the array
        long endTime = System.nanoTime();
        return endTime - startTime;
    }





    public static long bucketSort(Integer[] array, int first, int last, int maxDigits) {
        Vector<Integer>[] bucket = new Vector[10];
        long startTime = System.nanoTime();
        //instantiate each bucket;
        for (int i = 0; i < 10; i++)
            bucket[i] = new Vector<>();
        for (int i = 0; i < maxDigits; i++) {
            //clear the Vector buckets
            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements();
            }
            //Placing a[index] at end of bucket[digit]
            for (int index = first; index <= last; index++) {
                Integer digit = findDigit(array[index], i);
                bucket[digit].add(array[index]);
            }
            //placing all the buckets back into the array
            int index = 0;
            for (int m = 0; m < 10; m++) {
                for (int n = 0; n < bucket[m].size(); n++) {
                    array[index++] = bucket[m].get(n);
                }
            }

        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        return timeElapsed;
    }
    //The following method extracts the ith digit from a decimal number
    public static Integer findDigit(int number, int i) {
        int target = 0;
        for (int k = 0; k <= i; k++) {
            target = number % 10;
            number = number / 10;
        }
        return target;
    }


}





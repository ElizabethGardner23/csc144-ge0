package searchandsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The class SearchAndSort contains methods to sort a list by selection sort and
 * insertion sort and a method to find the first occurrence of an integer in an
 * ordered list using sequential search.
 *
 * @author Elizabeth Gardner
 * @version 27 March 2020
 */
public class SearchAndSort {

    // Random number generator borrowed from Professor Tabak.
    private static Random rng = new Random();

    /**
     * The method makeList produces a list of random numbers that can be used to
     * test the other methods of this class. Method borrowed from Professor
     * Tabak.
     *
     * @param size
     * @return list of random numbers
     */
    public static List<Integer> makeList(int size) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int n = 10 + rng.nextInt(90);
            result.add(n);
        } // for

        return result;
    } // makeList( int )

    /**
     * The method firstIndexSequential finds the index of the first occurrence
     * of a target number in a list of values through sequential search (going
     * through the list and checking each value for equality) and returns -1 if
     * the target number is not present in the list. Based on Professor Tabak's
     * linearSearch but with a for loop instead of a while loop.
     *
     * @param values
     * @param target
     * @return int index of the first occurrence of the target number or -1
     */
    public static int firstIndexSequential(List<Integer> values,
            int target) {
        int result = -1;
        for (int index = 0; index < values.size(); index++) {
            if (values.get(index) == target) {
                result = index;
            } // if
        } // for
        return result;
    } // firstIndexSequential

    // TO-DO: Define a method that determines
    // the index of the first integer in a list
    // of integers that matches a given integer.
    // The method should return -1 if no match is found.
    // Use the binary search algorithm.
    
    /**
     * The method selectionSort puts a list of integers in ascending order by
     * looking for the smallest number in the unordered subset towards the end
     * of the list and adding it to the ordered subset towards the beginning of
     * the list.
     * Adapted from Professor Tabak's example and code found here:
     * https://www.javatpoint.com/selection-sort-in-java
     *
     * @param values : The list of numbers to be ordered.
     */
    public static void selectionSort(List<Integer> values) {
        for (int i = 0; i < values.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < values.size(); j++) {
                if (values.get(j) < values.get(index)) {
                    index = j;
                } // if
            } // for
            int smallerNumber = values.get(index);
            values.set(index, values.get(i));
            values.set(i, smallerNumber);
        } // for

    } // selectionSort

    /**
     * The method insertionSort puts a list of integers in ascending order by
     * checking if each number is larger than the one after it and, if so,
     * switching the numbers accordingly.
     * Adapted from Professor Tabak's example and code found here:
     * https://stackabuse.com/insertion-sort-in-java/
     *
     * @param arr
     */
    public static void insertionSort(List<Integer> values) {
        for (int j = 1; j < values.size(); j++) {
            int current = values.get(j);
            int i = j - 1;
            while ((i > -1) && ((values.get(i) > current))) {
                values.set(i + 1, values.get(i));
                i--;
            } // while
            values.set(i + 1, current);
        } // for
    } // insertionSort

    // TO-DO: Define a method that sorts a list
    // of integers using the merge sort algorithm.
    
    /**
     * The main method generates and prints a list of random numbers before and
     * after being sorted by selection sort, another list before and after being
     * sorted by insertion sort, and the first index of the number 18 in the
     * previous sorted list.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Searching and sorting algorithms");

        List<Integer> test = makeList(10);
        System.out.println("Before selection sort:");
        for (int element : test) {
            System.out.print(element + " ");
        } // for
        System.out.println();

        selectionSort(test);
        System.out.println("After selection sort:");
        for (int element : test) {
            System.out.print(element + " ");
        } // for
        System.out.println();

        List<Integer> test2 = makeList(10);
        System.out.println("Before insertion sort:");
        for (int element : test2) {
            System.out.print(element + " ");
        } // for
        System.out.println();

        insertionSort(test2);
        System.out.println("After insertion sort:");
        for (int element : test2) {
            System.out.print(element + " ");
        } // for
        System.out.println();

        System.out.println("Index of the first occurance of 18 in the above list:");
        System.out.println(firstIndexSequential(test2, 18));
    } // main( String [] )
} // SearchAndSort

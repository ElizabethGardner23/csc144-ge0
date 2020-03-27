package searchandsort;

/**
 * The class SearchAndSort contains methods to sort a list by
 * selection sort and insertion sort.
 * 
 * @author Elizabeth Gardner
 * @version 26 March 2020
 */
public class SearchAndSort {

    // TO-DO: Define a method that determines
    // the index of the first integer in a list
    // of integers that matches a given integer.
    // The method should return -1 if no match is found.
    // Use the sequential search algorithm.
    
    // TO-DO: Define a method that determines
    // the index of the first integer in a list
    // of integers that matches a given integer.
    // The method should return -1 if no match is found.
    // Use the binary search algorithm.
    
    /**
     * The method selectionSort puts a list of integers in ascending order
     * by looking for the smallest number in the unordered subset towards the end
     * of the list and adding it to the ordered subset towards the beginning 
     * of the list.
     * 
     * @param arr 
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;//searching for lowest index  
                } // if
            } // for
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        } // for

    } // selectionSort

    /**
     * The method insertionSort puts a list of integers in ascending order by
     * checking if each number is larger than the one after it and, if so,
     * switching the numbers accordingly.
     * 
     * @param arr 
     */
    public static void insertionSort(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;
            while ((i > -1) && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
            } // while
            arr[i + 1] = key;
        } // for
    } // insertionSort
    // TO-DO: Define a method that sorts a list
    // of integers using the merge sort algorithm.

    /**
     * The main method first prints an unsorted list then prints the list after
     * being sorted through selection sort and sorted through insertion sort.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        System.out.println("Searching and sorting algorithms");

        int[] arr1 = {9, 14, 3, 2, 43, 11, 58, 22};
        System.out.println("Before Sorting");
        for (int i : arr1) {
            System.out.print(i + " ");
        } // for 
        System.out.println();

        selectionSort(arr1);

        System.out.println("After Selection Sort");
        for (int i : arr1) {
            System.out.print(i + " ");
        } // for 
        System.out.println();

        int[] arr2 = {9, 14, 3, 2, 43, 11, 58, 22};

        insertionSort(arr2);

        System.out.println("After Insertion Sort");
        for (int i : arr2) {
            System.out.print(i + " ");
        } // for
    } // main( String [] )
} // SearchAndSort

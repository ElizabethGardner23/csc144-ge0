package searchandsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The class SearchAndSort contains methods to sort a list by selection sort,
 * insertion sort, and merge sort and a method to find the first occurrence of a
 * target integer in an ordered list using sequential search and binary search.
 * It also contains a method that creates a list of random integers in order to
 * test the other methods. Writing multiple methods that provide the same
 * function allows one to compare and contrast each approach.
 *
 * For example, of the three sort methods, I found selection sort to be the most
 * straightforward method, as it is the method most often used in everyday life,
 * such as when alphabetizing a stack of books (which I do often as I work in a
 * library). When I put a cart of books in order before shelving them, I look
 * for the books whose author's name begins with "A", then "B" and "C" and so
 * on. One source I based my selection sort algorithm off of used arrays, but it
 * was easy enough to adapt the formula to sort a list instead.
 *
 * My insertion sort method was a little harder to write, as the examples that I
 * looked at tended to use supporting methods to make the insertionSort method
 * simpler but I wanted to have everything neatly in one method (just a personal
 * preference). Insertion sort works by comparing consecutive numbers in a list
 * and, if one is larger than the one after it, switching the two numbers, so
 * some have decided to make a separate switch method to simplify that part of
 * the process. However, I was able to combine the two functions into one
 * method, and I am fairly proud of how it turned out.
 *
 * On the other hand, merge sort was a far more complicated procedure. Merge
 * sort works by dividing a list in half repeatedly until each sublist contains
 * just one element then merging the ordered sublists into larger ordered lists
 * until the entire list is in order. This process is facilitated by a separate
 * merge method, which is used to combine two ordered sublists into a larger
 * ordered list and which I have been unable to condense into a single method.
 * Merge sort was the method I had the most trouble with. Though merge sort can
 * run faster than selection sort and insertion sort, I found it far more
 * difficult to work with and think that for the ten-integer lists that I tested
 * these methods on, any time saved during the execution of the algorithm was
 * more than spent in trying to make it run properly (and I'm still not sure
 * that I have).
 *
 * The two search algorithms also raised some interesting challenges. For
 * example, I tried using a for loop instead of a while loop in my sequential
 * sort algorithm. However, after testing this method on a longer list of
 * integers, I realized that it returned the index of the last, not the first,
 * occurrence of the target integer and was forced to change it back.
 *
 * Binary search also gave me a bit of trouble when I tested it on a longer
 * list. Binary search works by dividing an ordered list in half repeatedly in
 * order to narrow down where in the list the target number is relative to the
 * other values. I had three variables for the first index, middle index, and
 * last index of the section of the list being considered. However, I found that
 * when I used Professor Tabak's model and set the final result variable equal
 * to the middle index if the value in that place was equal to the target or the
 * last index if the value in that place was equal to the target, the final
 * result was not always the index of the first occurrence of the target number
 * if the number appeared multiple times in the list (imagine you were looking
 * for the first occurrence of the number 2 in a list composed of the numbers 1,
 * 2, 2, 2, 2, 2. The value associated with the middle index is 2, though not
 * the first occurrence of the number 2). In order to guarantee that only the
 * first occurrence of the target number was returned, I altered the algorithm
 * so that the result variable only changes when the number at the first index
 * is equal to the target integer.
 *
 * I am new to Java, so I had to do a lot of "borrowing" when it came to writing
 * these methods. However, I tried my best to make adaptations as I went and by
 * doing so I am becoming more familiar with how Java works.
 *
 * @author Elizabeth Gardner
 * @version 29 March 2020
 */
public class SearchAndSort {

    /**
     * Random number generator creates a new randomly chosen number. Borrowed
     * from Professor Tabak.
     */
    private static Random rng = new Random();

    /**
     * The method makeList produces a list of random two digit numbers that can
     * be used to test the other methods of this class. Method borrowed from
     * Professor Tabak.
     *
     * @param size the length of the desired list of random numbers
     * @return result list of random numbers of a length indicated by the size
     * variable
     */
    public static List<Integer> makeList(int size) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int n = 10 + rng.nextInt(90);
            result.add(n);
        } // for
        return result;
    } // makeList(int)

    /**
     * The method firstIndexSequential finds the index of the first occurrence
     * of a target number in a list of values through sequential search (going
     * through the list and checking each value for equality) and returns -1 if
     * the target number is not present in the list. Professor Tabak's
     * linearSearch method.
     *
     * @param values an ordered list of integers
     * @param target the integer that is being looked for in the list
     * @return result index of the first occurrence of the target number or -1
     */
    public static int firstIndexSequential(List<Integer> values,
            int target) {
        int result = -1;
        int index = 0;
        while (index < values.size() && result < 0) {
            if (target == values.get(index)) {
                result = index;
            } // if
            index += 1;
        } // while
        return result;
    } // firstIndexSequential(List<Integer>, int)

    /**
     * The method firstIndexBinary finds the index of the first occurrence of a
     * target number in a list of values through binary search (dividing a
     * sorted list in half repeatedly to narrow down the range in which the
     * target can be found) and returns -1 if the target number is not present
     * in the list. Based on Professor Tabak's binarySearch method.
     *
     * @param values an ordered list of integers
     * @param target the integer that is being looked for in the list
     * @return result index of the first occurrence of the target number or -1
     */
    public static int firstIndexBinary(List<Integer> values,
            int target) {
        int result = -1;
        int firstIndex = 0;
        int lastIndex = values.size() - 1;
        while (firstIndex < lastIndex && result < 0) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (target == values.get(firstIndex)) {
                result = firstIndex;
            } // if
            else if (target < values.get(middleIndex)) {
                lastIndex = middleIndex - 1;
            } // else if
            else {
                firstIndex = middleIndex;
            } // else
        } // while
        return result;
    } // firstIndexBinary(List<Integer>, int)

    /**
     * The method selectionSort puts a list of integers in ascending order by
     * looking for the smallest number in the unordered subset towards the end
     * of the list and adding it to the ordered subset towards the beginning of
     * the list. Adapted from Professor Tabak's example and code found here:
     * https://www.javatpoint.com/selection-sort-in-java.
     *
     * @param values the list of integers to be ordered
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
    } // selectionSort(List<Integer>)

    /**
     * The method insertionSort puts a list of integers in ascending order by
     * checking if each number is larger than the one after it and, if so,
     * switching the numbers accordingly. Adapted from Professor Tabak's example
     * and code found here: https://stackabuse.com/insertion-sort-in-java/.
     *
     * @param values the list of integers to be ordered
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
    } // insertionSort(List<Integer>)

    /**
     * The method merge is used to combine ordered sublists into one ordered
     * list. It is used to make the mergeSort method less complicated. Method
     * borrowed from Professor Tabak.
     *
     * @param values the list of integers that has been divided into ordered
     * sublists
     * @param prefixStart the beginning of the first sublist being merged
     * @param suffixStart the beginning of the second sublist being merged
     * @param suffixEnd the end of the second sublist being merged
     */
    public static void merge(List<Integer> values, int prefixStart,
            int suffixStart, int suffixEnd) {
        List<Integer> temp = new ArrayList<>();
        int i = prefixStart;
        int j = suffixStart;
        while (i < suffixStart && j < suffixEnd) {
            if (values.get(i) < values.get(j)) {
                temp.add(values.get(i));
                i++;
            } // if
            else {
                temp.add(values.get(j));
                j++;
            } // else
        } // while
        while (i < suffixStart) {
            temp.add(values.get(i));
            i++;
        } // while
        while (j < suffixEnd) {
            temp.add(values.get(j));
            j++;
        } // while
        i = prefixStart;
        for (int index = 0; index < temp.size(); index++) {
            values.set(i, temp.get(index));
            i++;
        } // for
    } // merge(List<Integer>, int, int, int)

    /**
     * The mergeSort method puts a list of integers in ascending order by
     * dividing the list in half into smaller and smaller sublists (eventually
     * consisting of just one element), ordering each sublist, and merging
     * (using the merge method above) the ordered sublists into a larger ordered
     * list until the entire list is in order. Borrowed from Professor Tabak.
     *
     * @param values the list of integers to be ordered
     */
    public static void mergeSort(List<Integer> values) {
        for (int stepSize = 2; stepSize < values.size(); stepSize *= 2) {
            for (int i = 0; i < values.size(); i += stepSize) {
                int prefixStart = i;
                int suffixStart = i + stepSize / 2;
                int suffixEnd = Math.min(values.size(), i + stepSize);
                merge(values, prefixStart, suffixStart, suffixEnd);
            } // for
            if (stepSize > values.size() / 2) {
                int prefixStart = 0;
                int suffixStart = stepSize;
                int suffixEnd = values.size();
                merge(values, prefixStart, suffixStart, suffixEnd);
            } // if
        } // for
    } // mergeSort(List<Integer>)

    /**
     * The main method generates and prints a list of random numbers before and
     * after being sorted by selection sort then prints the index of the first
     * occurrence of the number 18 in the sorted list as found by sequential
     * search, then generates and prints a new list of random numbers before and
     * after being sorted by insertion sort then prints the index of the first
     * occurrence of the number 24 in the sorted list as found by binary search,
     * then generates and prints a list of random numbers before and after being
     * sorted by merge sort.
     *
     * @param args
     */
    public static void main(String[] args) {
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

        System.out.println("Index of the first occurance of 18 in the above "
                + "list, found by sequential search:");
        System.out.println(firstIndexSequential(test, 18));

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

        System.out.println("Index of the first occurance of 24 in the above "
                + "list, found by binary search:");
        System.out.println(firstIndexBinary(test2, 24));

        List<Integer> test3 = makeList(10);
        System.out.println("Before merge sort:");
        for (int element : test3) {
            System.out.print(element + " ");
        } // for
        System.out.println();

        mergeSort(test3);
        System.out.println("After merge sort:");
        for (int element : test3) {
            System.out.print(element + " ");
        } // for
        System.out.println();
    } // main(String [])
} // SearchAndSort

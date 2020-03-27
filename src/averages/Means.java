package averages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The class Means includes methods to generate and print list of random integers
 * and find the arithmetic, geometric, and harmonic mean of the list.
 * 
 * @author Elizabeth Gardner
 * @version 25 March 2020
 */
public class Means {

    private static final Random RNG = new Random();
    private static final int SIZE_THRESHOLD = 12;

    /**
     * The method makeRandomList produces a list of random integers.
     * 
     * @param size
     * @return ArrayList
     */
    public static List<Double> makeRandomList(int size) {
        List<Double> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            double r = RNG.nextDouble();
            result.add(r);
        } // for

        return result;
    } // makeRandomList( int )

    /**
     * The method printList prints a list of random doubles.
     * 
     * @param data
     */
    public static void printList(List<Double> data) {
        if (data.size() < SIZE_THRESHOLD) {
            for (double x : data) {
                System.out.printf(" %4.2f", x);
            } // for
            System.out.println();
        } // if
        else {
            for (double x : data) {
                System.out.printf("\t%4.2f\n", x);
            } // for
        } // else
    } // printList( List<Double> )

    /**
     * The method arithmeticMean calculates the arithmetic mean of
     * a list of doubles.
     * 
     * @param data
     * @return double
     */
    public static double arithmeticMean(List<Double> data) {
        double result = 0.0;

        if (data.size() > 0) {
            double sum = 0.0;
            for (double x : data) {
                sum += x;
            } // for

            result = sum / data.size();
        } // if

        return result;
    } // arithmeticMean( List<Double> )

    /**
     * The method geometricMean calculates the geometric mean of
     * a list of doubles.
     * 
     * @param data
     * @return double
     */
    public static double geometricMean(List<Double> data) {
        double result = 0.0;

        if (data.size() > 0) {
            double product = 1.0;
            for (double x : data) {
                product *= x;
            } // for
            result = Math.pow(product, 1.0 / data.size());
        } // if

        return result;
    } // geometricMean( List<Double> )

    /**
     * The method harmonicMean calculates the harmonic mean of
     * a list of doubles.
     * 
     * @param data
     * @return double
     */
    public static double harmonicMean(List<Double> data) {
        double result = 0.0;

        if (data.size() > 0) {
            double sum = 0.0;
            for (double x : data) {
                sum += 1.0 / x;
            } // for
            result = data.size() / sum;
        } // if
        return result;
    } // harmonicMean( List<Double> )

    /**
     * The main method prints the String "Hallo!," produces a new ArrayList
     * of doubles, then prints the arithmetic, geometric, and harmonic means
     * of the list.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        System.out.println("Hallo!");
        //List<Double> values = makeRandomList(20);
        //printList(values);

        List<Double> values = new ArrayList<>();
        for( int i = 0; i < 12; i++ ) {
            values.add( 0.5 );
        } // for
        
        System.out.println("arithmetic mean = "
                + arithmeticMean(values));
        System.out.println("geometric mean = "
                + geometricMean(values));
        System.out.println("harmonic mean = "
                + harmonicMean(values));

    } // main( String [] )

} // Means

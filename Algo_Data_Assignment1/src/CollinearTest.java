import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

//-------------------------------------------------------------------------
/**
 *  Test class for Collinear.java
 *
 *  @author
 *  @version 18/09/18 12:21:26
 */
@RunWith(JUnit4.class)
public class CollinearTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new Collinear();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the two methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
        int expectedResult = 0;

        assertEquals("countCollinear failed with 3 empty arrays",       expectedResult, Collinear.countCollinear(new int[0], new int[0], new int[0]));
        assertEquals("countCollinearFast failed with 3 empty arrays", expectedResult, Collinear.countCollinearFast(new int[0], new int[0], new int[0]));
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleFalse()
    {
        int[] a3 = { 15 };
        int[] a2 = { 5 };
        int[] a1 = { 10 };

        int expectedResult = 0;

        assertEquals("countCollinear({10}, {5}, {15})",       expectedResult, Collinear.countCollinear(a1, a2, a3) );
        assertEquals("countCollinearFast({10}, {5}, {15})", expectedResult, Collinear.countCollinearFast(a1, a2, a3) );
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleTrue()
    {
        int[] a3 = { 15, 4 };       int[] a2 = { 5 };       int[] a1 = { 10, 15, 6 };

        int expectedResult = 1;

        assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")",     expectedResult, Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
    }


    // TODO: add more tests here. Each line of code and each decision in Collinear.java should
    // be executed at least once from at least one test.

    // BINARY SEARCH TESTS
    @Test
    public void testBinarySearchNoAns()
    {
        int[] test = {1,2,3,4,5,6,7,8,9,10};
        int testNumber = 11;
        boolean expectedResult = false;
        assertEquals("binarySearch("+ Arrays.toString(test) +", "+testNumber,expectedResult,Collinear.binarySearch(test,testNumber));

    }

    @Test
    public void testBinarySearchAnsIsFirst()
    {
        int[] test = {1,2,3,4,5,6,7,8,9,10};
        int testNumber = 1;
        boolean expectedResult = true;
        assertEquals("binarySearch("+ Arrays.toString(test) +", "+testNumber,expectedResult,Collinear.binarySearch(test,testNumber));
    }

    @Test
    public void testBinarySearchEmptyArray()
    {
        int[] test = new int[0];
        int testNumber = 0;
        boolean expectedResult = false;
        assertEquals("binarySearch("+ Arrays.toString(test) +", "+testNumber,expectedResult,Collinear.binarySearch(test,testNumber));
    }

    // other collinear tests.

    @Test
    public void testCollinearHorizontalLine()
    {
        int[] a= {5,-1};
        int[] b = {5,10};
        int[] c = {0,5};

        int expectedResult =1;

        assertEquals("countCollinear("+Arrays.toString(a)+","+Arrays.toString(b)+","+Arrays.toString(c)+")",expectedResult,Collinear.countCollinear(a,b,c));
        assertEquals("countCollinearFast("+Arrays.toString(a)+","+Arrays.toString(b)+","+Arrays.toString(c)+")",expectedResult,Collinear.countCollinearFast(a,b,c));
    }

    @Test
    public void testCollinearNegativeCoOrds()
    {
        int[] a= {-2};
        int[] b = {0};
        int[] c = {2};

        int expectedResult =1;

        assertEquals("countCollinear("+Arrays.toString(a)+","+Arrays.toString(b)+","+Arrays.toString(c)+")",expectedResult,Collinear.countCollinear(a,b,c));
        assertEquals("countCollinearFast("+Arrays.toString(a)+","+Arrays.toString(b)+","+Arrays.toString(c)+")",expectedResult,Collinear.countCollinearFast(a,b,c));
    }

    @Test
    public void testCollinearMultipleCoOrds()
    {
        int[] a= {-2,-3,1};
        int[] b = {0,2};
        int[] c = {2,3};

        int expectedResult =3;

        assertEquals("countCollinear("+Arrays.toString(a)+","+Arrays.toString(b)+","+Arrays.toString(c)+")",expectedResult,Collinear.countCollinear(a,b,c));
        assertEquals("countCollinearFast("+Arrays.toString(a)+","+Arrays.toString(b)+","+Arrays.toString(c)+")",expectedResult,Collinear.countCollinearFast(a,b,c));
    }






/*    public static void main(String[] args){
        In in;
        int[] a, b,c;
        Stopwatch stopwatch;
        double time;
        System.out.println("--- countCollinear ---");
        // Experiment isContained1 with input size 500
        in = new In("input-files/r05000-1.txt");
        a = in.readAllInts();
        in = new In("input-files/r05000-2.txt");
        b = in.readAllInts();
        in = new In("input-files/r05000-3.txt");
        c = in.readAllInts();
        stopwatch = new Stopwatch();
        System.out.println(Collinear.countCollinearFast(a,b,c));
        time = stopwatch.elapsedTime();
        System.out.println("When N = " + c.length + ", elapsed time = " + time + " sec.");
    }

 */
}

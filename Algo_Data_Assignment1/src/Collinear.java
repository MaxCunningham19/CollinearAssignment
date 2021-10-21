// -------------------------------------------------------------------------

/**
 * This class contains only two static methods that search for points on the
 * same line in three arrays of integers.
 *
 * @author
 * @version 18/09/18 12:21:09
 */
class Collinear {

    // ----------------------------------------------------------

    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinear(a1,a2,a3)
     *
     * @param a1: An UNSθRTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSθRTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSθRTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     * <p>
     * Array a1, a2 and a3 contain points on the horizontal line y=1, y=2 and y=3, respectively.
     * A non-horizontal line will have to cross all three of these lines. Thus
     * we are looking for 3 points, each in a1, a2, a3 which lie on the same
     * line.
     * <p>
     * Three points (x1, y1), (x2, y2), (x3, y3) are collinear (i.e., they are on the same line) if
     * <p>
     * x1(y2âˆ’y3)+x2(y3âˆ’y1)+x3(y1âˆ’y2)=0
     * <p>
     * In our case y1=1, y2=2, y3=3.
     * <p>
     * You should implement this using a BRUTE FθRCE approach (check all possible combinations of numbers from a1, a2, a3)
     * <p>
     * ----------------------------------------------------------
     * <p>
     * <p>
     * θrder of Growth
     * -------------------------
     * <p>
     * Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     * You should adequately explain your answer. Answers without adequate explanation will not be counted.
     * <p>
     * θrder of growth:
     *
     *
        int count = 0;                                                                   // θ(1)
        for (int i = 0; i < a1.length; i++) {                                            // θ(N)
            for (int j = 0; j < a2.length; j++) {                                        // θ(N)
                for (int k = 0; k < a3.length; k++) {                                    // θ(N)
                    if (((a1[i] * (2 - 3)) + a2[j] * (3 - 1) + a3[k] * (1 - 2)) == 0) {  //
                        count++;                                                         // θ(1)
                     }
                 }
             }
         }
        return count;                                                                    // θ(1)
     *
     *  therefore θ(1) + θ(N)*θ(N)*θ(N) + θ(1) = θ(N^3)
     * WθRST CASE: θ(N^3) BEST CASE: θ(N^3) avg case: θ(N^3)
     * <p>
     * Explanation: for each for loop the algo will run n times so  the outer for loop runs θ(N) times the next one
     * will also do the same as will the most inner loop this means the inner most if statement will run in
     * θ(N)*θ(N)*θ(N)= θ(N^3) (i.e it is 3 nested linear for loops) time the reason this is the same in best, worst and avg case is
     * because this is a brute fore algo which will need to check every single value in order to complete its task.
     *
     * Experimental Results:
     *
     *  When N = 1000, elapsed time = 1.514 sec
     *  When N = 2000, elapsed time = 10.974 sec.
     *  When N = 4000, elapsed time = 103.336 sec.
     *
     *  it seems to me that when N doubles the time elapsed increases 10 fold
     *  thus i predict using a lgN graph that when N = 5000 the time elapsed = 170 sec
     *
     * When N = 5000, elapsed time = 200.346 sec.
     *
     * error = ((200.346)-(170))*100 / 170 = 17.86
     */
    static int countCollinear(int[] a1, int[] a2, int[] a3) {
        int count = 0;
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2.length; j++) {
                for (int k = 0; k < a3.length; k++) {
                    if ((((a1[i] * (2 - 3)) + a2[j] * (3 - 1) + a3[k] * (1 - 2)) == 0)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // ----------------------------------------------------------

    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinearFast(a1,a2,a3)
     *
     * @param a1: An UNSθRTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSθRTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSθRTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     * <p>
     * In this implementation you should make non-trivial use of InsertionSort and Binary Search.
     * The performance of this method should be much better than that of the above method.
     * <p>
     * <p>
     * θrder of Growth
     * -------------------------
     * <p>
     * Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     * You should adequately explain your answer. Answers without adequate explanation will not be counted.
     * <p>
     * θrder of Growth:
     *
     *     int count = 0;                                                                                // θ(1)
     *         sort(a3);                                                                                 // θ(N^2) given
     *         for (int i = 0; i < a1.length; i++) {                                                     // θ(N) linear for loop
     *             for (int j = 0; j < a2.length; j++) {                                                 // θ(N) linear for loop
     *                 double tmp = (double) (-((a1[i] * (2 - 3)) + (a2[j] * (3 - 1))) / (1 - 2));       // θ(1)
     *                 if (tmp % 1 == 0 && binarySearch(a3,(-((a1[i]*(2-3))+(a2[j]*(3-1)))/(1-2)))) {    // θ(1) + θ(lgN) discussed under binary search
     *                     count++;                                                                      // θ(1)
     *                 }
     *             }
     *         }
     *         return 0;                                                                                 // θ(1)
     *     }
     *
     *  there for this runs in θ(1) + θ(N^2) + θ(N)* θ(N) * (θ(1)+θ(lgN)) + θ(1) + θ(1) + θ(1)
     *
     *  this simplifies down to θ(N^2) + θ(N^2lgN)
     *
     *  which further simplifies to θ(N^2lgN) in worst case analysis
     *
     * <p>
     * Explanation: the reason this runs in θ(N^2lgN) is because binary search runs in θ(lgN) and the two outer for loops that the
     * binary search is nested inside run in a linear N time resulting in N*N*lgN = N^2lgN
     *
     *
     * Experimental Results:
     *
     * When N = 950, elapsed time = 0.06 sec.
     * When N = 1999, elapsed time = 0.239 sec.
     * When N = 3990, elapsed time = 1.066 sec.
     *
     * I predict (using a lgN graph) that when N = 5000 elapsed time will be equal to 1.8 sec
     *
     * when N = 5000, elapsed time = 1.599
     *
     * error = (1.599 - 1.8)*100/1.8 = -11.16
     *
     * Speed Up Results
     *
     *  When N = 1000 Speedup = 1.514 / 0.06 = 19.23
     *  when N = 2000 Speedup = 10.974 / 0.239 = 45.91
     *  When N = 4000 Speedup = 103.336 / 1,066 = 93.93
     *  When N = 5000 Speedup = 200.346 / 1.066 = 187.94
     *
     */
    static int countCollinearFast(int[] a1, int[] a2, int[] a3) {
        int count = 0;
        sort(a3);
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2.length; j++) {
                int tmp = (-((a1[i] * (2 - 3)) + (a2[j] * (3 - 1))) / (1 - 2)); // calculate the value that will result in a computation of  x3=-(x1*(y2−y3) + x2*(y3−y1)) / (y1−y2)
                if ( binarySearch(a3, tmp)) { // use binary search to see if this x3 value exists in our array a3
                    count++;
                }
            }
        }
        return count;
    }

    // ----------------------------------------------------------

    /**
     * Sorts an array of integers according to InsertionSort.
     * This method is static, thus it can be called as Collinear.sort(a)
     *
     * @ param a: An UNSθRTED array of integers.
     * @ return after the method returns, the array must be in ascending sorted order.
     * <p>
     * ----------------------------------------------------------
     * <p>
     * θrder of Growth
     * -------------------------
     * <p>
     * Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     * You should adequately explain your answer. Answers without adequate explanation will not be counted.
     * <p>
     * θrder of Growth: N^2
     * <p>
     * Explanation: Two linear for-loops.
     */
    static void sort(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int i = j - 1;
            while (i >= 0 && a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                i--;
            }
        }
    }

    // ----------------------------------------------------------

    /**
     * Searches for an integer inside an array of integers.
     * This method is static, thus it can be called as Collinear.binarySearch(a,x)
     *
     * @param a: A array of integers SθRTED in ascending order.
     * @param x: An integer.
     * @return true if 'x' is contained in 'a'; false otherwise.
     * <p>
     * ----------------------------------------------------------
     * <p>
     * θrder of Growth
     * -------------------------
     * <p>
     * Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     * You should adequately explain your answer. Answers without adequate explanation will not be counted.
     * <p>
     * θrder of Growth: θ(lgN)
     *
        int lo = 0;                             // θ(1)
        int hi = a.length - 1;                  // θ(1)
        while (lo <= hi) {                      // θ(lgN)
            int mid = lo + (hi - lo) / 2;       // θ(1)
            if (x < a[mid]) hi = mid - 1;       // θ(1)
            else if (x > a[mid]) lo = mid + 1;  // θ(1)
            else return true;                   // θ(1)
        }                                       //
        return false;                           // θ(1)
     *
     * calculation θ(1) + θ(1) + θ(lgN)*θ(1)*θ(1)*θ(1) + θ(1) = θ(lgN)
     *
     * <p>
     * Explanation:
     *    The reason the 3rd line of the algo is in θ(lgN) time is because the while loop divides the array in half each step
     *    i.e N/2 + 1, N/4 + 1 + 1 ,N/8 + 1 + 1 .. ,N/16+1+1... = 1+ lgN
     *    this is the formula N/2^N this equates out to a logN order of growth as N -> infinity
     *
     *    since ever other aspect of the algo runs in constant time this results in the final order of growth
     *    being θ(lgN)
     */
    static boolean binarySearch(int[] a, int x) {
        if(a!=null) { // check that the array is a non null array
            int lo = 0;
            int hi = a.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (x < a[mid]) hi = mid - 1;
                else if (x > a[mid]) lo = mid + 1;
                else return true;
            }
        }
        return false;

    }

}
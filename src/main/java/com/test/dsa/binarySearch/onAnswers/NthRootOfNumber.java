package com.test.dsa.binarySearch.onAnswers;

/**
 * <a href="https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-nth-root-of-m">Link</a>
 * You are given 2 numbers n and m, the task is to find n√m (nth root of m). If the root is not integer then returns -1.
 * --
 * Input: n = 2, m = 9
 * Output: 3
 * Explanation: 3^2 = 9
 */
public class NthRootOfNumber {
    public static void main(String[] args) {
        System.out.println(nthRootOptimalApproach(1, 14));
    }

    /*
     * Nth root of m number
     *
     * TC - (m*n) if we use simple loops
     * If we use power exponential method then we can calculate power(n number with m times) in logN
     * in that case TC  - (m*log(n))
     * */
    public static int nthRoot(int n, int m) {
        int number = -1;

        for (int i = 1; i <= m; i++) {

            int nSquare = getNMultiply(i, n, m);
            if (nSquare == m) {
                number = i;
                break;
            } else if (nSquare > m) {
                break;
            }

        }

        return number;
    }

    public static int nthRootOptimalApproach(int n, int m) {
        int number = -1;

        int low = 1;
        int high = m;

        while (low <= high) {
            int mid = (low + high) / 2;

            final var nMultiply = getNMultiply(mid, n, m);
            if (nMultiply == m) {
                number = mid;
                break;
            } else if (nMultiply < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return number;
    }

    /*
    * Here if we are calculate  power of 10^9 it may cross the long limit to so here we can add one more condition
    * that if while multiply we are at place where it cross given number then only we can break there is not need to calculate
    * further
    * */
    private static int getNMultiply(final int x, final int n, final int m) {
        int result = 1;
//        for (int i = 0; i < n; i++) {
//            result = result * x;
//        }
        // Modified version

        for (int i = 0; i < n; i++) {
            result = result * x;
            if(result > m){
                break;
            }
        }
        return result;
    }
}

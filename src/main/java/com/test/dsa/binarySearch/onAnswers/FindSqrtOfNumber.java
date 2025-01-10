package com.test.dsa.binarySearch.onAnswers;

/**
 * Given a number N we need to find sqrt of that number if number is not perfect square then we need to return floor sqrt value
 * i.e sqrt(25) = 5  sqrt(30) = 5 sqrt(35) =  5 and sqrt(36) = 6
 * */
public class FindSqrtOfNumber {
    public static void main(String[] args) {
        System.out.println(floorSqrtInLogN(35));
    }

    /*
    * In brute force we can use simple for loop and if element's square is less than or equal to element then store that
    * otherwise break the loop as square of element is greater than number
    * */
    static int floorSqrt(int n) {
        int number = 0;
        for(int i = 1; i < n ; i++) {
            if((i*i) <= n) {
                number = i;
            } else {
                break;
            }
        }
        return number;
    }

    /*
    * In optimal solution we can use binary search and we will tool element from 1 to n and compare square of mid if it is less than
    * or equal to number then store it and move low = mid + 1 as there may be change for high value otherwise move high = mid-1
    * */
    static int floorSqrtInLogN(int n) {
        int number = 0;
       int low = 0;
       int high = n;

       while (low <= high) {
           int mid = (low + high)/2;

           if((mid * mid) <= n) {
               number = mid;
               low = mid + 1;
           } else {
               high = mid -1;
           }

       }
        return number;
    }
}

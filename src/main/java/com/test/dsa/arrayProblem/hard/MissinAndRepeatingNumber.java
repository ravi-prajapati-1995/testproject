package com.test.dsa.arrayProblem.hard;

import java.sql.Array;
import java.util.ArrayList;

/**
 * Given an unsorted array arr of positive integers. One number a from the set [1, 2,....,n] is missing
 * and one number b occurs twice in the array. Find numbers a and b.
 */
public class MissinAndRepeatingNumber {

    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 1, 1};
        System.out.println(findTwoElementBetterSolution(arr));
    }

    /**
     * We used here two loop and for upper i loop we loop from 1-n then we check if i == arr[j] in inner loop
     * and maintaining count , if count is Zero then that is missed number, if count is 2 that is repeating number
     * then at top level we have two variable missing and repeating
     * TC - O(n^2) for using nested loops
     * SC - O(1) Constant for not using extra space for processing
     */
    static ArrayList<Integer> findTwoElement(int arr[]) {
        final var integers = new ArrayList<Integer>();

        int missing = 0;
        int repeating = 0;
        for (int i = 1; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (i == arr[j]) {
                    count++;
                }
            }

            if (count == 0) {
                missing = i;
            }
            if (count == 2) {
                repeating = i;
            }

            if (missing != 0 && repeating != 0) {
                break;
            }

        }

        integers.add(missing);
        integers.add(repeating);
        return integers;
    }

    /**
     * Here we are maintaining a extra array with len + 1 array length because we are storing n natural numbers
     *
     * */
    static ArrayList<Integer> findTwoElementBetterSolution(int arr[]) {
        final var integers = new ArrayList<Integer>();
        int temp[] = new int[arr.length+1];
        int missing = 0;
        int repeating = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            temp[curr] = temp[curr] + 1;
        }

        for (int i = 1; i <= arr.length; i++) {
            if(temp[i] == 0) {
                missing = i;
            } else if(temp[i] == 2) {
                repeating = i;
            }
        }
        integers.add(repeating);
        integers.add(missing);
        return integers;
    }

    /**
     * Here assume missing number is X and repeating number is Y
     * So then we observe if we subtract s1 - sum1 = someNumber we only get x-y = someNumber
     * Same when we did square of s1^2 + sum2^2 = someNumber which is        x^2 - y^2 = someNumber1
     *
     * Using these equation we can drive formula
     * x^2 - y^2 = (x+y) * (x-y)  = someNumber
     * Here we can put value of x-y so we got value for x+y = someNewNumber
     *
     * so We have value for x+y and x-y
     *
     * */
    static ArrayList<Integer> findTwoElementOptimalSolution(int arr[]) {
        final var integers = new ArrayList<Integer>();
        long n = arr.length;
        long s1 = 0;
        long s2 = 0;
        for (final int j : arr) {
            s1 += j;
            s2 += (long) j * j;

        }


        long sum = (n*(n + 1)) / 2; // for getting sum of n natural numbers
        long sum2 = (n*(n + 1) * ((2*n)+1)) / 6; // for getting sum of squares of n natural numbers

        long firstValue = s1 - sum; // This is our x-y
        long secondValue = s2 - sum2; // this is x^2 - Y^2 which is  equals to (x+y)(x-y)

        secondValue = secondValue/firstValue; // x+y
        /*
        * x+y = secondValue
        * x-y = firstValue
        * -------------------------
        * 2x = secondValue + firstValue
        * ----------------------------
        * x = secondValue + firstValue/2
        * */
        long x = (firstValue + secondValue) / 2;
        long y = secondValue - x;


        integers.add(Long.valueOf(x).intValue());
        integers.add(Long.valueOf(y).intValue());
        return integers;
    }
}

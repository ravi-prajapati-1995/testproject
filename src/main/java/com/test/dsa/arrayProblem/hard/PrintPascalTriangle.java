package com.test.dsa.arrayProblem.hard;

import java.util.ArrayList;
import java.util.List;

public class PrintPascalTriangle {
    public static void main(String[] args) {
        final var generate = generateOptimal(6);
        System.out.println(generate);
//        final var integers = printNthRowOptimal(6);
//        System.out.println(integers);

    }

    /**
     * This function is can be used to get element at position: col of row: row, this is driven from formula
     * nCr = n!/(r! * (n-r)!)
     * By using this formula drived equation for pascal triangle
     * if we want to find 3rd element of 5th row that will be equal to (5*4*3)/(1*2*3)
     */
    public static int getNumberAtRowAndColInPascalTriangle(int row, int col) {
        int number = 1;
        for(int i = 0; i < col; i++) {
            number = (number * (row - i)) / (i+1);
        }
        return number;
    }

    /**
     * To get nth row we use our nCr formula function and we know that in pascal triangle at any row n there will be
     * n elements
     * So we loop from 0 to n and each time we call function with(n, i) i is index
     * Time Complexity: O(n2) : for using two loops
     * Space Complexity: O(n) : for storing result
     */
    public static List<Integer> printNthRow(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n;i++) {
            final var numberAtRowAndColInPascalTriangle = getNumberAtRowAndColInPascalTriangle(n-1, i);
            list.add(numberAtRowAndColInPascalTriangle);
        }
        return list;
    }
    /**
     * Below solution we drived from intuition:
     * 6th row elements : [1, 5, 10, 10, 5, 1]
     * if you observe every first and last element of any row will be 1
     * on 1st index value is (n-1)/1 = 5/1 on 2nd: (n-1)/1 * (n-2)/2 and so on
     * Time Complexity: O(n) : for using single loop
     * Space Complexity: O(n) : for storing result
     */
    public static List<Integer> printNthRowOptimal(int n) {
        int result = 1;
        List<Integer> list = new ArrayList<>();
        list.add(result);
        for(int i=1; i<n;i++) {
            result = result * (n - i);
            result = result / (i);
            list.add(result);
        }
        return list;
    }
    public static List<List<Integer>> generateOptimal(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            list.add(printNthRowOptimal(i));
        }
        return list;
    }


    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(1));
        if(numRows == 1)
            return list;

        for (int i = 1; i < numRows; i++) {
            List<Integer> pre = list.get(i-1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < i; j++) {
                curr.add(pre.get(j - 1) + pre.get(j));
            }
            curr.add(1);
            list.add(curr);
        }
        return list;
    }
}

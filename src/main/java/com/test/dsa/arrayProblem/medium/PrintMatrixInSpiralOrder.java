package com.test.dsa.arrayProblem.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an m x n matrix, return all elements of the matrix in spiral order.
    https://leetcode.com/problems/spiral-matrix/description/
 */
public class PrintMatrixInSpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5, 6},
                {20, 21, 22, 23, 24, 7},
                {19, 32, 33, 34, 25, 8},
                {18, 31, 36, 35, 26, 9},
                {17, 30, 29, 28, 27, 10},
                {16, 15, 14, 13, 12, 11}
        };

        int[][] aa = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        System.out.println(printInSpiralOrder(aa));
//        System.out.println(Arrays.deepToString(matrix));


    }

    private static List<Integer> printInSpiralOrder(final int[][] matrix) {
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>();

        while(left <= right && top <= bottom) {
            //for Left to right
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            //for top to bottom
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom) {
                //for right to left
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left <= right) {
                //for bottom to up
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        return list;
    }
}

package com.test.dsa.arrayProblem.medium;

import com.test.dsa.sorting.InsertionSort;

import java.util.Arrays;

import static com.test.dsa.sorting.InsertionSort.swap;
import static java.util.Collections.reverse;

public class RotateMatrixBy90Degree {
    /*  if matrix size if 3*3 then:
            a[0][0] -- always got to --> a[0][3]
            a[0][1] -- always got to --> a[1][3]
            a[0][2] -- always got to --> a[2][3]
      From above equation we can drive that a[0][0] always goes to a[j][size-1-i] and our brutforce is based on it
      we will take ans matrix with same size and using a[i][j] --> a[j][size-1-i]

     */
    public static void main(String[] args) {
        int[][] matrix = {{1,2, 3},{4,5, 6},{7, 8, 9}};
        rotateMatrixBy90OptimalSOl(matrix);
        System.out.println(Arrays.deepToString(matrix));


    }

    private static void rotateMatrixBy90(final int[][] matrix) {
        int size = matrix.length;
        int[][] ans = new int[size][size];
        int lastIndex = size - 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ans[j][lastIndex - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = ans[i][j];
            }
        }
    }

    /*
        To get optimal solution:
        1. Transpose a matrix
        2. Reverse each rows
     */
    private static void rotateMatrixBy90OptimalSOl(final int[][] matrix) {
        transposeMatrix(matrix);
        for (int i = 0; i < matrix.length ; i++) {
            reverse(matrix[i]);
        }
    }
        /**
            In transpose we will change rows to column and column to rows
            transpose of : [1, 2, 3]
                           [4, 5, 6]
                           [7, 8, 9]
            will be:
                           [1, 4, 7]
                           [2, 5, 8]
                           [3, 6, 9]

            Here we can carefully observe that every a[i][j] swap with a[j][i]
         we will run loop till n-2 rows because if we swap things above diagonal all values swapped like a[1][3] swapped with a[3][1]
         **/


        private static void transposeMatrix(final int[][] matrix) {
            int size = matrix.length;
            for (int i = 0; i < size - 1 ; i++) {
                for (int j = i+1; j < size; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

    private static void reverse(final int[] arr) {
        int p1 = 0;
        int p2 = arr.length-1;

        while(p1 < p2) {
            int temp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = temp;
            p1++;
            p2--;
        }
    }
}

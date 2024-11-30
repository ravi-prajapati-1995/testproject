package com.test.dsa.arrayProblem.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroesStriverOptimal(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void setZeroes(int[][] matrix) {
        var row = new ArrayList<Integer>();
        var col = new ArrayList<Integer>();
        for(int i = 0; i < matrix.length ; i++) {
            final var curRow = matrix[i];
            for (int j = 0; j< curRow.length  ; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for(int i = 0; i < row.size() ; i++) {
            final var curRow = row.get(i);
            for (int j = 0; j < matrix[0].length ; j++) {
                matrix[curRow][j] = 0;
            }

            final var curCol = col.get(i);
            for (int j = 0; j < matrix.length  ; j++) {
                matrix[j][curCol] = 0;
            }
        }

    }

    //Better approach
    public static void setZeroesStriver(int[][] matrix) {
        final var n = matrix.length;
        final var m = matrix[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        for(int i = 0; i < n; i++) {
            final var curRow = matrix[i];
            for (int j = 0; j< curRow.length  ; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                if(row[i] == 1 || col[j] == 1)
                    matrix[i][j] = 0;
            }
        }
    }

    //Best approach
    public static void setZeroesStriverOptimal(int[][] matrix) {
        final var rows = matrix.length;
        final var columns = matrix[0].length;
        int col1 = 1;
        // int row0 ---> matrix[0][...]
        // int col0 ---> matrix[...][0]
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j< columns  ; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // for first column
                    if(j != 0) {
                        matrix[0][j] = 0; // for first row
                    } else {
                        col1 = 0;
                    }
                }
            }
        }

        for(int i= 1; i<rows; i++) {
            for(int j=1;j<columns; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0) {
            for(int i =0; i <columns; i++ ) {
                matrix[0][i] = 0;
            }
        }

        if(col1 == 0) {
            for(int i =0; i <rows; i++ ) {
                matrix[i][0] = 0;
            }
        }

    }
}

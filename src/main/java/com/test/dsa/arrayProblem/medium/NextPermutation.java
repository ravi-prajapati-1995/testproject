package com.test.dsa.arrayProblem.medium;

import java.util.*;

import static com.test.dsa.sorting.InsertionSort.swap;

public class NextPermutation {
    /*
    *   For most optimal solution we need to keep in mind 3 things
    * 1. Longer prefix match where a[i] < a[i+1]
    * 2. find someone which is greater than 1 but smallest one so that you stay close
    * 3. Try to place remaining in sorted order
    */
    public static void main(String[] args) {
        int[] arr = {2,3,1};
        findNextPermunation(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] findNextPermunation(final int[] arr) {
        int breakPointIdx = -1;
       int n = arr.length;
        for(int i = n-2; i >= 0; i--) {
            if(arr[i] < arr[i+1]) {
                breakPointIdx = i;
                break;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = breakPointIdx + 1; i < arr.length ; i++) {
            list.add(arr[i]);
        }
        Collections.reverse(list);
        if(breakPointIdx == -1) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = list.get(i);
            }
        } else {
            final var iterator = list.iterator();
            int nextNonZero = 0;
            for (int i = breakPointIdx + 1; i < arr.length; i++) {
                arr[i] = iterator.next();
                if (arr[i] > 0 && nextNonZero == 0) {
                    nextNonZero = i;
                }
            }
            swap(arr, breakPointIdx, nextNonZero);
        }
        return null;
    }


}

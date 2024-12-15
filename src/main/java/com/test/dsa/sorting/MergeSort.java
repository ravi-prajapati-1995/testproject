package com.test.dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.test.dsa.sorting.InsertionSort.swap;

public class MergeSort {
    /*
        In merge sort we need to perform below steps:
        1. Divide given array in two parts
        2. Sort left part
        3. Sort right part
        4. Merge left and right
     */
    public static void main(String[] args) {
        int[] arr = {24, 18, 38, 43, 14, 40, 1, 54}; //3, 5, 6, 9, 2, 11, 7

        sortArray(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    private static void sortArray(final int[] arr, int low , final int high) {
        int mid = (low + high)/2;

        if (low  == high) {
            return;
        }
        // Sort left part
        sortArray(arr, low, mid);

        // Sort right part
        sortArray(arr, mid + 1, high);

        // Merge Left and Right
        mergeArray(arr, low, mid, high);
    }

    private static void mergeArray(final int[] arr,  int low, final int mid,  int high) {
        List<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid+1;
        /*
        * Took two pointer lets suppose we have:
        * [18, 24, 38, 43] from low to mid and [1, 14, 40]
        *
        * We arr looping here till our left pointer reaches mid or our right pointer reaches to high
        * And storing value in temporary list according to ascending order
        * */
        while(left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            } else {
                list.add(arr[right]);
                right++;
            }
        }

        //In case while loop completed and we have elements in left side so adding them
        while (left <= mid) {
            list.add(arr[left]);
            left++;
        }

        // If we have elements left in right side, only one will be executed at a time
        while(right <= high) {
            list.add(arr[right]);
            right++;
        }

        // adding back those value to original array
        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i - low);
        }
//        System.out.println(list);
    }


}

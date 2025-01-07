package com.test.dsa.binarySearch.on1DArray;

/**
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/">Link</a>
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * For example, the array nums = [0,1,4,4,5,6,7] might become:
 * [4,5,6,7,0,1,4] if it was rotated 4 times.
 * [0,1,4,4,5,6,7] if it was rotated 7 times.
 *
 * */
public class MinimumInSortedRotatedArrayWithDuplicates {
    public static void main(String[] args) {
        int[] arr = {0,1,2,4,5,6,7};
        System.out.println(find(arr));
    }

    //5,1,2,3,4
    public static int find(int[] arr) {
        int number = Integer.MAX_VALUE;
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            // when we have only one element or all the elements are same in the given array
            number = Math.min(arr[mid], number);
            if(arr[low] <= arr[high]) {
                number = Math.min(number, arr[low]);
                break;
            }

            if(arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            // if low is smaller than mid then left half is sorted
            if(arr[low] <= arr[mid] ) { // Why we need to give equal here:
                // Because if array has two elements then low and mid point to same element so need write <= here
                number = Math.min(arr[low], number);
                low = mid + 1;

            } else {
                number = Math.min(arr[mid], number);
                high = mid - 1;
            }
        }
        return number;
    }
}

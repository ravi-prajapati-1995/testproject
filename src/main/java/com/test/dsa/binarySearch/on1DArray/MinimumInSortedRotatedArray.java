package com.test.dsa.binarySearch.on1DArray;

/**
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/">Link</a></br>
 *
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 *
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 *
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * You must write an algorithm that runs in O(log n) time.
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 * */
public class MinimumInSortedRotatedArray {
    public static void main(String[] args) {
        int[] arr = {0,1,2,4,5,6,7};
        System.out.println(find(arr));
    }

    // [todo] Home Work to find the smallest element in sorted duplicate array rotated
    //5,1,2,3,4
    public static int find(int[] arr) {
        int number = Integer.MAX_VALUE;
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            /* For further optimization we can add one more check here when we have sorted half in which arr[low] <= arr[high]
            * Then we don't need to binary search again simply break because array is sorted
            * */
            if(arr[low] <= arr[high]) {
                number = Math.min(number, arr[low]);
                break;
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

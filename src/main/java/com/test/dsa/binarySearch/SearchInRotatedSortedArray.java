package com.test.dsa.binarySearch;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
 * or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        System.out.println(binarySearch(arr,7));
    }

    /*
    * To find the element in rotated sorted array we need to do follow steps
    * 1. Get the mid
    * 2. Identify the sorted half -> left/right
    *       To check left half sorted: arr[low] < arr[mid]
    *       To check right half sorted: arr[mid] < arr[high]
    * */

    //4,5,6,7,0,1,2
    public static int binarySearch(int[] arr, int target) {
        int number = -1;
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;


            if(arr[mid] == target) {
                return mid;
                // Left half is sorted
            } else if(arr[low] <= arr[mid]) {
                //If left half is sorted and element lies in between then eliminate the right half
                if(arr[low] <= target && arr[mid] >= target){
                    high = mid - 1;
                } else { // when right half is sorted but element doesn't exist in this half removing left half
                    low = mid + 1;
                }
                // right half is sorted
            } else {
                // Same way if right half is sorted then check if the given element is exist in between
                if((arr[mid] <= target && arr[high] >= target)){
                    low = mid + 1;
                } else { // when right half is sorted but element doesn't exist in this half removing left half
                    high = mid - 1;
                }
            }
        }
        return number;
    }
}

package com.test.dsa.binarySearch.on1DArray;

/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/">Link</a></br>
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 * <p>
 * Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
 * <p>
 * Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
 * <p>
 * You must decrease the overall operation steps as much as possible.
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 */
public class SearchInRotatedSortedArrayDuplicateElements {
    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 2, 2, 2, 2};
        System.out.println(binarySearch(arr, 5));
    }

    /*
     * To find the element in rotated sorted array we need to do follow steps
     * 1. Get the mid
     * 2. Identify the sorted half -> left/right
     *       To check left half sorted: arr[low] < arr[mid]
     *       To check right half sorted: arr[mid] < arr[high]
     *
     * While elements are duplicating then here we can face a problem like:
     * input: {2,5,6,2,2,2,2} x = 5  when we found half it will point to 2 (idx: 3) then both the element arr[low] == arr[mid] == arr[high]
     * for above input our previous code will give -1 as it goes to low = mid + 1 in first else condition
     *
     * To handle this condition we need to add one more if
     *  if we get arr[low] == arr[mid] == arr[high] trim down the search space by one left and right
     *
     * 1,0,1,1,1
     * */

    public static boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;


            if (arr[mid] == target) {
                return true;
                // Left half is sorted
            }

            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            if (arr[low] <= arr[mid]) {
                //If left half is sorted and element lies in between then eliminate the right half
                if (arr[low] <= target && arr[mid] >= target) {
                    high = mid - 1;
                } else { // when right half is sorted but element doesn't exist in this half removing left half
                    low = mid + 1;
                }
                // right half is sorted
            } else {
                // Same way if right half is sorted then check if the given element is exist in between
                if ((arr[mid] <= target && arr[high] >= target)) {
                    low = mid + 1;
                } else { // when right half is sorted but element doesn't exist in this half removing left half
                    high = mid - 1;
                }
            }
        }
        return false;
    }

}

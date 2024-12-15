package com.test.dsa.binarySearch;

/*
* Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search
* target in nums. If target exists, then return its index. Otherwise, return -1.
*
* In binary search we will take two variables low and high if the target element is equal to mid then return mid
* else if it is greater than mid then we will shift low to mid+1
* and if target element is less than mid then we will shift high to mid-1 as array is sorted
* int this way we can find element using binary search in O(logN) time complexity
* */
public class FindXUsingBinarySearch {
    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        System.out.println(iterativeSearch(arr, 9));
    }

    public static int search(int[] nums, int target) {
        return binarySearch1(nums, 0, nums.length - 1, target);
    }

    private static int binarySearch1(final int[] arr, final int left, final int right, final int target) {
        int mid = (left + right) / 2;
        if(target == arr[mid]) {
            return mid;
        } else if(left >= right) {
            return -1;
        } else if(target > arr[mid]) {
            return binarySearch1(arr, mid + 1, right, target);
        } else {
            return binarySearch1(arr, left, mid - 1, target);
        }
    }

    public static int iterativeSearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

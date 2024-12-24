package com.test.dsa.binarySearch;

import java.util.Arrays;

/*
* Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
* If target is not found in the array, return [-1, -1].
* You must write an algorithm with O(log n) runtime complexity.
* arr = [2, 4, 4, 8, 8, 8, 11, 13]
* x = 8 output = [3, 5]
* x = 10 output = [-1, -1]
* x = 11 output = [6, 6]
* */
public class FindFirstAndLastOccurence {

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange1(arr, 6)));
    }
    /*
    * By doing it using brute force solution we can take two variables firstIdx and lastIdx
    * if we found any element that is equal to target then
    * if check if firstIdx is -1 because we need to set it only first occurrence and update lastIdx to i
    * as there can be only one element that is matched with target value in our case  if target is 8
    * After that when we found any element then increase count of lastIdx
    * */
    static int[] searchRange(int[] nums, int target) {
        int firstIdx = -1;
        int lastIdx = -1;
        for(int i = 0; i< nums.length; i++) {
            if(nums[i] == target) {

                if(firstIdx == -1) {
                    firstIdx = i;
                }
                lastIdx = i;
            }
            if(nums[i] > target) {
                break; // As array is sorted
            }
        }
        return new int[]{firstIdx, lastIdx};
    }

    /*
    * To find the first and last occurrence we can use the upper and lower bound code;
    *
    * Lower Bound: It will find the smallest index which is greater than equal to the target element
    * Upper Bound: It will find the smallest index which is greater than the target element
    *
    * So from lower bound we will find the first occurrence and from upper bound we will find the last index as it will
    * give me element greater than given element so if I did upperBound -1 then it will give me last index
    *
    * Here we need to cover edge cases like if the target element is not present int the array
    *
    * According to striver  when we call lowerBound if it give us -1 then upper bound always give us -1
    *
    * We can do it another way in which we will find the first index and the last index using binary search
    * */
    static int[] searchRange1(int[] nums, int target) {
        final var lowerBound = lowerBound(nums, target);
        if(lowerBound == -1  || nums[lowerBound] != target) {
            return new int[]{-1, -1};
        }

        final var upperBound = upperBound(nums, target)-1;

        return new int[]{lowerBound, upperBound};
    }

    public static int lowerBound(int[] arr, int target) {
        int result = -1;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] >= target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static int upperBound(int[] arr, int target) {
        int result = arr.length;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] > target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }


}

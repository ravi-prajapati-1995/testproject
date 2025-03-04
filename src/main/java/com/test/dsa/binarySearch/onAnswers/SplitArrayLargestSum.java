package com.test.dsa.binarySearch.onAnswers;

import java.util.Arrays;

/**
 * Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of
 * any subarray is minimized.
 * Return the minimized largest sum of the split.
 * A subarray is a contiguous part of the array.
 * nums = [7,2,5,10,8], k = 2
 * Output: 18
 * Explanation: There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
* */
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,1,1,1};
        int k = 5;
        final var maxSum = splitArrayOptimal(nums, k);
        System.out.println(maxSum);

    }

    //nums = [7,2,5,10,8], k = 2
    public static int splitArray(int[] nums, int k) {

        final var maxElement = Arrays.stream(nums).max().getAsInt();
        final var sum = Arrays.stream(nums).reduce(0, Integer::sum);
        for (int i = maxElement; i <= sum; i++) {
            int arrayCount = getArrayCount(i, nums);
            if(arrayCount == k) {
                return i;
            }

            // Edge case when we have got array count less than k for minimum/starting element so we will return i only
            if(i == maxElement && arrayCount < k) {
                return i;
            }
        }
        return -1;
    }

    public static int splitArrayOptimal(int[] nums, int k) {

        final var maxElement = Arrays.stream(nums).max().getAsInt();
        final var sum = Arrays.stream(nums).reduce(0, Integer::sum);
        int low = maxElement;
        int high = sum;
        int result = -1;

        while(low <= high) {
            int mid = (low + high) / 2;

            int arrayCount = getArrayCount(mid, nums);

            //we we got array count greater than k then we need to increase low to mid+1
            if(arrayCount > k) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid -1;
            }

        }

        return result;
    }


    private static int getArrayCount(final int maxElement, final int[] nums) {
        int sum = 0;
        int arr = 1;

        for(int i = 0; i < nums.length; i++) {
            if(sum + nums[i] <= maxElement) {
                sum = sum + nums[i];
            } else {
                arr++;
                sum = nums[i];
            }
        }
        return arr;
    }
}

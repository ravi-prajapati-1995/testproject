package com.test.dsa.arrayProblem.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] ints = twoSumOptimal(nums, 6);
        System.out.println(Arrays.toString(ints));

    }

    /**
     * We used hashing in the better approach and did it O(n) complexity and O(n) space complexity because we are
     * using extra space
     */
    public static int[] twoSumBetterApproach(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{0, 1};
    }

    /**
     * In optimal solution we will do it O(n) time complexity without using extra space.
     * But for using this we need to sort the array first as we are going to use two pointer approach
     * Logic is based on:
     * We will maintain two pointer i = 0; and j = nums.length - 1;
     * if sum of these element is greater than target then we will move j by decreasing 1 as we know that we will find less element in left side of array
     * if sum is less than target then we will move i to i++
     *
     * <b>We can achieve it by using two pointer approach because if we sort the array we will lose index</b><br/>
     * We can solve problem that are required if there is any pair exist with particular sum
     */
    public static int[] twoSumOptimal(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[]{i, j};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }


        return new int[]{0, 1};
    }
}

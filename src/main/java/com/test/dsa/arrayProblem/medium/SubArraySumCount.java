package com.test.dsa.arrayProblem.medium;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumCount {
    public static void main(String[] args) {
        int arr[] = {1};
        int i = subArrayCountsBetter(arr, 0);
        System.out.println(i);
    }

    private static int subArrayCounts(final int[] nums, final int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j =i;j< nums.length;j++) {
                sum += nums[j];
                if(sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    /*
        Points to remember:
        1. For this problem we need to put element 0 that is has very significant
        2. We need to put value as count of number occurred

     */
    private static int subArrayCountsBetter(final int[] nums, final int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
       int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum - k;

            if (map.containsKey(rem)) {
                count = count + map.get(rem);
            }

            if(map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }

        return count;
    }
}

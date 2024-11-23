package com.test.dsa.arrayProblem.medium;

public class MaximumSumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, -3, 4, -1, -2, 1, 5, -3};
        final var i = maxSubArrayUsingKadanesAlgo(nums);
        System.out.println(i);

    }

    public static int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j< nums.length; j++) {
                sum = sum + nums[j];
                if(sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }

    public static int maxSubArrayUsingKadanesAlgo(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int left = 0;
        int right = 0;

        for(int i=0;i< nums.length; i++) {
            sum = sum + nums[i];
            if(sum ==0) {
                left = i;
            }
            if(sum > max ) {
                max = sum;
                right = i;
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        System.out.println(left + "\t" + right);
        return max;
    }

}

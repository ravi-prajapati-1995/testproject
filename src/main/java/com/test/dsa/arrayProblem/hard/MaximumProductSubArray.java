package com.test.dsa.arrayProblem.hard;

/**
 * Given an integer array nums, find a
 * subarray
 *  that has the largest product, and return the product.
 *
 *  Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * */
public class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] arr = {-2,0,-1};
        System.out.println(maxProductOptimal(arr));
    }

    public static int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentProduct = 1;
            for (int j = i; j < nums.length; j++) {
                currentProduct = currentProduct * nums[j];

                if(currentProduct > maxProduct) {
                    maxProduct = currentProduct;
                }
            }

        }

        return maxProduct;
    }
    /*
    * To get optimal solution we have following cases which kind of array we have:
    * 1. We can have array where all the number are positive, in that case multiplication of all will be max
    * 2. Where array can have even number of negative elements, in that case to multiplication of all will be max
    * 3. Where we can have odd numbers of negative elements, that case we need to check from prefix and suffix which will be larger
    * 4. Where we can have zeros in out elements, in that too we need to check from prefix and suffix
    *
    * So for drive this solution we will take two variable which one will calculate from front and second will from back
    * we need to take care when suffix or prefix will be zero we need to set it 1 again
    * */
    public static int maxProductOptimal(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }

            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length - i - 1];
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));

        }

        return maxProduct;
    }

}

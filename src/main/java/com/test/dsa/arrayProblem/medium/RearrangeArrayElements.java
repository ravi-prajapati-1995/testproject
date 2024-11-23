package com.test.dsa.arrayProblem.medium;

import java.util.Arrays;

public class RearrangeArrayElements {
    public static void main(String[] args) {
        int[] arr = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArrayOptimal(arr)));
    }


    public static int[] rearrangeArray(int[] nums) {
        int positive[] = new int[(nums.length / 2)];
        int pidx = 0;
        int negative[] = new int[(nums.length / 2)];
        int nidx = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                negative[nidx] = nums[i];
                nidx++;
            } else if(nums[i] > 0) {
                positive[pidx] = nums[i];
                pidx++;
            }
        }

        for (int i = 0; i < nums.length/2; i++) {
            nums[i * 2] = positive[i];
            nums[i * 2 + 1] = negative[i];
        }

        return nums;
    }

    public static int[] rearrangeArrayOptimal(int[] nums) {
        int result[] = new int[nums.length];
        int pIdx= 0;
        int nIdx = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                result[nIdx] = nums[i];
                nIdx += 2;
            } else if (nums[i] > 0) {
                result[pIdx] = nums[i];
                pIdx += 2;
            }
        }
        return result;
    }
}

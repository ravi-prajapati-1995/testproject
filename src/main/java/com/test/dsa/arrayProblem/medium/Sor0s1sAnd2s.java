package com.test.dsa.arrayProblem.medium;

import java.util.Arrays;

import static com.test.dsa.sorting.InsertionSort.swap;

public class Sor0s1sAnd2s {
    public static void main(String[] args) {
        int[] nums = {2, 1,0, 1, 1, 1, 0, 0};
        sortColorsStriverMethod(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zeroCount++;
            } else if(nums[i] ==1) {
                oneCount++;
            } else {
                twoCount++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(zeroCount != 0) {
                nums[i] = 0;
                zeroCount--;
            } else if(oneCount != 0 ) {
                nums[i] = 1;
                oneCount--;
            } else {
                nums[i] = 2;
                twoCount--;
            }
        }
    }

    public static void sortColorsStriverMethod(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high) {

            if(nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

}

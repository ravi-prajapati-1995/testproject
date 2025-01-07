package com.test.dsa.binarySearch.on1DArray;

/*
*https://leetcode.com/problems/find-peak-element/description/
*
* A Peak element X at index i is the element that is greater than from arr[i-1] and arr[i+1]
*
* */
public class FindPeakElement {

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(findPeakElementOptimal(arr));
    }

    public static int findPeakElement(int[] nums) {
        if(nums.length == 1 || nums[0] > nums[1]) {
            return 0;
        }
        int len = nums.length -1;
        if(nums[len] > nums[len - 1]) {
            return len;
        }

        for(int i = 1; i < len; i++) {
            if(nums[i] > nums[i -1] && nums[i] > nums[i+1]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * In peak element problem we will have array like it will increase till point then it start decreasing
     * So if we are at left side of peak then left element(mid-1) will be less than to current element(mid)
     * if we are on right side of peak then left element(mid-1) will be greater than current element
     * */
    public static int findPeakElementOptimal(int[] nums) {
        if(nums.length == 1 || nums[0] > nums[1]) {
            return 0;
        }
        int len = nums.length -1;
        if(nums[len] > nums[len - 1]) {
            return len;
        }

        int low = 1;
        int high = len - 1;
        while(low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }
}

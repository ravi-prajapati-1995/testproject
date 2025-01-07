package com.test.dsa.binarySearch.on1DArray;

/*
* Given a sorted array of distinct integers and a target value, return the index if the target is found.
* If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
* */
public class SearchInsert {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        System.out.println(searchInsert(arr,2));
    }

    public static int searchInsert(int[] nums, int target) {
        int number = -1;
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            //When we found any element that is equal to less than k than there can
            if(nums[mid] >= target) {
                number = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return number;
    }
}



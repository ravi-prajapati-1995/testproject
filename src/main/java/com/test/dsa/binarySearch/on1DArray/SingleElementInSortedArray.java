package com.test.dsa.binarySearch.on1DArray;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once.
 *
 * Return the single element that appears only once.
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * */
public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] arrr = {1,1,2};
        System.out.println(singleNonDuplicateOptimal(arrr));
    }

    /**
    * Below Brute force solution is came from if a element is duplicate it may have before element as same element
     * or next element as same element as array is sorted
     * if both element previous and next element is not equal to current element then that will be unique as in question
     * given that only one element will be single
    * */
    public static int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        // a element will be duplicate if either it +1 or -1 will be the same, in case no one is same as i then return that element
        for (int i = 0; i < nums.length ; i++) {
            if(i == 0) { // when index is 0 we will compare with next element only
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            } else if (i == nums.length - 1) { //when we at last index we will compare with previous element only
                if (nums[i] != nums[i - 1]) {
                    return nums[i];
                }
            } else { // in between element we will compare with next and previous element if both are not equal to that then return it is unique
                if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }

    public static int singleNonDuplicate2(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        // a element will be duplicate if either it +1 or -1 will be the same, in case no one is same as i then return that element
        for (int i = 1; i < nums.length - 1 ; i++) {
                if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                    return nums[i];
                }
        }
        return 0;
    }

    /**
     * This approach came from the observation that: [1,1,2,3,3,4,4,8,8]
     * Before single element every element has pair like (odd, even) and
     * after single element every element has pair (even, odd)
     * So we can say that if we are at odd index and pair made with even then element is in RIGHT Half
     * and if pair made even, odd then single element is in left half
     *
     * {1,1,2,3,3,4,4,8,8}
     * We will eliminate the part which don't have the element
     * If we are solving this problem using binary search we need to take care about 0th and n-1th index every time
     * because of 0th there will no 0-1 index and for n-1 there will be no nth index gives OutOfIndexException
     * So to handle these scenario we can trim down our search space from low = 1 and high = nums.length - 2
     *
     * And we will write edge cases in starting only like if array only have 1 element also for 1st and last index we
     * added edge cases see below
    * */
    public static int singleNonDuplicateOptimal(int[] nums) {

        if(nums.length == 1) {
            return nums[0];
        }
        if(nums[0] != nums[1]) {
            return nums[0];
        }
        if(nums[nums.length-1] != nums[nums.length-2]) {
            return nums[nums.length-1];
        }
        int low = 1;
        int high = nums.length -2;
        while(low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {// meaning mid element don't have pair return it
                return nums[mid];
            }
            /*
            * Here if we  are at even index and next element is same  then we are left side of single element move low=mid+1
            * if we are at odd index and previous element is also same then also we are at left side of single element
            * */
            if((mid%2 == 0 && nums[mid] == nums[mid + 1]) ||
                    (mid%2 == 1 && nums[mid] == nums[mid-1] )) { //we are on even index  and next element is same then we need to eliminatee
                    low = mid + 1;
            } else { //  we are at odd index
                    high = mid - 1;
            }
        }
        return -1;
    }
}

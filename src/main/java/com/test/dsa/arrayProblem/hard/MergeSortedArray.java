package com.test.dsa.arrayProblem.hard;

import com.test.dsa.sorting.InsertionSort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be
 * merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 5, 6};
        mergeWithoutExtraArrayUsingShellSortingStriverArray(nums1, 3, nums2, 3);
    }

    //    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        if (n == 0) {
            return;
        }

        while (j < n && i < nums1.length) {
            if (nums1[i] == 0) {
                break;
            }

            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                int last = n - 1;
                while (i <= last) {
                    nums1[last + 1] = nums1[last];
                    last--;
                }

                nums1[i] = nums2[j];

                i++;
                j++;
            }
        }

        if (j <= m) {
            for (int x = i; x < nums1.length; x++) {
                nums1[x] = nums2[j];
                j++;
            }
        }

    }

    /*
     Below solution is using extra temp array, Here we follow the steps:
     1. Create a temp array with length of m and n
     2. Maintain two pointers i for nums1 and j for nums2
     3. Then iterate array till i< m && j < n if we found nums1 element less then add that and increase i++ otherwise add nums2
     element and do j++;
     4. In last process for the remaining element in case we have array of diff size then element will be remained so process them
     5. Then put element back from temp array to nums1 in our case
     */
    public static void mergeBruteForce(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];

        int i = 0;
        int j = 0;
        int idx = 0;

        while (i < m && j < n) {

            if (nums1[i] > nums2[j]) {
                temp[idx] = nums2[j];
                j++;
            } else {
                temp[idx] = nums1[i];
                i++;
            }
            idx++;
        }
        // when first array will have more element than 2nd so in upper loop in 1st array there will be items that needs to be processed
        for (int x = i; x < m; x++) {
            temp[idx] = nums1[x];
            idx++;
        }
        //When second array have more element than 1st array
        for (int y = j; y < n; y++) {
            temp[idx] = nums2[y];
            idx++;
        }

        //Here we need to first add elements in 1st till its size
        for (int x = 0; x < nums1.length; x++) {
            nums1[x] = temp[x];
        }
        // when 1st array fully feel then we need to process elements for 2nd array
        //        for (int y = 0; y < n; y++) {
        //            nums2[y] = temp[m+y];
        //        }

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));

    }

    /*
     * For Optimal - 1 I need to take two pointer
     * 1st array pointer(i) will be from last index and 2nd array pointer(j) will from first index
     * I.e  Input: nums1 = [1,2,3], m = 3, nums2 = [2,5,6], n = 3
     * i= 2 and j=0; We will compare nums1[i] with nums2[j]
     * if nums[i] > nums[j] we need to swap elements
     * else
     * */
    public static void mergeWithoutExtraArray(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < n - 1) {
            if (nums1[i] > nums2[j]) {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);


        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

    public static void mergeWithoutExtraArray1(int[] nums1, int m, int[] nums2, int n) {
        int i = m;
        for (int x = 0; x < n; x++) {
            nums1[i + x] = nums2[x];
        }

        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * Input: [8, 5, 3, 9, 2, 6, 4, 7]; n = 8
     * In shell shorting we will take a gap and compare the items on gap formula for gap is:
     * for first time gap = Math.ceil(n/2) and after that
     * gap = Math.ceil(gap/2); after each iteration we will decrease the gap by one till gap become 1
     * We will keep 2 pointers one(i) will be on most left and another(j) will be gap in given example
     * i = 0; j = Math.ceil(n/2) then for first iteration i will be on 8(0th index) and j will be on 2(4th index) 0+4
     * if nums[i] > nums[j] swap it
     * Do it till right will cross the length
     */
    public static void mergeWithoutExtraArrayUsingShellSorting(int[] nums1, int m, int[] nums2, int n) {
        int i = m;
        for (int x = 0; x < n; x++) {
            nums1[i + x] = nums2[x];
        }

        int gap = (int) Math.ceil((double) nums1.length / 2);
        while (gap >= 0) {

            int left = 0;
            int right = gap;

            while (right < nums1.length) {
                if (nums1[left] > nums1[right]) {
                    int temp = nums1[left];
                    nums1[left] = nums1[right];
                    nums1[right] = temp;
                }

                left++;
                right++;
            }

            if (gap == 1) {
                break;
            }
            gap = (int) Math.ceil((double) gap / 2);
        }

        System.out.println(Arrays.toString(nums1));
    }

    public static void mergeWithoutExtraArrayUsingShellSortingStriverArray(int[] nums1, int m, int[] nums2, int n) {
        int i = m;
        for (int x = 0; x < n; x++) {
            nums1[i + x] = nums2[x];
        }

        int len = (m + n);
        int gap = (len / 2);
        while (gap >= 0) {

            int left = 0;
            int right = gap;

            while (right < nums1.length) {
                if (nums1[left] > nums1[right]) {
                    int temp = nums1[left];
                    nums1[left] = nums1[right];
                    nums1[right] = temp;
                }

                left++;
                right++;
            }

            if (gap == 1) {
                break;
            }
            gap = (int) Math.ceil((double) gap / 2);
        }

        System.out.println(Arrays.toString(nums1));
    }
}

package com.test.dsa.arrayProblem.hard;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {
    public static void main(String[] args) {
        int[] arr = {2,4,3,5,1};
        System.out.println(mergeSort(arr, 0, arr.length-1));
    }

    private static int reversePairs(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                long n1 = nums[i];
                long n2 = (2L * nums[j]);
                if(n1 > n2) {
                    count++;
                }
            }
        }

        return count;
    }

    static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if(low == high)
            return count;
        int mid = (low + high) / 2;

        count += mergeSort(arr, low, mid); // sort left
        count += mergeSort(arr, mid+1, high); // sort right
        count += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return count;
    }

    // We need to do this extra step to count the pairs
    private static int countPairs(final int[] arr, final int low, final int mid, final int high) {
        int count = 0;
        int right = mid + 1;
        /*
        * Here take example we have array: [40, 25, 19, 12, 9, 6, 2] with length 7 and while merge sort we reached
        * at a step where we have 0 to 3 idx(Left) = [12, 19, 25, 40]
        * and from 4(mid+1) to high(right part) = [2, 6, 9]
        * we will loop left items from low to mid we will pick 12 which is > 2*2(arr[right]) and we will move the
        * right pointer in count we will 1,
        *  then so on with 19 which is > 2*6 and 2*6 we will again add 2
        * */
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long)arr[i] > 2 * (long)arr[right]) {
                right++;
            }
            count = count + (right - (mid + 1));
        }

        return count;
    }

    private static void merge(final int[] arr, final int low, final int mid, final int high) {
        List<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while(left <= mid && right <= high) {


            if (arr[left] > arr[right]) {
                list.add(arr[right]);
                right++;
            } else {
                list.add(arr[left]);
                left++;
            }
        }

        while(left <= mid) {
            list.add(arr[left]);
            left++;
        }

        while(right <= high) {
            list.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i - low);
        }
    }
}

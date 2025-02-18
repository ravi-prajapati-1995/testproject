package com.test.dsa.binarySearch.onAnswers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int k = 2;
        System.out.println(findKthPositiveOptimal(arr, k));
    }

    /**
     * i.e arr [5, 6, 10, 12] and k =4, mean we need to find 4th missing number and it will be 4 in our case because
     * array itself starts from 5
     *
     * what if k=6 then our answer will be 8 so from this we can analyze that
     *
     * // [TODO] will review later
     * @param arr
     * @param k
     * @return
     */
    public static int findKthPositiveStriver(int[] arr, int k) {

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= k) {
                k++;
            } else {
                break;
            }
        }

        return k;
    }

    /**
     * Here we converting array in list and check if each element exist if not exist
     * then increase counter of count
     * We iterate while loop while(count<k) and then return curr which is Kth missing number
     *
     * @param arr
     * @param k
     * @return
     */
    public static int findKthPositiveGFG(int[] arr, int k) {
        final List<Integer> list = Arrays.stream(arr).boxed().toList();
        int count = 0;
        int curr = 0;

        while(count < k) {
            curr++;

            if(!list.contains(curr)) {
                count++;
            }
        }
        return curr;
    }

    public static int findKthPositive(int[] arr, int k) {
        final List<Integer> list = Arrays.stream(arr).boxed().toList();

        int currElement = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if(!list.contains(i)) {
                currElement++;
            }

            if (currElement == k) {
                return i;
            }
        }

        return -1;
    }

    /**
     * arr = [2,3,4,7,11], k = 5
     * Here we can observ that at any index lets say we are at 3rd index at 7 to find the number of missing numbers
     * till 7 it will be 7(actual Number) - (3(index) + 1) = 3 nos are missing before 7
     * in same way for  11 at index 4 so to get how many numbers are missing before it 11 - (4+1) = 6
     * 1. Our first task  is to  find the nearby indexes in which our answer is exist
     * @param arr
     * @param k
     * @return
     */
    public static int findKthPositiveOptimal(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            final var missingNoTillMid = arr[mid] - (mid + 1);
            if(missingNoTillMid < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k + high + 1;
    }
}

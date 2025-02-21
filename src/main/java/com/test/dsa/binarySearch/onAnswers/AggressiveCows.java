package com.test.dsa.binarySearch.onAnswers;

import java.util.Arrays;

/**
 * <a href="https://www.spoj.com/problems/AGGRCOW/">Here</a>
 * We have given an array of stall and count of cows we need to place cows such that minimum distance between two cows
 * will be max.
 * This problem is type of Min(Max) and Max(Min) it is different from previous problems
 * arr = [ 0, 3, 4, 7, 9, 10], cows = 4
 * Here we need to place cows in such a way that gap between any 2 cows can be maximum
 *
 */
public class AggressiveCows {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 4, 9};
        int cows = 3;

        int gap = getMaxGap(arr, cows);
        System.out.println(gap);

    }

    /*
    * Here we will iterate from 1 to max gap between two cows, as we sorted the array and maximum gap can be arr[last]- arr[0]
    *
    * and for each item we will calculate if it is possible max gap between two cows
    * if gap can possible we will store it in result otherwise we will break the loop
    * */
    private static int getMaxGap(final int[] arr, final int cows) {
        //Array will be unsorted so sorting array
        Arrays.sort(arr);
        int result = -1;
        for(int i = 1; i<= (arr[arr.length -1]- arr[0]); i++) {
            final var canCowHaveGap = canCowHaveGap(i, arr, cows);

            if (canCowHaveGap) {
                result = i;
            } else {
                break;
            }
        }
        return result;
    }

    private static int getMaxGapOptimal(final int[] arr, final int cows) {
        //Array will be unsorted so sorting array
        Arrays.sort(arr);
        int result = -1;
        int low = 1;
        int high = (arr[arr.length - 1] - arr[0]);

        while(low <= high) {
            int mid = (low + high) / 2;
            final var canCowHaveGap = canCowHaveGap(mid, arr, cows);
            if(canCowHaveGap) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    /*
    *  int[] arr = {0, 3, 4, 7, 9, 10};
        int cows = 4;
     * Here we are starting from 1st index and placing 1st cow on the 0th index, and then iterating over the arr
     * and check if this index is greater than equal to minDistance between two cows, if ye we will move the preCow to current
     * index and iterate
     * if not then we keep moving till then we don't have sufficient gap
    * */
    private static boolean canCowHaveGap(final int minDistance, final int[] arr, final int cows) {
       int cowAdded = 1;
       int previousCow = 0;
        for (int i = 1; i < arr.length; i++) {
            final var consecutiveDistance = arr[i] - arr[previousCow];
            if (consecutiveDistance >= minDistance) {
                cowAdded++;
                previousCow = i;
            }

            if(cowAdded == cows) {
                return true;
            }
        }

        return false;
    }
}

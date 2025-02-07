package com.test.dsa.binarySearch.onAnswers;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 The guards have gone and will come back in h hours.

 Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas
 from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during
 this hour.

 Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

 Return the minimum integer k such that she can eat all the bananas within h hours.
 Input: piles = [3,6,7,11], h = 8
 Output: 4
 */
public class KokoEatingBanna_M {
    public static void main(String[] args) {
        int[] piles = {805306368,805306368,805306368};
        int h = 1000000000;

        System.out.println(minEatingSpeedOptimal(piles, h));

    }

    /**
     * Brute Force:
     * Here we will use two loops upper loop will iterate over the piles
     * 1. we will sort the array as piles array is unsorted
     * 2. loop over each element and find time taken for eat all piles at speed i
     * 3. if total time taken is less than <= h the return the answer
     *  TC -> O(max(piles[])*N)
     *  max(piles[])-- maximum element
     *  n - total numbers of piles
     * */
    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        final var maxEatPerHour = piles[piles.length - 1];

        for (int i = 1; i <= maxEatPerHour; i++) {
            final var timeTaken = totalTimeAtSpeed(piles, i);
            if (timeTaken <= h) {
                return i;
            }
        }
        return 0;
    }

    /**
     * Optimal:
     * In optimal solution we know that result can be from 1 to max(piles[])
     * so we will binary search from 1 and max(piles[]) for each mid we will calculate time if time if greater than h
     * then move the left = mid+1 otherwise store the result and move right = mid-1 as we want to get minimum number of
     * banana that can be eaten per hour
     * */
    public static int minEatingSpeedOptimal(int[] piles, int h) {
        final var maxEatPerHour = Arrays.stream(piles).max().getAsInt();
        int result = maxEatPerHour;
        int low = 1;
        int high = maxEatPerHour;

        while(low <= high) {
            int mid = (low + high) / 2;
            final var timeTaken = totalTimeAtSpeed(piles, mid);
            if(timeTaken <= h ) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    /**
     * This function will return total time taken to eat all piles at speed s
     * 7 banana and speed 3 then in decimal 2.33 and koko will eat 7 banana in 3hr so taking ciel here
     * */
    static long totalTimeAtSpeed(int[] piles, int speed) {
        long totalTime = 0;
        for (int i = 0; i < piles.length; i++) {
            final int timeTaken = (int) Math.ceil((double) piles[i] / speed);
            totalTime = totalTime + timeTaken;
        }

        return totalTime;
    }
}

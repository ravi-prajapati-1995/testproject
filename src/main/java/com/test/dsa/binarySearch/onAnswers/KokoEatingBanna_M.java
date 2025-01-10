package com.test.dsa.binarySearch.onAnswers;

import java.util.Arrays;
import java.util.OptionalInt;

public class KokoEatingBanna_M {
    public static void main(String[] args) {
        int[] piles = {805306368,805306368,805306368};
        int h = 1000000000;

        System.out.println(minEatingSpeedOptimal(piles, h));

    }

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

    static long totalTimeAtSpeed(int[] piles, int speed) {
        long totalTime = 0;
        for (int i = 0; i < piles.length; i++) {
            final int timeTaken = (int) Math.ceil((double) piles[i] / speed);
            totalTime = totalTime + timeTaken;
        }

        return totalTime;
    }
}

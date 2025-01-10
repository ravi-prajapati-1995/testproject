package com.test.dsa.binarySearch.onAnswers;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
 * ou are given an integer array bloomDay, an integer m and an integer k.
 *
 * You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
 *
 * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
 *
 * Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
 * Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
 * Output: 3
 * Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
 * We need 3 bouquets each should contain 1 flower.
 * After day 1: [x, _, _, _, _]   // we can only make one bouquet.
 * After day 2: [x, _, _, _, x]   // we can only make two bouquets.
 * After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
 *-
 * -
 * Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
 * Output: 12
 * Explanation: We need 2 bouquets each should have 3 flowers.
 * Here is the garden after the 7 and 12 days:
 * After day 7: [x, x, x, x, _, x, x]
 * We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
 * After day 12: [x, x, x, x, x, x, x]
 * It is obvious that we can make two bouquets in different ways.
 * -
 * Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
 * Output: -1
* */
public class MinNoOfDayToMakeMBouque {
    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        int numberOfBouquet = 3;
        int noOfFlowers = 1;

        System.out.println(getMinOptimal(bloomDay, numberOfBouquet, noOfFlowers));

    }

    //[7,7,7,7,12,7,7]
    public static int getMin(int[] bloomDay, int numberOfBouquet, int noOfFlowers) {
        if((numberOfBouquet * noOfFlowers) > bloomDay.length){
            return -1;
        }

        final var minBloomDay = Arrays.stream(bloomDay).min().getAsInt();
        final var maxBloomDay = Arrays.stream(bloomDay).max().getAsInt();

        for(int i = minBloomDay; i <= maxBloomDay; i++) {
            final var bouquetCount = getBouquetCount(bloomDay, numberOfBouquet, noOfFlowers, i);
            if(bouquetCount >= numberOfBouquet) {
                return i;
            }
        }

        return -1;
    }

    public static int getMinOptimal(int[] bloomDay, int numberOfBouquet, int noOfFlowers) {
        if((numberOfBouquet * noOfFlowers) > bloomDay.length){
            return -1;
        }

        int result = -1;
         var low = Arrays.stream(bloomDay).min().getAsInt();
         var high = Arrays.stream(bloomDay).max().getAsInt();
         while(low <= high) {
             int mid = (low + high) / 2;
             final var bouquetCount = getBouquetCount(bloomDay, numberOfBouquet, noOfFlowers, mid);
             if(bouquetCount >=  numberOfBouquet) {
                 result = mid;
                 high = mid -1;
             } else {
                 low = mid + 1;
             }
         }

        return result;
    }

    //[7,7,7,7,12,7,7]
    private static int getBouquetCount(
            final int[] bloomDay, final int numberOfBouquet, final int noOfFlowers, final int day
    ) {
        int count = 0;
        int adjacentFlowers = 0;
        for (final int j : bloomDay) {
            if (j <= day) {
                adjacentFlowers++;
            } else {
                int bouquetCanCreate = adjacentFlowers / noOfFlowers;
                count += bouquetCanCreate;
                adjacentFlowers = 0;
            }
        }

        int bouquetCanCreate = adjacentFlowers / noOfFlowers;
        count += bouquetCanCreate;
        return count;
    }
}

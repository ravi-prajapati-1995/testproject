package com.test.dsa.binarySearch.onAnswers;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 *Find the Smallest Divisor Given a Threshold
 * nums = [1,2,5,9], threshold = 6
 *  Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
 *  Lets take Divisor 3
 *  1/3 = (0.33) = 1 -- taking ceil value
 *  2/3 = (0.66) = 1
 *  5/3 = (1.66) = 2
 *  9/3 = (3) =    3
 *
 *  Total sum of 1+1+2+3 = 7 which is greater than 6  lets do same with 4
 */
public class FindSmallestDivisor {
    public static void main(String[] args) {
        int[] nums = {44,22,33,11,1};
        int threshold = 5;

        System.out.println(smallestDivisorOptimal(threshold, nums));

    }

    private static int smallestDivisor(final int threshold, final int[] nums) {
        final var max = Arrays.stream(nums).max().getAsInt();
        for(int i = 1; i <= max; i++) {
            final var sumWhenDivisor = getSumWhenDivisor(nums, i);
            if(sumWhenDivisor <= threshold) {
                return i;
            }
        }
        return -1;
    }


    private static int smallestDivisorOptimal(final int threshold, final int[] nums) {
        final var max = Arrays.stream(nums).max().getAsInt();
        int low = 1;
        int high = max;
        int result = -1;

        while(low <= high) {
            int mid = (low + high) / 2;
            final var sumWhenDivisor = getSumWhenDivisor(nums, mid);
            if(sumWhenDivisor <= threshold) {
                result = mid;
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    /*
    * This will return sum of ceil values of all Quotient
    * 1/3 = ceil(0.33) -> 1
    * 2/3 = ceil(0.66) -> 1
    * */
    private static int getSumWhenDivisor(final int[] nums, final int i) {
        int sum = 0;
        for(int num : nums) {
            sum += (int) Math.ceil((float) num / i);
        }
        return sum;
    }
}

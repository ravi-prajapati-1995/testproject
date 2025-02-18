package com.test.dsa.binarySearch.onAnswers;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/">here</a>
 * A conveyor belt has packages that must be shipped from one port to another within days days.
 *
 * The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
 *
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.
 * weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * */
public class ShipPackagesWithinDDays {

    public static void main(String[] args) {
        int[] weights  = {10,50,100,100,50,100,100,100};
        int days = 5;
        System.out.println( shipWithinDaysOptimal(weights, days));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int maxWeight = Arrays.stream(weights).max().getAsInt();
        int totalWeight = Arrays.stream(weights).sum();
        for (int i = maxWeight; i <= totalWeight; i++) {
            final var daysForCapacity = getDaysForCapacity(weights, i);
            if(daysForCapacity!= -1 && daysForCapacity <= days) {
                return i;
            }
        }

        return -1;
    }

    public static int shipWithinDaysOptimal(int[] weights, int days) {
        int maxWeight = Arrays.stream(weights).max().getAsInt();
        int totalWeight = Arrays.stream(weights).sum();
        int low = maxWeight;
        int high = totalWeight;
        int result = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            final var daysForCapacity = getDaysForCapacity(weights, mid);
            if(daysForCapacity <= days) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return result;
    }

    /**
     * Here we will get days taken to move all weights at particular capacity.
     * if load is greater than capacity then it will be counted in next day and we will reinitialize load with remaining weight
     * @param weights
     * @param capacity
     * @return
     */
    private static int getDaysForCapacity(final int[] weights, final int capacity) {
        //1,2,3,1,1}  cap = 3
        int days = 1;
        int load = 0;
        for(int weight: weights) {
            load = load + weight;
            if(load  > capacity) {
                days += 1;
                load = weight;
            }
        }
        return  days;
    }
}

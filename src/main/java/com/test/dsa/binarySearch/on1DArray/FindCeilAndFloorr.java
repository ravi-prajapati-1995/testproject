package com.test.dsa.binarySearch.on1DArray;

import java.util.Arrays;

/*
* Given an unsorted array arr[] of integers and an integer x, find the floor and ceiling of x in arr[].

Floor of x is the largest element which is smaller than or equal to x. Floor of x doesn’t exist if x is smaller than smallest element of arr[].
Ceil of x is the smallest element which is greater than or equal to x. Ceil of x doesn’t exist if x is greater than greatest element of arr[].

* */
public class FindCeilAndFloorr {
    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 9, 6, 5, 5, 6};
        System.out.println(Arrays.toString(getFloorAndCeil1(7, arr)));
    }

    /*
    * This approach have time complexity of O(NLogN) - for Sorting  and O(LogN) + O(LogN) for finding floor and ceil using binary search
    * */
    static int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);

        return new int[]{findFloor(arr, x), findCeil(arr, x)};
    }

    /*
    *   Time complexity for this is only O(N) which is quite better than O(NLogN) we are using only one loop
    *   and maintaining two variables floor and ceil if we found element which is less than K we will check if the
    *   it is greater than existing value of floor, otherwise we will check for greater element if it is less than the
    *   last ceil element
     */
    static int[] getFloorAndCeil1(int x, int[] arr) {
        int floor = -1;
        int ceil = Integer.MAX_VALUE;

        for(int i: arr) {
            // For finding floor element
            if(i == x) {
                floor = Math.max(floor, i);
                ceil = i;
            } else if(i < x ) {
                floor = Math.max(floor, i);
            } else {
                ceil = Math.min(ceil, i);
            }
        }

        if(ceil == Integer.MAX_VALUE) {
            ceil = -1;
        }
        return new int[]{floor, ceil};
    }

    /*
    * Ceil of x is the smallest element which is greater than or equal to x.
    * Ceil of x doesn’t exist if x is greater than greatest element of arr[].
    * */
    static int findCeil(int[] arr, int k) {
        int number = -1;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= k) {
                number = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return number;
    }

    /*
    * Floor of x is the largest element which is smaller than or equal to x. Floor of x doesn’t exist if x is smaller than smallest element of arr[].
    */
    static int findFloor(int[] arr, int k) {
        int number = -1;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= k) {
                number =  arr[mid];
                low = mid + 1;
            } else {

                high = mid - 1;
            }
        }

        return number;
    }
}

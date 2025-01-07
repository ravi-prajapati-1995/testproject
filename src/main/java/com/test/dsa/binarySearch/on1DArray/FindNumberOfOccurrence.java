package com.test.dsa.binarySearch.on1DArray;

/*
https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1
* Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[].
*  Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
* Output: 4
* Explanation: target = 2 occurs 4 times in the given array so the output is 4.
 * */
public class FindNumberOfOccurrence {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3, 5, 5, 6};
        System.out.println(countFreqWithOutLUBound(arr, 6));
    }

   static int countFreq(int[] arr, int target) {

       int lowerBound = FindFirstAndLastOccurence.lowerBound(arr, target);
       if(lowerBound == -1 || arr[lowerBound] != target)
           return 0;

       int upperBound = FindFirstAndLastOccurence.upperBound(arr, target) ;

        return upperBound - lowerBound;
    }

    static int countFreqWithOutLUBound(int[] arr, int target) {

        final var firstOccurrence = getFirstOccurrence(arr, target);
        if(firstOccurrence == -1)
            return 0;
        final var lastOccurrence = getLastOccurrence(arr, target);
        return lastOccurrence - firstOccurrence + 1;
    }

    private static int getFirstOccurrence(final int[] arr, final int target) {
        int result = -1;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }


        return result;
    }
    private static int getLastOccurrence(final int[] arr, final int target) {
        int result = -1;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }


        return result;
    }

}

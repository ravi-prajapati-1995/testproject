package com.test.dsa.binarySearch.on1DArray;

import java.util.Arrays;
import java.util.List;
/**
 * <a href="https://www.geeksforgeeks.org/problems/rotation4723/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=rotation">Link</a>
 * Given an increasing sorted rotated array arr of distinct integers. The array is right-rotated k times. Find the value of k.
 * Let's suppose we have an array arr = [2, 4, 6, 9], so if we rotate it by 2 times so that it will look like this:
 * After 1st Rotation : [9, 2, 4, 6]
 * After 2nd Rotation : [6, 9, 2, 4]
 * */
public class FindHowManyTimeArrayRotated {

    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        System.out.println(findMin(Arrays.stream(arr).boxed().toList()));
    }

    public static int findMin(List<Integer> arr) {

        int number = Integer.MAX_VALUE;
        int low = 0;
        int high = arr.size() - 1;
        int idx = 0;

        while(low <= high) {
            int mid = (low + high) / 2;

            /* For further optimization we can add one more check here when we have sorted half in which arr[low] <= arr[high]
             * Then we don't need to binary search again simply break because array is sorted
             * */
            if(arr.get(low) <= arr.get(high)) {
                if(arr.get(low) < number) {
                    idx = low;
                }
                break;
            }

            // if low is smaller than mid then left half is sorted
            if(arr.get(low) <= arr.get(mid)) { // Why we need to give equal here:
                // Because if array has two elements then low and mid point to same element so need write <= here
                if(arr.get(low) < number) {
                    number = arr.get(low);
                    idx = low;
                }
                low = mid + 1;

            } else {
                if(arr.get(mid) < number) {
                    number = arr.get(mid);
                    idx = mid;
                }
                high = mid - 1;
            }
        }

        return idx;
    }
}

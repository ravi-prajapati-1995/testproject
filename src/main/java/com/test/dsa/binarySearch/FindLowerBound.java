package com.test.dsa.binarySearch;

/*
* Given a sorted array arr[] (with unique elements) and an integer k, find the index (0-based) of the largest
*  element in arr[] that is less than or equal to k. This element is called the "floor" of k.
*  If such an element does not exist, return -1.
*  Need to return index not actual nuber on that position
*
* */
public class FindLowerBound {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 11, 12, 19};
        System.out.println(findFloor(arr,8));
    }

    /*
    * As array is sorted we can apply binary search here which has time complexity = O(logN)
    * In this lower bound algo if we find any element that is greater than equal to target, then it can be our lower bound
    * So setting that element as lower bound and moving high = mid-1
    * if mid is less than target element then that element should be in right side so moving low = mid+1
    * in else case we will jus move the high to mid-1
    *
    * We can do upper bound problem just updating the if condition
    * */
    static int findFloor(int[] arr, int k) {
            int number = -1;
            int low = 0;
            int high = arr.length - 1;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (arr[mid] >= k) {
                    number = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return number;
    }
}

package com.test.dsa.arrayProblem.hard;


import java.util.ArrayList;
import java.util.List;

/*
* Given an array of integers arr[]. Find the Inversion Count in the array.
Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.
*
* arr[] = [2, 4, 1, 3, 5]
* Output: 3
* Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
* */
public class CountInversion {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        System.out.println(inversionCountOptimal(arr));
    }

    static int inversionCount(int arr[]) {
       int count = 0;
       int len = arr.length;

       for(int i =0;i < len; i++) {
           for(int j = i+1; j< arr.length; j++) {
               if(arr[i] > arr[j]) {
                   count++;
               }
           }
       }

       return count;
    }

    /*
    * To drive optimal solution lets assume we have two sorted array:
    * arr1 = [2, 3, 5, 6] and arr2 = [2, 2, 4, 4, 8]
    *
    * Lets assume we have two sorted array we need to make inversion pair with left (arr1) and right (arr2)
    * So in 1st step we will pick 2 from left array and 2 from right
    * Here arr2[0] from arr2 is not greater than arr1[0]
    * So move right++ arr1 reached at 1 and arr2 at 0
    * then compare arr1[1] with arr2[0], It is greater we know that all the element of arr1's right is greater than
    * arr1[1](2) because array is sorted, so we can say that
    * if arr1[1] > arr2[0] -- then it will be greater than all other elements that present in arr1[1]'s right then add those in count
    * then we increase count of arr2 and repeat the steps
    *
    * On the above formula, we will drive solution using merge sort
    * when we are merging array then we will check if arr[left] > arr[right] then increase count
    *
    * */
    static int inversionCountOptimal(int[] arr) {
       return mergeSort(arr, 0, arr.length - 1);
    }

    static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if(low == high)
            return count;
        int mid = (low + high) / 2;

        count += mergeSort(arr, low, mid); // sort left
        count += mergeSort(arr, mid+1, high); // sort right
        count += mergeAndCount(arr, low, mid, high);
        return count;
    }

    private static int mergeAndCount(final int[] arr, final int low, final int mid, final int high) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while(left <= mid && right <= high) {

            if (arr[left] > arr[right]) {
                count = count + (mid - left + 1);
                list.add(arr[right]);
                right++;
            } else {
                list.add(arr[left]);
                left++;
            }
        }

        while(left <= mid) {
            list.add(arr[left]);
            left++;
        }

        while(right <= high) {
            list.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i - low);
        }

        return count;
    }
}

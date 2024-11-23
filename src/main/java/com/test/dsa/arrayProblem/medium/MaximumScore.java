package com.test.dsa.arrayProblem.medium;

public class MaximumScore {
    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 5, 6};
        System.out.println(pairWithMaxSum(arr));
    }
    public static int pairWithMaxSum(int arr[]) {
        // Your code goes here
        int left = 0;
        int right = 1;
        int max = 0;

        while(right < arr.length ) {
            int sum = arr[left] + arr[right];

            if(sum > max) {
                max = sum;
            }

            right++;
            left++;
        }

        return max;
    }
}

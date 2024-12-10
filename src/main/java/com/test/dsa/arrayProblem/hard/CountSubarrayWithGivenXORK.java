package com.test.dsa.arrayProblem.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a array ie:arr = {4, 2, 2, 6, 4} and k = 6 , We need to find out number of subarray with XOR 6
 * i.e [4, 2] ---> 4^2 = 6,
 * [2, 2, 6]--->  2^2 = 0 XOR of similar elements is always 0
 * [6] 0^6 = 6 --> if we XOR any element with 0 we will get same element
 * [4, 2, 2, 6, 4] --> 4 ^ 4 = 0, 2 ^ 2 = 0 then 6 remained
 *
 * For finding optimal solution for this we need to keep in mind that if from 0 to 3rd index XOR is XR
 * and from 1st to 3rd XOR is K and XOR of 0th element is X then:
 * X = XR ^ K
 * */
public class CountSubarrayWithGivenXORK {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        System.out.println(solveOpt(arr, 6));
    }

    public static int solve(int[] arr, int k) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int xor = 0;
            for (int j = i; j < arr.length; j++) {
                xor = xor ^ arr[j];
                if(xor == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public static int solveOpt(int[] arr, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Because if we have arr [4] with single element and we want to find out arr[i] ^ k = 0
        int xor = 0;

        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
            int x = xor ^ k;
            if(map.containsKey(x)) {
                count = count + map.get(x);
            }

            if(map.containsKey(xor)) {
                map.put(xor, map.get(xor) + 1);
            } else {
                map.put(xor, 1);
            }
        }
        return count;
    }
}

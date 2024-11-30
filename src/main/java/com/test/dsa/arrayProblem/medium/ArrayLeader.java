package com.test.dsa.arrayProblem.medium;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeader {
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        System.out.println(leadersOptimal(arr));
    }

    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        final var integers = new ArrayList<Integer>();
        integers.add(arr[arr.length - 1]);

        for(int i = arr.length -2 ; i >= 0; i--) {

            boolean isLeader = true;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] > arr[i]) {
                    isLeader = false;
                    break;
                }
            }
            if(isLeader) {
                integers.add(arr[i]);
            }
        }
        Collections.reverse(integers);
        return integers;
    }


    static ArrayList<Integer> leadersOptimal(int arr[]) {
        // code here
        final var integers = new ArrayList<Integer>();
        integers.add(arr[arr.length - 1]);
        int maxOnRight = arr[arr.length - 1];
        for(int i = arr.length -2 ; i >= 0; i--) {
            if(arr[i] > maxOnRight) {
                integers.add(arr[i]);
                maxOnRight = arr[i];
            }
        }
        Collections.reverse(integers);
        return integers;
    }
}

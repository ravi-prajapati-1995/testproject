package com.test.dsa.recursion;

import java.util.*;

public class PrintAllPermutationsOfArrayOrString {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        List<Integer> set = new ArrayList<>();
        printAllPermuntation(arr, set);
    }

    private static void printAllPermuntation(final int[] arr, final List<Integer> set) {

        if(set.size() == arr.length) {
            System.out.println(set);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(!set.contains(arr[i])) {
                set.add(arr[i]);
                printAllPermuntation(arr, set);
                set.remove(Integer.valueOf(arr[i]));
            }
        }
    }

    private static void printfor(final int i, final Map<Integer, Boolean> map) {
    }
}

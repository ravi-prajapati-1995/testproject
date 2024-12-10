package com.test.dsa.arrayProblem.hard;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWith0Sum {
    public static void main(String[] args) {
        int[] arr = {-42, 12 ,20 ,15, 31, -4, 0, 15};
        System.out.println(maxLen(arr));
    }

    static int maxLen(int arr[]) {
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            sum = sum + arr[i];
          /*  Here we are directly assigning i+1 to maxLen because if we got sum 0 while traversing then no array other
            array greater than this length can be existed till now
            */
            if(sum == 0) {
                maxLen = i + 1;
            } else {
                /*
                    Here we checking if the sum already existed of not before or not i.e if 3 already existed at
                    2nd index and now we are on 7th index again we got sum 3 then from 7th to 2nd index there are
                    elements that will be zero in sum
                * */
                if(map.containsKey(sum)) {
                    maxLen = Math.max(maxLen, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }

        return maxLen;
    }
}

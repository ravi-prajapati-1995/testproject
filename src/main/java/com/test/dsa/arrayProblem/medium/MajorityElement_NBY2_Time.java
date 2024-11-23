package com.test.dsa.arrayProblem.medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_NBY2_Time {
    public static void main(String[] args) {
        int[] nums = {6,5,5};
        System.out.println(majorityElementStrivereMethod(nums));
    }

    public static int majorityElement(final int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final var num = nums[i];
            if(map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num,1);
            }
        }

        int maxElement = 0;
        int maxCount = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() > maxCount) {
                maxElement = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return maxElement;
    }

    // By applying Moore's voting algo
    //Since we know a element should present more that n/2 times
    public static int majorityElementStrivereMethod(final int[] nums) {
        int element = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count == 0) {
                element = nums[i];
                count++;
            } else {
                if (nums[i] == element) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        return element;
    }
}

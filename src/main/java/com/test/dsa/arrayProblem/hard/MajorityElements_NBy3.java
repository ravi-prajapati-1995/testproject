package com.test.dsa.arrayProblem.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElements_NBy3 {
    public static void main(String[] args) {
        int[] nums = {6,5,5};
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final var currElement = nums[i];
            if(map.containsKey(currElement)) {
                map.put(currElement, map.get(currElement) + 1);
            } else {
                map.put(currElement, 1);
            }
        }

        int i = nums.length / 3;
        for (var entry : map.entrySet()) {
            if(entry.getKey() >= i) {
                list.add(entry.getValue());
            }
        }

        return list.stream().sorted().toList();
    }
}

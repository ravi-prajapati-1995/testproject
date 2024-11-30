package com.test.dsa.arrayProblem.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(longestConsecutiveOptimal(arr));
    }

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int count = 1;
        int maxCount = 1;
        int pre = nums[0];

        for(int i=1;i<nums.length;i++){

            if(nums[i] == pre + 1) {
                pre = nums[i];
                count++;
            } else if(nums[i] == pre) {
                // do nothing
            } else {
                count = 1;
                pre = nums[i];
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static int longestConsecutiveOptimal(int[] nums) {
        var count = 1;
        var maxCount = 0;
        final var set = new HashSet<Integer>(nums.length);
        for(int i: nums) {
            set.add(i);
        }
        final var iterator = set.iterator();
        while (iterator.hasNext()) {
            count = 1;
            var value = iterator.next();
            if(!set.contains(value-1)){
                while(set.contains(value + 1)) {
                    value++;
                    count++;
                }
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }

}

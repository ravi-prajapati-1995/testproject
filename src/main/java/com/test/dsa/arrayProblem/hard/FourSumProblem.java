package com.test.dsa.arrayProblem.hard;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class FourSumProblem {
    public static void main(String[] args) {
        int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
        System.out.println(fourSumOptimal(nums, -9));
    }

    public static List<List<Integer>> fourSumBruteForce(int[] nums, int target) {
        Set<List<Integer>> output = new HashSet<>();

        final var n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n;l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] ==target) {
                            final var list = Stream.of(nums[i], nums[j], nums[k], nums[l]).sorted().toList();
                                output.add(list);
                        }
                    }
                }
            }
        }
        return output.stream().toList();
    }

    public static List<List<Integer>> fourSumBetter(int[] nums, int target) {
        Set<List<Integer>> output = new HashSet<>();

        final var n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                Set<Long> set = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long rem = (long)target - ((long)nums[i] + (long)nums[j] + (long)nums[k]);
                    if (set.contains(rem)) {
                        final var list = Stream.of(nums[i], nums[j], nums[k], rem).map(Number::intValue).sorted().toList();
                        output.add(list);
                    }
                    set.add((long)nums[k]);
                }
            }
        }
        return output.stream().toList();
    }

    /**
     * It is based on two pointer approach we will sort array first then use two pointer approach
     * {1,0,-1,0,-2,2}
     */
    public static List<List<Integer>> fourSumOptimal(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> output = new HashSet<>();

        final var n = nums.length;
        for (int i = 0; i < n ; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j < n ; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    long sum = ((long) nums[i] + (long) nums[j] + nums[k] + nums[l]);

                    if (sum == target) {
                        final var list = Stream.of(nums[i], nums[j], nums[k], nums[l]).map(Number::intValue).sorted()
                                .toList();
                        output.add(list);
                        k++;
                        l--;
                        while(k < l && nums[k] == nums[k+1]) k++;
                        while(l > k && nums[l] == nums[l-1]) l--;
                    } else if (sum > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return output.stream().toList();
    }
}

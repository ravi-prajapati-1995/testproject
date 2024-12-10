package com.test.dsa.arrayProblem.hard;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

public class Three3Sum {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum1OptionOtimal(nums));
        System.out.println(LocalDateTime.now());
    }

    /**
     * Brute Force Solution: We used 3 loops and count
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        final var n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        final var list = Stream.of(nums[i], nums[j], nums[k]).sorted().toList();
                        if (!output.contains(list))
                            output.add(list);
                    }
                }
            }
        }
        return output;
    }

    /**
     * For finding 3 sum we can use this is optimal solution because we are using here
     * Time Complexity: O(n2) for using 2 nested for loops somewhere about n2 because nested loop run always with
     * more than 1 element  + O(1) for searching and adding element in hashset
     * Space Complexity: O(n) for storing set elements in inner loop + O(n2) worst case
     */
    //{-1,0,1,2,-1,-4}
    public static List<List<Integer>> threeSum1OptionBetterSolution(int[] nums) {
        Set<List<Integer>> output = new HashSet<>();

        final var n = nums.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int elementNeedToFind = -(nums[i] + nums[j]);
                if (set.contains(elementNeedToFind)) {
                    final var list = Stream.of(nums[i], nums[j], elementNeedToFind).sorted().toList();
                    output.add(list);
                }

                set.add(nums[j]);

            }
        }
        return output.stream().toList();
    }


    /**
     * For better solution time complexity is okay O(n2) but we can further reduce space complexity
     * {-1,0,1,2,-1,-4} -> {-4, -1, -1, 0, 1, 2}
     * Time Complexity: O(nlogn) -- For sorting the array + O(n2) we are using one for loop and while loop in it so it
     * will be nearly so time complexity will be: O(n2)
     *
     * Space Complexity: O(n) for storing the output as we are not using any other space
     */
    public static List<List<Integer>> threeSum1OptionOtimal(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> output = new HashSet<>();
        final var n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = i+1;
            int k = n-1;
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            while (k > j) {
                final var sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    output.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(nums[j] == nums[j+1]) j++;
                    while(nums[k] == nums[k-1]) k--;
                } else if(sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return output.stream().toList();
    }

}

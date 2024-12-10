package com.test.dsa.arrayProblem.hard;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElements_NBy3 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,3, 2, 1, 1, 3, 4, 5, 6, 7, 8, 9, 9};
        System.out.println(LocalDateTime.now());
        System.out.println(majorityElement(nums));
        System.out.println(LocalDateTime.now());
    }

    /**
     * We will maintain a map that will take key as element and value as count of element and if count is equal to the
     * count at which we can add element than we will add it in list
     * TC: O(n) -> because searching and adding in map will be O(1)
     * SC: O(n) -> worst case when all elements are unique
    **/
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int cout = (nums.length / 3)  ;
        for (int i = 0; i < nums.length; i++) {
            final var currElement = nums[i];
            if(map.containsKey(currElement)) {
                final var value = map.get(currElement) + 1;
                map.put(currElement, value);
            } else {
                map.put(currElement, 1);
            }

            if(map.get(currElement) == cout) {
                list.add(currElement);
            }
        }

        return list;
    }

    /**
     * In this question we need to find out element which appears in array more than n/3 times.</br>
     * <b>Observation: for any length of array there will be only max 2 element.</b></br>
     * i.e n = 26;  26/3 = 8,</br> so we need to find out element which appears more than 8 times mean element should appears
     * 9 or more time if element appears 9 + 9 +9 = 27, so there will be only 2 elements at max that can present more
     * than n/3 times
     *This solution is derived from n/2 problem here we will maintain two variables
     * @param nums
     * @return
     */
    public static List<Integer> majorityElementOptimal(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int ele1 = 0;
        int ele2 = 0;
        int count1 = 0; //{2,2,1,3}
        int count2 = 0;

        for(int i: nums) {
            if(count1 == 0 && i != ele2) {
                ele1 = i;
                count1++;
            } else if(count2 == 0 && i != ele1) {
                ele2 = i;
                count2++;
            } else if(i == ele1) {
                count1++;
            } else if (i == ele2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;

        for (int i : nums) {
            if(i == ele1)
                count1++;
            else if(i == ele2)
                count2++;
        }

        int shouldCount = nums.length / 3 ;
        if(count1 > shouldCount) {
            list.add(ele1);
        }
        if(count2 > shouldCount) {
            list.add(ele2);
        }

        return list;
    }
}

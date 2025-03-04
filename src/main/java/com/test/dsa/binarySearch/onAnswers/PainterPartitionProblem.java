package com.test.dsa.binarySearch.onAnswers;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array/list of length ‘n’, where the array/list represents the boards and each element of the given
 * array/list represents the length of each board. Some ‘k’ numbers of painters are available to paint these boards.
 * Consider that each unit of a board takes 1 unit of time to paint.</br>
 * You are supposed to return the area of the minimum time to get this job done of painting all the ‘n’ boards under a
 * constraint that any painter will only paint the continuous sections of boards.
 * Example :
 * Input: arr = [2, 1, 5, 6, 2, 3], k = 2
 * Output: 11
 */
public class PainterPartitionProblem {
    public static void main(String[] args) {
        var nums = new ArrayList<>(List.of(2, 1, 5, 6, 2, 3));
        int k = 2;
        final var maxSum = findLargestMinDistanceOptimal(nums, k);
        System.out.println(maxSum);
    }

    /*
    * It is the same problem split Array largest sum, we can use the same logic
    * */
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        final int max = boards.stream().max(Integer::compareTo).get();
        final int sum = boards.stream().reduce(0, Integer::sum);

        for (int i = max; i <= sum; i++) {
            final var paintersTimeTaken = getPaintersRequired(i, boards);
            if (paintersTimeTaken == k) {
                return i;
            }

            if (i == max && paintersTimeTaken < k) {
                return i;
            }
        }
        return -1;
    }

    public static int findLargestMinDistanceOptimal(ArrayList<Integer> boards, int k) {
        int low = boards.stream().max(Integer::compareTo).get();
        int high = boards.stream().reduce(0, Integer::sum);
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            final var paintersRequired = getPaintersRequired(mid, boards);

            //if painters are greater than given painter we need to increase maxBoards
            if(paintersRequired > k) {
                low = mid + 1;
            } else {
                result = low;
                high = mid - 1;

            }
        }
        return result;
    }

    private static int getPaintersRequired(final int maxBoards, final ArrayList<Integer> boards) {
        int painters = 1;
        int boardsCount = 0;

        for (int board : boards) {

            if (boardsCount + board <= maxBoards) {
                boardsCount += board;
            } else {
                painters++;
                boardsCount = board;
            }
        }

        return painters;
    }
}

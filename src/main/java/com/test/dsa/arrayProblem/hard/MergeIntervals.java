package com.test.dsa.arrayProblem.hard;

import java.util.*;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 */
public class MergeIntervals {
    public static void main(String[] args) {
        final var arr = new int[][]{{1, 3}, {2, 6}, {8, 9}, {9, 11}, {8, 10}, {2, 4}, {15, 18}, {16, 17}};
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] intervals1 = {{2, 3}, {5, 5}, {2, 2}, {3, 4}, {3, 4}};
        int[][] intervals2 = {{0, 0}, {1, 2}, {5, 5}, {2, 4}, {3, 3}, {5, 6}, {5, 6}, {4, 6}, {0, 0}, {1, 2}, {0, 2}, {4, 5}};

        final var merge = mergeOptimal(arr);
        System.out.println(Arrays.deepToString(merge));
    }


    // example input: [[1, 3], [2, 4], [2, 6], [8, 9], [8, 10], [9, 11], [15, 18], [16, 17]]
    /*
     * TC: O(NLogN) for sorting array + O(2N) As we are touching each element twice
     * */
    public static int[][] merge(int[][] intervals) {
        LinkedList<List<Integer>> list = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // Compare first elements
            } else {
                return Integer.compare(a[1], b[1]); // Compare second elements
            }
        });

        System.out.println(Arrays.deepToString(intervals));
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            /*
                For i = 0 we added in list [1,6] from internal loop if we are at [2,4] then we will compare that if
                end(which is 4) is less than 6, if yes then we don't need to do anything
            * */
            if (i > 0 && end <= list.getLast().get(1)) {
                continue;
            }
            //            [[1, 3], [2, 4], [2, 6], [8, 9], [8, 10], [9, 11], [15, 18], [16, 17]]
            for (int j = i + 1; j < intervals.length; j++) {
                //                Here we need to compare 0th 3 with 1st 2 if it is less than from or equal to end then need to replace end with max from
                //                Because imagine you are at [15, 18] and comparing with [16, 17] 16 <= 18 but we can't directly make end = 17 because 15-18 already there so doing max
                //                otherwise break because we reach at [8, 9] so don't need to process
                if (intervals[j][0] <= end) {
                    end = Math.max(intervals[j][1], end);
                } else {
                    break;
                }
            }
            list.add(List.of(start, end));
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i).get(0);
            result[i][1] = list.get(i).get(1);
        }
        return result;
    }

    /*
    * We can use only one loop and iterate it over all the elements steps:
    * 1. sort the array
    * 2. Set first element in list
    * 3. Loop from  1 to n
    * 4. If element is overlapping mean last element end element is greater than current element starting then it is overlapping,
    *    then replace last items end with max(lastEnd, currEnd)
    * 5. else add current start and end element to the list
    * */
    public static int[][] mergeOptimal(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList();

        merged.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            final var last = merged.getLast();

            if(start <= last[1]) {
                last[1] = Math.max(end, last[1]);
            } else {
                merged.add(new int[]{start, end});
            }

        }
        return merged.toArray(new int[merged.size()][2]);
    }

    public int[][] merge1(int[][] intervals) {
        //sort first in case of array sequence is not connected
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList();

        for(int[] x : intervals) {
            if(merged.isEmpty() || merged.get(merged.size() -1)[1] < x[0]) {  //first of no overlap case
                merged.add(x);
            } else {    //there is overlap
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], x[1] );
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

}

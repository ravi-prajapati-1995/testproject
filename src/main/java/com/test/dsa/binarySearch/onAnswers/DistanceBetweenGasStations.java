package com.test.dsa.binarySearch.onAnswers;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <a href="https://www.geeksforgeeks.org/problems/minimize-max-distance-to-gas-station/0">here</a>
 * We have a horizontal number line. On that number line, we have gas stations at positions stations[0], stations[1], ..., stations[n-1],
 * where n is the size of the stations array. Now, we add k more gas stations so that d, the maximum distance between adjacent gas stations,
 * is minimized. We have to find the smallest possible value of d. Find the answer exactly to 2 decimal places.
 * Note: stations is in a strictly increasing order.
 * <p>
 * n = 4
 * stations[] = [1, 13, 17, 23]
 * k = 5
 * We need to place 4 station in between so that maximum distance between stations can be minimized
 * Current max gap is 12 between any two consecutive stations
 * Tip: we can't place elements beyond and before first and last element if we do that it will not the max gap for 1 and 13
 * So we need to place elements between elements
 * To do that we need to find out maximum gap between element and start putting station in between in above case max gap
 * in consecutive element is 13 - 1 = 12 so we will place one station there then arr will look like
 * stations[] = [1, '7' , 13, 17, 23] now we put a element at '7' place than max gap will be 6 which between 7 -1, 13-7, 23-17
 * now place second element between 17 and 23 to minimize gap
 * stations[] = [1, '7' , 13, 17, '20', 23] - now max gap is 6 between 7 -1 and 13 - 7 and we put 2 elements
 * stations[] = [1, '4', '7' , 13, 17, '20', 23] now max gap is 6 between 13 and 7
 * stations[] = [1, '4', '7', '10' , 13, 17, '20', 23] now max gap is 4 between 17 and 13 and we put 4 elements
 * stations[] = [1, '4', '7', '10' , 13, '15' 17, '20', 23] now max gap is 3 between 1, 4, 7 and 10 and we put all 5 elements
 * equals to k so our answer for this will be 3
 */
public class DistanceBetweenGasStations {
    public static void main(String[] args) {
        int[] stations = {1, 13, 17, 23};
        System.out.println(findSmallestMaxDistStriver(stations, 5));

    }



    /**
     * stations[] = [1, 13, 17, 23] k= 5
     * We need to know how many places we have where we can store or add number for that we will create a array with
     * length arr[stations.length -1]
     * When we add a number for any place we will increase it
     * ----
     * Iterate over the stations(k) that we need to put in between the station
     * For each value we will find the max diff between two station keeping track of earlier values that we have
     * added in howMany variable
     * i.e we iterate for 0 and in inner loop we got max diff 13-1 = 12 and we will return 0th index and increase
     * that index in howMany array
     * For next time we need to check diff 13-1 as we already put one value between it so we need to divide it by 2
     * loop from 0 to n-1
     */
    public static double findSmallestMaxDistStriver(int stations[], int k) {
        // code here
        final var n = stations.length;
        double[] howMany = new double[n - 1];
        for (int gasStations = 0; gasStations < k; gasStations++) {
            final var maxIdx = getMaxDiffIdx(stations, howMany);
            howMany[maxIdx]++;
        }
        //here in the howMany array we will get: [3.0, 0.0, 1.0] meaning 3 values can be added between 1 and 13
        System.out.println(Arrays.toString(howMany));

        double maxDiff = -1;
        for (int i = 0; i < n - 1; i++) {
            /*
            * Why we added howMany[i] + 1 because because it will be total sections
            * i.e 13 - 1 = 12 we added 3 elements between 1 and 13 so it will become 1, '4', '7', '10', 13 so total section
            * between 1 and 13 will be 4
            * */
            double sectionLen = (stations[i + 1] - stations[i]) / (howMany[i] + 1);
            maxDiff = Math.max(maxDiff, sectionLen);
        }
        return maxDiff;
    }

    /**
     * stations[] = [1, 13, 17, 23] k= 5
    * */
    private static int getMaxDiffIdx(final int[] stations, final double[] howMany) {
        double maxSection = -1F;
        int maxIdx = -1;
        for (int i = 0; i < stations.length - 1; i++) {
            double diff = stations[i + 1] - stations[i];
            //We are adding 1 in howMany because if there 1 howMany that will broke down into 2 sections to find the
            // maximum difference
            double sectionLen = diff / (howMany[i] + 1);
            if (sectionLen > maxSection) {
                maxSection = sectionLen;
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    record PriorityKey(int first, int second) {}


    public static double findSmallestMaxDistStriverOptimize(int stations[], int k) {
        // code here
        
        final var n = stations.length;
        for (int i = 0; i < n - 1; i++) {
            double diff = stations[i + 1] - stations[i];

        }

        double[] howMany = new double[n - 1];
        for (int gasStations = 0; gasStations < k; gasStations++) {
            final var maxIdx = getMaxDiffIdx(stations, howMany);
            howMany[maxIdx]++;
        }
        //here in the howMany array we will get: [3.0, 0.0, 1.0] meaning 3 values can be added between 1 and 13
        System.out.println(Arrays.toString(howMany));

        double maxDiff = -1;
        for (int i = 0; i < n - 1; i++) {
            /*
             * Why we added howMany[i] + 1 because because it will be total sections
             * i.e 13 - 1 = 12 we added 3 elements between 1 and 13 so it will become 1, '4', '7', '10', 13 so total section
             * between 1 and 13 will be 4
             * */
            double sectionLen = (stations[i + 1] - stations[i]) / (howMany[i] + 1);
            maxDiff = Math.max(maxDiff, sectionLen);
        }
        return maxDiff;
    }

    /**
     * stations[] = [1, 13, 17, 23] k= 5
     * */
    private static int getMaxDiffIdxOptimzed(final int[] stations, final double[] howMany) {
        double maxSection = -1F;
        int maxIdx = -1;
        for (int i = 0; i < stations.length - 1; i++) {
            double diff = stations[i + 1] - stations[i];
            //We are adding 1 in howMany because if there 1 howMany that will broke down into 2 sections to find the
            // maximum difference
            double sectionLen = diff / (howMany[i] + 1);
            if (sectionLen > maxSection) {
                maxSection = sectionLen;
                maxIdx = i;
            }
        }
        return maxIdx;
    }


}


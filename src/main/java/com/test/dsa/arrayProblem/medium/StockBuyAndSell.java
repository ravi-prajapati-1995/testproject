package com.test.dsa.arrayProblem.medium;

public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] a) {
        int maxProfit = 0;
        int mini = a[0];

        for(int i=0;i<a.length; i++) {
            int cost = a[i] - mini;
            maxProfit = Math.max(cost, maxProfit);
            mini = Math.min(a[i], mini);
        }

        return maxProfit;
    }
}

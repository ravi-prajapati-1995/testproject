package com.test.dsa.recursion.strong_hold;

/**
 * <a href="https://leetcode.com/problems/count-good-numbers/description/">Problem Link</a>
 * A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).
 * <p>
 * For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2)
 * at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
 * Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.
 * <p>
 * A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.
 */
public class CountGoodNumbers {
    public static void main(String[] args) {
        final var goodNumbers = countGoodNumbersOptimal(806166225460393l);
        System.out.println(goodNumbers);
//        System.out.println(myPow(2, 10, 10000000));
    }

    /**
     * Instead of multiplying 5 for even and 4 for odd position
     * We can figure out how many event places in n number
     * Find out how many odd places if n is given
     * i.e n = 4, start from 0-index there are 2 odd places and 2 event places,
     * n= 5  start from 0-index there 01234 there are 3 event places at 0, 2, 4 and 2 odd places
     * From here we can drive a formula even = n/2 +  1
     * after figure out even number of places e  and odd number of places 0
     * simply 5^e * 4^o where e and o are even and odd
     */
    public static int countGoodNumbersOptimal(long n) {
        long oddPlaces = n / 2;
        long evenPlaces = n / 2 + n % 2;
        int mod = 10_000_000_07;

        final var res = (myPow(4, oddPlaces, mod)) * (myPow(5, evenPlaces, mod)) % mod;

        return (int) res % mod;
    }

    public static long myPow(long x, long n, int mod) {
        if (n == 0) {
            return 1;
        }
        //when n is 3  or any od number we need to manually multipy
        if (n % 2 == 1) {
            return (x * (myPow(x, n - 1, mod) % mod)) % mod;
        }

        return myPow((x * x) % mod,  n / 2, mod) % mod;
    }

    /**
     * We have 5 even numbers: 0, 2, 4, 6, 8 and 4 Prime numbers: 2, 3, 5, 7
     * if n is 1 so we have only 0, 2, 4, 6, 8 total 5 good numbers because at 0 index there should be only even
     * numbers
     * if n is 2 then there are permutation and combination with even and prime numbers
     * so we have 5 * 4  = 20 Good numbers i.e
     * 02, 03, 05, 07
     * 22, 23, 25, 27
     * 42, 43, 45, 47
     * 62, 63, 65, 67
     * 82, 83, 85, 87
     * if is 3 then we have total combination 5(even Numbers) * 4(prime Numbers) * 5(Even number) because at even places
     * we can have only even number and at odd places we can only have prime numbers
     * <p>
     * Steps:
     * 1. Iterate n from 0 - n-1 and take a result variable initialize it with 1
     * 2. for each even number multiply result with 5 and for each odd multiply by 4
     */
    public static int countGoodNumbers(long n) {
        long res = 1;
        int mod = 10_000_000_07;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                res = (res * 5) % mod;
            } else {
                res = (res * 4) % mod;
            }
            res = res % mod;
        }

        return (int) (res % mod);
    }

    public static int countGoodNumbersBetter(long n) {
        long res = 1;

        int mod = 10_000_000_07;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                res = (res * 5) % mod;
            } else {
                res = (res * 4) % mod;
            }
            res = res % mod;
        }

        return (int) (res % mod);
    }
}

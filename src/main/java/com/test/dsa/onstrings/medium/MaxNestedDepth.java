package com.test.dsa.onstrings.medium;

/**
 *Given a valid parentheses string s, return the nesting depth of s.
 * The nesting depth is the maximum number of nested parentheses.
 *
 * Input: s = "(1+(2*3)+((8)/4))+1"
 *
 * Output: 3
 *
 * Explanation:
 *
 * Digit 8 is inside of 3 nested parentheses in the string.
 * */
public class MaxNestedDepth {
    public static void main(String[] args) {
        System.out.println(maxDepth("(1)+((2))+((3))"));
    }

    public static int maxDepth(String s) {
        int curr = 0;
        int max = 0;

        for(char c: s.toCharArray()) {
            if(c == '(') {
                curr++;
            }
            max = Math.max(curr, max);
            if(c == ')') {
                curr--;
            }
        }
        return max;
    }
}

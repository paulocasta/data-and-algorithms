package com.example.algorithms.greedy;

// https://leetcode.com/problems/split-a-string-in-balanced-strings/
public class SplitStringInBalancedStrings {
    private static String s1 = "RLRRLLRLRL";
    private static String s2 = "RLRRRLLRLL";
    private static String s3 = "LLLLRRRR";

    public static void main(String[] args) {
        System.out.println(balancedStringSplit(s1));
        System.out.println(balancedStringSplit(s2));
        System.out.println(balancedStringSplit(s3));
    }

    /*
        La idea es sumar y restar las R y L, cuando estas den 0, es un grupo balanceado
     */
    public static int balancedStringSplit(String s) {
        int curSum = 0;
        int countGroup = 0;
        for (char c : s.toCharArray()) {
            if (c == 'R') {
                curSum++;
            } else {
                curSum--;
            }
            if (curSum == 0) {
                countGroup++;
            }
        }
        return countGroup;
    }
}

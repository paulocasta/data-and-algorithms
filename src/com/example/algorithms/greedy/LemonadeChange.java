package com.example.algorithms.greedy;

// https://leetcode.com/problems/lemonade-change/description/
public class LemonadeChange {

    private static int[] bills1 = {5,5,5,10,20};
    private static int[] bills2 = {5,5,10,10,20};

    public static void main(String[] args) {
        System.out.println(lemonadeChange(bills1));
        System.out.println(lemonadeChange(bills2));
    }

    private static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five += 1;
                continue;
            }
            if (bill == 10) {
                if (five > 0) {
                    ten += 1;
                    five -= 1;
                    continue;
                }
                return false;
            }
            if (bill == 20) {
                if (ten > 0 &&  five > 0) {
                    ten -= 1;
                    five -=1;
                    continue;
                } else if (five >= 3) {
                    five -= 3;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}

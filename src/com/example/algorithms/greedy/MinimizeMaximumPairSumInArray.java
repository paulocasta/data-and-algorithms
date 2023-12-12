package com.example.algorithms.greedy;

import java.util.Arrays;

// https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
public class MinimizeMaximumPairSumInArray {
    private static int nums1[] = {3,5,2,3};
    private static int nums2[] = {3,5,4,2,4,6};

    public static void main(String[] args) {
        System.out.println(minPairSum(nums1));
        System.out.println(minPairSum(nums2));
    }

    /*
     * La idea es ordenar el array y hacer pares entre el menor y mayor donde estan los punteros en el array
     */
    private static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, pairSum;
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            pairSum = nums[left]+nums[right];
            ans = Math.max(pairSum, ans);
            left+=1;
            right-=1;
        }
        return ans;
    }
}

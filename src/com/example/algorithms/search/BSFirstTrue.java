package com.example.algorithms.search;

import java.util.List;

/**
 * An array of boolean values is divided into two sections; the left section consists of all false and the right section consists of all true.
 * Find the First True in a Sorted Boolean Array of the right section, i.e. the index of the first true element. If there is no true element, return -1.
 */
public class BSFirstTrue {

    public static void main(String[] args) {
        List<Boolean> list = List.of(false,false,false,true,true);
        System.out.println(findBoundary(list));
    }
    private static int findBoundary(List<Boolean> arr) {
        int left = 0;
        int right = arr.size() - 1;
        int boundaryIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid)) {
                boundaryIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return boundaryIndex;
    }
}

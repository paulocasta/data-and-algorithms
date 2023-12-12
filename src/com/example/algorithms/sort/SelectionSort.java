package com.example.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

/*
    The idea for this sorting algorithm is that during each cycle, we find the smallest item from the unsorted
    pile and add it to the sorted pile.
 */

public class SelectionSort {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(List.of(5,3,6,1,2));

        List<Integer> sorted = sortList(list);
        sorted.forEach(System.out::println);
    }

    /*
        For each n item in the list, the time complexity to find the smallest item in the unsorted pile is O(n - i),
        where i is the index of that item. Overall, the time complexity is O(n * (n + 1) / 2), which is equivalent to O(n^2).
     */
    private static List<Integer> sortList(List<Integer> unsortedList) {
        int n = unsortedList.size();
        for (int i = 0; i < n; i++) {
            // Assume the current position as minimum
            int minIndex = i;

            // Find the minimum element's index from the rest of the list
            for (int j = i; j < n; j++) {
                if (unsortedList.get(j) < unsortedList.get(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = unsortedList.get(i);

            // Swap the minimum element with the first element
            unsortedList.set(i, unsortedList.get(minIndex));
            unsortedList.set(minIndex, temp);
        }
        return unsortedList;
    }
}

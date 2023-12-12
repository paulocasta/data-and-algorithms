package com.example.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

/**
    The idea of bubble sort is this: for each pass, we use a pointer to point at the first element of the list.
    For each cycle, we compare it to the next element in the list and swap them if the current item is greater,
    then move the pointer by one until it reaches the end of the list. We repeat this process until the list becomes sorted.
    The list is sorted if, during a pass, no swapping occurs.
 */
public class BubbleSort {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(List.of(5,3,6,1,2));

        List<Integer> sorted = sortList(list);
        sorted.forEach(System.out::println);
    }

    // The time complexity of this algorithm, like before, is O(n^2), because it is essentially two nested loops.
    private static List<Integer> sortList(List<Integer> unsortedList) {
        int n = unsortedList.size();
        // Iterate through all list elements in reversed order
        for (int i = n - 1; i >= 0; i--) {

            // Track whether a swap occurred in this pass
            boolean swapped = false;
            for (int j = 0; j < i; j++) {

                // Swap if the element found is greater than the next element
                if (unsortedList.get(j) > unsortedList.get(j + 1)) {
                    int temp = unsortedList.get(j);
                    unsortedList.set(j, unsortedList.get(j + 1));
                    unsortedList.set(j + 1, temp);
                    swapped = true;
                }
            }

            // If no two elements were swapped, the list is sorted
            if (!swapped)
                return unsortedList;
        }
        return unsortedList;
    }
}

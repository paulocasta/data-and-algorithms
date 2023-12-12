package com.example.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * The idea of quick sort is this: We select an arbitrary element in the list (known as the "pivot"), and we swap the elements in the list into two sides: a side where all the elements are smaller than the pivot, and a side where all the elements are larger or equal to the pivot.
 *
 * After grouping them this way, we swap the pivot with the first element of the side that is larger or equal to the pivot. This way, each element to the left of the pivot is smaller than it, and each element on the right is larger or equal. Then we need to sort the left and right intervals (using the same method), then the list will be sorted.
 */
public class QuickSort {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(List.of(5,3,6,7,1,2,0,4));

        sortListInterval(list, 0, list.size());
        list.forEach(System.out::println);
    }

    /**
     * The time complexity of quick sort is a bit complicated. On average, where the list is divided somewhere near the center each time, the time complexity is O(nlog(n)). However, in the worst-case scenario, each interval to sort is one less than the current interval, which would make the time complexity O(n^2). This depends heavily on which pivot point you choose: if you select an endpoint as your pivot and the list is already sorted, it will reach this time complexity. Otherwise, the chance of this happening is very low.
     */
    private static void sortListInterval(List<Integer> unsortedList, int start, int end) {
        // If segment is 1 or 0, it's sorted
        if (end - start <= 1)
            return;

        // Using last element as the pivot
        int pivot = unsortedList.get(end - 1);
        int startPtr = start, endPtr = end - 1;

        // Partitioning process
        while (startPtr < endPtr) {
            // Find the next element from the left that is larger than the pivot
            while (unsortedList.get(startPtr) < pivot && startPtr < endPtr) {
                startPtr++;
            }

            // Find the next element from the right that is smaller than or equal to the pivot
            while (unsortedList.get(endPtr) >= pivot && startPtr < endPtr) {
                endPtr--;
            }

            // Swap if pointers haven't met
            if (startPtr != endPtr) {
                int temp = unsortedList.get(startPtr);
                unsortedList.set(startPtr, unsortedList.get(endPtr));
                unsortedList.set(endPtr, temp);
            }
        }

        // Place pivot in its final position
        int temp = unsortedList.get(startPtr);
        unsortedList.set(startPtr, unsortedList.get(end - 1));
        unsortedList.set(end - 1, temp);

        // Sort left and right of the pivot
        sortListInterval(unsortedList, start, startPtr);
        sortListInterval(unsortedList, startPtr + 1, end);
    }
}

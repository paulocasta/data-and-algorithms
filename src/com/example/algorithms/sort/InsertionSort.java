package com.example.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

/**
    The idea of an insertion sort is this: initially, only the first item is considered sorted.
    Then, for each item in the sequence, we "insert" that item into the sorted list by swapping it with the item
    before it until the item is smaller than the current item.
 */
public class InsertionSort {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(List.of(5,3,6,1,2));

        List<Integer> sorted = sortList(list);
        sorted.forEach(System.out::println);
    }

    /*
        For each n item in the list, the time complexity to insert it into the sorted list is O(i),
        where i is the index of that item. Overall, the time complexity is O(n * (n - 1) / 2),
        which is equivalent to O(n^2).
     */
    private static List<Integer> sortList(List<Integer> unsortedList) {
        for (int i = 0; i < unsortedList.size(); i++) {
            int current = i;
            // gets the smallest element and inserts at current index
            while (current > 0 && unsortedList.get(current) < unsortedList.get(current - 1)) {
                int temp = unsortedList.get(current);
                // swaps current smaller element with the element before it
                unsortedList.set(current, unsortedList.get(current - 1));
                unsortedList.set(current - 1, temp);
                current--;
            }
        }
        return unsortedList;
    }
}
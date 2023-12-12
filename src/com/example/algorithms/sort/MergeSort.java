package com.example.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

/*
    The idea of a merge sort is divide and conquer: We divide the array into two almost equally,
    sort them (usually another merge sort), and merge the two sorted lists into one. To merge the two sorted lists,
    have two pointers point towards the bottom of the two lists, and in each step, add the smaller element from those
    two into the list and move the pointer of that item up by one until elements from both lists are fully added.
 */
public class MergeSort {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(List.of(5,3,6,1,2,8,4));

        List<Integer> sorted = sortListInterval(list, 0, list.size());
        sorted.forEach(System.out::println);
    }

    /**
        The overall time complexity is O(nlog(n)). To understand why this is the case, let's break down the algorithm and analyze its operations
        The main idea of merge sort is to continually split or divide the list in half until we're left with "sub-lists" of size 1.
        If we start with a list of n elements, the first split gets us two lists with size n/2.
        The second split would give us four lists of size n/4. Continuing this pattern, in the end we'll get n lists of size 1.
        The number of times we'll split is O(log(n)), because log(n) represents how many times we can divide n by 2 to reach 1.
        Similarly here, we're splitting the array in half each time which is why we'll split the array O(log(n)) times.
        Once everything is split, the next step is merging these sub-lists. Merging two halves of a list of size n requires O(n) operations in the worst case.
        The first merge level (with lists of size 1) requires n/2 merges, each with 2 operations, so O(n) operations. The next merge level (with lists of size 2) requires n/4 merges, each with 4 operations, so again O(n) operations. This pattern continues, and at each level, there are a total of O(n) operations.
        If we add up the total number of operations for each level:
        n + n + n + ... (for log(n) times) = n * log(n)
     */
    public static List<Integer> sortListInterval(List<Integer> unsortedList, int start, int end) {
        // Base case: A list of size 1 or 0 is already sorted
        if (end - start <= 1) {
            return unsortedList.subList(start, end);
        }

        // Split the list into left and right halves
        int midpoint = (start + end) / 2;
        List<Integer> leftList = sortListInterval(unsortedList, start, midpoint);
        List<Integer> rightList = sortListInterval(unsortedList, midpoint, end);

        List<Integer> resultList = new ArrayList<>();
        int leftPointer = 0, rightPointer = 0;

        // Merge the sorted left and right lists with two pointers
        while (leftPointer < leftList.size() || rightPointer < rightList.size()) {
            if (leftPointer == leftList.size()) {  // If left list is empty, append element from right
                resultList.add(rightList.get(rightPointer));
                rightPointer++;
            } else if (rightPointer == rightList.size()) {  // If right list is empty, append element from left
                resultList.add(leftList.get(leftPointer));
                leftPointer++;
            } else if (leftList.get(leftPointer) <= rightList.get(rightPointer)) {  // Append smaller element from left
                resultList.add(leftList.get(leftPointer));
                leftPointer++;
            } else {  // Append smaller element from right
                resultList.add(rightList.get(rightPointer));
                rightPointer++;
            }
        }

        return resultList;
    }
}

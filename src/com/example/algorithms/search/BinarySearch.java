package com.example.algorithms.search;

import java.util.List;

/**
 * The key observation here is that the array is sorted. We pick a random element in the array and compare it to the target.
 * <ul>
 * <li> If we happen to pick the element that equals the target (how lucky!), then bingo. We don't need to do any more work; return its index.
 * <li> If the element is smaller than the target, then we know the target cannot be found in the section to the left of the current element since everything to the left is even smaller. So we discard the current element and everything on the left from the search range.
 * <li> If the element is larger than the target, then we know the target cannot be found in the section to the right of the current element since everything to the right is even larger. So we discard the current element and everything on the right from the search range.
 * </ul>
 */
public class BinarySearch {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,3,5,6,12,19,21,23,34,40,52,56,60);
        System.out.println(binarySearch(list, 23));
    }

    /**
     * Time Complexity: O(log(n))
     *
     * @param arr ordered list
     * @param target to find
     * @return position where the target is found
     */
    private static int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;

        while (left <= right) { // <= here because left and right could point to the same element, < would miss it
            int mid = left + (right - left) / 2; // use `(right - left) /2` to prevent `left + right` potential overflow
            // found target, return its index
            if (arr.get(mid) == target) return mid;
            if (arr.get(mid) < target) {
                // middle less than target, discard left half by making left search boundary `mid + 1`
                left = mid + 1;
            } else {
                // middle greater than target, discard right half by making right search boundary `mid - 1`
                right = mid - 1;
            }
        }
        return -1; // if we get here we didn't hit above return so we didn't find target
    }
}

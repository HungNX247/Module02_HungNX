package com.codegym.binarysearch;

// Java implementation of iterative Binary Search
class BinarySearchExample1 {
    // Returns index of x if it is present in arr[],
    // else return -1
    public static int binarySearch(int arr[], int x) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            // Check if x is present at mid
            if (arr[middle] == x) return middle;

            // If x greater, ignore left half
            if (arr[middle] < x) left = middle + 1;

            // If x is smaller, ignore right half
            else right = middle - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }

    // Driver method to test above
    public static void main(String args[]) {
        int arr[] = { 2, 3, 4, 10, 40, 50 };
        int x = 15;

        int result = binarySearch(arr, x);
        if (result == -1)
            System.out.println("Element not present in array");
        else
            System.out.println("Element found at " + "index " + result);
    }
}

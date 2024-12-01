package models;

import java.util.Arrays;

public class MergeSort {

    // Method to perform merge sort
    public void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return; // Base case: if array has one or no elements, it's already sorted
        }

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid); // Split the array into left half
        int[] right = Arrays.copyOfRange(arr, mid, arr.length); // Split the array into right half

        mergeSort(left); // Recursively sort the left half
        mergeSort(right); // Recursively sort the right half

        merge(arr, left, right); // Merge the sorted halves
    }

    // Method to merge two sorted arrays
    private void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge elements from left and right arrays into the main array
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy remaining elements from the left array, if any
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // Copy remaining elements from the right array, if any
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10}; // Sample input array
        MergeSort sorter = new MergeSort(); // Create an instance of MergeSort

        System.out.println("Original Array: " + Arrays.toString(arr));
        sorter.mergeSort(arr); // Sort the array using merge sort
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}

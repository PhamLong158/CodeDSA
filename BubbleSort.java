package models;
// BubbleSort.java
public class BubbleSort {
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {  // Outer loop
            for (int j = 0; j < n - i - 1; j++) {  // Inner loop
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        BubbleSort sorter = new BubbleSort();
        int[] arr = {5, 2, 9, 1, 5, 6};
        sorter.bubbleSort(arr);

        // Print the sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

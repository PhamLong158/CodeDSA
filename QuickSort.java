package models;
public class QuickSort {
    public void sort(int[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = divide(array, start, end);
            sort(array, start, pivotIndex - 1);
            sort(array, pivotIndex + 1, end);
        }
    }

    private int divide(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, end);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

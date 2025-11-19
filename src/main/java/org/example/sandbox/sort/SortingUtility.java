package org.example.sandbox.sort;

public class SortingUtility {

    public static <T extends Comparable<T>> void selectionSort(T[] data) {

        int min;

        for (int index = 0; index < data.length - 1; index++) {

            // Assume first value is min
            min = index;

            for (int scan = index + 1; scan < data.length; scan++) {

                // Find minimum value
                if (data[scan].compareTo(data[min]) < 0) {
                    min = scan;
                }

            }

            // Swap minimum value with lowest index
            swap(data, min, index);
        }
    }

    private static <T extends Comparable<T>> void swap(T[] data, int min, int index) {
        T temp = data[min];
        data[min] = data[index];
        data[index] = temp;
    }

    public static <T extends Comparable<T>> void insertionSort(T[] data) {

        for (int index = 1; index < data.length; index++) {

            T key = data[index];
            int position = index;

            // shift larger values to the right
            while (position > 0 && data[position - 1].compareTo(key) > 0) {
                data[position] = data[position - 1];
                position--;
            }

            data[position] = key;

        }
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] data) {

        int position, scan;

        for (position = data.length - 1; position >= 0; position--) {

            for (scan = 0; scan <= position - 1; scan++) {
                if (data[scan].compareTo(data[scan + 1]) > 0) {
                    // swap
                    swap(data, scan, scan + 1);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void quickSort(T[] data) {
        quickSortHelper(data, 0, data.length - 1);
    }

    private static <T extends Comparable<T>> void quickSortHelper(T[] data, int min, int max) {
        // Base case: If the sub-array has one or no elements, it's already sorted
        if (min < max) {

            // Partition the array and get the pivot index
            int pivotIndex = partition(data, min, max);

            // Recursively sort the left sub-array
            quickSortHelper(data, min, pivotIndex - 1);

            // Recursively sort the right sub-array
            quickSortHelper(data, pivotIndex + 1, max);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] data, int min, int max) {

        T pivot = data[max]; // Choose the last element as pivot
        int i = (min - 1); // Index of smaller element

        for (int j = min; j < max; j++) {
            // If current element is smaller than or equal to pivot
            if (data[j].compareTo(pivot) <= 0) {
                i++;

                // Swap data[i] and data[j]
                swap(data, i, j);
            }
        }

        // Swap data[i + 1] and data[max] (or pivot)
        swap(data, i + 1, max);

        return i + 1; // Return the partitioning index
    }

    public static <T extends Comparable<T>> void mergeSort(T[] data) {

        mergeSort(data, 0, data.length - 1);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] data, int min, int max) {

        if (min < max) {

            int mid = (min + max) / 2;
            mergeSort(data, min, mid);
            mergeSort(data, mid + 1, max);
            merge(data, min, mid, max);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] data, int min, int mid, int max) {

        T[] temp = (T[]) new Comparable[data.length];

        int first1 = min, last1 = mid; // endpoints of first subarray
        int first2 = mid + 1, last2 = max; // endpoints of second subarray
        int index = first1;  // next index open in temp array

        /*
        Copy smaller item from each subarray into temp until one of the sub-arrays is exhausted
         */

        while(first1 <= last1 && first2 <= last2) {

            if (data[first1].compareTo(data[first2]) < 0) {
                // Not sorted
                temp[index] = data[first1];
                first1++;
            } else {
                // sorted
                temp[index] = data[first2];
                first2++;
            }
            index++;
        }

        // Copy remaining elements from first subarray, if any
        while (first1 <= last1) {
            temp[index] = data[first1];
            first1++;
            index++;
        }

        // Copy remaining elements from second subarray, if any
        while (first2 <= last2) {
            temp[index] = data[first2];
            first2++;
            index++;
        }

        // Copy merged subarray back into original array
        for (index = min; index <= max; index++) {
            data[index] = temp[index];
        }


    }

}

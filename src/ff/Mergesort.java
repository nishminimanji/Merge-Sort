package ff;

public class Mergesort {

public void mergesort(long[] arr, int low, int high) {
        if (low >= high) // If the range is 1 or invalid,
            return; // no need to sort
        else {
            // find midpoint
            int mid = (low + high) / 2;
            // sort low half
            mergesort(arr, low, mid);
            // sort high half
            mergesort(arr, mid + 1, high);
            // merge them
            merge(arr, low, mid, high);
        }
    }

    public void merge(long[] arr, int lowPtr, int mid, int upperBound) {
        long[] workSpace = new long[upperBound - lowPtr + 1];
        int leftIndex = lowPtr;
        int rightIndex = mid + 1;
        int workSpaceIndex = 0;

        // Merge the two halves into the workspace
        while (leftIndex <= mid && rightIndex <= upperBound) {
            if (arr[leftIndex] <= arr[rightIndex]) {
                workSpace[workSpaceIndex++] = arr[leftIndex++];
            } else {
                workSpace[workSpaceIndex++] = arr[rightIndex++];
            }
        }

        // Copy remaining elements from the left half, if any
        while (leftIndex <= mid) {
            workSpace[workSpaceIndex++] = arr[leftIndex++];
        }

        // Copy remaining elements from the right half, if any
        while (rightIndex <= upperBound) {
            workSpace[workSpaceIndex++] = arr[rightIndex++];
        }

        // Copy the merged elements back into the original array
        for (int i = 0; i < workSpace.length; i++) {
            arr[lowPtr + i] = workSpace[i];
        }
    }

    // Main function to test the merge sort implementation
    public static void main(String[] args) {
        Mergesort sorter = new Mergesort();
        long[] array = {20, 15, 9, 4, 13, 7};

        // Print the original array
        System.out.print("Original array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        // Sort the array using merge sort
        sorter.mergesort(array, 0, array.length - 1);

        // Print the sorted array
        System.out.print("Sorted array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

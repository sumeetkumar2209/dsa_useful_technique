package com.dsa.technique;

/*
* @author : Sumeet Kumar
* @content : Find the kth smallest element in the array
* @technique : QuickSelect
* */


public class QuickSelectAlgorithm {

    public static void main(String[] args) {

        QuickSelectAlgorithm qs = new QuickSelectAlgorithm();
        int[] arr = {4, 1, 5, 7, 3, 9, 2};

        // Find the 6th smallest element in the array
        System.out.println(qs.findKthSmallest(arr, 6, 0, arr.length - 1));
    }

    // Function to find the kth smallest element in the array using QuickSelect
    public int findKthSmallest(int[] arr, int k, int l, int r) {

        // Partition the array and get the pivot index
        int pivotIndex = partition(arr, l, r);

        // Check if the pivot is the kth smallest element
        if (pivotIndex == k - 1) {
            return arr[pivotIndex];
        }
        // If the pivot index is greater than k, search in the left subarray
        else if (pivotIndex > k - 1) {
            return findKthSmallest(arr, k, l, pivotIndex - 1);
        }
        // If the pivot index is less than k, search in the right subarray
        else {
            return findKthSmallest(arr, k, pivotIndex + 1, r);
        }
    }

    // Function to partition the array and return the pivot index
    public int partition(int[] arr, int l, int r) {

        // Choose the rightmost element as the pivot
        int pivot = r;
        int i = l, j = l;

        // Iterate through the array and partition elements around the pivot
        while (j < pivot) {
            if (arr[j] < arr[pivot]) {
                swap(arr, i, j);
                i++;
            }
            j++;
        }

        // Swap the pivot element to its correct position
        swap(arr, i, pivot);

        // Return the index where the pivot is now located
        return i;
    }

    // Function to swap two elements in the array
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

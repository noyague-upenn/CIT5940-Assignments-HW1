package homework1.src;

import java.util.LinkedList;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {

        int[] input = new int[1000];
        Random rand = new Random();

        for (int i = 0; i < 1000; i++) {
            input[i] = rand.nextInt(5000);
        }


        ///*
        // Testing runtime
        long start = System.nanoTime(); // start testing runtime

        // JavierMergeSort.mergeSort(input);
        mergeSort(input);

        long end = System.nanoTime(); // end testing runtime

        System.out.println("Run time was " + (end - start) / 1000000.0 + " milliseconds." ); // print runtime
        /*
        // Testing correctness:

        int [] javierSort = JavierMergeSort.mergeSort(input);
        int[] recursiveSort = mergeSort(input);
        boolean answer = true;

        for (int i = 0; i < javierSort.length; i++) {
            if (javierSort[i] != recursiveSort[i]) {
                answer = false;
                break;
            }
        }
        System.out.println(answer);
         */
    }

    public static int[] mergeSort(int[] input) {
        // Base case
        if (input.length == 1) return input;

        // Divide input by two
        int middle = input.length / 2;
        int[] left = new int[middle];
        for (int i = 0; i < middle; i++) {
            left[i] = input[i];
        }

        int[] right = new int[input.length - middle];
        for (int i = 0; i < input.length - middle; i++) {
            right[i] = input[middle + i];
        }

        // Call recursive function
        left = mergeSort(left);
        right = mergeSort(right);

        // Merge
        return merge(left, right);
    }

    // Merges two sorted arrays into one new sorted array
    private static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0; // index for a
        int j = 0; // index for b
        int k = 0; // index for result

        // Compare elements and add the smaller one
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[k] = a[i]; // add val from a if smaller
                i++;
            } else {
                result[k] = b[j]; // add val from b if smaller
                j++;
            }
            k++;
        }

        // Add remaining elements from a (if any)
        while (i < a.length) {
            result[k] = a[i];
            i++;
            k++;
        }

        // Add remaining elements from b (if any)
        while (j < b.length) {
            result[k] = b[j];
            j++;
            k++;
        }

        return result;
    }
}

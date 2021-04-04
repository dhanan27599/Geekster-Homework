package Arrays;
/*
Inversion Count for an array 
indicates – how far (or close) the array is from being sorted. 
If the array is already sorted, 
then the inversion count is 0, 
but if the array is sorted in the reverse order, 
the inversion count is the maximum. 
Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j 

Example: 
Input: arr[] = {8, 4, 2, 1}
Output: 6

Explanation: Given array has six inversions:
(8, 4), (4, 2), (8, 2), (8, 1), (4, 1), (2, 1).

Input: arr[] = {3, 1, 2}
Output: 2

Explanation: Given array has two inversions:
(3, 1), (3, 2) 
 */
import java.util.*;
public class Count_Inversions {
    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 1};
        int result = solve(arr);
        System.out.println(result);
    }

    public static int solve(int[] arr) {
        return mergesort(arr, 0, arr.length - 1);
    }

    private static int mergesort(int[] arr, int l, int r) {
        int count = 0;
        if(l < r) {
            int mid = (l + r) / 2;

            count += mergesort(arr, l, mid);
            count += mergesort(arr, mid + 1, r);
            count += merger(arr, l, mid, r);
        }
        return count;
    }

    private static int merger(int[] arr, int l, int mid, int r) {
        int[] left = Arrays.copyOfRange(arr, l, mid + 1);
        int[] right = Arrays.copyOfRange(arr, mid + 1, r + 1);

        int i = 0, j = 0;
        int swaps = 0;
        int k = l;
        int midLength = left.length;
        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swaps += midLength - i;
            }
        }

        while(i < left.length) {
            arr[k++] = left[i++];
        }
        
        while(j < right.length) {
            arr[k++] = right[j++];
        }        
        
        return swaps;
    }

}

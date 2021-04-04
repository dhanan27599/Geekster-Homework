package Arrays;
/*
Given heights of n towers and a value k. 
We need to either increase or decrease height of every tower by k (only once) where k > 0. 
The task is to minimize the difference between the heights 
of the longest and the shortest tower after modifications, 
and output this difference.

Examples: 

Input  : arr[] = {1, 15, 10}, k = 6
Output :  Maximum difference is 2.
Explanation : We change 1 to 7, 15 to 
9 and 10 to 4. Maximum difference is 5
(between 7 and 9). We can't get a lower
difference.

Input : arr[] = {1, 5, 15, 10} 
        k = 3   
Output : Maximum difference is 8
arr[] = {4, 8, 12, 7}

Input : arr[] = {4, 6} 
        k = 10
Output : Maximum difference is 2
arr[] = {14, 16} OR {-6, -4}

Input : arr[] = {6, 10} 
        k = 3
Output : Maximum difference is 2
arr[] = {9, 7} 

Input : arr[] = {1, 10, 14, 14, 14, 15}
        k = 6 
Output: Maximum difference is 5
arr[] = {7, 4, 8, 8, 8, 9} 

Input : arr[] = {1, 2, 3}
        k = 2 
Output: Maximum difference is 2
arr[] = {3, 4, 5} 
 */
import java.util.*;
public class Max_Diff_Heights {
    public static void main(String[] args) {
        System.out.println(solve(new int[] {1, 5, 15, 10}, 3));
    }

    public static int solve(int[] arr, int k) {
        Arrays.sort(arr);
        int ans = arr[arr.length - 1] - arr[0];
        int small = arr[0] + k;
        int big = arr[arr.length - 1] - k;
        if(small > big) {
            int temp = big;
            big = small;
            small = temp;
        }

        for(int i = 1 ; i < arr.length - 1 ; i++) {
             int sub = arr[i] - k;
             int add = arr[i] + k;

             if(sub >= small || add <= big) {
                 continue;
             }

             if(big - sub <= add - small) {
                 small = sub;
             } else {
                 big = small;
             }
        }

        return Math.min(ans, big - small);
    }
}
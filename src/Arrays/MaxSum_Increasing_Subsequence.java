package Arrays;

import java.util.*;

/*

Given an array of n positive integers. 
Write a program to find the sum of maximum sum subsequence of the given array 
such that the integers in the subsequence are sorted in increasing order. 
For example, if input is {1 101 2 3 100 4 5}, 
then output should be 106 (1 + 2 + 3 + 100), 
if the input array is {3 4 5 10}, 
then output should be 22 (3 + 4 + 5 + 10) 
and if the input array is {10 5 4 3}, 
then output should be 10

*/

public class MaxSum_Increasing_Subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        int result = solve(arr);
        System.out.println(result);
        sc.close();
    }

    public static int solve(int[] arr) {
        int totalMax = Integer.MIN_VALUE;
        int[] cache = new int[arr.length];
        cache[0] = arr[0];
        for(int i = 1 ; i < arr.length ; i++) {
            int max = 0;
            for(int j = 0 ; j < i ; j++) {
                if(arr[j] < arr[i]) {
                    max = cache[j];
                }
            }
            cache[i] = arr[i] + max;
        }


        for(int i = 0 ; i < cache.length ; i++) {
            totalMax = Math.max(totalMax, cache[i]);
        }

        return totalMax;
    }

    
}

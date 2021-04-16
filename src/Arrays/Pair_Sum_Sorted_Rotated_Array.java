package Arrays;
/*
Given an array that is sorted and then rotated around an unknown point. 
Find if the array has a pair with a given sum ‘x’. 
It may be assumed that all elements in the array are distinct.

Examples : 

Input: arr[] = {11, 15, 6, 8, 9, 10}, x = 16
Output: true
There is a pair (6, 10) with sum 16

Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 35
Output: true
There is a pair (26, 9) with sum 35

Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 45
Output: false
There is no pair with sum 45.
*/
public class Pair_Sum_Sorted_Rotated_Array {
    public static void main(String[] args) {
        int[] arr = {11, 15, 26, 38, 9, 10};
        int key = 45;
        System.out.println(solve(arr, key));
    }

    public static boolean solve(int[] arr, int key) {
        int i;
        int n = arr.length;
        for(i = 0 ; i < arr.length - 1 ; i++) {
            if(arr[i] > arr[i + 1]) {
                break;
            }
        }

        int l = (i + 1) % n;
        int r = i;
        while(l != r) {
            if(arr[l] + arr[r] == key) {
                return true;
            }
            if(arr[l] + arr[r] < key) {
                l = (l + 1) % n;
            } else {
                r = (n + r - 1) % n;
            }
        }
        return false;
    }
}

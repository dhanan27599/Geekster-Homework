package Arrays;
import java.util.*;

/*

Given an array of DISTINCT elements, rearrange the elements of array in zig-zag fashion in O(n) time. 
The converted array should be in form a < b > c < d > e < f. 

Example:
Input: arr[] = {4 3 7 8 6 2 1} 
Output: arr[] = {3, 7, 4, 8, 2, 6, 1}

Input: arr[] = {1 4 3 2} 
Output: arr[] = {1, 4, 2, 3}

 */

public class Zigzag_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        int[] result = solve(arr);
        for(int i : result) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    public static int[] solve(int[] arr) {
        boolean flag = true;
        for(int i = 0 ; i < arr.length - 1 ; i++) {
            if(flag) {
                if(arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            } else {
                if(arr[i] < arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            flag = !flag;
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

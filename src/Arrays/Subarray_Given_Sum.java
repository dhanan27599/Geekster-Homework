package Arrays;

import java.util.*;

/*
Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number. 
Examples : 

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4
Sum of elements between indices
2 and 4 is 20 + 3 + 10 = 33

Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
Ouptut: Sum found between indexes 1 and 4
Sum of elements between indices
1 and 4 is 4 + 0 + 0 + 3 = 7

Input: arr[] = {1, 4}, sum = 0
Output: No subarray found
There is no subarray with 0 sum
There may be more than one subarrays with sum as the given sum. The following solutions print first such subarray. 
*/

public class Subarray_Given_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        String result = solve(arr, target);
        System.out.println(result);
        sc.close();
    }

    public static String solve(int[] arr, int target) {
        StringBuilder sb = new StringBuilder();
        // int[] prefix = new int[arr.length];
        // prefix[0] = arr[0];
        // for(int i = 1 ; i < prefix.length ; i++) {
        //     prefix[i] = arr[i] + prefix[i - 1];
        // }
        int sum = 0;
        for(int i : arr) {
            sum += i;
        }

        int i = 0;
        int j = arr.length - 1;
        while(i < j) {
            if(sum - arr[j] >= target) {
                sum -= arr[j--];

            } else if(sum - arr[i] >= target) {
                sum -= arr[i++];
            } else if(sum == target) {
                sb.append(i + "th index to "+ j + "th index");
                break;
            } else {
                sb.append("no subarray found");
                break;
            }
        }

        return sb.length() != 0 ? sb.toString() : "no subarray found";
    }
}

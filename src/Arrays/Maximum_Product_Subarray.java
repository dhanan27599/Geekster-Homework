package Arrays;
/*
Given an array that contains both positive and negative integers, 
find the product of the maximum product subarray. 
Expected Time complexity is O(n) and only O(1) extra space can be used.

Examples:

Input: arr[] = {6, -3, -10, 0, 2}
Output:   180  // The subarray is {6, -3, -10}

Input: arr[] = {-1, -3, -10, 0, 60}
Output:   60  // The subarray is {60}

Input: arr[] = {-2, -40, 0, -2, -3}
Output:   80  // The subarray is {-2, -40}
*/
public class Maximum_Product_Subarray {
    public static void main(String[] args) {
        int[] arr = {6, -3, -10, 0, 2};
        int result = solve(arr);
        System.out.println(result);
    }

    public static int solve(int[] arr) {
        int maxOverall = arr[0];
        int max_now = arr[0];
        int min_now = arr[0];

        for(int i = 1 ; i < arr.length ; i++) {
            int temp = max_now;
            max_now = Math.max(arr[i], Math.max(arr[i] * max_now, arr[i] * min_now));
            min_now = Math.min(arr[i], Math.min(arr[i] * temp, arr[i] * min_now));
            maxOverall = Math.max(maxOverall, max_now);
        }

        return maxOverall;
    }
}